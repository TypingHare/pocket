package pocket.ast

import pocket.ast.Type
import pocket.ast.node.Expr

class Scope(
    val parent: Scope? = UNRESOLVED,
    val symbols: MutableMap<String, Symbol> = mutableMapOf(),
) {
    fun define(symbol: Symbol) {
        symbols[symbol.name] = symbol
    }

    fun resolve(name: String): Symbol? = symbols[name] ?: parent?.resolve(name)

    companion object {
        val ROOT = Scope(null)
        val UNRESOLVED = Scope(null)
    }
}

data class Symbol(
    val name: String,
    val declExpr: Expr?,
    val isMutable: Boolean,
    val isDestructured: Boolean,
) {
    fun getType(): Type = declExpr?.type ?: Type.None
}

