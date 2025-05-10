package pocket;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;

import pocket.antlr.PocketLexer;
import pocket.antlr.PocketParser;
import pocket.visitor.GlobalVisitor;
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

    /** Maps filenames to AST. */
    public final Map<String, PocketParser.ProgramContext> parsers = new HashMap<>();

    /** Maps filenames to the generated JavaScript functions. */
    public final Map<String, String> fileFunctions = new HashMap<>();

    /** Entry file function name. */
    public String entryFileFunctionName = null;

    /** Creates a Pocket transpiler */
    public PocketTranspiler(@NotNull final Path workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    /** Parses a Pocket file. */
    public @NotNull PocketParser.ProgramContext parse(@NotNull final String filename)
            throws IOException {
        if (parsers.containsKey(filename)) {
            return parsers.get(filename);
        }

        final var path = workingDirectory.resolve(filename);
        final var sourceCode = String.join("\n", Files.readAllLines(path));
        final var lexer = new PocketLexer(CharStreams.fromString(sourceCode));
        final var parser = new PocketParser(new CommonTokenStream(lexer));

        final var cst = parser.program();
        parsers.put(filename, cst);

        return cst;
    }

    public void transpile(@NotNull final String filename) throws IOException {
        if (fileFunctions.containsKey(filename)) {
            return;
        }

        final var cst = parse(filename);

        final var fileFunctionName = getFileFunctionName(filename);
        final var transpilerVisitor = new TranspilerVisitor(fileFunctionName);
        var targetCode = transpilerVisitor.visit(cst);

        if (!getFileFunctionName(filename).equals(entryFileFunctionName)) {
            targetCode = targetCode + String.format("%s();\n", getFileFunctionName(filename));
        }

        fileFunctions.put(filename, targetCode);
    }

    public void transpileEntry(@NotNull final String filename) throws IOException {
        entryFileFunctionName = getFileFunctionName(filename);

        final var globalVisitor = new GlobalVisitor(filename, this);
        globalVisitor.visit(parse(filename));

        transpile(filename);
    }

    public @NotNull String generateJavaScriptFile() {
        final var header =
"""
$global = {}; \n
function $loop(fn) { while(true) { if (fn() === true) break } } \n
function println(x) { console.log(x); }
""";
        final var callEntryFileFunction =
                String.format(
                        "const exitCode = %s();\nprocess.exit(exitCode);", entryFileFunctionName);

        return header + String.join("\n", fileFunctions.values()) + callEntryFileFunction;
    }

    @NotNull
    public static String getFileFunctionName(@NotNull final String filename) {
        return "$_" + filename.replace('.', '_').replace("/", "__");
    }
}
