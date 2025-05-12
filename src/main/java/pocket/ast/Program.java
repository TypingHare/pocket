package pocket.ast;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Program extends ASTNode {
  @NotNull public final List<ModuleFn> moduleFnList = new ArrayList<>();

  public Program(@NotNull final ASTNode node) {
    super(node);
  }
}
