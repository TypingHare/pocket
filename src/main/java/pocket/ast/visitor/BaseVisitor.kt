package pocket.ast.visitor

import pocket.ast.node.*

open class BaseVisitor<T>() : Visitor<T>() {
    override fun visitProgram(program: Program): T? = null

    override fun visitModuleFn(moduleFn: ModuleFn): T? = null

    override fun visitExprStmt(stmt: ExprStmt): T? = null
    override fun visitDeclStmt(stmt: DeclStmt): T? = null
    override fun visitAssignmentStmt(stmt: AssignmentStmt): T? = null
    override fun visitDestructingStmt(stmt: DestructingStmt): T? = null
    override fun visitBreakStmt(stmt: BreakStmt): T? = null
    override fun visitNativeStmt(stmt: NativeStmt): T? = null

    override fun visitLiteralExpr(expr: LiteralExpr): T? = null
    override fun visitIdExpr(expr: IdExpr): T? = null
    override fun visitMemberExpr(expr: MemberExpr): T? = null
    override fun visitBinaryExpr(expr: BinaryExpr): T? = null
    override fun visitUnaryExpr(expr: UnaryExpr): T? = null
    override fun visitLambdaExpr(expr: LambdaExpr): T? = null
    override fun visitYieldExpr(expr: YieldExpr): T? = null
    override fun visitCallExpr(expr: CallExpr): T? = null
    override fun visitListExpr(expr: ListExpr): T? = null
    override fun visitObjectExpr(expr: ObjectExpr): T? = null
    override fun visitIfExpr(expr: IfExpr): T? = null
    override fun visitLoopExpr(expr: LoopExpr): T? = null
    override fun visitTypeExpr(expr: TypeExpr): T? = null
    override fun visitImportExpr(expr: ImportExpr): T? = null
}