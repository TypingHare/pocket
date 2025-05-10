package pocket.visitor;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

import pocket.PocketTranspiler;
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

        return String.format(
                "$global['%s'] = { export: {} };\nfunction %s() {\n%s\n%s\n}\n",
                fileFunctionName, fileFunctionName, stmts, returnStmt);
    }

    @Override
    public String visitExprStmt(PocketParser.ExprStmtContext ctx) {
        return visit(ctx.expr()) + ";";
    }

    @Override
    public String visitDeclStmt(PocketParser.DeclStmtContext ctx) {
        final var id = ctx.ID().getText();
        final var expr = visit(ctx.expr());
        final var isExport = ctx.EXPORT() != null;
        final var declKeyword = getJSDeclKeyword(ctx.decl());

        final var exportStr =
                isExport
                        ? String.format(
                                "\n$global['%s']['export']['%s'] = %s;", fileFunctionName, id, id)
                        : "";
        return String.format("%s %s = %s;%s", declKeyword, id, expr, exportStr);
    }

    @Override
    public String visitDestructuring(PocketParser.DestructuringContext ctx) {
        return ctx.ID().stream().map(ParseTree::getText).collect(Collectors.joining(", "));
    }

    @Override
    public String visitDestructingStmt(PocketParser.DestructingStmtContext ctx) {
        final var structBinding = visit(ctx.destructuring());
        final var exprStr = visit(ctx.expr());
        final var declKeyword = getJSDeclKeyword(ctx.decl());

        return String.format("%s { %s } = %s;", declKeyword, structBinding, exprStr);
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
        // Start with the first multiplicative expression
        StringBuilder result = new StringBuilder(visit(ctx.additiveExpr(0)));

        // Loop through the remaining operators and expressions
        for (int i = 1; i < ctx.additiveExpr().size(); i++) {
            // Get the operator token between expressions
            String op = ctx.getChild(2 * i - 1).getText();
            String right = visit(ctx.additiveExpr(i));

            result.append(" ").append(op).append(" ").append(right);
        }

        return result.toString();
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
        final var paramList = fn.paramList() != null ? visit(fn.paramList()) : "";
        final var stmts = fn.stmt().stream().map(this::visit).collect(Collectors.joining("\n"));
        final var expr = fn.expr() != null ? "return " + visit(fn.expr()) + ";" : "";
        return "function(" + paramList + ") {\n" + stmts + expr + "\n}";
    }

    public String visitImportExpr(PocketParser.ImportExprContext ctx) {
        final var literal = ctx.STRING_LITERAL().getText();
        final var filename = literal.substring(1, literal.length() - 1);
        final var fileFunctionName = PocketTranspiler.getFileFunctionName(filename);

        return String.format("$global['%s']['export']", fileFunctionName);
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
        final var argString = argList.isBlank() && !ctx.LEFT_PAREN().isEmpty() ? "()" : argList;

        return primaryExpr + argString;
    }

    @Override
    public String visitLoopExpr(PocketParser.LoopExprContext ctx) {
        final var exprStr = visit(ctx.expr());

        return "$loop(" + exprStr + ")";
    }

    @Override
    public String visitBreakStmt(PocketParser.BreakStmtContext ctx) {
        final var expr = visit(ctx.expr());

        return String.format("const $breakCond = %s; if ($breakCond) return true;", expr);
    }

    public String visitParenExpr(PocketParser.ParenExprContext ctx) {
        return "(" + visit(ctx.expr()) + ")";
    }

    @Override
    public String visitAssgnStmt(PocketParser.AssgnStmtContext ctx) {
        final var id = ctx.ID().getText();
        final var expr = visit(ctx.expr());

        return String.format("%s = %s;", id, expr);
    }

    public String visitIfExpr(PocketParser.IfExprContext ctx) {
        final var ifExpr = ctx.if_();
        final var cond = visit(ifExpr.expr(0));
        final var fn1 = visit(ifExpr.expr(1));
        final var fn2 = ifExpr.expr(2) != null ? visit(ifExpr.expr(2)) : null;

        final var elsePart = fn2 != null ? String.format("else return (%s)();", fn2) : "";

        return String.format(
                "(function () { if (%s) { return %s(); } %s } )()", cond, fn1, elsePart);
    }

    private String getJSDeclKeyword(PocketParser.DeclContext ctx) {
        return ctx.VAL() != null ? "const" : "let";
    }
}
