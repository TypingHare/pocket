package pocket.ast.builder

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import pocket.antlr.PocketLexer
import pocket.antlr.PocketParser
import pocket.ast.DependencyNode
import pocket.ast.DependencyTree
import pocket.ast.MissingSourceFIleException
import pocket.ast.node.ImportExpr
import pocket.ast.node.ModuleFn
import pocket.ast.node.Program
import pocket.ast.visitor.StructuralVisitor
import java.nio.file.Files
import java.nio.file.Path

class ProgramBuilder(private val entryFileAbsolutePath: Path) {
    /**
     * Maps absolute file paths to module functions and dependency nodes.
     */
    private val dependencyMap =
        mutableMapOf<Path, Pair<ModuleFn, DependencyNode>>()

    /**
     * The list of module functions.
     */
    private val moduleFnList = mutableListOf<ModuleFn>()

    fun build(): Program {
        val (_, root) = parse(entryFileAbsolutePath, listOf())
        return Program(
            moduleFnList.last(),
            moduleFnList.toList(),
            DependencyTree(root)
        )
    }

    fun parse(
        absolutePath: Path,
        dependencyPath: List<Path>
    ): Pair<ModuleFn, DependencyNode> {
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

        // Get the AST for the module function and save it to `moduleFnList`
        val moduleFn = ModuleFnBuilder(absolutePath)
            .visitModuleFn(moduleFnCst) as ModuleFn
        moduleFnList.add(moduleFn)

        // Resolve dependencies
        val targetPathMap = DependencyVisitor(absolutePath).let {
            it.visitModuleFn(moduleFn)
            it.dependencyMap
        }
        val newDependencyList = dependencyPath + absolutePath
        val map = targetPathMap.mapValues { parse(it.value, newDependencyList) }

        // Set the module function for import expressions
        val moduleFnMap = map.mapValues { it.value.first }
        ImportExprVisitor(moduleFnMap).visitModuleFn(moduleFn)

        // Create a dependency node for the current module
        val children = map.mapValues { it.value.second }
        val dependencyNode = DependencyNode(absolutePath, children)
        val pair = moduleFn to dependencyNode
        dependencyMap.put(absolutePath, pair)

        return pair
    }
}

class DependencyVisitor(
    val currentAbsolutePath: Path
) : StructuralVisitor<Object>() {
    val dependencyMap: MutableMap<String, Path> = mutableMapOf()

    override fun visitImportExpr(expr: ImportExpr): Object? {
        getTargetAbsolutePath(currentAbsolutePath, expr.targetPath).let {
            expr.absolutePath = it
            dependencyMap[expr.targetPath] = it
        }

        return null
    }

    private fun getTargetAbsolutePath(
        currentAbsolutePath: Path,
        targetPath: String
    ): Path = currentAbsolutePath.parent.resolve(targetPath)
}

class ImportExprVisitor(
    val moduleFnMap: Map<String, ModuleFn>
) : StructuralVisitor<Object>() {
    override fun visitImportExpr(expr: ImportExpr): Object? {
        expr.moduleFn = moduleFnMap[expr.targetPath]
        return null
    }
}