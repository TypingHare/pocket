package pocket

import picocli.CommandLine
import pocket.provider.NodeProcessProvider
import pocket.transpiler.Transpiler
import pocket.transpiler.js.JavaScriptTranspiler
import java.io.IOException
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
        negatable = true,
        description = ["Do not emit the generated code."],
        defaultValue = "true"
    )
    private var shouldEmit = true

    @CommandLine.Option(
        names = ["-e", "--execute"],
        description = ["Execute the generated code."],
        defaultValue = "false"
    )
    private var shouldExecute = false

    @CommandLine.Option(
        names = ["-t", "--target"],
        description = ["The target language of the generated code."],
        defaultValue = "JavaScript"
    )
    private var targetLanguage: String = "JavaScript"

    @Throws(Exception::class)
    override fun call(): Int {
        val workingDirectory = Path.of(System.getProperty("user.dir"))
        val entryFilepath = workingDirectory.resolve(Path.of(entryFilepath))
        val targetCode = Transpilation(getTranspiler()).transpile(entryFilepath)

        if (shouldEmit) {
            Files.writeString(
                workingDirectory.resolve(outputFilepath),
                targetCode
            )
        }

        if (shouldExecute) {
            executeTargetCode(targetCode)
        }

        return CommandLine.ExitCode.OK
    }

    private fun getTranspiler(): KClass<out Transpiler> =
        when (targetLanguage) {
            "JavaScript" -> JavaScriptTranspiler::class
            else -> error("Unsupported target language: $targetLanguage")
        }

    @Throws(IOException::class, InterruptedException::class)
    private fun executeTargetCode(targetCode: String) {
        val process = getProcessProvider().get()

        process.outputStream.bufferedWriter().use {
            it.write(targetCode)
        }

        process.inputStream.bufferedReader().useLines { lines ->
            lines.forEach { println(it) }
        }

        process.errorStream.bufferedReader().useLines { lines ->
            lines.forEach { println(it) }
        }

        exitProcess(process.waitFor())
    }

    private fun getProcessProvider(): NodeProcessProvider =
        when (targetLanguage) {
            "JavaScript" -> NodeProcessProvider()
            else -> error("Unsupported target language: $targetLanguage")
        }

    @JvmStatic
    fun main(args: Array<String>) {
        exitProcess(CommandLine(Pocket).execute(*args))
    }
}