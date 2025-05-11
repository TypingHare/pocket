package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;
import pocket.ast.symbol.BinaryOp;

public final class LogicAndExpr extends BinaryExpr {
    public LogicAndExpr(
            @NotNull final ASTNode node, @NotNull final Expr left, @NotNull final Expr right) {
        super(node, left, BinaryOp.LOGIC_AND, right);
    }
}
