package pocket.ast.visitor

import pocket.ast.node.*


abstract class Visitor<T> {
    abstract fun visitProgram(program: Program): T?

    abstract fun visitModuleFn(moduleFn: ModuleFn): T?

    open fun visitStmt(stmt: Stmt): T? = when (stmt) {
        is ExprStmt -> visitExprStmt(stmt)
        is DeclStmt -> visitDeclStmt(stmt)
        is AssignmentStmt -> visitAssignmentStmt(stmt)
        is DestructingStmt -> visitDestructingStmt(stmt)
        is BreakStmt -> visitBreakStmt(stmt)
        is NativeStmt -> visitNativeStmt(stmt)
        else -> error("Unexpected statement: $stmt")
    }

    abstract fun visitExprStmt(stmt: ExprStmt): T?
    abstract fun visitDeclStmt(stmt: DeclStmt): T?
    abstract fun visitAssignmentStmt(stmt: AssignmentStmt): T?
    abstract fun visitDestructingStmt(stmt: DestructingStmt): T?
    abstract fun visitBreakStmt(stmt: BreakStmt): T?
    abstract fun visitNativeStmt(stmt: NativeStmt): T?

    open fun visitExpr(expr: Expr): T? = when (expr) {
        is LiteralExpr -> visitLiteralExpr(expr)
        is IdExpr -> visitIdExpr(expr)
        is MemberExpr -> visitMemberExpr(expr)
        is BinaryExpr -> visitBinaryExpr(expr)
        is UnaryExpr -> visitUnaryExpr(expr)
        is LambdaExpr -> visitLambdaExpr(expr)
        is YieldExpr -> visitYieldExpr(expr)
        is CallExpr -> visitCallExpr(expr)
        is ListExpr -> visitListExpr(expr)
        is ObjectExpr -> visitObjectExpr(expr)
        is IfExpr -> visitIfExpr(expr)
        is LoopExpr -> visitLoopExpr(expr)
        is TypeExpr -> visitTypeExpr(expr)
        is ImportExpr -> visitImportExpr(expr)
        else -> error("Unexpected expression: $expr")
    }

    abstract fun visitLiteralExpr(expr: LiteralExpr): T?
    abstract fun visitIdExpr(expr: IdExpr): T?
    abstract fun visitMemberExpr(expr: MemberExpr): T?
    abstract fun visitBinaryExpr(expr: BinaryExpr): T?
    abstract fun visitUnaryExpr(expr: UnaryExpr): T?
    abstract fun visitLambdaExpr(expr: LambdaExpr): T?
    abstract fun visitYieldExpr(expr: YieldExpr): T?
    abstract fun visitCallExpr(expr: CallExpr): T?
    abstract fun visitListExpr(expr: ListExpr): T?
    abstract fun visitObjectExpr(expr: ObjectExpr): T?
    abstract fun visitIfExpr(expr: IfExpr): T?
    abstract fun visitLoopExpr(expr: LoopExpr): T?
    abstract fun visitTypeExpr(expr: TypeExpr): T?
    abstract fun visitImportExpr(expr: ImportExpr): T?
}