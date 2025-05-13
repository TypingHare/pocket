package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

import java.util.HashMap;
import java.util.Map;

public class ObjectExpr extends Expr {
    @NotNull public final Map<String, Expr> items = new HashMap<>();

    public ObjectExpr(
        @NotNull final ASTNode node,
        @NotNull final Map<String, Expr> items
    ) {
        super(node);
        this.items.putAll(items);
    }
}
