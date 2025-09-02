package pocket

import pocket.transpiler.javascript.JavaScriptTranspiler
import kotlin.io.path.Path

fun main() {
    val samplesDirPath = Path(System.getProperty("user.dir")).resolve("samples")
    val targetCode = Transpilation(JavaScriptTranspiler::class, listOf(
        samplesDirPath
    )).transpile(samplesDirPath.resolve("demo.pk"))

    println(targetCode)
}