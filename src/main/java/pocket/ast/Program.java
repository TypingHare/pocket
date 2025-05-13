package pocket.ast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class Program extends ASTNode {
    @NotNull
    public final List<ModuleFn> moduleFnList = new ArrayList<>();

    public Program(@NotNull final ASTNode node) {
        super(node);
    }
}
