package pocket.ast.node

import pocket.ast.DeclKeyword

/**
 * Represents a statement node in the AST.
 *
 * @param node The original AST node containing file and location information.
 */
abstract class Stmt(
    node: Node,
) : Node(node)

/**
 * Represents an expression statement.
 *
 * @property expr The expression contained in this statement.
 * @param node The original AST node containing file and location information.
 */
class ExprStmt(
    node: Node,
    val expr: Expr,
) : Stmt(node)

/**
 * Represents a declaration statement.
 *
 * @property isExport Indicates if the declaration is exported.
 * @property declKeyword The keyword used for the declaration.
 * @property id The identifier for the declaration.
 * @property type The type of the declaration, if specified.
 * @property value The value assigned to the declaration.
 * @param node The original AST node containing file and location information.
 */
class DeclStmt(
    node: Node,
    val isExport: Boolean,
    val declKeyword: DeclKeyword,
    val id: IdExpr,
    val type: TypeExpr?,
    val value: Expr,
) : Stmt(node)

/**
 * Represents an assignment statement.
 *
 * @property id The identifier expression that will receive the assigned value.
 * @property value The expression representing the value to be assigned to the
 *     identifier.
 * @param node The original AST node containing file and location information.
 */
class AssignmentStmt(
    node: Node,
    val id: IdExpr,
    val value: Expr,
) : Stmt(node)

/**
 * Represents a destructuring assignment statement.
 *
 * @property isExport Indicates if the destructuring variables are exported.
 * @property declKeyword The keyword used for the destructuring assignment.
 * @property idList A list of identifier expressions that will receive the
 *     destructured values.
 * @property value The expression representing the value to be destructured.
 * @param node The original AST node containing file and location information.
 */
class DestructingStmt(
    node: Node,
    val isExport: Boolean,
    val declKeyword: DeclKeyword,
    val idList: List<IdExpr>,
    val value: Expr,
) : Stmt(node)

/**
 * Represents a break statement.
 *
 * @property condition The expression that determines the condition for breaking.
 * @param node The original AST node containing file and location information.
 */
class BreakStmt(
    node: Node,
    val condition: Expr,
) : Stmt(node)

/**
 * Represents a native statement.
 *
 * @property id The identifier expression.
 * @property typeExpr The type of the native identifier.
 * @param node The original AST node containing file and location information.
 */
class NativeStmt(
    node: Node,
    val id: IdExpr,
    val typeExpr: TypeExpr,
) : Stmt(node)

/**
 * Represents a type declaration statement.
 *
 * @property id The identifier expression.
 * @property typeExpr The type of the native identifier.
 * @param node The original AST node containing file and location information.
 */
class TypeDeclStmt(
    node: Node,
    val id: IdExpr,
    val typeExpr: TypeExpr,
): Stmt(node)