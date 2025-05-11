package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public final class DestructingStmt extends Stmt {
    public DestructingStmt(@NotNull final ASTNode node) {
        super(node);
    }
}
