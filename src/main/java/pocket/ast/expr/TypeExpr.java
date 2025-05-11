package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pocket.ast.ASTNode;

public final class TypeExpr extends Expr {
    @Nullable public final IdExpr id;

    public TypeExpr(@NotNull final ASTNode node, @Nullable final IdExpr id) {
        super(node);
        this.id = id;
    }
}
