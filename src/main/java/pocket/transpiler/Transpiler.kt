package pocket.transpiler

import pocket.ast.ModuleFnNameGenerator
import pocket.ast.Program

interface Transpiler {
    /**
     * The module function name generator.
     */
    val moduleFnNameGenerator: ModuleFnNameGenerator

    /**
     * Transpiles a Pocket abstract syntax tree into a target language.
     *
     * @param entryFilepath The path to the Pocket source file.
     * @param program       A Pocket abstract syntax tree.
     * @return A target code string.
     */
    fun transpile(entryFilepath: String, program: Program): String
}