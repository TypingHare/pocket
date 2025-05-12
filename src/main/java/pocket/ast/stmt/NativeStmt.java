package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.expr.IdExpr;

public class NativeStmt extends Stmt {
  @NotNull final IdExpr id;

  public NativeStmt(@NotNull final ASTNode node, @NotNull final IdExpr id) {
    super(node);
    this.id = id;
  }
}
