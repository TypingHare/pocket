package pocket

import pocket.ast.builder.ProgramBuilder
import pocket.transpiler.Transpiler
import java.nio.file.Path
import kotlin.reflect.KClass

class Transpilation(
    val transpilerClass: KClass<out Transpiler>,
    val modulePathList: List<Path>,
) {
    fun transpile(entryFilepath: Path): String {
        // Build the raw abstract syntax tree
        val program = ProgramBuilder(entryFilepath, modulePathList).build()

        // Semantic analysis
//        ScopeVisitor().visitProgram(program)
//        ResolveTypeVisitor().visitProgram(program)
//
        // Create the transpiler and transpiles the program abstract syntax tree
        // into a target language program
        val transpiler = transpilerClass.constructors.first().call(program)

        return transpiler.transpile()
    }
}
