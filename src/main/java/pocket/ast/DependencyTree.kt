package pocket.ast

import java.nio.file.Path

class DependencyTree(root: DependencyNode) {
    private val targetMap = mutableMapOf<Path, Map<String, Path>>()

    init {
        traverse(root)
    }

    private fun traverse(node: DependencyNode) {
        targetMap.put(
            node.absolutePath,
            node.children.mapValues { it.value.absolutePath }
        )
    }

    @Throws(TargetFileNotFound::class)
    fun getTargetAbsolutePath(
        currentFileAbsolutePath: Path,
        targetPath: String
    ): Path = targetMap[currentFileAbsolutePath]?.get(targetPath)
        ?: throw TargetFileNotFound(currentFileAbsolutePath, targetPath)
}

class DependencyNode(
    val absolutePath: Path,
    val children: Map<String, DependencyNode>
)