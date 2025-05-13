package pocket;

import org.jetbrains.annotations.NotNull;
import picocli.CommandLine;
import pocket.transpiler.js.JavaScriptTranspiler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "pocket",
    mixinStandardHelpOptions = true,
    version = "1.0.0",
    description = "Pocket transpiler.")
public class Pocket implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "The path to the entry file.")
    private String entryFilepath;

    @CommandLine.Option(
        names = {"-d", "--directory"},
        description = "The working directory.",
        defaultValue = ".")
    private String workingDirectory;

    @CommandLine.Option(
        names = {"-n", "--no-emit"},
        description = "Do not emit the generated code.",
        defaultValue = "false")
    private Boolean shouldNoEmit = false;

    @Override
    public Integer call() throws Exception {
        final var workingDirectory =
            Path.of(System.getProperty("user.dir")).resolve(this.workingDirectory);
        final var transpilation = new Transpilation(new JavaScriptTranspiler());
        final var targetCode = transpilation.transpile(workingDirectory, entryFilepath);

        if (shouldNoEmit) {
            executeTargetCode(targetCode);
        } else {
            final var outFilePath = workingDirectory.resolve("out.js");
            Files.writeString(outFilePath, targetCode);
        }

        return CommandLine.ExitCode.OK;
    }

    private void executeTargetCode(@NotNull final String targetCode)
        throws IOException, InterruptedException {
        final var processBuilder = new ProcessBuilder("node");
        final var process = processBuilder.start();

        try (final var writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
            writer.write(targetCode);
            writer.flush();
        }

        try (BufferedReader reader =
                 new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try (BufferedReader errReader =
                 new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String errLine;
            while ((errLine = errReader.readLine()) != null) {
                System.err.println(errLine);
            }
        }

        int exitCode = process.waitFor();
        System.exit(exitCode);
    }
}
