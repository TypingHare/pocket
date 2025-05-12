package pocket.ast;

import pocket.ast.expr.*;
import pocket.ast.stmt.*;

public class BaseProgramVisitor<T> extends ProgramVisitor<T> {
  @Override
  public T visitProgram(final Program program) {
    program.moduleFnList.forEach(this::visitModuleFn);
    return null;
  }

  @Override
  public T visitModuleFn(final ModuleFn moduleFn) {
    moduleFn.stmts.forEach(this::visitStmt);
    if (moduleFn.expr != null) visitExpr(moduleFn.expr);

    return null;
  }

  @Override
  public T visitAssngStmt(final AssgnStmt assnStmt) {
    visitExpr(assnStmt.value);
    return null;
  }

  @Override
  public T visitBreakStmt(final BreakStmt breakStmt) {
    visitExpr(breakStmt.condition);
    return null;
  }

  @Override
  public T visitDeclStmt(final DeclStmt declStmt) {
    visitTypeExpr(declStmt.type);
    visitExpr(declStmt.value);
    return null;
  }

  @Override
  public T visitDestructingStmt(final DestructingStmt stmt) {
    visitExpr(stmt.expr);
    return null;
  }

  @Override
  public T visitExprStmt(final ExprStmt stmt) {
    visitExpr(stmt.expr);
    return null;
  }

  @Override
  public T visitNativeStmt(final NativeStmt stmt) {
    return null;
  }

  @Override
  public T visitBinaryExpr(final BinaryExpr expr) {
    visitExpr(expr.left);
    visitExpr(expr.right);
    return null;
  }

  @Override
  public T visitFloatLiteralExpr(final FloatLiteralExpr expr) {
    return null;
  }

  @Override
  public T visitIdExpr(final IdExpr expr) {
    return null;
  }

  @Override
  public T visitIfExpr(final IfExpr expr) {
    visitExpr(expr.condition);
    visitExpr(expr.thenFn);
    if (expr.elseFn != null) visitExpr(expr.elseFn);
    return null;
  }

  @Override
  public T visitImportExpr(final ImportExpr expr) {
    return null;
  }

  @Override
  public T visitIntLiteralExpr(final IntLiteralExpr expr) {
    return null;
  }

  @Override
  public T visitLambdaExpr(final LambdaExpr expr) {
    expr.stmts.forEach(this::visitStmt);
    if (expr.expr != null) visitExpr(expr.expr);
    return null;
  }

  @Override
  public T visitLoopExpr(final LoopExpr expr) {
    visitExpr(expr.expr);
    return null;
  }

  @Override
  public T visitCallExpr(final CallExpr expr) {
    visitExpr(expr.callee);
    expr.argList.forEach(this::visitExpr);
    return null;
  }

  @Override
  public T visitStringLiteralExpr(final StringLiteralExpr expr) {
    return null;
  }

  @Override
  public T visitTypeExpr(final TypeExpr expr) {
    return null;
  }

  @Override
  public T visitUnaryExpr(final UnaryExpr expr) {
    visitExpr(expr.operand);
    return null;
  }
}
