package pocket.ast.node

sealed class Type {
    object None : Type()
    object Any : Type()

    object Int : Type()
    object Float : Type()
    object Bool : Type()
    object String : Type()

    open class Function(
        val parameterTypeList: kotlin.collections.List<Type>,
        val returnType: Type
    ) : Type()

    class TradeFunction(
        parameterTypeList: kotlin.collections.List<Type>,
        returnType: Type,
        val exportObjectType: Object
    ) : Function(parameterTypeList, returnType)

    class Tuple(val typeList: kotlin.collections.List<Type>) : Type()

    open class Iterable(val elementType: Type) : Type()

    class List(elementType: Type) : Iterable(elementType)

    class Object(val fieldTypeMap: Map<kotlin.String, Type>) : Type()

    override fun toString(): kotlin.String {
        return when (this) {
            None -> "None"
            Any -> "Any"
            Int -> "Int"
            Float -> "Float"
            Bool -> "Bool"
            String -> "String"
            is Function -> "(${parameterTypeList.joinToString(", ")}) => $returnType"
            is Tuple -> "(${typeList.joinToString(", ")})"
            is List -> "[$elementType]"
            is Iterable -> "*[$elementType]"
            is Object -> ""
        }
    }

    override fun equals(other: kotlin.Any?): Boolean {
        if (other == null) return false
        if (this === other) return true

        if (this is Function) {
            if (other !is Function) {
                return false
            }

            return this.parameterTypeList == other.parameterTypeList
                    && this.returnType == other.returnType
        }

        if (this is Tuple) {
            if (other !is Tuple) {
                return false
            }

            return this.typeList == other.typeList
        }

        if (this is List) {
            if (other !is List) {
                return false
            }

            return this.elementType == other.elementType
        }

        if (this is Iterable) {
            if (other !is Iterable) {
                return false
            }

            return this.elementType == other.elementType
        }

        if (this is Object) {
            if (other !is Object) {
                return false
            }

            for ((key, valueType) in this.fieldTypeMap) {
                return other.fieldTypeMap.getOrDefault(key, null) == valueType
            }
        }

        return false
    }

    override fun hashCode(): kotlin.Int {
        return javaClass.hashCode()
    }
}