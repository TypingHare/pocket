package pocket.ast.visitor

import pocket.ast.LiteralType
import pocket.ast.Scope
import pocket.ast.node.*

class ResolveTypeVisitor() : StructuralTypeVisitor<Object>() {
    override fun visitModuleFn(moduleFn: ModuleFn, scope: Scope): Object? {
        super.visitModuleFn(moduleFn, scope)
        val returnType = moduleFn.returnExpr?.type ?: Type.Int
        moduleFn.type = Type.Function(listOf(), returnType)

        return null
    }

    override fun visitExprStmt(stmt: ExprStmt, scope: Scope): Object? = null

    override fun visitDeclStmt(stmt: DeclStmt, scope: Scope): Object? {
        super.visitDeclStmt(stmt, scope)
        stmt.id.type = stmt.value.type

        return null
    }

    override fun visitAssignmentStmt(
        stmt: AssignmentStmt,
        scope: Scope
    ): Object? = null

    override fun visitDestructingStmt(
        stmt: DestructingStmt,
        scope: Scope
    ): Object? = null

    override fun visitBreakStmt(stmt: BreakStmt, scope: Scope): Object? = null
    override fun visitNativeStmt(stmt: NativeStmt, scope: Scope): Object? = null

    override fun visitLiteralExpr(expr: LiteralExpr, scope: Scope): Object? {
        when (expr.literalType) {
            LiteralType.INT -> expr.type = Type.Int
            LiteralType.FLOAT -> expr.type = Type.Float
            LiteralType.BOOLEAN -> expr.type = Type.Bool
            LiteralType.STRING -> expr.type = Type.String
        }

        return null
    }

    override fun visitIdExpr(expr: IdExpr, scope: Scope): Object? = null
    override fun visitMemberExpr(expr: MemberExpr, scope: Scope): Object? = null
    override fun visitBinaryExpr(expr: BinaryExpr, scope: Scope): Object? = null
    override fun visitUnaryExpr(expr: UnaryExpr, scope: Scope): Object? = null

    override fun visitLambdaExpr(expr: LambdaExpr, scope: Scope): Object? {
        super.visitLambdaExpr(expr, scope)

        val paramTypeList = expr.paramMap.values.map { it?.type ?: Type.Any }
        val returnType = expr.returnExpr?.type ?: Type.Int
        expr.type = Type.Function(paramTypeList, returnType)

        return null
    }

    override fun visitYieldExpr(expr: YieldExpr, scope: Scope): Object? = null
    override fun visitCallExpr(expr: CallExpr, scope: Scope): Object? = null
    override fun visitListExpr(expr: ListExpr, scope: Scope): Object? = null
    override fun visitObjectExpr(expr: ObjectExpr, scope: Scope): Object? = null

    override fun visitIfExpr(expr: IfExpr, scope: Scope): Object? {
        super.visitIfExpr(expr, scope)
        // TODO: Ensure the return type of then and else are the same
        expr.type = (expr.thenFn.type as Type.Function).returnType

        return null
    }

    override fun visitLoopExpr(expr: LoopExpr, scope: Scope): Object? = null
    override fun visitTypeExpr(expr: TypeExpr, scope: Scope): Object? = null
    override fun visitImportExpr(expr: ImportExpr, scope: Scope): Object? = null
}