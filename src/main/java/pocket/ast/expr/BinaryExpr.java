package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ASTNode;
import pocket.ast.symbol.BinaryOp;

public class BinaryExpr extends Expr {
    @NotNull
    public final Expr left;
    @NotNull
    public final BinaryOp op;
    @NotNull
    public final Expr right;

    public BinaryExpr(
        @NotNull final ASTNode node,
        @NotNull final Expr left,
        @NotNull final BinaryOp op,
        @NotNull final Expr right) {
        super(node);
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
