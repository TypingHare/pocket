package pocket.ast

import java.nio.file.Path

class DependencyNode(
    val absolutePath: Path,
    val children: Set<DependencyNode>
)