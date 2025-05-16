package pocket.ast.visitor

import pocket.ast.Scope
import pocket.ast.node.*

abstract class TypeVisitor<T>() {
    abstract fun visitProgram(program: Program): T?

    abstract fun visitModuleFn(moduleFn: ModuleFn, scope: Scope): T?

    open fun visitStmt(stmt: Stmt, scope: Scope): T? = when (stmt) {
        is ExprStmt -> visitExprStmt(stmt, scope)
        is DeclStmt -> visitDeclStmt(stmt, scope)
        is AssignmentStmt -> visitAssignmentStmt(stmt, scope)
        is DestructingStmt -> visitDestructingStmt(stmt, scope)
        is BreakStmt -> visitBreakStmt(stmt, scope)
        is NativeStmt -> visitNativeStmt(stmt, scope)
        else -> error("Unexpected statement: $stmt")
    }

    abstract fun visitExprStmt(stmt: ExprStmt, scope: Scope): T?
    abstract fun visitDeclStmt(stmt: DeclStmt, scope: Scope): T?
    abstract fun visitAssignmentStmt(stmt: AssignmentStmt, scope: Scope): T?
    abstract fun visitDestructingStmt(stmt: DestructingStmt, scope: Scope): T?
    abstract fun visitBreakStmt(stmt: BreakStmt, scope: Scope): T?
    abstract fun visitNativeStmt(stmt: NativeStmt, scope: Scope): T?

    open fun visitExpr(expr: Expr, scope: Scope): T? = when (expr) {
        is LiteralExpr -> visitLiteralExpr(expr, scope)
        is IdExpr -> visitIdExpr(expr, scope)
        is MemberExpr -> visitMemberExpr(expr, scope)
        is BinaryExpr -> visitBinaryExpr(expr, scope)
        is UnaryExpr -> visitUnaryExpr(expr, scope)
        is LambdaExpr -> visitLambdaExpr(expr, scope)
        is YieldExpr -> visitYieldExpr(expr, scope)
        is CallExpr -> visitCallExpr(expr, scope)
        is ListExpr -> visitListExpr(expr, scope)
        is ObjectExpr -> visitObjectExpr(expr, scope)
        is IfExpr -> visitIfExpr(expr, scope)
        is LoopExpr -> visitLoopExpr(expr, scope)
        is TypeExpr -> visitTypeExpr(expr, scope)
        is ImportExpr -> visitImportExpr(expr, scope)
        else -> error("Unexpected expression: $expr")
    }

    abstract fun visitLiteralExpr(expr: LiteralExpr, scope: Scope): T?
    abstract fun visitIdExpr(expr: IdExpr, scope: Scope): T?
    abstract fun visitMemberExpr(expr: MemberExpr, scope: Scope): T?
    abstract fun visitBinaryExpr(expr: BinaryExpr, scope: Scope): T?
    abstract fun visitUnaryExpr(expr: UnaryExpr, scope: Scope): T?
    abstract fun visitLambdaExpr(expr: LambdaExpr, scope: Scope): T?
    abstract fun visitYieldExpr(expr: YieldExpr, scope: Scope): T?
    abstract fun visitCallExpr(expr: CallExpr, scope: Scope): T?
    abstract fun visitListExpr(expr: ListExpr, scope: Scope): T?
    abstract fun visitObjectExpr(expr: ObjectExpr, scope: Scope): T?
    abstract fun visitIfExpr(expr: IfExpr, scope: Scope): T?
    abstract fun visitLoopExpr(expr: LoopExpr, scope: Scope): T?
    abstract fun visitTypeExpr(expr: TypeExpr, scope: Scope): T?
    abstract fun visitImportExpr(expr: ImportExpr, scope: Scope): T?
}