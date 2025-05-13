package pocket.transpiler.js;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ModuleFnNameGenerator;
import pocket.ast.Program;
import pocket.transpiler.Transpiler;
import pocket.utility.FileUtility;

import java.nio.file.Path;

public final class JavaScriptTranspiler implements Transpiler {
    @Override
    public @NotNull String transpile(
        @NotNull final String entryFilepath, @NotNull final Program program) {
        final var moduleFnNameGenerator = this.getModuleFnNameGenerator();
        final var directory = Path.of("src/main/resources/pocket/js");
        return new JavaScriptTranspileProgramVisitor(moduleFnNameGenerator, directory)
            .visitProgram(program);
    }

    @Override
    public @NotNull ModuleFnNameGenerator getModuleFnNameGenerator() {
        return (filepath ->
            "$_" + FileUtility.removeExtension(filepath).replace('/', '_').replace('\\', '_'));
    }
}
