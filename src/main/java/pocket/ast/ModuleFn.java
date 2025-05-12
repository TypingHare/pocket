package pocket.ast;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pocket.ast.expr.Expr;
import pocket.ast.stmt.Stmt;

public final class ModuleFn extends ASTNode {
  @NotNull public final String name;
  @NotNull public final List<Stmt> stmts = new ArrayList<>();
  @Nullable public final Expr expr;

  public ModuleFn(
      @NotNull final ASTNode node,
      @NotNull final String name,
      @NotNull final List<Stmt> stmts,
      @Nullable final Expr expr) {
    super(node);
    this.name = name;
    this.stmts.addAll(stmts);
    this.expr = expr;
  }
}
