package pocket.ast.builder

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import pocket.antlr.PocketLexer
import pocket.antlr.PocketParser
import pocket.ast.DependencyNode
import pocket.ast.node.ModuleFn
import pocket.ast.node.Program
import pocket.ast.visitor.DependencyVisitor
import java.nio.file.Files
import java.nio.file.Path

/**
 * @param fnNameGenerator A function that maps an absolute file name to a valid
 *                        function name in the target language.
 */
class ProgramBuilder(
    private val entryFileAbsolutePath: Path,
    private val fnNameGenerator: FnNameGenerator
) {
    /**
     * The absolute path to the root directory where the entry file resides.
     */
    private val rootDirectory = entryFileAbsolutePath.parent

    private val dependencyMap = mutableMapOf<Path, DependencyNode>()

    private val moduleFnList = mutableListOf<ModuleFn>()

    fun build(): Program {
        parse(entryFileAbsolutePath, listOf())
        return Program(moduleFnList.last(), moduleFnList.toList())
    }

    fun parse(
        fileAbsolutePath: Path,
        dependencyPath: List<Path>
    ): DependencyNode {
        // If the file has been parsed, return the dependency node
        dependencyMap[fileAbsolutePath]?.let { return it }

        // If the file already exists in the dependency path, then a circular
        // dependency appears
        if (dependencyPath.contains(fileAbsolutePath)) {
            val dependencyPathString = dependencyPath.joinToString(" -> ")
            error("Circular dependency detected: $dependencyPathString")
        }

        val sourceCode = Files.readString(fileAbsolutePath)
        val lexer = PocketLexer(CharStreams.fromString(sourceCode))
        val parser = PocketParser(CommonTokenStream(lexer))
        val moduleFnCst = parser.moduleFn()

        val fnName = fnNameGenerator(fileAbsolutePath.fileName.toString())
        val moduleFn = ModuleFnBuilder(fileAbsolutePath, fnName)
            .visitModuleFn(moduleFnCst) as ModuleFn

        // Resolve dependencies
        val dependencyPathSet = DependencyVisitor()
            .let { it.visitModuleFn(moduleFn); it.dependencySet }
        val newDependencyList = dependencyPath + fileAbsolutePath
        val nodes = dependencyPathSet
            .map { parse(getFilePath(it), newDependencyList) }
            .toSet()
        val dependencyNode = DependencyNode(fileAbsolutePath, nodes)
        dependencyMap.put(fileAbsolutePath, dependencyNode)

        moduleFnList.add(moduleFn)
        return dependencyNode
    }

    private fun getFilePath(targetPath: String): Path {
        return rootDirectory.resolve(targetPath)
    }
}

typealias FnNameGenerator = (String) -> String