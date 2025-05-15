package pocket.transpiler.js

import pocket.ast.node.Program
import pocket.transpiler.Transpiler
import java.nio.file.Path
import java.security.MessageDigest

class JavaScriptTranspiler() : Transpiler() {
    /**
     * Maps from absolute paths to function names.
     */
    private val absolutePathFnNameMap = mutableMapOf<Path, String>()

    private var program: Program? = null

    override fun transpile(program: Program): String {
        this.program = program
        return JavaScriptVisitor(this).visitProgram(program)
    }

    fun getFnName(absolutePath: Path): String {
        return absolutePathFnNameMap.getOrPut(absolutePath) {
            "\$_" + createHashFnName(absolutePath.toString())
        }
    }

    fun getFnName(currentAbsolutePath: Path, targetPath: String): String =
        program!!.dependencyTree
            .getTargetAbsolutePath(currentAbsolutePath, targetPath)
            .let { getFnName(it) }

    private fun createHashFnName(filepath: String): String {
        val fnName = MessageDigest.getInstance("SHA-256")
            .digest(filepath.toByteArray())
            .joinToString("") { "%02x".format(it) }
            .substring(0, 16)

        return if (absolutePathFnNameMap.containsValue(fnName))
            createHashFnName("$filepath#") else fnName
    }
}