package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.expr.TypeExpr;

public final class DeclStmt extends Stmt {
    public final boolean isExport;
    @NotNull public final IdExpr id;
    @NotNull public final TypeExpr type;
    @NotNull public final Expr value;

    public DeclStmt(
            @NotNull final ASTNode node,
            final boolean isExport,
            @NotNull final IdExpr id,
            @NotNull final TypeExpr type,
            @NotNull final Expr value) {
        super(node);
        this.isExport = isExport;
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
