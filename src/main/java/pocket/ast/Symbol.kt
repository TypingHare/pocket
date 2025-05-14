package pocket.ast

enum class LiteralType {
    INT,
    FLOAT,
    BOOLEAN,
    STRING
}

enum class DeclKeyword {
    VAL,
    LET;

    override fun toString(): String {
        return when (this) {
            DeclKeyword.VAL -> "val"
            DeclKeyword.LET -> "let"
        }
    }
}

enum class BinaryOperator {
    PIPE,
    LOGIC_OR,
    LOGIC_AND,
    EQUALS,
    NOT_EQUALS,
    LESS_THAN,
    LESS_THAN_EQUALS,
    GREATER_THAN,
    GREATER_THAN_EQUALS,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    MODULO;

    override fun toString(): String {
        return when (this) {
            BinaryOperator.PIPE -> "->"
            BinaryOperator.LOGIC_OR -> "||"
            BinaryOperator.LOGIC_AND -> "&&"
            BinaryOperator.EQUALS -> "=="
            BinaryOperator.NOT_EQUALS -> "!="
            BinaryOperator.LESS_THAN -> "<"
            BinaryOperator.LESS_THAN_EQUALS -> "<="
            BinaryOperator.GREATER_THAN -> ">"
            BinaryOperator.GREATER_THAN_EQUALS -> ">="
            BinaryOperator.PLUS -> "+"
            BinaryOperator.MINUS -> "-"
            BinaryOperator.MULTIPLY -> "*"
            BinaryOperator.DIVIDE -> "/"
            BinaryOperator.MODULO -> "%"
        }
    }
}

enum class UnaryOperator {
    NOT,
    MINUS;

    override fun toString(): String {
        return when (this) {
            UnaryOperator.NOT -> "!"
            UnaryOperator.MINUS -> "-"
        }
    }
}