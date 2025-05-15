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

    override fun toString(): String = when (this) {
        VAL -> "val"
        LET -> "let"
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

    override fun toString(): String = when (this) {
        PIPE -> "->"
        LOGIC_OR -> "||"
        LOGIC_AND -> "&&"
        EQUALS -> "=="
        NOT_EQUALS -> "!="
        LESS_THAN -> "<"
        LESS_THAN_EQUALS -> "<="
        GREATER_THAN -> ">"
        GREATER_THAN_EQUALS -> ">="
        PLUS -> "+"
        MINUS -> "-"
        MULTIPLY -> "*"
        DIVIDE -> "/"
        MODULO -> "%"
    }
}

enum class UnaryOperator {
    NOT,
    MINUS;

    override fun toString(): String = when (this) {
        NOT -> "!"
        MINUS -> "-"
    }
}