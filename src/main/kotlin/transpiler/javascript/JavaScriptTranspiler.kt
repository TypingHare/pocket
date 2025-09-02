package pocket.transpiler.javascript

import pocket.ast.node.Program
import pocket.transpiler.Transpiler
import java.nio.file.Path
import java.security.MessageDigest

class JavaScriptTranspiler(program: Program) : Transpiler(program) {
    /**
     * Maps from absolute paths to function names.
     */
    private val absolutePathFnNameMap = mutableMapOf<Path, String>()

    override fun transpile(): String =
        JavaScriptVisitor(this).visitProgram(program)

    fun getFnName(targetPath: Path): String {
        return absolutePathFnNameMap.getOrPut(targetPath) {
            "\$_" + createHashFnName(targetPath.toString())
        }
    }

    fun getFnName(moduleFnPath: Path, targetPath: String): String =
        getFnName(program.getModuleFn(moduleFnPath, targetPath).filepath)

    private fun createHashFnName(filepath: String): String {
        val fnName = MessageDigest.getInstance("SHA-256")
            .digest(filepath.toByteArray())
            .joinToString("") { "%02x".format(it) }
            .substring(0, 16)

        return if (absolutePathFnNameMap.containsValue(fnName))
            createHashFnName("$filepath#") else fnName
    }
}