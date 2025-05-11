package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

public abstract class Stmt extends ASTNode {
    public Stmt(@NotNull final ASTNode node) {
        super(node);
    }
}
