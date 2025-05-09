package pocket;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;

import pocket.antlr.PocketLexer;
import pocket.antlr.PocketParser;
import pocket.visitor.TranspilerVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/** Pocket transpiler can transpile a Pocket file into a single JavaScript file. */
public final class PocketTranspiler {
    /** The working directory of the transpiler. */
    public final Path workingDirectory;

    /** Maps filenames to Pocket parsers. */
    public final Map<String, PocketParser> parsers = new HashMap<>();

    /** Maps filenames to the generated JavaScript functions. */
    public final Map<String, String> fileFunctions = new HashMap<>();

    /** Entry file function name. */
    public String entryFileFunctionName = null;

    /** Creates a Pocket transpiler */
    public PocketTranspiler(@NotNull final Path workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    /** Parses a Pocket file. */
    public @NotNull PocketParser parse(@NotNull final String filename) throws IOException {
        final var path = workingDirectory.resolve(filename);
        final var sourceCode = String.join("\n", Files.readAllLines(path));
        final var lexer = new PocketLexer(CharStreams.fromString(sourceCode));
        final var parser = new PocketParser(new CommonTokenStream(lexer));

        parsers.put(filename, parser);
        return parser;
    }

    public void transpile(@NotNull final String filename) throws IOException {
        final var parser = parse(filename);
        final var program = parser.program();

        final var fileFunctionName = getFileFunctionName(filename);
        final var transpilerVisitor = new TranspilerVisitor(fileFunctionName);
        final var targetCode = transpilerVisitor.visit(program);

        fileFunctions.put(filename, targetCode);
    }

    public void transpileEntry(@NotNull final String filename) throws IOException {
        transpile(filename);
        entryFileFunctionName = getFileFunctionName(filename);
    }

    public @NotNull String generateJavaScriptFile() {
        final var libraryString =
"""

function println(x) { console.log(x); }

""";
        final var callEntryFileFunction =
                String.format("const exitCode = %s();", entryFileFunctionName);

        return String.join("\n", fileFunctions.values()) + libraryString + callEntryFileFunction;
    }

    @NotNull
    private String getFileFunctionName(@NotNull final String filename) {
        return "$_" + filename.replace('.', '_').replace("/", "__");
    }
}
