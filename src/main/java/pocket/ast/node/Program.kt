package pocket.ast.node

class Program(node: ASTNode, val moduleFnList: List<ModuleFn>) : ASTNode(node)

class ModuleFn(
    node: ASTNode,
    val fnName: String,
    stmtList: List<Stmt>,
    returnExpr: Expr?
) : LambdaExpr(node, true, emptyMap(), stmtList, returnExpr)
