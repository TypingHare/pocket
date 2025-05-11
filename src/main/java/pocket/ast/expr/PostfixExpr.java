package pocket.ast.expr;

import org.jetbrains.annotations.NotNull;

import pocket.ast.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class PostfixExpr extends Expr {
    public final List<ArgList> list = new ArrayList<>();

    public PostfixExpr(@NotNull final ASTNode node, @NotNull final List<ArgList> list) {
        super(node);
        this.list.addAll(list);
    }

    public static final class ArgList extends ASTNode {
        public final List<Expr> args = new ArrayList<>();

        public ArgList(@NotNull ASTNode node) {
            super(node);
        }
    }
}
