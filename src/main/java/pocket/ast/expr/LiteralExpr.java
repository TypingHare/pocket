package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public abstract class LiteralExpr extends Expr {
  @NotNull public final String literal;

  public LiteralExpr(@NotNull final ASTNode node, @NotNull final String literal) {
    super(node);
    this.literal = literal;
  }
}
