package pocket.ast;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import pocket.antlr.PocketParser;
import pocket.antlr.PocketParserVisitor;

public final class ASTBuilder implements PocketParserVisitor<ASTNode> {
    @Override
    public ASTNode visitModuleFn(PocketParser.ModuleFnContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitEqualityOp(PocketParser.EqualityOpContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitRelationalOp(PocketParser.RelationalOpContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitAdditiveOp(PocketParser.AdditiveOpContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitMultiplicativeOp(PocketParser.MultiplicativeOpContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitUnaryOp(PocketParser.UnaryOpContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDecl(PocketParser.DeclContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDestructuringList(PocketParser.DestructuringListContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitExprStmt(PocketParser.ExprStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDeclStmt(PocketParser.DeclStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDestructingStmt(PocketParser.DestructingStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitAssgnStmt(PocketParser.AssgnStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitBreakStmt(PocketParser.BreakStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitExpr(PocketParser.ExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPipeExpr(PocketParser.PipeExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitLogicOrExpr(PocketParser.LogicOrExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitLogicAndExpr(PocketParser.LogicAndExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitEqualityExpr(PocketParser.EqualityExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitRelationalExpr(PocketParser.RelationalExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitAdditiveExpr(PocketParser.AdditiveExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitMultiplicativeExpr(PocketParser.MultiplicativeExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitUnaryExpr(PocketParser.UnaryExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIdExpr(PocketParser.IdExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIntLiteralExpr(PocketParser.IntLiteralExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFloatLiteralExpr(PocketParser.FloatLiteralExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitStringLiteralExpr(PocketParser.StringLiteralExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFnExpr(PocketParser.FnExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIfExpr(PocketParser.IfExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitLoopExpr(PocketParser.LoopExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitImportExpr(PocketParser.ImportExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitParenExpr(PocketParser.ParenExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPostfixExpr(PocketParser.PostfixExprContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitArgList(PocketParser.ArgListContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitType(PocketParser.TypeContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitParam(PocketParser.ParamContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitParamList(PocketParser.ParamListContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitLambda(PocketParser.LambdaContext ctx) {
        return null;
    }

    @Override
    public ASTNode visit(ParseTree tree) {
        return null;
    }

    @Override
    public ASTNode visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public ASTNode visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public ASTNode visitErrorNode(ErrorNode node) {
        return null;
    }
}
