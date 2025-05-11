package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public final class LoopExpr extends Expr {
    @NotNull public final Expr expr;

    public LoopExpr(@NotNull final ASTNode node, @NotNull final Expr expr) {
        super(node);
        this.expr = expr;
    }
}
