package pocket.ast.visitor

import pocket.ast.BinaryOperator
import pocket.ast.LiteralType
import pocket.ast.Scope
import pocket.ast.Symbol
import pocket.ast.node.*
import java.nio.file.Path

class ResolveTypeVisitor() : StructuralTypeVisitor<Object>() {
    override fun visitProgram(program: Program): Object? {
        val definePrimitiveSymbol: (String, Type) -> Unit = { name, type ->
            program.globalScope.define(
                Symbol(
                    name,
                    IdExpr(object : ASTNode(Path.of(""), 0, 0) {}, name)
                        .apply { this.type = type },
                    isMutable = false,
                    isDestructured = false
                )
            )
        }

        definePrimitiveSymbol("Int", Type.Int)
        definePrimitiveSymbol("Float", Type.Float)
        definePrimitiveSymbol("Bool", Type.Bool)
        definePrimitiveSymbol("String", Type.String)

        super.visitProgram(program)

        return null
    }

    override fun visitModuleFn(moduleFn: ModuleFn, scope: Scope): Object? {
        super.visitModuleFn(moduleFn, scope)
        val returnType = moduleFn.returnExpr?.type ?: Type.Int
        val fieldTypeMap = moduleFn.stmtList
            .filter { it is DeclStmt }
            .associate { (it as DeclStmt).id.name to it.value.type }
        val exportObjectType = Type.Object(fieldTypeMap)
        moduleFn.type =
            Type.TradeFunction(listOf(), returnType, exportObjectType)

        return null
    }

    override fun visitDeclStmt(stmt: DeclStmt, scope: Scope): Object? {
        super.visitDeclStmt(stmt, scope)
        val realType = stmt.value.type
        val declType = stmt.type?.type

        if (declType == null) {
            stmt.id.type = realType
            return null
        }

        if (realType != declType) {
            error("The declaration type doesn't match the real type: $declType")
        }

        stmt.id.type = declType

        return null
    }

    override fun visitAssignmentStmt(
        stmt: AssignmentStmt,
        scope: Scope
    ): Object? {
        super.visitAssignmentStmt(stmt, scope)

        return null
    }

    override fun visitDestructingStmt(
        stmt: DestructingStmt,
        scope: Scope
    ): Object? {
        super.visitDestructingStmt(stmt, scope)
        return null
    }

    override fun visitBreakStmt(stmt: BreakStmt, scope: Scope): Object? {
        super.visitBreakStmt(stmt, scope)

        if (stmt.condition.type != Type.Bool) {
            error("condition is not a boolean")
        }

        return null
    }

    override fun visitNativeStmt(stmt: NativeStmt, scope: Scope): Object? {
        super.visitNativeStmt(stmt, scope)
        visitTypeExpr(stmt.type, scope)
        stmt.id.type = stmt.type.type

        return null
    }

    override fun visitLiteralExpr(expr: LiteralExpr, scope: Scope): Object? {
        when (expr.literalType) {
            LiteralType.INT -> expr.type = Type.Int
            LiteralType.FLOAT -> expr.type = Type.Float
            LiteralType.BOOLEAN -> expr.type = Type.Bool
            LiteralType.STRING -> expr.type = Type.String
        }

        return null
    }

    override fun visitIdExpr(expr: IdExpr, scope: Scope): Object? {
        super.visitIdExpr(expr, scope)
        val symbol = scope.resolve(expr.name)
        expr.type = when (symbol) {
            null -> Type.Any
            else -> if (!symbol.isDestructured) {
                symbol.declExpr?.type ?: Type.Any
            } else {
                if (symbol.declExpr?.type !is Type.Object) {
                    error("Destructured symbol is not an object")
                }

                val objectType = symbol.declExpr.type as Type.Object
                objectType.fieldTypeMap[expr.name] ?: Type.Any
            }
        }

        return null
    }

    override fun visitMemberExpr(expr: MemberExpr, scope: Scope): Object? {
        super.visitMemberExpr(expr, scope)
        val objectType = expr.type

        if (objectType is Type.Any) {
            return null
        }

        if (objectType !is Type.Object) {
            error("objectType is not an object")
        }

        expr.type = objectType.fieldTypeMap[expr.name] ?: Type.Any

        return null
    }

    override fun visitBinaryExpr(expr: BinaryExpr, scope: Scope): Object? {
        super.visitBinaryExpr(expr, scope)
        expr.type = when (expr.operator) {
            BinaryOperator.PIPE -> {
                val calleeType = expr.right.type
                if (calleeType !is Type.Function) {
                    error("right operand is not a function")
                }

                calleeType.returnType
            }
            BinaryOperator.LOGIC_OR -> Type.Int
            BinaryOperator.LOGIC_AND -> Type.Int
            BinaryOperator.EQUALS -> Type.Bool
            BinaryOperator.NOT_EQUALS -> Type.Bool
            BinaryOperator.LESS_THAN -> Type.Bool
            BinaryOperator.LESS_THAN_EQUALS -> Type.Bool
            BinaryOperator.GREATER_THAN -> Type.Bool
            BinaryOperator.GREATER_THAN_EQUALS -> Type.Bool
            BinaryOperator.PLUS -> expr.left.type
            BinaryOperator.MINUS -> expr.left.type
            BinaryOperator.MULTIPLY -> expr.left.type
            BinaryOperator.DIVIDE -> expr.left.type
            BinaryOperator.MODULO -> expr.left.type
        }

        return null
    }

    override fun visitUnaryExpr(expr: UnaryExpr, scope: Scope): Object? = null

    override fun visitLambdaExpr(expr: LambdaExpr, scope: Scope): Object? {
        super.visitLambdaExpr(expr, scope)

        val paramTypeList = expr.paramMap.values.map { it?.type ?: Type.Any }
        val returnType = expr.returnExpr?.type ?: Type.Int
        expr.type = Type.Function(paramTypeList, returnType)

        return null
    }

    override fun visitYieldExpr(expr: YieldExpr, scope: Scope): Object? = null

    override fun visitCallExpr(expr: CallExpr, scope: Scope): Object? {
        super.visitCallExpr(expr, scope)
        val calleeType = expr.callee.type
        expr.type = when (calleeType) {
            is Type.Function -> calleeType.returnType
            else -> Type.Any
        }

        return null
    }

    override fun visitListExpr(expr: ListExpr, scope: Scope): Object? {
        super.visitListExpr(expr, scope)
        expr.type = Type.List(expr.itemList.firstOrNull()?.type ?: Type.Any)

        return null
    }

    override fun visitObjectExpr(expr: ObjectExpr, scope: Scope): Object? {
        super.visitObjectExpr(expr, scope)

        if (expr.fieldMap.isEmpty()) {
            expr.type = Type.Object(mapOf())
            return null
        }

        val fieldTypeMap = mutableMapOf<String, Type>()
        expr.fieldMap.entries.forEach {
            fieldTypeMap[it.key.name] = it.value.type
        }
        Type.Object(fieldTypeMap)

        return null
    }

    override fun visitIfExpr(expr: IfExpr, scope: Scope): Object? {
        super.visitIfExpr(expr, scope)

        if (expr.condition.type != Type.Bool) {
            error("condition is not a boolean")
        }

        if (expr.thenFn.type !is Type.Function) {
            error("thenFn is not a function")
        }

        if (expr.elseFn != null) {
            if (expr.elseFn.type !is Type.Function) {
                error("elseFn is not a function")
            }

            val thenFnType = expr.thenFn.type as Type.Function
            val elseFnType = expr.elseFn.type as Type.Function
            if (thenFnType.returnType != elseFnType.returnType) {
                error("thenFn and elseFn have different return types")
            }
        }

        expr.type = (expr.thenFn.type as Type.Function).returnType

        return null
    }

    override fun visitLoopExpr(expr: LoopExpr, scope: Scope): Object? {
        expr.type = Type.None
        return null
    }

    override fun visitImportExpr(expr: ImportExpr, scope: Scope): Object? {
        expr.type = Type.Object(mapOf())
        val tradeFunctionType = expr.moduleFn!!.type as Type.TradeFunction
        expr.type = tradeFunctionType.exportObjectType

        return null
    }

    override fun visitNoneTypeExpr(
        expr: NoneTypeExpr,
        scope: Scope
    ): Object? {
        expr.type = Type.None
        return null
    }

    override fun visitIdTypeExpr(
        expr: IdTypeExpr,
        scope: Scope
    ): Object? {
        val symbol = scope.resolve(expr.name)
        expr.type = symbol?.declExpr?.type ?: Type.Any

        return null
    }

    override fun visitLambdaTypeExpr(
        expr: LambdaTypeExpr,
        scope: Scope
    ): Object? {
        expr.paramTypeList.forEach { visitTypeExpr(it, scope) }
        visitTypeExpr(expr.returnType, scope)

        val parameterTypeList = expr.paramTypeList.map { it.type }
        val returnType = expr.returnType.type
        expr.type = Type.Function(parameterTypeList, returnType)

        return null
    }

    override fun visitTupleTypeExpr(
        expr: TupleTypeExpr,
        scope: Scope
    ): Object? {
        expr.itemTypeList.forEach { visitTypeExpr(it, scope) }
        val typeList = expr.itemTypeList.map { it.type }
        expr.type = Type.Tuple(typeList)

        return null
    }

    override fun visitListTypeExpr(
        expr: ListTypeExpr,
        scope: Scope
    ): Object? {
        visitTypeExpr(expr.itemType, scope)
        expr.type = Type.List(expr.type)

        return null
    }

    override fun visitIterableTypeExpr(
        expr: IterableTypeExpr,
        scope: Scope
    ): Object? {
        visitTypeExpr(expr, scope)
        expr.type = Type.Iterable(expr.type)

        return null
    }

    override fun visitObjectTypeExpr(
        expr: ObjectTypeExpr,
        scope: Scope
    ): Object? {
        expr.fieldTypeMap.forEach { (_, type) -> visitTypeExpr(type, scope) }
        val fieldTypeMap = expr.fieldTypeMap.map { (idExpr, typeExpr) ->
            idExpr.type = typeExpr.type
            idExpr.name to typeExpr.type
        }.toMap()
        expr.type = Type.Object(fieldTypeMap)

        return null
    }
}