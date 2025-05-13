package pocket.ast.stmt;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.symbol.DeclKeyword;

import java.util.List;

public final class DestructingStmt extends Stmt {
    public final boolean isExport;
    @NotNull
    public final DeclKeyword declKeyword;
    @NotNull
    public final List<IdExpr> idList;
    @NotNull
    public final Expr expr;

    public DestructingStmt(
        @NotNull final ASTNode node,
        final boolean isExport,
        @NotNull final DeclKeyword declKeyword,
        @NotNull final List<IdExpr> idList,
        @NotNull final Expr expr) {
        super(node);
        this.isExport = isExport;
        this.declKeyword = declKeyword;
        this.idList = idList;
        this.expr = expr;
    }
}
