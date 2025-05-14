package pocket.ast.node

import java.nio.file.Path

abstract class ASTNode(
    val filepath: Path,
    val line: Int,
    val column: Int
) {
    constructor(node: ASTNode) : this(
        node.filepath,
        node.line,
        node.column
    )
}