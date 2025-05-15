package pocket.ast.builder

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import pocket.antlr.PocketLexer
import pocket.antlr.PocketParser
import pocket.ast.DependencyNode
import pocket.ast.DependencyTree
import pocket.ast.MissingSourceFIleException
import pocket.ast.node.ModuleFn
import pocket.ast.node.Program
import pocket.ast.visitor.DependencyVisitor
import java.nio.file.Files
import java.nio.file.Path

class ProgramBuilder(private val entryFileAbsolutePath: Path) {
    /**
     * Maps absolute file paths to dependency nodes.
     */
    private val dependencyMap = mutableMapOf<Path, DependencyNode>()

    /**
     * The list of module functions.
     */
    private val moduleFnList = mutableListOf<ModuleFn>()

    fun build(): Program {
        val root = parse(entryFileAbsolutePath, listOf())

        return Program(
            moduleFnList.last(),
            moduleFnList.toList(),
            DependencyTree(root)
        )
    }

    fun parse(
        absolutePath: Path,
        dependencyPath: List<Path>
    ): DependencyNode {
        // If the file has been parsed, return the dependency node
        dependencyMap[absolutePath]?.let { return it }

        // If the file already exists in the dependency path, then a circular
        // dependency appears
        if (dependencyPath.contains(absolutePath)) {
            val dependencyPathString = dependencyPath.joinToString(" -> ")
            error("Circular dependency detected: $dependencyPathString")
        }

        if (!Files.exists(absolutePath) || Files.isDirectory(absolutePath)) {
            throw MissingSourceFIleException(absolutePath)
        }

        val sourceCode = Files.readString(absolutePath)
        val lexer = PocketLexer(CharStreams.fromString(sourceCode))
        val parser = PocketParser(CommonTokenStream(lexer))
        val moduleFnCst = parser.moduleFn()

        val moduleFn = ModuleFnBuilder(absolutePath)
            .visitModuleFn(moduleFnCst) as ModuleFn

        // Resolve dependencies
        val targetPathMap = DependencyVisitor()
            .let { it.visitModuleFn(moduleFn); it.dependencySet }
            .associateWith { getFilePath(absolutePath, it) }
        val newDependencyList = dependencyPath + absolutePath
        val nodes = targetPathMap.mapValues {
            parse(it.value, newDependencyList)
        }
        val dependencyNode = DependencyNode(absolutePath, nodes)
        dependencyMap.put(absolutePath, dependencyNode)

        moduleFnList.add(moduleFn)
        return dependencyNode
    }

    private fun getFilePath(
        currentAbsolutePath: Path,
        targetPath: String
    ): Path = currentAbsolutePath.parent.resolve(targetPath)
}