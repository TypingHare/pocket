package pocket.ast.visitor

import pocket.ast.node.*

/**
 * Walks through all the internal nodes. The following expressions are
 * considered as leaf nodes:
 *
 * 1. [LiteralExpr]
 * 2. [IdExpr]
 * 3. [MemberExpr]
 * 4. [TypeExpr]
 */
open class StructuralVisitor<T> : BaseVisitor<T>() {
    override fun visitProgram(program: Program): T? {
        program.moduleFnList.forEach { visitModuleFn(it) }
        return null
    }

    override fun visitModuleFn(moduleFn: ModuleFn): T? {
        visitLambdaExpr(moduleFn as LambdaExpr)
        return null
    }

    override fun visitExprStmt(stmt: ExprStmt): T? {
        visitExpr(stmt.expr)
        return null
    }

    override fun visitDeclStmt(stmt: DeclStmt): T? {
        visitExpr(stmt.value)
        return null
    }

    override fun visitAssignmentStmt(stmt: AssignmentStmt): T? {
        visitExpr(stmt.value)
        return null
    }

    override fun visitDestructingStmt(stmt: DestructingStmt): T? {
        visitExpr(stmt.value)
        return null
    }

    override fun visitBreakStmt(stmt: BreakStmt): T? {
        visitExpr(stmt.condition)
        return null
    }

    override fun visitNativeStmt(stmt: NativeStmt): T? = null

    override fun visitBinaryExpr(expr: BinaryExpr): T? {
        visitExpr(expr.left)
        visitExpr(expr.right)
        return null
    }

    override fun visitUnaryExpr(expr: UnaryExpr): T? {
        visitExpr(expr.operand)
        return null
    }

    override fun visitLambdaExpr(expr: LambdaExpr): T? {
        expr.stmtList.forEach { visitStmt(it) }
        expr.returnExpr?.let { visitExpr(it) }

        return null
    }

    override fun visitYieldExpr(expr: YieldExpr): T? {
        visitExpr(expr.initializer)
        visitExpr(expr.isAlive)
        visitExpr(expr.toYield)
        visitExpr(expr.updater)

        return null
    }

    override fun visitCallExpr(expr: CallExpr): T? {
        visitExpr(expr.callee)
        expr.argList.forEach { visitExpr(it) }

        return null
    }

    override fun visitListExpr(expr: ListExpr): T? {
        expr.itemList.forEach { visitExpr(it) }
        return null
    }

    override fun visitObjectExpr(expr: ObjectExpr): T? {
        expr.fieldMap.values.forEach { visitExpr(it) }
        return null
    }

    override fun visitIfExpr(expr: IfExpr): T? {
        visitExpr(expr.condition)
        visitExpr(expr.thenFn)
        expr.elseFn?.let { visitExpr(it) }

        return null
    }

    override fun visitLoopExpr(expr: LoopExpr): T? {
        visitExpr(expr.fn)

        return null
    }

    override fun visitImportExpr(expr: ImportExpr): T? = null
}