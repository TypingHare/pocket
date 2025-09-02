package pocket.ast.node

import java.nio.file.Path

/**
 * Represents a node in the abstract syntax tree.
 *
 * @param filepath The path to the source file where this node is located.
 * @param line The line number in the source file.
 * @param column The column number in the source file.
 */
open class Node(
    val filepath: Path,
    val line: Int,
    val column: Int
) {
    /**
     * Creates a copy of the given node.
     *
     * @param node The node to copy.
     */
    constructor(node: Node) : this(node.filepath, node.line, node.column)

    override fun toString(): String = "$filepath $line:$column"
}