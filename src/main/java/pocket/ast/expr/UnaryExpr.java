package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.symbol.UnaryOp;

public final class UnaryExpr extends Expr {
  @NotNull public final UnaryOp op;
  @NotNull public final Expr operand;

  public UnaryExpr(
      @NotNull final ASTNode node, @NotNull final UnaryOp op, @NotNull final Expr operand) {
    super(node);
    this.op = op;
    this.operand = operand;
  }
}
