package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public final class StringLiteralExpr extends LiteralExpr {
    public StringLiteralExpr(@NotNull final ASTNode node, @NotNull final String literal) {
        super(node, literal);
    }
}
