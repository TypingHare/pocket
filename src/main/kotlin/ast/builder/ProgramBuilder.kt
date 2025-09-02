package pocket.ast.builder

import ast.builder.ModuleFnBuilder
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import pocket.antlr.PocketLexer
import pocket.antlr.PocketParser
import pocket.ast.DependencyGraph
import pocket.ast.Scope
import pocket.ast.node.ImportExpr
import pocket.ast.node.ModuleFn
import pocket.ast.node.Program
import pocket.ast.visitor.StructuralVisitor
import java.nio.file.Files
import java.nio.file.Path

/**
 * @param entryFileAbsolutePath
 * @param modulePaths
 */
class ProgramBuilder(
    val entryFileAbsolutePath: Path,
    val modulePaths: List<Path>,
) {
    val dependencyGraph = DependencyGraph<Path>()
    val moduleFnMap = mutableMapOf<Path, ModuleFn>()
    val moduleFnList = mutableListOf<ModuleFn>()

    fun build(): Program {
        val moduleFn = parse(entryFileAbsolutePath, null)
        return Program(
            moduleFn,
            dependencyGraph,
            moduleFnMap,
            moduleFnList.toList(),
            Scope()
        )
    }

    fun parse(targetPath: Path, dependentPath: Path?): ModuleFn {
        // If the file has been parsed, return the module function node
        moduleFnMap[targetPath]?.let { return it }

        // Add the target path to the dependency graph
        if (dependentPath == null) {
            dependencyGraph.addNode(targetPath)
        } else {
            dependencyGraph.addDependency(targetPath, dependentPath)
        }

        // If a graph path between the target path to the dependent path exists,
        // then circular dependency exists
        if (dependentPath != null) {
            val path = dependencyGraph.pathBetween(targetPath, dependentPath)
            if (path != null) {
                val dependencyPathString = path.vertexList.joinToString(" -> ")
                error("Circular dependency detected: $dependencyPathString")
            }
        }

        if (!Files.exists(targetPath) || Files.isDirectory(targetPath)) {
            throw MissingSourceFIleException(targetPath)
        }

        val sourceCode = Files.readString(targetPath)
        val lexer = PocketLexer(CharStreams.fromString(sourceCode))
        val parser = PocketParser(CommonTokenStream(lexer))
        val moduleFnCst = parser.moduleFn()

        // Get the AST for the module function and save it to `moduleFnList`
        val moduleFn = ModuleFnBuilder(targetPath).visitModuleFn(moduleFnCst)
        moduleFnList.add(moduleFn)

        // Resolve dependencies
        val targetPathMap = DependencyVisitor(targetPath).let {
            it.visitModuleFn(moduleFn)
            it.dependencyMap
        }
        val moduleFnMap = targetPathMap.mapValues { parse(it.value, targetPath) }

        // Set the module function for all import expressions
        ImportExprVisitor(moduleFnMap).visitModuleFn(moduleFn)

        return moduleFn
    }
}

class DependencyVisitor(
    val currentAbsolutePath: Path
) : StructuralVisitor<Object>() {
    val dependencyMap: MutableMap<String, Path> = mutableMapOf()

    override fun visitImportExpr(expr: ImportExpr): Object? {
        val targetAbsolutePath =
            currentAbsolutePath.parent.resolve(expr.targetPath)
        expr.absolutePath = targetAbsolutePath
        dependencyMap[expr.targetPath] = targetAbsolutePath

        return null
    }
}

/**
 * Represents the import expression visitor.
 *
 * It visits all the import expressions and sets the `moduleFn` attribute of
 * each import expression to the corresponding module function in the module
 * function map.
 *
 * @property moduleFnMap The module function map.
 */
class ImportExprVisitor(
    val moduleFnMap: Map<String, ModuleFn>
) : StructuralVisitor<Object>() {
    override fun visitImportExpr(expr: ImportExpr): Object? {
        expr.moduleFn = moduleFnMap[expr.targetPath]
        return null
    }
}

class MissingSourceFIleException(filepath: Path) :
    RuntimeException("Source file <$filepath> not found")