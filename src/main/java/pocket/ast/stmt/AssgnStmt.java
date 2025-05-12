package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;

public final class AssgnStmt extends Stmt {
  @NotNull public final IdExpr id;
  @NotNull public final Expr value;

  public AssgnStmt(
      @NotNull final ASTNode node, @NotNull final IdExpr id, @NotNull final Expr value) {
    super(node);
    this.id = id;
    this.value = value;
  }
}
