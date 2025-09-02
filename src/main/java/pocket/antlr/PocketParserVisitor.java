// Generated from PocketParser.g4 by ANTLR 4.13.2
package pocket.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PocketParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PocketParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PocketParser#moduleFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleFn(PocketParser.ModuleFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#pipeOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeOp(PocketParser.PipeOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#logicOrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrOp(PocketParser.LogicOrOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#logicAndOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndOp(PocketParser.LogicAndOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#equalityOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOp(PocketParser.EqualityOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOp(PocketParser.RelationalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#additiveOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOp(PocketParser.AdditiveOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#multiplicativeOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOp(PocketParser.MultiplicativeOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(PocketParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(PocketParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#destructuringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestructuringList(PocketParser.DestructuringListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(PocketParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStmt(PocketParser.DeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DestructingStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestructingStmt(PocketParser.DestructingStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssgnStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssgnStmt(PocketParser.AssgnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(PocketParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NativeStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeStmt(PocketParser.NativeStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclStmt(PocketParser.TypeDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PocketParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#pipeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeExpr(PocketParser.PipeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#logicOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrExpr(PocketParser.LogicOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#logicAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndExpr(PocketParser.LogicAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(PocketParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(PocketParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(PocketParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(PocketParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(PocketParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#tupleItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleItemList(PocketParser.TupleItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#listItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemList(PocketParser.ListItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#objectItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectItemList(PocketParser.ObjectItemListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteralExpr(PocketParser.IntLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteralExpr(PocketParser.FloatLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(PocketParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpr(PocketParser.StringLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(PocketParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(PocketParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpr(PocketParser.ObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleExpr(PocketParser.TupleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(PocketParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(PocketParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopExpr(PocketParser.LoopExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yieldExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldExpr(PocketParser.YieldExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportExpr(PocketParser.ImportExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(PocketParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(PocketParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixMemberAccess}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixMemberAccess(PocketParser.PostfixMemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixCall}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixCall(PocketParser.PostfixCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(PocketParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PocketParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(PocketParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(PocketParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#targetPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetPath(PocketParser.TargetPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTypeExpr(PocketParser.IdTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneTypeExpr(PocketParser.NoneTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaTypeExpr(PocketParser.LambdaTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tupleTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeExpr(PocketParser.TupleTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTypeExpr(PocketParser.ListTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTypeExpr(PocketParser.ObjectTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(PocketParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PocketParser#objectTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTypeList(PocketParser.ObjectTypeListContext ctx);
}