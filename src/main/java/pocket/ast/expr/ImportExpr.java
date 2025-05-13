package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

public final class ImportExpr extends Expr {
    @NotNull
    public final String path;

    public ImportExpr(@NotNull final ASTNode node, @NotNull final String path) {
        super(node);
        this.path = path;
    }
}
