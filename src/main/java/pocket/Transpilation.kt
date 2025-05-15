package pocket

import pocket.ast.builder.ProgramBuilder
import pocket.transpiler.Transpiler
import java.nio.file.Path
import kotlin.reflect.KClass

class Transpilation(val transpilerClass: KClass<out Transpiler>) {
    fun transpile(entryFilepath: Path): String {
        val transpiler = transpilerClass.constructors.first().call()
        val program = ProgramBuilder(entryFilepath).build()

        return transpiler.transpile(program)
    }
}