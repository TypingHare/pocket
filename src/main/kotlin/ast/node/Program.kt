package pocket.ast.node

import pocket.ast.DependencyGraph
import pocket.ast.Scope
import java.nio.file.Path

class Program(
    node: Node,
    val dependencyGraph: DependencyGraph<Path>,
    val moduleFnMap: Map<Path, ModuleFn>,
    val moduleFnList: List<ModuleFn>,
    var globalScope: Scope,
) : Node(node) {
    fun getModuleFn(moduleFnPath: Path, targetPath: String): ModuleFn {
        val targetPath = moduleFnPath.parent.resolve(targetPath)
        return moduleFnMap[targetPath]
            ?: throw IllegalArgumentException("Module not resolved: $targetPath")
    }
}

/**
 * Represents a module function.
 *
 * @param node The original AST node containing file and location information.
 * @param stmtList The list of statements that make up the function body.
 * @param returnExpr The expression that represents the return value of the
 *     function, or null if the function does not return a value.
 */
class ModuleFn(
    node: Node,
    stmtList: List<Stmt>,
    returnExpr: Expr?,
) : LambdaExpr(node, true, emptyMap(), stmtList, returnExpr)
