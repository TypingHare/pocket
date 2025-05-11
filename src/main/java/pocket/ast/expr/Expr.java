package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public abstract class Expr extends ASTNode {
    public Expr(@NotNull final ASTNode node) {
        super(node);
    }
}
