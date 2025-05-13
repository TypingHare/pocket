package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;

public class ExprStmt extends Stmt {
    @NotNull
    public final Expr expr;

    public ExprStmt(@NotNull final ASTNode node, @NotNull final Expr expr) {
        super(node);
        this.expr = expr;
    }
}
