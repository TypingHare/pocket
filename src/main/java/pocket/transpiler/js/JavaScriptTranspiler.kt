package pocket.transpiler.js

import pocket.ast.node.Program
import pocket.transpiler.Transpiler
import java.security.MessageDigest

class JavaScriptTranspiler : Transpiler() {
    private val filepathFnNameMap = mutableMapOf<String, String>();

    override fun transpile(program: Program): String {
        return JavaScriptVisitor(this).visitProgram(program)!!
    }

    override fun fnNameGenerator(filepath: String): String {
        return filepathFnNameMap.getOrPut(filepath) {
            "\$_" + createHash(filepath)
        }
    }

    private fun createHash(filepath: String): String {
        return MessageDigest.getInstance("SHA-256")
            .digest(filepath.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}