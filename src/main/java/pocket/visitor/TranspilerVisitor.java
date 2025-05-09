package pocket.visitor;

import org.antlr.v4.runtime.Token;
import org.jetbrains.annotations.NotNull;

import pocket.antlr.PocketBaseVisitor;
import pocket.antlr.PocketParser;

import java.util.Objects;
import java.util.stream.Collectors;

public final class TranspilerVisitor extends PocketBaseVisitor<String> {
    final String fileFunctionName;

    public TranspilerVisitor(@NotNull final String fileFunctionName) {
        this.fileFunctionName = fileFunctionName;
    }

    @Override
    public String visitProgram(PocketParser.ProgramContext ctx) {
        final var stmts = ctx.stmt().stream().map(this::visit).collect(Collectors.joining("\n"));
        final var expr = ctx.expr();
        final var returnStmt = expr != null ? "return " + visit(expr) + ";" : "return 0;";

        return String.format("function %s() {\n%s\n%s\n}", fileFunctionName, stmts, returnStmt);
    }

    @Override
    public String visitExprStmt(PocketParser.ExprStmtContext ctx) {
        return visit(ctx.expr()) + ";";
    }

    @Override
    public String visitDeclStmt(PocketParser.DeclStmtContext ctx) {
        final var id = ctx.ID().getText();
        final var expr = visit(ctx.expr());
        final var isConst = ctx.VAL() != null;
        final var declKeyword = isConst ? "const" : "let";

        return String.format("%s %s = %s;", declKeyword, id, expr);
    }

    @Override
    public String visitExpr(PocketParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIdExpr(PocketParser.IdExprContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitIntLiteralExpr(PocketParser.IntLiteralExprContext ctx) {
        return ctx.INT_LITERAL().getText();
    }

    @Override
    public String visitFloatLiteralExpr(PocketParser.FloatLiteralExprContext ctx) {
        return ctx.FLOAT_LITERAL().getText();
    }

    @Override
    public String visitStringLiteralExpr(PocketParser.StringLiteralExprContext ctx) {
        return ctx.STRING_LITERAL().getText();
    }

    @Override
    public String visitPipeExpr(PocketParser.PipeExprContext ctx) {
        StringBuilder result = new StringBuilder(visit(ctx.logicOrExpr(0)));

        for (int i = 1; i < ctx.logicOrExpr().size(); i++) {
            String right = visit(ctx.logicOrExpr(i));
            Token opToken =
                    ctx.getChild(2 * i - 1).getPayload() instanceof Token
                            ? (Token) ctx.getChild(2 * i - 1).getPayload()
                            : null;

            String operator = opToken != null ? opToken.getText() : null;
            if (Objects.equals(operator, "->")) {
                operator = null;
            }

            if (operator == null) {
                result = new StringBuilder(right + "(" + result + ")");
            } else {
                result.append(" ").append(operator).append(" ").append(right);
            }
        }

        return result.toString();
    }

    @Override
    public String visitLogicOrExpr(PocketParser.LogicOrExprContext ctx) {
        return visit(ctx.logicAndExpr(0));
    }

    @Override
    public String visitLogicAndExpr(PocketParser.LogicAndExprContext ctx) {
        return visit(ctx.equalityExpr(0));
    }

    @Override
    public String visitEqualityExpr(PocketParser.EqualityExprContext ctx) {
        StringBuilder result = new StringBuilder(visit(ctx.relationalExpr(0)));

        for (int i = 1; i < ctx.relationalExpr().size(); i++) {
            String right = visit(ctx.relationalExpr(i));
            Token opToken =
                    ctx.getChild(2 * i - 1).getPayload() instanceof Token
                            ? (Token) ctx.getChild(2 * i - 1).getPayload()
                            : null;

            String operator = opToken != null ? opToken.getText() : "==";

            result.append(" ").append(operator).append(" ").append(right);
        }

        return result.toString();
    }

    @Override
    public String visitRelationalExpr(PocketParser.RelationalExprContext ctx) {
        return visit(ctx.additiveExpr(0));
    }

    @Override
    public String visitAdditiveExpr(PocketParser.AdditiveExprContext ctx) {
        // Start with the first multiplicative expression
        StringBuilder result = new StringBuilder(visit(ctx.multiplicativeExpr(0)));

        // Loop through the remaining operators and expressions
        for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
            // Get the operator token between expressions
            String op = ctx.getChild(2 * i - 1).getText(); // e.g. '+' or '-'
            String right = visit(ctx.multiplicativeExpr(i));

            result.append(" ").append(op).append(" ").append(right);
        }

        return result.toString();
    }

    @Override
    public String visitMultiplicativeExpr(PocketParser.MultiplicativeExprContext ctx) {
        StringBuilder result = new StringBuilder(visit(ctx.unaryExpr(0)));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            String right = visit(ctx.unaryExpr(i));

            result.append(" ").append(op).append(" ").append(right);
        }

        return result.toString();
    }

    @Override
    public String visitUnaryExpr(PocketParser.UnaryExprContext ctx) {
        final var unaryOp = ctx.unaryOp();

        if (unaryOp == null) {
            return visit(ctx.postfixExpr());
        } else {
            if (unaryOp.NOT() != null) {
                return "!" + visit(ctx.unaryExpr());
            } else if (unaryOp.MINUS() != null) {
                return "-" + visit(ctx.unaryExpr());
            } else {
                return visit(ctx.unaryExpr());
            }
        }
    }

    @Override
    public String visitParam(PocketParser.ParamContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitParamList(PocketParser.ParamListContext ctx) {
        return ctx.param().stream().map(this::visit).collect(Collectors.joining(", "));
    }

    @Override
    public String visitFnExpr(PocketParser.FnExprContext ctx) {
        final var fn = ctx.fn();
        final var paramList = visit(fn.paramList());
        final var stmts = fn.stmt().stream().map(this::visit).collect(Collectors.joining(", "));
        final var expr = "return " + visit(fn.expr()) + ";";
        return "function(" + paramList + ") {\n" + stmts + expr + "\n}";
    }

    @Override
    public String visitArgList(PocketParser.ArgListContext ctx) {
        return ctx.expr().stream().map(this::visit).collect(Collectors.joining(", "));
    }

    @Override
    public String visitPostfixExpr(PocketParser.PostfixExprContext ctx) {
        final var primaryExpr = visit(ctx.primaryExpr());
        final var argList =
                ctx.argList().stream()
                        .map(this::visit)
                        .map(args -> "(" + args + ")")
                        .collect(Collectors.joining(", "));

        return primaryExpr + argList;
    }
}
