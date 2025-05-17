package pocket.ast

import pocket.ast.node.Expr

class Scope(
    val parent: Scope? = Unresolved,
    val symbols: MutableMap<String, Symbol> = mutableMapOf()
) {
    fun define(symbol: Symbol) {
        symbols[symbol.name] = symbol
    }

    fun resolve(name: String): Symbol? = symbols[name] ?: parent?.resolve(name)

    companion object {
        val Root = Scope(null)
        val Unresolved = Scope(null)
        val Unknown = Scope(null)
    }
}

data class Symbol(
    val name: String,
    val declExpr: Expr?,
    val isMutable: Boolean,
    val isDestructured: Boolean
)