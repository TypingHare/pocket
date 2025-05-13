package pocket

import pocket.ast.ProgramBuilder
import pocket.transpiler.Transpiler
import java.io.IOException
import java.nio.file.Path

@JvmRecord
data class Transpilation(val transpiler: Transpiler) {
    @Throws(IOException::class)
    fun transpile(workingDirectory: Path, entryFilepath: String): String {
        val program = ProgramBuilder(
            workingDirectory,
            entryFilepath,
            transpiler.getModuleFnNameGenerator()
        ).buildProgram()

        return transpiler.transpile(entryFilepath, program)
    }
}