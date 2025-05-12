package pocket.ast.expr;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pocket.ast.ASTNode;
import pocket.ast.stmt.Stmt;

public final class LambdaExpr extends Expr {
  public final boolean isTrade;
  @NotNull public final List<Param> paramList = new ArrayList<>();
  @NotNull public final List<Stmt> stmts = new ArrayList<>();
  @Nullable public final Expr expr;

  public LambdaExpr(
      @NotNull final ASTNode node,
      final boolean isTrade,
      @NotNull final List<Param> parmaList,
      @NotNull final List<Stmt> stmts,
      @Nullable final Expr expr) {
    super(node);
    this.isTrade = isTrade;
    this.paramList.addAll(parmaList);
    this.stmts.addAll(stmts);
    this.expr = expr;
  }

  public static final class Param extends ASTNode {
    @NotNull public final IdExpr id;
    @Nullable public final TypeExpr type;

    public Param(
        @NotNull final ASTNode node, @NotNull final IdExpr id, @Nullable final TypeExpr type) {
      super(node);
      this.id = id;
      this.type = type;
    }
  }
}
