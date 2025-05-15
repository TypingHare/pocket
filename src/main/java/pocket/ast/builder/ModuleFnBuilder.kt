package pocket.ast.builder

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
class ModuleFnBuilder(val filepath: Path) : PocketParserBaseVisitor<ASTNode>() {
    override fun visitModuleFn(ctx: ModuleFnContext): ASTNode {
        val stmtList = ctx.stmt()?.map { visitFor<Stmt>(it) } ?: emptyList()
        val expr = ctx.expr()?.let { visitFor<Expr>(it) }

        return ModuleFn(startNode(ctx), stmtList, expr)
    }

    override fun visitExprStmt(ctx: ExprStmtContext): ASTNode {
        return ExprStmt(startNode(ctx), visitFor(ctx.expr()))
    }

    override fun visitDeclStmt(ctx: DeclStmtContext): ASTNode {
        val isExport = ctx.EXPORT() != null
        val declKeyword = toDeclKeyword(ctx.decl())
        val id = toIdExpr(ctx.ID())
        val type = ctx.type()?.let { visitFor<TypeExpr>(it) }
        val value = visitFor<Expr>(ctx.expr())

        return DeclStmt(startNode(ctx), isExport, declKeyword, id, type, value)
    }

    override fun visitAssgnStmt(ctx: AssgnStmtContext): ASTNode {
        val id = toIdExpr(ctx.ID())
        val value = visitFor<Expr>(ctx.expr())

        return AssignmentStmt(startNode(ctx), id, value)
    }

    override fun visitDestructingStmt(ctx: DestructingStmtContext): ASTNode {
        val isExport = ctx.EXPORT() != null
        val declKeyword = toDeclKeyword(ctx.decl())
        val destructuringList = ctx.destructuringList()
        val idList = destructuringList.ID().map { toIdExpr(it) }
        val value = visitFor<Expr>(ctx.expr())

        return DestructingStmt(
            startNode(ctx),
            isExport,
            declKeyword,
            idList,
            value
        )
    }

    override fun visitBreakStmt(ctx: BreakStmtContext): ASTNode {
        val condition = visitFor<Expr>(ctx.expr())
        return BreakStmt(startNode(ctx), condition)
    }

    override fun visitNativeStmt(ctx: NativeStmtContext): ASTNode {
        val id = toIdExpr(ctx.ID())
        val type = ctx.type()?.let { visitFor<TypeExpr>(it) }

        return NativeStmt(startNode(ctx), id, type)
    }

    override fun visitExpr(ctx: ExprContext): ASTNode = visit(ctx.pipeExpr())

    override fun visitIntLiteralExpr(ctx: IntLiteralExprContext): ASTNode =
        LiteralExpr(
            startNode(ctx),
            LiteralType.INT,
            ctx.INT_LITERAL().text
        )

    override fun visitFloatLiteralExpr(ctx: FloatLiteralExprContext): ASTNode =
        LiteralExpr(
            startNode(ctx),
            LiteralType.FLOAT,
            ctx.FLOAT_LITERAL().text
        )

    override fun visitBoolExpr(ctx: BoolExprContext): ASTNode {
        return LiteralExpr(
            startNode(ctx),
            LiteralType.BOOLEAN,
            ctx.text
        )
    }

    override fun visitStringLiteralExpr(ctx: StringLiteralExprContext): ASTNode =
        LiteralExpr(
            startNode(ctx),
            LiteralType.STRING,
            ctx.STRING_LITERAL().text
        )

    override fun visitIdExpr(ctx: IdExprContext): ASTNode =
        IdExpr(startNode(ctx), ctx.ID().text)

    override fun visitPipeExpr(ctx: PipeExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.logicOrExpr(),
            ctx.pipeOp()
        )

    override fun visitLogicOrExpr(ctx: LogicOrExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.logicAndExpr(),
            ctx.logicOrOp()
        )

    override fun visitLogicAndExpr(ctx: LogicAndExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.equalityExpr(),
            ctx.logicAndOp()
        )

    override fun visitEqualityExpr(ctx: EqualityExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.relationalExpr(),
            ctx.equalityOp()
        )

    override fun visitRelationalExpr(ctx: RelationalExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.additiveExpr(),
            ctx.relationalOp()
        )

    override fun visitAdditiveExpr(ctx: AdditiveExprContext): ASTNode =
        collapseBinaryOperation(
            startNode(ctx),
            ctx.multiplicativeExpr(),
            ctx.additiveOp()
        )

    override fun visitMultiplicativeExpr(
        ctx: MultiplicativeExprContext
    ): ASTNode = collapseBinaryOperation(
        startNode(ctx),
        ctx.unaryExpr(),
        ctx.multiplicativeOp()
    )

    override fun visitUnaryExpr(ctx: UnaryExprContext): ASTNode {
        return when {
            ctx.unaryExpr() != null -> {
                val operator = toUnaryOperator(ctx.unaryOp())
                val operand = visitFor<Expr>(ctx.unaryExpr())
                return UnaryExpr(startNode(ctx), operator, operand)
            }
            ctx.postfixExpr() != null -> visit(ctx.postfixExpr())
            else -> error("Unexpected unary expression: ${ctx.text}")
        }
    }

    override fun visitLambdaExpr(ctx: LambdaExprContext): ASTNode =
        visit(ctx.lambda())

    override fun visitLambda(ctx: LambdaContext): ASTNode {
        val isTrade = ctx.TRADE() != null
        val paramMap =
            ctx.paramList()?.param()?.associate { toParam(it) } ?: emptyMap()
        val stmtList = ctx.stmt().map { visitFor<Stmt>(it) }
        val expr = ctx.expr()?.let { visitFor<Expr>(it) }

        return LambdaExpr(startNode(ctx), isTrade, paramMap, stmtList, expr)
    }

    override fun visitYieldExpr(ctx: YieldExprContext): ASTNode {
        val initializer = visitFor<Expr>(ctx.expr(0))
        val isAlive = visitFor<Expr>(ctx.expr(1))
        val toYield = visitFor<Expr>(ctx.expr(2))
        val updater = visitFor<Expr>(ctx.expr(3))

        return YieldExpr(startNode(ctx), initializer, isAlive, toYield, updater)
    }

    override fun visitPostfixMemberAccess(ctx: PostfixMemberAccessContext?): ASTNode? {
        return super.visitPostfixMemberAccess(ctx)
    }

    override fun visitPostfixExpr(ctx: PostfixExprContext): ASTNode {
        val hasTrailingLambda = ctx.lambda() != null
        if (ctx.postfixPart().isEmpty() && !hasTrailingLambda) {
            return visit(ctx.primaryExpr())
        }

        val isPartial = ctx.AMPERSAND() != null
        val left = visitFor<Expr>(ctx.primaryExpr())
        val lastExpr = ctx.postfixPart().fold(left) { left, postfixPart ->
            val node = startNode(postfixPart)
            when (postfixPart) {
                is PostfixMemberAccessContext -> MemberExpr(
                    node, left, postfixPart.ID().text
                )
                is PostfixCallContext -> CallExpr(
                    node, isPartial, left, toArgList(postfixPart.argList())
                )
                else -> error("Unexpected postfix part: ${postfixPart.text}")
            }
        }

        if (!hasTrailingLambda) {
            return lastExpr
        }

        // Support trailing lambda
        val lambdaExpr = visitFor<Expr>(ctx.lambda())
        val node = startNode(ctx)
        return if (lastExpr is CallExpr) {
            CallExpr(
                node,
                isPartial,
                lastExpr.callee,
                lastExpr.argList + lambdaExpr
            )
        } else {
            CallExpr(node, isPartial, lastExpr, listOf(lambdaExpr))
        }
    }

    override fun visitEmptyListExpr(ctx: EmptyListExprContext): ASTNode {
        return ListExpr(startNode(ctx), mutableListOf())
    }

    override fun visitListExpr(ctx: ListExprContext): ASTNode {
        val exprList = ctx.listElementList().expr()
        return ListExpr(startNode(ctx), exprList.map { visitFor(it) })
    }

    override fun visitObjectExpr(ctx: ObjectExprContext): ASTNode {
        val idList = ctx.objectElementList().ID().map { toIdExpr(it) }
        val valueList =
            ctx.objectElementList().expr().map { visitFor<Expr>(it) }
        val fieldMap = idList.zip(valueList).toMap()

        return ObjectExpr(startNode(ctx), fieldMap)
    }

    override fun visitIfExpr(ctx: IfExprContext): ASTNode {
        val condition = visitFor<Expr>(ctx.expr(0))
        val thenBranch = visitFor<Expr>(ctx.expr(1))
        val elseBranch = ctx.expr(2)?.let { visitFor<Expr>(it) }

        return IfExpr(startNode(ctx), condition, thenBranch, elseBranch)
    }

    override fun visitLoopExpr(ctx: LoopExprContext): ASTNode =
        LoopExpr(startNode(ctx), visitFor(ctx.expr()))

    override fun visitType(ctx: TypeContext): ASTNode =
        TypeExpr(startNode(ctx), visitFor(ctx.ID()))

    override fun visitImportExpr(ctx: ImportExprContext): ASTNode {
        val targetPath = ctx.targetPath().text
        return ImportExpr(startNode(ctx), targetPath)
    }

    /**
     * Visits a parse tree and cast the return type into a specific type.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <D> visitFor(tree: ParseTree): D = visit(tree) as D

    /**
     * Extracts the line number and column number from a given token and returns
     * an AST node.
     */
    private fun tokenToNode(token: Token): ASTNode {
        val line = token.line
        val column = token.charPositionInLine

        return object : ASTNode(filepath, line, column) {}
    }

    private fun startNode(ctx: ParserRuleContext): ASTNode =
        tokenToNode(ctx.getStart())

    private fun toIdExpr(ctx: TerminalNode): IdExpr =
        IdExpr(tokenToNode(ctx.symbol), ctx.text)

    private fun toDeclKeyword(ctx: DeclContext): DeclKeyword {
        if (ctx.LET() != null) return DeclKeyword.LET
        if (ctx.VAL() != null) return DeclKeyword.VAL

        throw IllegalStateException("Unexpected token ${ctx.text}")
    }

    private fun collapseBinaryOperation(
        startNode: ASTNode,
        exprCtxList: List<ParserRuleContext>,
        operatorCtxList: List<ParserRuleContext>
    ): ASTNode {
        val operatorList = operatorCtxList.map { toBinaryOperator(it) }
        return exprCtxList
            .map { visitFor<Expr>(it) }
            .reduceIndexed { index, left, right ->
                BinaryExpr(startNode, operatorList[index - 1], left, right)
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
}

