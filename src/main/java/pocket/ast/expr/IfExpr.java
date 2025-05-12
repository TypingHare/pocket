package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pocket.ast.ASTNode;

public final class IfExpr extends Expr {
  @NotNull public final Expr condition;
  @NotNull public final Expr thenFn;
  @Nullable public final Expr elseFn;

  public IfExpr(
      @NotNull final ASTNode node,
      @NotNull final Expr condition,
      @NotNull final Expr thenFn,
      @Nullable final Expr elseFn) {
    super(node);
    this.condition = condition;
    this.thenFn = thenFn;
    this.elseFn = elseFn;
  }
}
