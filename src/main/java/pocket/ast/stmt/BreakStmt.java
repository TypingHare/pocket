package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;

public final class BreakStmt extends Stmt {
    @NotNull public final Expr condition;

    public BreakStmt(@NotNull final ASTNode node, @NotNull final Expr condition) {
        super(node);
        this.condition = condition;
    }
}
