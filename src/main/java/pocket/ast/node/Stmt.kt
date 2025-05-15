package pocket.ast.node

import pocket.ast.DeclKeyword

abstract class Stmt(node: ASTNode) : ASTNode(node)

class ExprStmt(node: ASTNode, val expr: Expr) : Stmt(node)

class DeclStmt(
    node: ASTNode,
    val isExport: Boolean,
    val declKeyword: DeclKeyword,
    val id: IdExpr,
    val type: TypeExpr?,
    val value: Expr
) : Stmt(node)

class AssignmentStmt(
    node: ASTNode,
    val id: IdExpr,
    val value: Expr
) : Stmt(node)

class DestructingStmt(
    node: ASTNode,
    val isExport: Boolean,
    val declKeyword: DeclKeyword,
    val idList: List<IdExpr>,
    val value: Expr
) : Stmt(node)

class BreakStmt(node: ASTNode, val condition: Expr) : Stmt(node)

class NativeStmt(
    node: ASTNode,
    val id: IdExpr,
    val type: TypeExpr?
) : Stmt(node)