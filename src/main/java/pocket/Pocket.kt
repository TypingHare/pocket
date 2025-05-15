package pocket

import picocli.CommandLine
import pocket.transpiler.Transpiler
import pocket.transpiler.js.JavaScriptTranspiler
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.Callable
import kotlin.reflect.KClass
import kotlin.system.exitProcess

@CommandLine.Command(
    name = "pocket",
    mixinStandardHelpOptions = true,
    version = ["0.0.0"],
    description = ["Pocket transpiler."]
)
object Pocket : Callable<Int?> {
    @CommandLine.Parameters(
        index = "0",
        description = ["The path to the entry file."]
    )
    private var entryFilepath: String = ""

    @CommandLine.Option(
        names = ["-o", "--output"],
        description = ["The name of the output file."],
        defaultValue = "out.js"
    )
    private var outputFilepath: String = "out.js"

    @CommandLine.Option(
        names = ["-n", "--no-emit"],
        description = ["Do not emit the generated code."],
        defaultValue = "false"
    )
    private var shouldNoEmit = false

    @Throws(Exception::class)
    override fun call(): Int {
        val workingDirectory = Path.of(System.getProperty("user.dir"))
        val entryFilepath = workingDirectory.resolve(Path.of(entryFilepath))
        val transpilation = Transpilation(getTranspiler())
        val targetCode = transpilation.transpile(entryFilepath)

        when (shouldNoEmit) {
            true -> executeTargetCode(targetCode)
            false -> Files.writeString(
                workingDirectory.resolve(outputFilepath),
                targetCode
            )
        }

        return CommandLine.ExitCode.OK
    }

    private fun getTranspiler(): KClass<out Transpiler> {
        return JavaScriptTranspiler::class
    }

    @Throws(IOException::class, InterruptedException::class)
    private fun executeTargetCode(targetCode: String) {
        val processBuilder = ProcessBuilder("node")
        val process = processBuilder.start()

        BufferedWriter(OutputStreamWriter(process.outputStream)).use { writer ->
            writer.write(targetCode)
            writer.flush()
        }

        BufferedReader(InputStreamReader(process.inputStream)).use { reader ->
            var line: String?
            while ((reader.readLine().also { line = it }) != null) {
                println(line)
            }
        }

        BufferedReader(InputStreamReader(process.errorStream)).use { errReader ->
            var errLine: String?
            while ((errReader.readLine().also { errLine = it }) != null) {
                System.err.println(errLine)
            }
        }

        exitProcess(process.waitFor())
    }

    @JvmStatic
    fun main(args: Array<String>) {
        exitProcess(CommandLine(Pocket).execute(*args))
    }
}