package pocket.transpiler

import pocket.ast.node.Program

/**
 * An abstract base class for transpilers that convert a Pocket program's
 * abstract syntax tree (AST) into source code in a target programming language.
 *
 * Implementations of this class should provide the logic to perform the
 * transpilation for specific target languages.
 *
 * @param program The Pocket program's AST to be transpiled.
 * @see pocket.ast.node.Program
 */
abstract class Transpiler(val program: Program) {

    /**
     * Transpiles the Pocket program into equivalent source code in the target
     * language.
     *
     * @return A {@code String} containing the generated target language code.
     */
    abstract fun transpile(): String
}