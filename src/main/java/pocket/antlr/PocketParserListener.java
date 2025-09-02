// Generated from PocketParser.g4 by ANTLR 4.13.2
package pocket.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PocketParser}.
 */
public interface PocketParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PocketParser#moduleFn}.
	 * @param ctx the parse tree
	 */
	void enterModuleFn(PocketParser.ModuleFnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#moduleFn}.
	 * @param ctx the parse tree
	 */
	void exitModuleFn(PocketParser.ModuleFnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#pipeOp}.
	 * @param ctx the parse tree
	 */
	void enterPipeOp(PocketParser.PipeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#pipeOp}.
	 * @param ctx the parse tree
	 */
	void exitPipeOp(PocketParser.PipeOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#logicOrOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrOp(PocketParser.LogicOrOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#logicOrOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrOp(PocketParser.LogicOrOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#logicAndOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndOp(PocketParser.LogicAndOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#logicAndOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndOp(PocketParser.LogicAndOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOp(PocketParser.EqualityOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOp(PocketParser.EqualityOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(PocketParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(PocketParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#additiveOp}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOp(PocketParser.AdditiveOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#additiveOp}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOp(PocketParser.AdditiveOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#multiplicativeOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOp(PocketParser.MultiplicativeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#multiplicativeOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOp(PocketParser.MultiplicativeOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(PocketParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(PocketParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(PocketParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(PocketParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#destructuringList}.
	 * @param ctx the parse tree
	 */
	void enterDestructuringList(PocketParser.DestructuringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#destructuringList}.
	 * @param ctx the parse tree
	 */
	void exitDestructuringList(PocketParser.DestructuringListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(PocketParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(PocketParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclStmt(PocketParser.DeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclStmt(PocketParser.DeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DestructingStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDestructingStmt(PocketParser.DestructingStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DestructingStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDestructingStmt(PocketParser.DestructingStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssgnStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssgnStmt(PocketParser.AssgnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssgnStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssgnStmt(PocketParser.AssgnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(PocketParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(PocketParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NativeStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterNativeStmt(PocketParser.NativeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NativeStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitNativeStmt(PocketParser.NativeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclStmt(PocketParser.TypeDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDeclStmt}
	 * labeled alternative in {@link PocketParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclStmt(PocketParser.TypeDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PocketParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PocketParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#pipeExpr}.
	 * @param ctx the parse tree
	 */
	void enterPipeExpr(PocketParser.PipeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#pipeExpr}.
	 * @param ctx the parse tree
	 */
	void exitPipeExpr(PocketParser.PipeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#logicOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpr(PocketParser.LogicOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#logicOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpr(PocketParser.LogicOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExpr(PocketParser.LogicAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExpr(PocketParser.LogicAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(PocketParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(PocketParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(PocketParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(PocketParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(PocketParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(PocketParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(PocketParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(PocketParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(PocketParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(PocketParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#tupleItemList}.
	 * @param ctx the parse tree
	 */
	void enterTupleItemList(PocketParser.TupleItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#tupleItemList}.
	 * @param ctx the parse tree
	 */
	void exitTupleItemList(PocketParser.TupleItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#listItemList}.
	 * @param ctx the parse tree
	 */
	void enterListItemList(PocketParser.ListItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#listItemList}.
	 * @param ctx the parse tree
	 */
	void exitListItemList(PocketParser.ListItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#objectItemList}.
	 * @param ctx the parse tree
	 */
	void enterObjectItemList(PocketParser.ObjectItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#objectItemList}.
	 * @param ctx the parse tree
	 */
	void exitObjectItemList(PocketParser.ObjectItemListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteralExpr(PocketParser.IntLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteralExpr(PocketParser.IntLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteralExpr(PocketParser.FloatLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteralExpr(PocketParser.FloatLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(PocketParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(PocketParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpr(PocketParser.StringLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteralExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpr(PocketParser.StringLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(PocketParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(PocketParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(PocketParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(PocketParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpr(PocketParser.ObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpr(PocketParser.ObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTupleExpr(PocketParser.TupleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTupleExpr(PocketParser.TupleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(PocketParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(PocketParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(PocketParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(PocketParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpr(PocketParser.LoopExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpr(PocketParser.LoopExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yieldExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterYieldExpr(PocketParser.YieldExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yieldExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitYieldExpr(PocketParser.YieldExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterImportExpr(PocketParser.ImportExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitImportExpr(PocketParser.ImportExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(PocketParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link PocketParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(PocketParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(PocketParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(PocketParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixMemberAccess}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 */
	void enterPostfixMemberAccess(PocketParser.PostfixMemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixMemberAccess}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 */
	void exitPostfixMemberAccess(PocketParser.PostfixMemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixCall}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCall(PocketParser.PostfixCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixCall}
	 * labeled alternative in {@link PocketParser#postfixPart}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCall(PocketParser.PostfixCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(PocketParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(PocketParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PocketParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PocketParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(PocketParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(PocketParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(PocketParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(PocketParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#targetPath}.
	 * @param ctx the parse tree
	 */
	void enterTargetPath(PocketParser.TargetPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#targetPath}.
	 * @param ctx the parse tree
	 */
	void exitTargetPath(PocketParser.TargetPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIdTypeExpr(PocketParser.IdTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIdTypeExpr(PocketParser.IdTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNoneTypeExpr(PocketParser.NoneTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNoneTypeExpr(PocketParser.NoneTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterLambdaTypeExpr(PocketParser.LambdaTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitLambdaTypeExpr(PocketParser.LambdaTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTupleTypeExpr(PocketParser.TupleTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTupleTypeExpr(PocketParser.TupleTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterListTypeExpr(PocketParser.ListTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitListTypeExpr(PocketParser.ListTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void enterObjectTypeExpr(PocketParser.ObjectTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectTypeExpr}
	 * labeled alternative in {@link PocketParser#type}.
	 * @param ctx the parse tree
	 */
	void exitObjectTypeExpr(PocketParser.ObjectTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(PocketParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(PocketParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PocketParser#objectTypeList}.
	 * @param ctx the parse tree
	 */
	void enterObjectTypeList(PocketParser.ObjectTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PocketParser#objectTypeList}.
	 * @param ctx the parse tree
	 */
	void exitObjectTypeList(PocketParser.ObjectTypeListContext ctx);
}