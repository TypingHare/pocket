package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public final class FloatLiteralExpr extends LiteralExpr {
    public final float value;

    public FloatLiteralExpr(@NotNull final ASTNode node, @NotNull final String literal) {
        super(node, literal);
        this.value = Float.parseFloat(literal);
    }
}
