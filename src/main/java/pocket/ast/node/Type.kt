package pocket.ast.node

sealed class Type {
    object Any : Type()
    object Int : Type()
    object Float : Type()
    object Bool : Type()
    object String : Type()

    data class Function(
        val parameterTypeList: List<Type>,
        val returnType: Type
    ) : Type()

    data class Iterable(val elementType: Type) : Type()

    override fun toString(): kotlin.String {
        return when (this) {
            Any -> "Any"
            Int -> "Int"
            Float -> "Float"
            Bool -> "Bool"
            String -> "String"
            is Function -> "(${parameterTypeList.joinToString(", ")}) => $returnType"
            is Iterable -> "Iterable<$elementType>"
        }
    }

    override fun equals(other: kotlin.Any?): Boolean {
        if (this === other) return true

        if (this is Function) {
            if (other !is Function) {
                return false
            }

            return this.parameterTypeList == other.parameterTypeList
                    && this.returnType == other.returnType
        }

        return false
    }

    override fun hashCode(): kotlin.Int {
        return javaClass.hashCode()
    }
}