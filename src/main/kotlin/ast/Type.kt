package pocket.ast

sealed class Type {
    object None : Type()

    object Any : Type()

    object Int : Type()

    object Float : Type()

    object Bool : Type()

    object String : Type()

    class Tuple(
        val typeList: kotlin.collections.List<Type>,
    ) : Type()

    class List(
        val elementType: Type,
    ) : Type()

    class Object(
        val fieldTypeMap: Map<kotlin.String, Type>,
    ) : Type()

    open class Function(
        val parameterTypeList: kotlin.collections.List<Type>,
        val returnType: Type,
    ) : Type()

    class TradeFunction(
        parameterTypeList: kotlin.collections.List<Type>,
        returnType: Type,
        val exportObjectType: Object,
    ) : Function(parameterTypeList, returnType)

    override fun equals(other: kotlin.Any?): Boolean {
        if (other == null) return false
        if (this === other) return true

        return when (this) {
            is Tuple -> other is Tuple && this.typeList == other.typeList
            is List -> other is List && this.elementType == other.elementType
            is Object -> other is Object && this.fieldTypeMap == other.fieldTypeMap
            is TradeFunction -> {
                other is TradeFunction &&
                    this.parameterTypeList == other.parameterTypeList &&
                    this.returnType == other.returnType &&
                    this.exportObjectType == other.exportObjectType
            }
            is Function -> {
                other is Function &&
                    this.parameterTypeList == other.parameterTypeList &&
                    this.returnType == other.returnType
            }
            else -> false
        }
    }

    override fun hashCode(): kotlin.Int = javaClass.hashCode()
}

