package pocket.ast.visitor

import pocket.ast.Scope
import pocket.ast.node.*

open class BaseTypeVisitor<T>() : TypeVisitor<T>() {
    override fun visitProgram(program: Program): T? = null

    override fun visitModuleFn(moduleFn: ModuleFn, scope: Scope): T? = null

    override fun visitExprStmt(stmt: ExprStmt, scope: Scope): T? = null
    override fun visitDeclStmt(stmt: DeclStmt, scope: Scope): T? = null
    override fun visitAssignmentStmt(stmt: AssignmentStmt, scope: Scope): T? =
        null

    override fun visitDestructingStmt(stmt: DestructingStmt, scope: Scope): T? =
        null

    override fun visitBreakStmt(stmt: BreakStmt, scope: Scope): T? = null
    override fun visitNativeStmt(stmt: NativeStmt, scope: Scope): T? = null

    override fun visitLiteralExpr(expr: LiteralExpr, scope: Scope): T? = null
    override fun visitIdExpr(expr: IdExpr, scope: Scope): T? = null
    override fun visitMemberExpr(expr: MemberExpr, scope: Scope): T? = null
    override fun visitBinaryExpr(expr: BinaryExpr, scope: Scope): T? = null
    override fun visitUnaryExpr(expr: UnaryExpr, scope: Scope): T? = null
    override fun visitLambdaExpr(expr: LambdaExpr, scope: Scope): T? = null
    override fun visitYieldExpr(expr: YieldExpr, scope: Scope): T? = null
    override fun visitCallExpr(expr: CallExpr, scope: Scope): T? = null
    override fun visitListExpr(expr: ListExpr, scope: Scope): T? = null
    override fun visitObjectExpr(expr: ObjectExpr, scope: Scope): T? = null
    override fun visitIfExpr(expr: IfExpr, scope: Scope): T? = null
    override fun visitLoopExpr(expr: LoopExpr, scope: Scope): T? = null
    override fun visitTypeExpr(expr: TypeExpr, scope: Scope): T? = null
    override fun visitImportExpr(expr: ImportExpr, scope: Scope): T? = null
}