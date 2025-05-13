package pocket.ast;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;
import pocket.antlr.PocketLexer;
import pocket.antlr.PocketParser;
import pocket.ast.expr.ImportExpr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ProgramBuilder {
    @NotNull
    public final Path workingDirectory;
    @NotNull
    public final String entryFilepath;
    @NotNull
    public final Map<String, ModuleFn> moduleFnMap = new LinkedHashMap<>();
    @NotNull
    public final ModuleFnNameGenerator moduleFnNameGenerator;

    public ProgramBuilder(
        @NotNull final Path workingDirectory,
        @NotNull final String entryFilepath,
        @NotNull final ModuleFnNameGenerator moduleFnNameGenerator) {
        this.workingDirectory = workingDirectory;
        this.entryFilepath = entryFilepath;
        this.moduleFnNameGenerator = moduleFnNameGenerator;
    }

    private void parse(@NotNull final String filepath) throws IOException {
        if (moduleFnMap.containsKey(filepath)) {
            return;
        }

        final var absolutePath = workingDirectory.resolve(filepath);
        final var sourceCode = String.join("\n", Files.readAllLines(absolutePath));
        final var lexer = new PocketLexer(CharStreams.fromString(sourceCode));
        final var parser = new PocketParser(new CommonTokenStream(lexer));
        final var cst = parser.moduleFn();

        final var functionName = moduleFnNameGenerator.generate(filepath);
        final var astBuilder = new ModuleFnASTBuilder(filepath, functionName);
        final var ast = astBuilder.<ModuleFn>visitFor(cst);

        new ImportProgramVisitor(this).visitModuleFn(ast);

        moduleFnMap.put(filepath, ast);
    }

    @NotNull
    public Program buildProgram() throws IOException {
        parse(entryFilepath);

        final var moduleFnList = new ArrayList<>(moduleFnMap.values());
        final var program = new Program(moduleFnList.getFirst());
        program.moduleFnList.addAll(moduleFnList);

        return program;
    }

    private static final class ImportProgramVisitor extends BaseProgramVisitor<Object> {
        @NotNull
        private final ProgramBuilder programBuilder;

        public ImportProgramVisitor(@NotNull final ProgramBuilder programBuilder) {
            this.programBuilder = programBuilder;
        }

        @Override
        public Object visitImportExpr(final ImportExpr expr) {
            try {
                programBuilder.parse(expr.path);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            return null;
        }
    }
}
