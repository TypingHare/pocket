package pocket.transpiler.js

import pocket.ast.node.Program
import pocket.transpiler.Transpiler
import java.security.MessageDigest

class JavaScriptTranspiler : Transpiler() {
    /**
     * Maps from absolute paths to function names.
     */
    private val filepathFnNameMap = mutableMapOf<String, String>()

    override fun transpile(program: Program): String {
        return JavaScriptVisitor(this).visitProgram(program)
    }

    override fun fnNameGenerator(filepath: String): String {
        return filepathFnNameMap.getOrPut(filepath) {
            "\$_" + createHashFnName(filepath)
        }
    }

    fun getFnName(targetPath: String): String =
        filepathFnNameMap[targetPath] ?: error("Target path not found: $targetPath")

    private fun createHashFnName(filepath: String): String {
        val fnName = MessageDigest.getInstance("SHA-256")
            .digest(filepath.toByteArray())
            .joinToString("") { "%02x".format(it) }
            .substring(0, 16)

        return if (filepathFnNameMap.containsValue(fnName))
            createHashFnName("$filepath#") else fnName
    }
}