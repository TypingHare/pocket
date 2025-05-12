package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.expr.TypeExpr;
import pocket.ast.symbol.DeclKeyword;

public final class DeclStmt extends Stmt {
  public final boolean isExport;
  @NotNull public final IdExpr id;
  @NotNull public final DeclKeyword declKeyword;
  @Nullable public final TypeExpr type;
  @NotNull public final Expr value;

  public DeclStmt(
      @NotNull final ASTNode node,
      final boolean isExport,
      @NotNull final DeclKeyword declKeyword,
      @NotNull final IdExpr id,
      @Nullable final TypeExpr type,
      @NotNull final Expr value) {
    super(node);
    this.isExport = isExport;
    this.declKeyword = declKeyword;
    this.id = id;
    this.type = type;
    this.value = value;
  }
}
