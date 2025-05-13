package pocket.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import pocket.antlr.PocketParser;
import pocket.antlr.PocketParserBaseVisitor;
import pocket.ast.expr.*;
import pocket.ast.stmt.*;
import pocket.ast.symbol.BinaryOp;
import pocket.ast.symbol.DeclKeyword;
import pocket.ast.symbol.UnaryOp;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ModuleFnASTBuilder extends PocketParserBaseVisitor<ASTNode> {
    @NotNull
    private final String filepath;
    @NotNull
    private final String functionName;
    @NotNull
    private final Path directory;

    public ModuleFnASTBuilder(
        @NotNull final String filepath,
        @NotNull final String functionName
    ) {
        this.filepath = filepath;
        this.functionName = functionName;
        this.directory = Path.of(new File(filepath).getParent());
    }

    @Override
    public ASTNode visitModuleFn(PocketParser.ModuleFnContext ctx) {
        final List<Stmt> stmts =
            ctx.stmt() == null ? List.of() : ctx.stmt().stream()
                .map(this::<Stmt>visitFor).toList();
        final Expr expr = ctx.expr() == null ? null : visitFor(ctx.expr());

        return new ModuleFn(
            tokenToBaseNode(ctx.getStart()), functionName,
            stmts, expr
        );
    }

    @Override
    public ASTNode visitExprStmt(PocketParser.ExprStmtContext ctx) {
        return new ExprStmt(
            tokenToBaseNode(ctx.getStart()),
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitDeclStmt(PocketParser.DeclStmtContext ctx) {
        final var isExport = ctx.EXPORT() != null;
        final var declKeyword = declToDeclKeyword(ctx.decl());
        final var idExpr = idToIdExpr(ctx.ID());
        final var typeExpr =
            ctx.type() == null ? null : this.<TypeExpr>visitFor(
                ctx.type());

        return new DeclStmt(
            tokenToBaseNode(ctx.getStart()),
            isExport,
            declKeyword,
            idExpr,
            typeExpr,
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitDestructingStmt(
        PocketParser.DestructingStmtContext ctx
    ) {
        final var isExport = ctx.EXPORT() != null;
        final var declKeyword = declToDeclKeyword(ctx.decl());
        final var destructuringList = ctx.destructuringList();
        final var idList = destructuringList.ID().stream().map(this::idToIdExpr)
            .toList();

        return new DestructingStmt(
            tokenToBaseNode(ctx.getStart()), isExport, declKeyword, idList,
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitAssgnStmt(PocketParser.AssgnStmtContext ctx) {
        return new AssgnStmt(
            tokenToBaseNode(ctx.getStart()), idToIdExpr(ctx.ID()),
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitBreakStmt(PocketParser.BreakStmtContext ctx) {
        return new BreakStmt(
            tokenToBaseNode(ctx.getStart()),
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitExpr(PocketParser.ExprContext ctx) {
        return visit(ctx.pipeExpr());
    }

    @Override
    public ASTNode visitPipeExpr(PocketParser.PipeExprContext ctx) {
        final var parts = ctx.logicOrExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left,
                BinaryOp.PIPE, right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitLogicOrExpr(PocketParser.LogicOrExprContext ctx) {
        final var parts = ctx.logicAndExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left,
                BinaryOp.LOGIC_OR, right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitLogicAndExpr(PocketParser.LogicAndExprContext ctx) {
        final var parts = ctx.equalityExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left,
                BinaryOp.LOGIC_AND, right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitEqualityExpr(PocketParser.EqualityExprContext ctx) {
        final var parts = ctx.relationalExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            final var op = equalityOpToBinaryOp(ctx.equalityOp(i - 1));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left, op,
                right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitRelationalExpr(PocketParser.RelationalExprContext ctx) {
        final var parts = ctx.additiveExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            final var op = relationalOpToBinaryOp(ctx.relationalOp(i - 1));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left, op,
                right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitAdditiveExpr(PocketParser.AdditiveExprContext ctx) {
        final var parts = ctx.multiplicativeExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            final var op = additiveOpToBinaryOp(ctx.additiveOp(i - 1));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left, op,
                right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitMultiplicativeExpr(
        PocketParser.MultiplicativeExprContext ctx
    ) {
        final var parts = ctx.unaryExpr();
        Expr left = visitFor(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            final Expr right = visitFor(parts.get(i));
            final var op = multiplicativeOpToBinaryOp(
                ctx.multiplicativeOp(i - 1));
            left = new BinaryExpr(
                tokenToBaseNode(ctx.getStart()), left, op,
                right
            );
        }

        return left;
    }

    @Override
    public ASTNode visitUnaryExpr(PocketParser.UnaryExprContext ctx) {
        if (ctx.unaryExpr() != null) {
            final var op = unaryOpToUnaryOp(ctx.unaryOp());
            return new UnaryExpr(
                tokenToBaseNode(ctx.getStart()), op,
                visitFor(ctx.unaryExpr())
            );
        }

        if (ctx.postfixExpr() != null) {
            return visit(ctx.postfixExpr());
        }

        throw new RuntimeException(
            "Invalid unary expression: " + ctx.getText());
    }

    @Override
    public ASTNode visitIdExpr(PocketParser.IdExprContext ctx) {
        return idToIdExpr(ctx.ID());
    }

    @Override
    public ASTNode visitIntLiteralExpr(PocketParser.IntLiteralExprContext ctx) {
        return new IntLiteralExpr(
            tokenToBaseNode(ctx.getStart()),
            ctx.getText()
        );
    }

    @Override
    public ASTNode visitFloatLiteralExpr(
        PocketParser.FloatLiteralExprContext ctx
    ) {
        return new FloatLiteralExpr(
            tokenToBaseNode(ctx.getStart()),
            ctx.getText()
        );
    }

    @Override
    public ASTNode visitStringLiteralExpr(
        PocketParser.StringLiteralExprContext ctx
    ) {
        return new StringLiteralExpr(
            tokenToBaseNode(ctx.getStart()),
            ctx.getText()
        );
    }

    @Override
    public ASTNode visitLambdaExpr(PocketParser.LambdaExprContext ctx) {
        return visit(ctx.lambda());
    }

    @Override
    public ASTNode visitIfExpr(PocketParser.IfExprContext ctx) {
        final Expr condition = visitFor(ctx.expr(0));
        final Expr thenBranch = visitFor(ctx.expr(1));
        final Expr elseBranch = ctx.expr(2) == null ? null : visitFor(
            ctx.expr(2));
        return new IfExpr(
            tokenToBaseNode(ctx.getStart()), condition,
            thenBranch, elseBranch
        );
    }

    @Override
    public ASTNode visitLoopExpr(PocketParser.LoopExprContext ctx) {
        return new LoopExpr(
            tokenToBaseNode(ctx.getStart()),
            visitFor(ctx.expr())
        );
    }

    @Override
    public ASTNode visitImportExpr(PocketParser.ImportExprContext ctx) {
        final var literal = ctx.STRING_LITERAL().getText();
        final var filepath = literal.substring(1, literal.length() - 1);
        final var fullFilePath = directory.resolve(filepath).toString();

        return new ImportExpr(tokenToBaseNode(ctx.getStart()), fullFilePath);
    }

    @Override
    public ASTNode visitParenExpr(PocketParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitPostfixExpr(PocketParser.PostfixExprContext ctx) {
        if (ctx.LEFT_PAREN().isEmpty() && ctx.lambda() == null) {
            // Not a call expression
            return visit(ctx.primaryExpr());
        }

        final var isPartial = ctx.AMPERSAND() != null;
        final Expr callee = visitFor(ctx.primaryExpr());
        final List<Expr> args =
            ctx.argList().isEmpty() ? new ArrayList<>() : visitArglist(
                ctx.argList(0));
        var left = new CallExpr(
            tokenToBaseNode(ctx.getStart()),
            isPartial && ctx.argList().size() <= 1, callee, args
        );
        for (int i = 1; i < ctx.argList().size(); i++) {
            final List<Expr> nextArgs = visitArglist(ctx.argList(i));
            final var nextIsPartial = isPartial && i == ctx.argList()
                .size() - 1;
            left = new CallExpr(
                tokenToBaseNode(ctx.getStart()), nextIsPartial,
                left, nextArgs
            );
        }

        // Trailing lambda
        if (ctx.lambda() != null) {
            left.argList.add(visitFor(ctx.lambda()));
        }

        return left;
    }

    @Override
    public ASTNode visitType(PocketParser.TypeContext ctx) {
        return idToIdExpr(ctx.ID());
    }

    @Override
    public ASTNode visitLambda(PocketParser.LambdaContext ctx) {
        final var isTrade = ctx.TRADE() != null;
        final List<LambdaExpr.Param> params = paramListToParamList(
            ctx.paramList());
        final List<Stmt> stmts =
            ctx.stmt() == null ? List.of() : ctx.stmt().stream()
                .map(s -> (Stmt) visit(s)).toList();
        final var expr = ctx.expr() == null ? null : (Expr) visit(ctx.expr());

        return new LambdaExpr(
            tokenToBaseNode(ctx.getStart()), isTrade, params,
            stmts, expr
        );
    }

    @Override
    public ASTNode visitNativeStmt(PocketParser.NativeStmtContext ctx) {
        return new NativeStmt(
            tokenToBaseNode(ctx.getStart()),
            idToIdExpr(ctx.ID())
        );
    }

    @Override
    public ASTNode visitYieldExpr(final PocketParser.YieldExprContext ctx) {
        final Expr initializer = visitFor(ctx.expr(0));
        final Expr toYield = visitFor(ctx.expr(1));
        final Expr next = visitFor(ctx.expr(2));
        final Expr isAlive = visitFor(ctx.expr(3));

        return new YieldExpr(
            tokenToBaseNode(ctx.getStart()),
            initializer,
            toYield,
            next,
            isAlive
        );
    }

    @Override
    public ASTNode visitListExpr(final PocketParser.ListExprContext ctx) {
        final var exprList = ctx.listElementList().expr();

        return new ListExpr(
            tokenToBaseNode(ctx.getStart()),
            exprList.stream().map(this::<Expr>visitFor).toList()
        );
    }

    @Override
    public ASTNode visitObjectExpr(final PocketParser.ObjectExprContext ctx) {
        final var idList = ctx.objectElementList().ID();
        final var itemsList = ctx.objectElementList().expr();
        final var map = new HashMap<String, Expr>();

        for (int i = 0; i < idList.size(); i++) {
            map.put(
                idList.get(i).getText(),
                this.<Expr>visitFor(itemsList.get(i))
            );
        }

        return new ObjectExpr(tokenToBaseNode(ctx.getStart()), map);
    }

    @NotNull
    private ASTNode tokenToBaseNode(@NotNull final Token token) {
        final var line = token.getLine();
        final var column = token.getCharPositionInLine();

        return ASTNode.create(filepath, line, column);
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public <D> D visitFor(@NotNull final ParseTree tree) {
        return (D) visit(tree);
    }

    @Override
    public ASTNode visitEmptyListExpr(
        final PocketParser.EmptyListExprContext ctx
    ) {
        return new ListExpr(tokenToBaseNode(ctx.getStart()), List.of());
    }

    @NotNull
    private IdExpr idToIdExpr(@NotNull final TerminalNode terminalNode) {
        return new IdExpr(
            tokenToBaseNode(terminalNode.getSymbol()),
            terminalNode.getText()
        );
    }

    @NotNull
    private DeclKeyword declToDeclKeyword(
        @NotNull final PocketParser.DeclContext ctx
    ) {
        if (ctx.VAL() != null) {
            return DeclKeyword.VAL;
        }

        if (ctx.LET() != null) {
            return DeclKeyword.LET;
        }

        throw new RuntimeException(
            "Invalid declaration keyword: " + ctx.getText());
    }

    @NotNull
    private BinaryOp equalityOpToBinaryOp(
        final PocketParser.EqualityOpContext ctx
    ) {
        if (ctx.EQUAL_EQUALS() != null) {
            return BinaryOp.EQUALS;
        }

        if (ctx.EQUAL_EQUALS() != null) {
            return BinaryOp.NOT_EQUALS;
        }

        throw new RuntimeException(
            "Invalid equality operator: " + ctx.getText());
    }

    @NotNull
    private BinaryOp relationalOpToBinaryOp(
        final PocketParser.RelationalOpContext ctx
    ) {
        if (ctx.LESS_THAN() != null) {
            return BinaryOp.LESS_THAN;
        }

        if (ctx.LESS_THAN_EQUALS() != null) {
            return BinaryOp.LESS_THAN_EQUALS;
        }

        if (ctx.GREATER_THAN() != null) {
            return BinaryOp.GREATER_THAN;
        }

        if (ctx.GREATER_THAN_EQUALS() != null) {
            return BinaryOp.GREATER_THAN_EQUALS;
        }

        throw new RuntimeException(
            "Invalid relational operator: " + ctx.getText());
    }

    @NotNull
    private BinaryOp additiveOpToBinaryOp(
        final PocketParser.AdditiveOpContext ctx
    ) {
        if (ctx.PLUS() != null) {
            return BinaryOp.PLUS;
        }

        if (ctx.MINUS() != null) {
            return BinaryOp.MINUS;
        }

        throw new RuntimeException(
            "Invalid additive operator: " + ctx.getText());
    }

    @NotNull
    private BinaryOp multiplicativeOpToBinaryOp(
        final PocketParser.MultiplicativeOpContext ctx
    ) {
        if (ctx.ASTERISK() != null) {
            return BinaryOp.MULTIPLY;
        }

        if (ctx.SLASH() != null) {
            return BinaryOp.DIVIDE;
        }

        if (ctx.PERCENT() != null) {
            return BinaryOp.MODULO;
        }

        throw new RuntimeException(
            "Invalid additive operator: " + ctx.getText());
    }

    @NotNull
    private UnaryOp unaryOpToUnaryOp(final PocketParser.UnaryOpContext ctx) {
        if (ctx.MINUS() != null) {
            return UnaryOp.MINUS;
        }

        if (ctx.NOT() != null) {
            return UnaryOp.NOT;
        }

        throw new RuntimeException("Invalid unary operator: " + ctx.getText());
    }

    @NotNull
    private List<Expr> visitArglist(final PocketParser.ArgListContext ctx) {
        return ctx.expr().stream().map(this::<Expr>visitFor).toList();
    }

    @NotNull
    private List<LambdaExpr.Param> paramListToParamList(
        final PocketParser.ParamListContext ctx
    ) {
        if (ctx == null) {
            return List.of();
        }

        return ctx.param().stream()
            .map(p -> {
                final var idExpr = idToIdExpr(p.ID());
                final var typeExpr =
                    p.type() == null ? null : this.<TypeExpr>visitFor(
                        p.type());
                return new LambdaExpr.Param(
                    tokenToBaseNode(p.getStart()),
                    idExpr, typeExpr
                );
            })
            .toList();
    }
}
