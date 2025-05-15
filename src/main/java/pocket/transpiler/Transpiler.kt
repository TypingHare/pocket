package pocket.transpiler

import pocket.ast.node.Program

/**
 * Represents a transpiler that transpiles a Pocket program abstract syntax tree
 * into a target language program.
 *
 * @see pocket.ast.node.Program
 */
abstract class Transpiler() {
    abstract fun transpile(program: Program): String
}