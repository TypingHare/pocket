package pocket.ast.visitor

import pocket.ast.DeclKeyword
import pocket.ast.Scope
import pocket.ast.Symbol
import pocket.ast.node.DeclStmt
import pocket.ast.node.LambdaExpr
import pocket.ast.node.ModuleFn
import pocket.ast.node.Program

/**
 * Scope analysis.
 */
class ScopeVisitor() : StructuralVisitor<Scope>() {
    override fun visitProgram(program: Program): Scope =
        Scope(Scope.Root).apply {
            program.moduleFnList
                .map { visitModuleFn(it) }
                .map { Scope(this, it.symbols) }

            program.globalScope = this
        }

    override fun visitModuleFn(moduleFn: ModuleFn): Scope =
        visitLambdaExpr(moduleFn as LambdaExpr)

    override fun visitLambdaExpr(expr: LambdaExpr): Scope =
        Scope(Scope.Unknown).apply {
            for (stmt in expr.stmtList) {
                when (stmt) {
                    is DeclStmt -> {
                        val isMutable = stmt.declKeyword == DeclKeyword.LET
                        define(Symbol(stmt.id.name, stmt.value, isMutable))
                    }
                }
            }

            expr.scope = this
        }
}

