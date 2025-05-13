package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public class YieldExpr extends Expr {
    @NotNull public final Expr initializer;
    @NotNull public final Expr toYield;
    @NotNull public final Expr next;
    @NotNull public final Expr isAlive;

    public YieldExpr(
        @NotNull final ASTNode node,
        @NotNull final Expr initializer,
        @NotNull final Expr toYield,
        @NotNull final Expr next,
        @NotNull final Expr isAlive
    ) {
        super(node);
        this.initializer = initializer;
        this.toYield = toYield;
        this.next = next;
        this.isAlive = isAlive;
    }
}
