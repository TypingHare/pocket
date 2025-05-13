package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CallExpr extends Expr {
    public final boolean isPartial;
    public final Expr callee;
    public final List<Expr> argList = new ArrayList<>();

    public CallExpr(
        @NotNull final ASTNode node,
        final boolean isPartial,
        @NotNull final Expr callee,
        @NotNull final List<Expr> list
    ) {
        super(node);
        this.isPartial = isPartial;
        this.callee = callee;
        this.argList.addAll(list);
    }
}
