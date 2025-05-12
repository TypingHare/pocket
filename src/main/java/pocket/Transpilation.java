package pocket;

import java.io.IOException;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import pocket.ast.ProgramBuilder;
import pocket.transpiler.Transpiler;

public record Transpilation(@NotNull Transpiler transpiler) {
  @NotNull
  public String transpile(@NotNull final Path workingDirectory, @NotNull final String entryFilepath)
      throws IOException {
    final var program =
        new ProgramBuilder(workingDirectory, entryFilepath, transpiler.getModuleFnNameGenerator())
            .buildProgram();

    return transpiler.transpile(entryFilepath, program);
  }
}
