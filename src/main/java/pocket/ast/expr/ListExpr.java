package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ListExpr extends Expr {
    @NotNull public final List<Expr> elements = new ArrayList<>();

    public ListExpr(
        @NotNull final ASTNode node,
        @NotNull final List<Expr> elements
    ) {
        super(node);
        this.elements.addAll(elements);
    }
}
