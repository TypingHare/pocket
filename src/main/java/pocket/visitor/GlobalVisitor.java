package pocket.visitor;

import org.jetbrains.annotations.NotNull;

import pocket.PocketTranspiler;
import pocket.antlr.PocketBaseVisitor;
import pocket.antlr.PocketParser;

public final class GlobalVisitor extends PocketBaseVisitor<Object> {
    private final PocketTranspiler pocketTranspiler;

    public GlobalVisitor(
            @NotNull final String entryFilename, @NotNull final PocketTranspiler pocketTranspiler) {
        this.pocketTranspiler = pocketTranspiler;
    }

    public String visitImportExpr(PocketParser.ImportExprContext ctx) {
        final var literal = ctx.STRING_LITERAL().getText();
        final var filename = literal.substring(1, literal.length() - 1);

        try {
            pocketTranspiler.transpile(filename);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return filename;
    }
}
