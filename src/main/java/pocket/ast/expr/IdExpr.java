package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public final class IdExpr extends Expr {
  @NotNull public final String text;

  public IdExpr(@NotNull final ASTNode node, @NotNull final String text) {
    super(node);
    this.text = text;
  }
}
