package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;

public final class AssgnStmt extends Stmt {
    @NotNull public final IdExpr idExpr;
    @NotNull public final Expr value;

    public AssgnStmt(
            @NotNull final ASTNode node, @NotNull final IdExpr idExpr, @NotNull final Expr value) {
        super(node);
        this.idExpr = idExpr;
        this.value = value;
    }
}
