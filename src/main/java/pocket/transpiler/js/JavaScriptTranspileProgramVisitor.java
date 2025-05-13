package pocket.transpiler.js;

import org.jetbrains.annotations.NotNull;
import pocket.ast.ModuleFn;
import pocket.ast.ModuleFnNameGenerator;
import pocket.ast.Program;
import pocket.ast.ProgramVisitor;
import pocket.ast.expr.*;
import pocket.ast.stmt.*;
import pocket.ast.symbol.BinaryOp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class JavaScriptTranspileProgramVisitor
    extends ProgramVisitor<String> {
    @NotNull
    private final ModuleFnNameGenerator moduleFnNameGenerator;
    @NotNull
    private final Path directory;

    public JavaScriptTranspileProgramVisitor(
        @NotNull final ModuleFnNameGenerator moduleFnNameGenerator,
        @NotNull final Path directory
    ) {
        this.moduleFnNameGenerator = moduleFnNameGenerator;
        this.directory = directory;
    }

    private List<String> moduleFnListToString(
        @NotNull final List<ModuleFn> moduleFnList
    ) {
        final var numFn = moduleFnList.size();
        final var stringList = new ArrayList<String>();

        final var index = new AtomicInteger(0);
        for (final var moduleFn : moduleFnList) {
            final var fnString = visitModuleFn(moduleFn);
            final var fnName = moduleFn.name;

            if (index.getAndIncrement() == numFn - 1) {
                stringList.add(
                    String.format(
                        "%s\nconst $exitCode = %s();\nprocess.exit($exitCode);",
                        fnString, fnName
                    ));
            } else {
                stringList.add(String.format("%s\n%s();", fnString, fnName));
            }
        }

        return stringList;
    }

    @NotNull
    private String getHeader() {
        final var path = directory.resolve("header.js");

        try {
            return Files.readString(path);
        } catch (IOException ex) {
            throw new RuntimeException("Header file not found: " + path, ex);
        }
    }

    @Override
    public String visitProgram(final Program program) {
        final var moduleFnStringList = moduleFnListToString(
            program.moduleFnList);
        final var header = getHeader();

        return String.format(
            "%s\nconst $global = {};\n%s", header,
            String.join("\n", moduleFnStringList)
        );
    }

    @Override
    public String visitModuleFn(final ModuleFn moduleFn) {
        final var stmtListString =
            moduleFn.stmts.stream().map(this::visitStmt)
                .collect(Collectors.joining("\n"));
        final var exprString =
            moduleFn.expr == null ? "\nreturn 0;" : "\nreturn " + visitExpr(
                moduleFn.expr) + ";";

        return String.format(
            "$global['%s'] = { export: {} };\nfunction %s() {\n%s%s\n}\n",
            moduleFn.name, moduleFn.name, stmtListString, exprString
        );
    }

    @Override
    public String visitAssngStmt(final AssgnStmt assnStmt) {
        final var id = visitIdExpr(assnStmt.id);
        final var valueExpr = visitExpr(assnStmt.value);

        return String.format("%s = %s;", id, valueExpr);
    }

    @Override
    public String visitBreakStmt(final BreakStmt breakStmt) {
        final var condition = visitExpr(breakStmt.condition);

        return String.format(
            "const $breakCond = %s; if ($breakCond) return true;", condition);
    }

    @Override
    public String visitDeclStmt(final DeclStmt declStmt) {
        final var isExport = declStmt.isExport;
        final var jsDeclKeyword =
            switch (declStmt.declKeyword) {
                case VAL -> "const";
                case LET -> "let";
            };
        final var id = visitIdExpr(declStmt.id);
        final var value = visitExpr(declStmt.value);
        final var moduleFnName = moduleFnNameGenerator.generate(
            declStmt.filename);
        final var exportStr =
            isExport ? String.format(
                "\n$global['%s']['export']['%s'] = %s",
                moduleFnName, id, id
            ) : "";

        return String.format(
            "%s %s = %s;%s", jsDeclKeyword, id, value,
            exportStr
        );
    }

    @Override
    public String visitDestructingStmt(final DestructingStmt stmt) {
        //        final var isExport = stmt.isExport;
        final var idList =
            stmt.idList.stream().map(this::visitIdExpr)
                .collect(Collectors.joining(", "));
        final var exprStr = visitExpr(stmt.expr);
        final var declKeyword =
            switch (stmt.declKeyword) {
                case VAL -> "const";
                case LET -> "let";
            };

        return String.format("%s { %s } = %s;", declKeyword, idList, exprStr);
    }

    @Override
    public String visitExprStmt(final ExprStmt stmt) {
        return String.format("%s;", visitExpr(stmt.expr));
    }

    @Override
    public String visitNativeStmt(final NativeStmt stmt) {
        return "";
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String visitBinaryExpr(final BinaryExpr expr) {
        final var left = visitExpr(expr.left);
        final var right = visitExpr(expr.right);
        if (expr.op == BinaryOp.PIPE) {
            return String.format("%s(%s)", right, left);
        }

        final var op =
            switch (expr.op) {
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
                default -> throw new RuntimeException(
                    "Invalid binary operator: " + expr.op);
            };

        return String.format("(%s %s %s)", left, op, right);
    }

    @Override
    public String visitFloatLiteralExpr(final FloatLiteralExpr expr) {
        return expr.literal;
    }

    @Override
    public String visitIdExpr(final IdExpr expr) {
        return expr.text;
    }

    @Override
    public String visitIfExpr(final IfExpr expr) {
        final var condition = visitExpr(expr.condition);
        final var thenFn = visitExpr(expr.thenFn);
        final var elsePart =
            expr.elseFn == null ? "" : String.format(
                "else return (%s)();",
                visitExpr(expr.elseFn)
            );

        return String.format(
            "(function () { if (%s) { return %s(); } %s } )()", condition,
            thenFn, elsePart
        );
    }

    @Override
    public String visitImportExpr(final ImportExpr expr) {
        final var filepath = expr.path;
        final var moduleFnName = moduleFnNameGenerator.generate(filepath);

        return String.format("$global['%s']['export']", moduleFnName);
    }

    @Override
    public String visitIntLiteralExpr(final IntLiteralExpr expr) {
        return expr.literal;
    }

    @Override
    public String visitLambdaExpr(final LambdaExpr expr) {
        final var paramList =
            expr.paramList.stream().map(p -> p.id.text)
                .collect(Collectors.joining(", "));
        final var stmts = expr.stmts.stream().map(this::visitStmt)
            .collect(Collectors.joining("\n"));

        String exprStr;
        if (expr.expr == null) {
            exprStr = "";
        } else {
            if (expr.expr instanceof YieldExpr) {
                exprStr = visitYieldExpr((YieldExpr) expr.expr);
            } else {
                exprStr = String.format("\nreturn %s;", visitExpr(expr.expr));
            }
        }

        final var asterisk = expr.expr instanceof YieldExpr ? "*" : "";
        return String.format(
            "function %s(%s) {%s%s\n}", asterisk, paramList,
            stmts, exprStr
        );
    }

    @Override
    public String visitListExpr(final ListExpr expr) {
        final var elements = expr.elements.stream().map(this::visitExpr)
            .collect(Collectors.joining(","));

        return String.format("[%s]", elements);
    }

    @Override
    public String visitLoopExpr(final LoopExpr expr) {
        final var loopExpr = visitExpr(expr.expr);
        return String.format("$loop(%s)", loopExpr);
    }

    @Override
    public String visitObjectExpr(final ObjectExpr expr) {
        final var items = expr.items.entrySet().stream()
            .map(item -> String.format(
                "%s: %s", item.getKey(),
                visitExpr(item.getValue())
            ))
            .collect(Collectors.joining(","));

        return String.format("{ %s }", items);
    }

    @Override
    public String visitCallExpr(final CallExpr expr) {
        final var callee = visitExpr(expr.callee);
        final var args = expr.argList.stream().map(this::visitExpr)
            .collect(Collectors.joining(", "));

        if (expr.isPartial) {
            // Now it only supports the case where only one parameter is required
            return String.format(
                "(function(x) { return %s(%s, x) })", callee,
                args
            );
        } else {
            return String.format("%s(%s)", callee, args);
        }
    }

    @Override
    public String visitStringLiteralExpr(final StringLiteralExpr expr) {
        return expr.literal;
    }

    @Override
    public String visitTypeExpr(final TypeExpr expr) {
        return expr.id == null ? "" : visitIdExpr(expr.id);
    }

    @Override
    public String visitUnaryExpr(final UnaryExpr expr) {
        final var op =
            switch (expr.op) {
                case NOT -> "!";
                case MINUS -> "-";
            };
        final var operand = visitExpr(expr.operand);

        return String.format("(%s%s)", op, operand);
    }

    @Override
    public String visitYieldExpr(final YieldExpr expr) {
        final var initializer = visitExpr(expr.initializer);
        final var toYield = visitExpr(expr.toYield);
        final var next = visitExpr(expr.next);
        final var isAlive = visitExpr(expr.isAlive);

        return String.format(
            "yield* $buildGenerator(%s, %s, %s, %s)",
            initializer, toYield, next, isAlive
        );
    }
}
