package pocket.transpiler.js

import pocket.ast.BinaryOperator
import pocket.ast.node.*
import pocket.ast.visitor.Visitor
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path


class JavaScriptVisitor(
    private val transpiler: JavaScriptTranspiler
) : Visitor<String>() {
    private val transpilerDirectory = Path.of("src/main/resources/pocket/js")

    override fun visitProgram(program: Program): String {
        val moduleFnStringListString =
            moduleFnListToString(program.moduleFnList).joinToString { "\n" }
        val header = getHeader()

        return "$header\nconst \$global = {}; \n$moduleFnStringListString"
    }

    override fun visitModuleFn(moduleFn: ModuleFn): String {
        val stmtListString = moduleFn.stmtList
            .map { this::visitStmt }
            .joinToString("\n")
        val exprString = moduleFn.returnExpr
            ?.let { visitExpr(it) }
            ?: "return 0;"
        val fnName = moduleFn.fnName

        return "\$global['%s'] = { export: {} };\n" +
                "function $fnName () {\n" +
                "$stmtListString\n" +
                "$exprString\n" +
                "}"
    }

    override fun visitStmt(stmt: Stmt): String = super.visitStmt(stmt)!!

    override fun visitExprStmt(stmt: ExprStmt): String {
        val exprString = visitExpr(stmt.expr)
        return "$exprString;"
    }

    override fun visitDeclStmt(stmt: DeclStmt): String {
        TODO("Not yet implemented")
    }

    override fun visitAssignmentStmt(stmt: AssignmentStmt): String {
        val id = visitIdExpr(stmt.id);
        val valueExpr = visitExpr(stmt.value);

        return "$id = $valueExpr;"
    }

    override fun visitDestructingStmt(stmt: DestructingStmt): String {
        TODO("Not yet implemented")
    }

    override fun visitBreakStmt(stmt: BreakStmt): String {
        val condition = visitExpr(stmt.condition)
        return "const \$cond = $condition;\nif (\$cond) return true;"
    }

    override fun visitNativeStmt(stmt: NativeStmt): String = ""

    override fun visitLiteralExpr(expr: LiteralExpr): String {
        return expr.literal
    }

    override fun visitExpr(expr: Expr): String = super.visitExpr(expr)!!

    override fun visitIdExpr(expr: IdExpr): String = expr.name

    override fun visitMemberExpr(expr: MemberExpr): String {
        val exprString = visitExpr(expr.expr)
        return "$exprString.${expr.name}"
    }

    override fun visitBinaryExpr(expr: BinaryExpr): String {
        val leftString = visitExpr(expr.left)
        val rightString = visitExpr(expr.right)

        if (expr.operator == BinaryOperator.PIPE) {
            return "$rightString($leftString)"
        }

        val operatorString = when (expr.operator) {
            else -> expr.operator.toString()
        }

        return "($leftString $operatorString $rightString)"
    }

    override fun visitUnaryExpr(expr: UnaryExpr): String {
        val operator = expr.operator.toString()
        val operand = visitExpr(expr.operand)

        return "($operator$operand)"
    }

    override fun visitLambdaExpr(expr: LambdaExpr): String {
        TODO("Not yet implemented")
    }

    override fun visitYieldExpr(expr: YieldExpr): String {
        val initializerString = visitExpr(expr.initializer)
        val isAliveString = visitExpr(expr.isAlive)
        val toYieldString = visitExpr(expr.toYield)
        val updaterString = visitExpr(expr.updater)

        return "yield* \$buildGenerator($initializerString, $isAliveString, $toYieldString, $updaterString)"
    }

    override fun visitCallExpr(expr: CallExpr): String {
        TODO("Not yet implemented")
    }

    override fun visitListExpr(expr: ListExpr): String {
        val itemListString = expr.itemList
            .joinToString(", ") { visitExpr(it) }

        return "[ $itemListString ]"
    }

    override fun visitObjectExpr(expr: ObjectExpr): String {
        val fieldListString = expr.fieldMap
            .mapValues { visitExpr(it.value) }
            .map { (name, value) -> "$name: $value" }
            .joinToString(", ")

        return "{ $fieldListString }"
    }

    override fun visitIfExpr(expr: IfExpr): String {
        val conditionString = visitExpr(expr.condition)
        val thenFnString = visitExpr(expr.thenFn)
        val elseFnString = expr.elseFn?.let { visitExpr(it) }
        val thenPart = "($thenFnString)()"
        val elsePart = elseFnString?.let { "($it)()" } ?: "null"

        return "(() => ($conditionString ? $thenPart : $elsePart))()"
    }

    override fun visitLoopExpr(expr: LoopExpr): String {
        val fnString = visitExpr(expr.fn)
        return "\$loop($fnString)"
    }

    override fun visitTypeExpr(expr: TypeExpr): String = ""

    override fun visitImportExpr(expr: ImportExpr): String {
        val filepath = expr.targetPath
        val importedFnName = transpiler

        return "\$global['$importedFnName']['export']"
    }

    private fun moduleFnListToString(
        moduleFnList: List<ModuleFn>
    ): List<String> {
        return moduleFnList.mapIndexed { index, moduleFn ->
            val fnString = visitModuleFn(moduleFn)
            val fnName = moduleFn.fnName

            if (index == moduleFnList.lastIndex) {
                "$fnString\nconst \$exitCode = $fnName();process.exit(\$exitCode);"
            } else {
                "$fnString\n$fnName();"
            }
        }
    }

    private fun getHeader(): String {
        val headerFilepath = transpilerDirectory.resolve(HEADER_FILEPATH)

        try {
            return Files.readString(headerFilepath)
        } catch (ex: IOException) {
            throw RuntimeException("Header file not found: $headerFilepath", ex)
        }
    }

    companion object {
        const val HEADER_FILEPATH = "header.js"
    }
}