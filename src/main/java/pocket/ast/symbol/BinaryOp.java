package pocket.ast.symbol;

public enum BinaryOp {
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

    @Override
    public String toString() {
        return switch (this) {
            case PIPE -> "->";
            case LOGIC_OR -> "||";
            case LOGIC_AND -> "&&";
            case EQUALS -> "==";
            case NOT_EQUALS -> "!=";
            case LESS_THAN -> "<";
            case LESS_THAN_EQUALS -> "<=";
            case GREATER_THAN -> ">";
            case GREATER_THAN_EQUALS -> ">=";
            case PLUS -> "+";
            case MINUS -> "-";
            case MULTIPLY -> "*";
            case DIVIDE -> "/";
            case MODULO -> "%";
        };
    }
}
