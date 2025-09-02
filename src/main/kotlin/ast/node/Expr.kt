package pocket.ast.node

import pocket.ast.*
import java.nio.file.Path

/**
 * Represents an expression node.
 *
 * By default, the type of expression is Any.
 *
 * @property type The type that this expression evaluates to.
 * @param node The original AST node containing file and location information.
 */
abstract class Expr(
    node: Node,
    var type: Type = Type.Any,
) : Node(node)

/**
 * Represents a literal expression.
 *
 * @property literalType The type of the literal.
 * @property literal The actual literal value as a string.
 * @param node The original AST node containing file and location information.
 */
class LiteralExpr(
    node: Node,
    val literalType: LiteralType,
    val literal: String,
) : Expr(node)

/**
 * Represents an identifier expression.
 *
 * @property name The name of the identifier.
 * @param node The original AST node containing file and location information.
 */
class IdExpr(
    node: Node,
    val name: String,
) : Expr(node)

/**
 * Represents a member access expression.
 *
 * Typically used for accessing properties or methods of an object.
 *
 * @property expr The expression that evaluates to the object whose member is
 *     being accessed.
 * @property name The name of the member being accessed.
 * @param node The original AST node containing file and location information.
 */
class MemberExpr(
    node: Node,
    val expr: Expr,
    val name: String,
) : Expr(node)

/**
 * Represents a binary expression.
 *
 * @property operator The binary operator.
 * @property left The left-hand side operand expression.
 * @property right The right-hand side operand expression.
 * @param node The original AST node containing file and location information.
 */
class BinaryExpr(
    node: Node,
    val operator: BinaryOperator,
    val left: Expr,
    val right: Expr,
) : Expr(node)

/**
 * Represents a unary expression.
 *
 * @property operator The unary operator.
 * @property operand The operand expression.
 * @param node The original AST node containing file and location information.
 */
class UnaryExpr(
    node: Node,
    val operator: UnaryOperator,
    val operand: Expr,
) : Expr(node)

/**
 * Represents a tuple expression.
 *
 * A tuple expression is an ordered, fixed-size collection of expressions.
 *
 * @property itemList The list of expressions contained in the tuple.
 * @param node The original AST node containing file and location information.
 */
class TupleExpr(
    node: Node,
    val itemList: List<Expr>,
) : Expr(node)

/**
 * Represents a list expression.
 *
 * A list expression is an ordered, variable-size collection of expressions.
 *
 * @property itemList The list of expressions contained in the list.
 * @param node The original AST node containing file and location information.
 */
class ListExpr(
    node: Node,
    val itemList: List<Expr>,
) : Expr(node)

/**
 * Represents an object expression.
 *
 * An object expression is a collection of key-value pairs where keys are
 * identifiers and values are expressions.
 *
 * @property fieldMap A mapping from identifier expressions (keys) to their
 *     corresponding expressions (values).
 * @param node The original AST node containing file and location information.
 */
class ObjectExpr(
    node: Node,
    val fieldMap: Map<IdExpr, Expr>,
) : Expr(node)

/**
 * Represents a lambda expression.
 *
 * @property isTrade
 * @property paramMap
 * @property stmtList
 * @property returnExpr
 * @property scope
 * @param node The original AST node containing file and location information.
 */
open class LambdaExpr(
    node: Node,
    val isTrade: Boolean,
    val paramMap: Map<IdExpr, TypeExpr?>,
    val stmtList: List<Stmt>,
    val returnExpr: Expr?,
    var scope: Scope = Scope.UNRESOLVED,
) : Expr(node)

/**
 * Represents a yield expression.
 *
 * @property initializer
 * @property isAlive
 * @property toYield
 * @property updater
 * @param node The original AST node containing file and location information.
 */
class YieldExpr(
    node: Node,
    val initializer: Expr,
    val isAlive: Expr,
    val toYield: Expr,
    val updater: Expr,
) : Expr(node)

/**
 * Represents a call expression.
 *
 * @property callee
 * @property argList
 * @param node The original AST node containing file and location information.
 */
class CallExpr(
    node: Node,
    val callee: Expr,
    val argList: List<Expr>,
) : Expr(node) {
    var isPartial: Boolean = false
}

/**
 * Represents an if expression.
 *
 * @property condition The condition expression that determines which branch to
 *     take.
 * @property thenFn The expression to evaluate if the condition is true.
 * @property elseFn The expression to evaluate if the condition is false, or
 *     null if there is no else branch.
 * @param node The original AST node containing file and location information.
 */
class IfExpr(
    node: Node,
    val condition: Expr,
    val thenFn: Expr,
    val elseFn: Expr?,
) : Expr(node)

/**
 * Represents a loop expression.
 *
 * @property fn The function to execute in the loop.
 * @param node The original AST node containing file and location information.
 */
class LoopExpr(
    node: Node,
    val fn: Expr,
) : Expr(node)

/**
 * Represents an import expression.
 *
 * This expression is used to import modules or files into the current scope.
 *
 * @property targetPath The path of the module or file to import.
 * @param node The original AST node containing file and location information.
 */
class ImportExpr(
    node: Node,
    val targetPath: String,
) : Expr(node) {
    var absolutePath: Path? = null
    var moduleFn: ModuleFn? = null
}

