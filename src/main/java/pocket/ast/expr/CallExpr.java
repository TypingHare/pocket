package pocket.ast.expr;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public class CallExpr extends Expr {
  public final Expr callee;
  public final List<Expr> argList = new ArrayList<>();

  public CallExpr(
      @NotNull final ASTNode node, @NotNull final Expr callee, @NotNull final List<Expr> list) {
    super(node);
    this.callee = callee;
    this.argList.addAll(list);
  }
}
