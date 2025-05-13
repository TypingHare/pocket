package pocket.ast.symbol;

public enum UnaryOp {
    NOT,
    MINUS;

    @Override
    public String toString() {
        return switch (this) {
            case NOT -> "!";
            case MINUS -> "-";
        };
    }
}
