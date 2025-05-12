package pocket.transpiler;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ModuleFnNameGenerator;
import pocket.ast.Program;

public interface Transpiler {
  /**
   * Transpiles a Pocket abstract syntax tree into a target language.
   *
   * @param entryFilepath The path to the Pocket source file.
   * @param program A Pocket abstract syntax tree.
   * @return A target code string.
   */
  @NotNull
  String transpile(@NotNull final String entryFilepath, @NotNull final Program program);

  @NotNull
  ModuleFnNameGenerator getModuleFnNameGenerator();
}
