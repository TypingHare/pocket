package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public final class UnaryExpr extends Expr {
    @NotNull public final Expr operand;

    public UnaryExpr(@NotNull final ASTNode node, @NotNull final Expr operand) {
        super(node);
        this.operand = operand;
    }
}
