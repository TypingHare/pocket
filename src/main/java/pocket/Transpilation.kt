package pocket

import pocket.ast.builder.ProgramBuilder
import pocket.ast.visitor.ResolveTypeVisitor
import pocket.ast.visitor.ScopeVisitor
import pocket.transpiler.Transpiler
import java.nio.file.Path
import kotlin.reflect.KClass

class Transpilation(val transpilerClass: KClass<out Transpiler>) {
    fun transpile(entryFilepath: Path): String {
        // Build the raw AST
        val program = ProgramBuilder(entryFilepath).build()

        // Semantic analysis
         ScopeVisitor().visitProgram(program)
         ResolveTypeVisitor().visitProgram(program)

        val transpiler = transpilerClass.constructors.first().call(program)

        return transpiler.transpile()
    }
}