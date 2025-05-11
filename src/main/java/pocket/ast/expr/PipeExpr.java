package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.symbol.BinaryOp;

public final class PipeExpr extends BinaryExpr {
    public PipeExpr(@NotNull ASTNode node, @NotNull final Expr left, @NotNull final Expr right) {
        super(node, left, BinaryOp.PIPE, right);
    }
}
