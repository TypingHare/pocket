package pocket.ast.node

import pocket.ast.DependencyTree

class Program(
    node: ASTNode,
    val moduleFnList: List<ModuleFn>,
    val dependencyTree: DependencyTree,
) : ASTNode(node)

class ModuleFn(
    node: ASTNode,
    stmtList: List<Stmt>,
    returnExpr: Expr?
) : LambdaExpr(node, true, emptyMap(), stmtList, returnExpr)
