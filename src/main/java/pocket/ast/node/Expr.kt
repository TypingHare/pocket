package pocket.ast.node

import pocket.ast.BinaryOperator
import pocket.ast.LiteralType
import pocket.ast.Scope
import pocket.ast.UnaryOperator

abstract class Expr(node: ASTNode, var type: Type = Type.Any) : ASTNode(node)

class LiteralExpr(
    node: ASTNode,
    val literalType: LiteralType,
    val literal: String
) : Expr(node)

class IdExpr(node: ASTNode, val name: String) : Expr(node)

class MemberExpr(node: ASTNode, val expr: Expr, val name: String) : Expr(node)

class BinaryExpr(
    node: ASTNode,
    val operator: BinaryOperator,
    val left: Expr,
    val right: Expr,
) : Expr(node)

class UnaryExpr(
    node: ASTNode,
    val operator: UnaryOperator,
    val operand: Expr
) : Expr(node)

open class LambdaExpr(
    node: ASTNode,
    val isTrade: Boolean,
    val paramMap: Map<IdExpr, TypeExpr?>,
    val stmtList: List<Stmt>,
    val returnExpr: Expr?,
    var scope: Scope = Scope.Unresolved
) : Expr(node)

class YieldExpr(
    node: ASTNode,
    val initializer: Expr,
    val isAlive: Expr,
    val toYield: Expr,
    val updater: Expr,
) : Expr(node)

class CallExpr(
    node: ASTNode,
    val isPartial: Boolean,
    val callee: Expr,
    val argList: List<Expr>
) : Expr(node)

class ListExpr(node: ASTNode, val itemList: List<Expr>) : Expr(node)

class ObjectExpr(
    node: ASTNode,
    val fieldMap: Map<IdExpr, Expr>
) : Expr(node)

class IfExpr(
    node: ASTNode,
    val condition: Expr,
    val thenFn: Expr,
    val elseFn: Expr?
) : Expr(node)

class LoopExpr(node: ASTNode, val fn: Expr) : Expr(node)

class TypeExpr(node: ASTNode, val expr: Expr) : Expr(node)

class ImportExpr(node: ASTNode, val targetPath: String) : Expr(node)