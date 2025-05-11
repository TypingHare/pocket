package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.symbol.BinaryOp;

public final class EqualityExpr extends BinaryExpr {
    public EqualityExpr(
            @NotNull final ASTNode node,
            @NotNull final Expr left,
            @NotNull final BinaryOp op,
            @NotNull final Expr right) {
        super(node, left, op, right);
    }
}
