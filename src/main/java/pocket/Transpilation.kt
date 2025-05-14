package pocket

import pocket.ast.builder.ProgramBuilder
import pocket.transpiler.Transpiler
import java.nio.file.Path

class Transpilation(val transpiler: Transpiler) {
    fun transpile(entryFilepath: Path): String {
        val fnNameGenerator = transpiler::fnNameGenerator
        val program = ProgramBuilder(entryFilepath, fnNameGenerator).build()

        return transpiler.transpile(program)
    }
}