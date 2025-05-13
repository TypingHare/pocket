package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public final class IntLiteralExpr extends LiteralExpr {
    public final int value;

    public IntLiteralExpr(@NotNull final ASTNode node, @NotNull final String literal) {
        super(node, literal);
        this.value = Integer.parseInt(literal);
    }
}
