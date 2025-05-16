package pocket.ast.visitor

import pocket.ast.Scope
import pocket.ast.node.*

open class StructuralTypeVisitor<T> : BaseTypeVisitor<T>() {
    override fun visitProgram(program: Program): T? {
        program.moduleFnList.forEach {
            visitModuleFn(it, program.globalScope)
        }
        return null
    }

    override fun visitModuleFn(moduleFn: ModuleFn, scope: Scope): T? =
        visitLambdaExpr(moduleFn as LambdaExpr, scope)

    override fun visitExprStmt(stmt: ExprStmt, scope: Scope): T? =
        visitExpr(stmt.expr, scope)

    override fun visitDeclStmt(stmt: DeclStmt, scope: Scope): T? =
        visitExpr(stmt.value, scope)

    override fun visitAssignmentStmt(
        stmt: AssignmentStmt,
        scope: Scope
    ): T? = visitExpr(stmt.value, scope)

    override fun visitDestructingStmt(
        stmt: DestructingStmt,
        scope: Scope
    ): T? = visitExpr(stmt.value, scope)

    override fun visitBreakStmt(stmt: BreakStmt, scope: Scope): T? =
        visitExpr(stmt.condition, scope)

    override fun visitMemberExpr(expr: MemberExpr, scope: Scope): T? {
        return visitExpr(expr.expr, scope)
    }

    override fun visitBinaryExpr(expr: BinaryExpr, scope: Scope): T? {
        visitExpr(expr.left, scope)
        visitExpr(expr.right, scope)

        return null
    }

    override fun visitUnaryExpr(expr: UnaryExpr, scope: Scope): T? =
        visitExpr(expr.operand, scope)

    override fun visitLambdaExpr(expr: LambdaExpr, scope: Scope): T? {
        expr.paramMap.values.forEach {
            if (it != null) visitExpr(it, expr.scope)
        }
        expr.stmtList.forEach { visitStmt(it, expr.scope) }
        expr.returnExpr?.let { visitExpr(it, expr.scope) }

        return null
    }

    override fun visitYieldExpr(expr: YieldExpr, scope: Scope): T? {
        visitExpr(expr.initializer, scope)
        visitExpr(expr.isAlive, scope)
        visitExpr(expr.toYield, scope)
        visitExpr(expr.updater, scope)

        return null
    }

    override fun visitCallExpr(expr: CallExpr, scope: Scope): T? {
        visitExpr(expr.callee, scope)
        expr.argList.forEach { visitExpr(it, scope) }

        return null
    }

    override fun visitListExpr(expr: ListExpr, scope: Scope): T? {
        expr.itemList.forEach { visitExpr(it, scope) }
        return null
    }

    override fun visitObjectExpr(expr: ObjectExpr, scope: Scope): T? {
        expr.fieldMap.keys.forEach { visitExpr(it, scope) }
        expr.fieldMap.values.forEach { visitExpr(it, scope) }

        return null
    }

    override fun visitIfExpr(expr: IfExpr, scope: Scope): T? {
        visitExpr(expr.condition, scope)
        visitExpr(expr.thenFn, scope)
        expr.elseFn?.let { visitExpr(it, scope) }

        return null
    }

    override fun visitLoopExpr(expr: LoopExpr, scope: Scope): T? =
        visitExpr(expr.fn, scope)

    override fun visitTypeExpr(expr: TypeExpr, scope: Scope): T? =
        visitExpr(expr.expr, scope)
}