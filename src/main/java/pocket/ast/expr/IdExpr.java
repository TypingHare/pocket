package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public final class IdExpr extends Expr {
    @NotNull public final String id;

    public IdExpr(@NotNull final ASTNode node, @NotNull final String id) {
        super(node);
        this.id = id;
    }
}
