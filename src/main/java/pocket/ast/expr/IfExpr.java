package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pocket.ast.ASTNode;

public final class IfExpr extends Expr {
    @NotNull public final Expr condition;
    @NotNull public final Expr thenBranch;
    @Nullable public final Expr elseBranch;

    public IfExpr(
            @NotNull final ASTNode node,
            @NotNull final Expr condition,
            @NotNull final Expr thenBranch,
            @Nullable final Expr elseBranch) {
        super(node);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }
}
