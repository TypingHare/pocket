package pocket.ast.visitor

import pocket.ast.DeclKeyword
import pocket.ast.Scope
import pocket.ast.Symbol
import pocket.ast.node.*

/**
 * Scope analysis.
 */
class ScopeVisitor() : StructuralVisitor<Scope>() {
    override fun visitProgram(program: Program): Scope =
        Scope(Scope.Root).apply {
            program.moduleFnList.map { visitModuleFn(it) }
            program.moduleFnList.forEach {
                it.scope = Scope(this, it.scope.symbols)
            }

            program.globalScope = this
        }

    override fun visitModuleFn(moduleFn: ModuleFn): Scope =
        visitLambdaExpr(moduleFn as LambdaExpr)

    override fun visitLambdaExpr(expr: LambdaExpr): Scope =
        Scope(Scope.Unknown).apply {
            // Resolve parameters
            expr.paramMap.forEach { (idExpr, paramExpr) ->
                define(
                    Symbol(
                        idExpr.name, paramExpr,
                        isMutable = false,
                        isDestructured = false
                    )
                )
            }

            expr.stmtList.forEach { resolveStmt(it, this) }
            expr.scope = this
        }

    private fun resolveStmt(stmt: Stmt, scope: Scope) {
        when (stmt) {
            is DeclStmt -> {
                val isMutable = stmt.declKeyword == DeclKeyword.LET
                scope.define(Symbol(stmt.id.name, stmt.value, isMutable, false))
            }
            is DestructingStmt -> {
                val isMutable = stmt.declKeyword == DeclKeyword.LET
                for (id in stmt.idList) {
                    scope.define(Symbol(id.name, stmt.value, isMutable, true))
                }
            }
            is NativeStmt -> {
                scope.define(
                    Symbol(
                        stmt.id.name, stmt.id,
                        isMutable = false,
                        isDestructured = false
                    )
                )
            }
        }
    }
}

