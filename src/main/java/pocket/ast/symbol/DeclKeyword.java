package pocket.ast.symbol;

public enum DeclKeyword {
    VAL,
    LET;

    @Override
    public String toString() {
        return switch (this) {
            case VAL -> "val";
            case LET -> "let";
        };
    }
}
