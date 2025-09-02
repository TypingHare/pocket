package ast.builder

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import pocket.antlr.PocketParser.*
import pocket.antlr.PocketParserBaseVisitor
import pocket.ast.BinaryOperator
import pocket.ast.DeclKeyword
import pocket.ast.LiteralType
import pocket.ast.UnaryOperator
import pocket.ast.node.*
import java.nio.file.Path

/**
 * A builder to convert a module file into a module function abstract syntax
 * tree. In Pocket, a file is a module function, which is a trade function
 * taking no parameters.
 *
 * @parma filepath The absolute path of the module file.
 */
class ModuleFnBuilder(val filepath: Path) : PocketParserBaseVisitor<Node>() {
    override fun visitModuleFn(ctx: ModuleFnContext): ModuleFn {
        val stmtList = ctx.stmt()?.map { visitFor<Stmt>(it) } ?: emptyList()
        val returnExpr = ctx.expr()?.let { visitFor<Expr>(it) }

        return ModuleFn(getStartNode(ctx), stmtList, returnExpr)
    }

    override fun visitExprStmt(ctx: ExprStmtContext): Node {
        return ExprStmt(getStartNode(ctx), visitFor(ctx.expr()))
    }

    override fun visitDeclStmt(ctx: DeclStmtContext): Node {
        val isExport = ctx.EXPORT() != null
        val declKeyword = toDeclKeyword(ctx.decl())
        val id = toIdExpr(ctx.ID())
        val type = ctx.type()?.let { visitFor<TypeExpr>(it) }
        val value = visitFor<Expr>(ctx.expr())

        return DeclStmt(
            getStartNode(ctx),
            isExport,
            declKeyword,
            id,
            type,
            value
        )
    }

    override fun visitAssgnStmt(ctx: AssgnStmtContext): Node {
        val id = toIdExpr(ctx.ID())
        val value = visitFor<Expr>(ctx.expr())

        return AssignmentStmt(getStartNode(ctx), id, value)
    }

    override fun visitDestructingStmt(ctx: DestructingStmtContext): Node {
        val isExport = ctx.EXPORT() != null
        val declKeyword = toDeclKeyword(ctx.decl())
        val destructuringList = ctx.destructuringList()
        val idList = destructuringList.ID().map { toIdExpr(it) }
        val value = visitFor<Expr>(ctx.expr())

        return DestructingStmt(
            getStartNode(ctx),
            isExport,
            declKeyword,
            idList,
            value
        )
    }

    override fun visitBreakStmt(ctx: BreakStmtContext): Node {
        val condition = visitFor<Expr>(ctx.expr())
        return BreakStmt(getStartNode(ctx), condition)
    }

    override fun visitNativeStmt(ctx: NativeStmtContext): Node {
        val id = toIdExpr(ctx.ID())
        val type = visitFor<TypeExpr>(ctx.type())

        return NativeStmt(getStartNode(ctx), id, type)
    }

    override fun visitTypeDeclStmt(ctx: TypeDeclStmtContext): Node? {
        val id = toIdExpr(ctx.ID())
        val type = visitFor<TypeExpr>(ctx.type())

        return TypeDeclStmt(getStartNode(ctx), id, type)
    }

    override fun visitExpr(ctx: ExprContext): Node = visit(ctx.pipeExpr())

    override fun visitIntLiteralExpr(ctx: IntLiteralExprContext): Node =
        LiteralExpr(
            getStartNode(ctx),
            LiteralType.INT,
            ctx.INT_LITERAL().text
        )

    override fun visitFloatLiteralExpr(ctx: FloatLiteralExprContext): Node =
        LiteralExpr(
            getStartNode(ctx),
            LiteralType.FLOAT,
            ctx.FLOAT_LITERAL().text
        )

    override fun visitBoolExpr(ctx: BoolExprContext): Node =
        LiteralExpr(
            getStartNode(ctx),
            LiteralType.BOOLEAN,
            ctx.text
        )

    override fun visitStringLiteralExpr(ctx: StringLiteralExprContext): Node =
        LiteralExpr(
            getStartNode(ctx),
            LiteralType.STRING,
            ctx.STRING_LITERAL().text
        )

    override fun visitIdExpr(ctx: IdExprContext): Node =
        IdExpr(getStartNode(ctx), ctx.ID().text)

    override fun visitPipeExpr(ctx: PipeExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.logicOrExpr(),
            ctx.pipeOp()
        )

    override fun visitLogicOrExpr(ctx: LogicOrExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.logicAndExpr(),
            ctx.logicOrOp()
        )

    override fun visitLogicAndExpr(ctx: LogicAndExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.equalityExpr(),
            ctx.logicAndOp()
        )

    override fun visitEqualityExpr(ctx: EqualityExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.relationalExpr(),
            ctx.equalityOp()
        )

    override fun visitRelationalExpr(ctx: RelationalExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.additiveExpr(),
            ctx.relationalOp()
        )

    override fun visitAdditiveExpr(ctx: AdditiveExprContext): Node =
        collapseBinaryOperation(
            getStartNode(ctx),
            ctx.multiplicativeExpr(),
            ctx.additiveOp()
        )

    override fun visitMultiplicativeExpr(
        ctx: MultiplicativeExprContext
    ): Node = collapseBinaryOperation(
        getStartNode(ctx),
        ctx.unaryExpr(),
        ctx.multiplicativeOp()
    )

    override fun visitUnaryExpr(ctx: UnaryExprContext): Node {
        return when {
            ctx.unaryExpr() != null -> {
                val operator = toUnaryOperator(ctx.unaryOp())
                val operand = visitFor<Expr>(ctx.unaryExpr())
                return UnaryExpr(getStartNode(ctx), operator, operand)
            }
            ctx.postfixExpr() != null -> visit(ctx.postfixExpr())
            else -> error("Unexpected unary expression: ${ctx.text}")
        }
    }

    override fun visitLambdaExpr(ctx: LambdaExprContext): Node =
        visit(ctx.lambda())

    override fun visitLambda(ctx: LambdaContext): Node {
        val isTrade = ctx.TRADE() != null
        val paramMap =
            ctx.paramList()?.param()?.associate { toParam(it) } ?: emptyMap()
        val stmtList = ctx.stmt().map { visitFor<Stmt>(it) }
        val expr = ctx.expr()?.let { visitFor<Expr>(it) }

        return LambdaExpr(getStartNode(ctx), isTrade, paramMap, stmtList, expr)
    }

    override fun visitYieldExpr(ctx: YieldExprContext): Node {
        val initializer = visitFor<Expr>(ctx.expr(0))
        val isAlive = visitFor<Expr>(ctx.expr(1))
        val toYield = visitFor<Expr>(ctx.expr(2))
        val updater = visitFor<Expr>(ctx.expr(3))

        return YieldExpr(
            getStartNode(ctx),
            initializer,
            isAlive,
            toYield,
            updater
        )
    }

    override fun visitPostfixMemberAccess(
        ctx: PostfixMemberAccessContext?
    ): Node? = super.visitPostfixMemberAccess(ctx)

    override fun visitPostfixExpr(ctx: PostfixExprContext): Node {
        val hasTrailingLambda = ctx.lambda() != null
        if (ctx.postfixPart().isEmpty() && !hasTrailingLambda) {
            return visit(ctx.primaryExpr())
        }

        val left = visitFor<Expr>(ctx.primaryExpr())
        val lastExpr = ctx.postfixPart().fold(left) { left, postfixPart ->
            val node = getStartNode(postfixPart)
            when (postfixPart) {
                is PostfixMemberAccessContext -> MemberExpr(
                    node, left, postfixPart.ID().text
                )
                is PostfixCallContext -> CallExpr(
                    node, left, toArgList(postfixPart.argList())
                )
                else -> error("Unexpected postfix part: ${postfixPart.text}")
            }
        }

        if (!hasTrailingLambda) {
            return lastExpr
        }

        // Support trailing lambda
        val lambdaExpr = visitFor<Expr>(ctx.lambda())
        val node = getStartNode(ctx)
        return if (lastExpr is CallExpr) {
            CallExpr(node, lastExpr.callee, lastExpr.argList + lambdaExpr)
        } else {
            CallExpr(node, lastExpr, listOf(lambdaExpr))
        }
    }

    override fun visitTupleExpr(ctx: TupleExprContext): Node? {
        val itemList = ctx.tupleItemList().expr().map { visitFor<Expr>(it) }
        return TupleExpr(getStartNode(ctx), itemList)
    }

    override fun visitListExpr(ctx: ListExprContext): Node {
        val exprList = ctx.listItemList().expr()
        return ListExpr(getStartNode(ctx), exprList.map { visitFor(it) })
    }

    override fun visitObjectExpr(ctx: ObjectExprContext): Node {
        val idList = ctx.objectItemList().ID().map { toIdExpr(it) }
        val valueList =
            ctx.objectItemList().expr().map { visitFor<Expr>(it) }
        val fieldMap = idList.zip(valueList).toMap()

        return ObjectExpr(getStartNode(ctx), fieldMap)
    }

    override fun visitIfExpr(ctx: IfExprContext): Node {
        val condition = visitFor<Expr>(ctx.expr(0))
        val thenBranch = visitFor<Expr>(ctx.expr(1))
        val elseBranch = ctx.expr(2)?.let { visitFor<Expr>(it) }

        return IfExpr(getStartNode(ctx), condition, thenBranch, elseBranch)
    }

    override fun visitLoopExpr(ctx: LoopExprContext): Node =
        LoopExpr(getStartNode(ctx), visitFor(ctx.expr()))

    override fun visitImportExpr(ctx: ImportExprContext): Node {
        val targetPath = ctx.targetPath().text
        return ImportExpr(getStartNode(ctx), targetPath)
    }

    override fun visitIdTypeExpr(ctx: IdTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    override fun visitNoneTypeExpr(ctx: NoneTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    override fun visitLambdaTypeExpr(ctx: LambdaTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    override fun visitTupleTypeExpr(ctx: TupleTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    override fun visitListTypeExpr(ctx: ListTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    override fun visitObjectTypeExpr(ctx: ObjectTypeExprContext?): Node? =
        ctx?.let { parseTypeExprContext(it) }

    /**
     * Visits a parse tree and cast the return type into a specific type.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <D> visitFor(tree: ParseTree): D = visit(tree) as D

    /**
     * Extracts the line number and column number from a given token and returns
     * an original AST node.
     */
    private fun tokenToNode(token: Token): Node {
        val line = token.line
        val column = token.charPositionInLine

        return object : Node(filepath, line, column) {}
    }

    /**
     * Gets the first token in the given parser rule context, and converts it
     * into an original AST node.
     */
    private fun getStartNode(ctx: ParserRuleContext): Node =
        tokenToNode(ctx.getStart())

    /**
     * Converts a terminal node context into an ID expression.
     */
    private fun toIdExpr(ctx: TerminalNode) =
        IdExpr(tokenToNode(ctx.symbol), ctx.text)

    /**
     * Converts a declaration context into a declaration keyword.
     */
    private fun toDeclKeyword(ctx: DeclContext): DeclKeyword {
        if (ctx.LET() != null) return DeclKeyword.LET
        if (ctx.VAL() != null) return DeclKeyword.VAL

        throw IllegalStateException("Unexpected token ${ctx.text}")
    }

    private fun collapseBinaryOperation(
        getStartNode: Node,
        exprCtxList: List<ParserRuleContext>,
        operatorCtxList: List<ParserRuleContext>
    ): Node {
        val operatorList = operatorCtxList.map { toBinaryOperator(it) }
        return exprCtxList
            .map { visitFor<Expr>(it) }
            .reduceIndexed { index, left, right ->
                BinaryExpr(getStartNode, operatorList[index - 1], left, right)
            }
    }

    private fun toBinaryOperator(
        ctx: ParserRuleContext
    ): BinaryOperator {
        return when (ctx) {
            is PipeOpContext -> return BinaryOperator.PIPE
            is LogicOrOpContext -> return BinaryOperator.LOGIC_OR
            is LogicAndOpContext -> return BinaryOperator.LOGIC_AND
            is EqualityOpContext -> when {
                ctx.EQUAL_EQUALS() != null -> BinaryOperator.EQUALS
                ctx.NOT_EQUALS() != null -> BinaryOperator.NOT_EQUALS
                else -> error("Unexpected binary operator: ${ctx.text}")
            }
            is RelationalOpContext -> when {
                ctx.LESS_THAN() != null -> BinaryOperator.LESS_THAN
                ctx.LESS_THAN_EQUALS() != null -> BinaryOperator.LESS_THAN_EQUALS
                ctx.GREATER_THAN() != null -> BinaryOperator.GREATER_THAN
                ctx.GREATER_THAN_EQUALS() != null -> BinaryOperator.GREATER_THAN_EQUALS
                else -> error("Unexpected binary operator: ${ctx.text}")
            }
            is AdditiveOpContext -> when {
                ctx.PLUS() != null -> BinaryOperator.PLUS
                ctx.MINUS() != null -> BinaryOperator.MINUS
                else -> error("Unexpected binary operator: ${ctx.text}")
            }
            is MultiplicativeOpContext -> when {
                ctx.ASTERISK() != null -> BinaryOperator.MULTIPLY
                ctx.SLASH() != null -> BinaryOperator.DIVIDE
                ctx.PERCENT() != null -> BinaryOperator.MODULO
                else -> error("Unexpected binary operator: ${ctx.text}")
            }
            else -> error("Unexpected binary operator: ${ctx.text}")
        }
    }

    private fun toUnaryOperator(ctx: UnaryOpContext): UnaryOperator = when {
        ctx.NOT() != null -> UnaryOperator.NOT
        ctx.MINUS() != null -> UnaryOperator.MINUS
        else -> error("Unexpected unary operator: ${ctx.text}")
    }

    private fun toParam(ctx: ParamContext): Pair<IdExpr, TypeExpr?> =
        toIdExpr(ctx.ID()) to ctx.type()?.let { visitFor<TypeExpr>(it) }

    private fun toArgList(ctx: ArgListContext): List<Expr> =
        ctx.expr().map { visitFor(it) }

    private fun parseTypeExprContext(ctx: TypeContext): TypeExpr =
        when (ctx) {
            is NoneTypeExprContext -> NoneTypeExpr(getStartNode(ctx))
            is IdTypeExprContext -> parseIdTypeExpr(ctx)
            is TupleTypeExprContext -> parseTupleTypeExpr(ctx)
            is ListTypeExprContext -> parseListTypeExpr(ctx)
            is ObjectTypeExprContext -> parseObjectTypeExpr(ctx)
            is LambdaTypeExprContext -> parseLambdaTypeExpr(ctx)
            else -> error("Unknown type: ${ctx.text}")
        }

    private fun parseIdTypeExpr(ctx: IdTypeExprContext): TypeExpr =
        IdTypeExpr(getStartNode(ctx), ctx.ID().text)

    private fun parseLambdaTypeExpr(ctx: LambdaTypeExprContext): TypeExpr {
        val paramTypeList = ctx.typeList()?.type()?.map {
            parseTypeExprContext(it)
        } ?: emptyList()
        val returnType = parseTypeExprContext(ctx.type())

        return LambdaTypeExpr(getStartNode(ctx), paramTypeList, returnType)
    }

    private fun parseTupleTypeExpr(ctx: TupleTypeExprContext): TypeExpr {
        val itemTypeList = ctx.typeList()?.type()?.map {
            parseTypeExprContext(it)
        } ?: emptyList()

        return TupleTypeExpr(getStartNode(ctx), itemTypeList)
    }

    private fun parseListTypeExpr(ctx: ListTypeExprContext): TypeExpr {
        val itemType = parseTypeExprContext(ctx.type())
        return ListTypeExpr(getStartNode(ctx), itemType)
    }

    private fun parseObjectTypeExpr(ctx: ObjectTypeExprContext): TypeExpr {
        val objectTypeList = ctx.objectTypeList()
        val idList = objectTypeList.ID()
        val typeList = objectTypeList.type()
        val fieldTypeMap = (0 until typeList.size).associate {
            val id = idList[it]
            val type = typeList[it]
            val idExpr = IdExpr(tokenToNode(id.symbol), id.text)
            idExpr to parseTypeExprContext(type)
        }

        return ObjectTypeExpr(getStartNode(ctx), fieldTypeMap)
    }
}