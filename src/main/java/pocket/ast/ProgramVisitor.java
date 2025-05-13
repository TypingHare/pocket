package pocket.ast;

import pocket.ast.expr.*;
import pocket.ast.stmt.*;

public abstract class ProgramVisitor<T> {
    public abstract T visitProgram(final Program program);

    public abstract T visitModuleFn(final ModuleFn moduleFn);

    public T visitStmt(final Stmt stmt) {
        return switch (stmt) {
            case AssgnStmt assgnStmt -> visitAssngStmt(assgnStmt);
            case BreakStmt breakStmt -> visitBreakStmt(breakStmt);
            case DeclStmt declStmt -> visitDeclStmt(declStmt);
            case DestructingStmt destructingStmt -> visitDestructingStmt(destructingStmt);
            case ExprStmt exprStmt -> visitExprStmt(exprStmt);
            case NativeStmt nativeStmt -> visitNativeStmt(nativeStmt);
            default -> throw new IllegalStateException("Unexpected value: " + stmt);
        };
    }

    public abstract T visitAssngStmt(final AssgnStmt assnStmt);

    public abstract T visitBreakStmt(final BreakStmt breakStmt);

    public abstract T visitDeclStmt(final DeclStmt declStmt);

    public abstract T visitDestructingStmt(final DestructingStmt stmt);

    public abstract T visitExprStmt(final ExprStmt stmt);

    public abstract T visitNativeStmt(final NativeStmt stmt);

    public T visitExpr(final Expr expr) {
        return switch (expr) {
            case BinaryExpr binaryExpr -> visitBinaryExpr(binaryExpr);
            case IdExpr idExpr -> visitIdExpr(idExpr);
            case IfExpr ifExpr -> visitIfExpr(ifExpr);
            case ImportExpr importExpr -> visitImportExpr(importExpr);
            case LambdaExpr lambdaExpr -> visitLambdaExpr(lambdaExpr);
            case LiteralExpr literalExpr -> visitLiteralExpr(literalExpr);
            case LoopExpr loopExpr -> visitLoopExpr(loopExpr);
            case CallExpr postfixExpr -> visitCallExpr(postfixExpr);
            case TypeExpr typeExpr -> visitTypeExpr(typeExpr);
            case UnaryExpr unaryExpr -> visitUnaryExpr(unaryExpr);
            case YieldExpr yieldExpr -> visitYieldExpr(yieldExpr);
            default -> throw new IllegalStateException("Unexpected value: " + expr);
        };
    }

    public abstract T visitBinaryExpr(final BinaryExpr expr);

    public abstract T visitFloatLiteralExpr(final FloatLiteralExpr expr);

    public abstract T visitIdExpr(final IdExpr expr);

    public abstract T visitIfExpr(final IfExpr expr);

    public abstract T visitImportExpr(final ImportExpr expr);

    public abstract T visitIntLiteralExpr(final IntLiteralExpr expr);

    public abstract T visitLambdaExpr(final LambdaExpr expr);

    public T visitLiteralExpr(final LiteralExpr expr) {
        return switch (expr) {
            case IntLiteralExpr intLiteralExpr -> visitIntLiteralExpr(intLiteralExpr);
            case FloatLiteralExpr floatLiteralExpr -> visitFloatLiteralExpr(floatLiteralExpr);
            case StringLiteralExpr stringLiteralExpr -> visitStringLiteralExpr(stringLiteralExpr);
            default -> throw new IllegalStateException("Unexpected value: " + expr);
        };
    }

    public abstract T visitLoopExpr(final LoopExpr expr);

    public abstract T visitCallExpr(final CallExpr expr);

    public abstract T visitStringLiteralExpr(final StringLiteralExpr expr);

    public abstract T visitTypeExpr(final TypeExpr expr);

    public abstract T visitUnaryExpr(final UnaryExpr expr);

    public abstract T visitYieldExpr(final YieldExpr expr);
}
