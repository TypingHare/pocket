package pocket.ast.node

import pocket.ast.DependencyTree
import pocket.ast.Scope

class Program(
    node: ASTNode,
    val moduleFnList: List<ModuleFn>,
    val dependencyTree: DependencyTree,
    var globalScope: Scope = Scope()
) : ASTNode(node)

class ModuleFn(
    node: ASTNode,
    stmtList: List<Stmt>,
    returnExpr: Expr?
) : LambdaExpr(node, true, emptyMap(), stmtList, returnExpr)
