package pocket.ast.node

/**
 * Represents a type expression Node.
 *
 * Type expressions describe the structure or category of values in the
 * language's type system.
 *
 * @constructor Creates a base type expression node.
 * @param node The original AST node containing file and location information.
 */
abstract class TypeExpr(node: Node) : Expr(node)

/**
 * Represents the 'None' type Node.
 *
 * @constructor Creates a None type expression node.
 * @param node The original AST node containing file and location information.
 */
class NoneTypeExpr(node: Node) : TypeExpr(node)

/**
 * Represents a named type (identifier) Node.
 *
 * @property name The name of the type.
 * @constructor Creates an identifier type expression node.
 * @param node The original AST node containing file and location information.
 */
class IdTypeExpr(node: Node, val name: String) : TypeExpr(node)

/**
 * Represents a tuple type Node.
 *
 * A tuple type is an ordered collection of type expressions.
 * Example: (Int, String, Boolean)
 *
 * @property itemTypeList The list of types contained in the tuple.
 * @constructor Creates a tuple type expression node.
 * @param node The original AST node containing file and location information.
 */
class TupleTypeExpr(
    node: Node,
    val itemTypeList: List<TypeExpr>
) : TypeExpr(node)

/**
 * Represents a list type.
 *
 * @property itemType The type of elements contained in the list.
 * @constructor Creates a list type expression node.
 * @param node The original AST node containing file and location information.
 */
class ListTypeExpr(
    node: Node,
    val itemType: TypeExpr
) : TypeExpr(node)

/**
 * Represents an object type (similar to a map or dictionary).
 *
 * @property fieldTypeMap A mapping from identifier expressions (keys) to their
 * corresponding type expressions (values).
 * @constructor Creates an object type expression node.
 * @param node The original AST node containing file and location information.
 */
class ObjectTypeExpr(
    node: Node,
    val fieldTypeMap: Map<IdExpr, TypeExpr>
) : TypeExpr(node)

/**
 * Represents a lambda (function) type.
 *
 * @property paramTypeList The list of parameter types.
 * @property returnType The return type of the lambda expression.
 * @constructor Creates a lambda type expression node.
 * @param node The original AST node containing file and location information.
 */
class LambdaTypeExpr(
    node: Node,
    val paramTypeList: List<TypeExpr>,
    val returnType: TypeExpr
) : TypeExpr(node)
