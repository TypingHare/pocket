// Generated from PocketParser.g4 by ANTLR 4.13.2
package pocket.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PocketParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_PAREN=1, RIGHT_PAREN=2, LEFT_BRACKET=3, RIGHT_BRACKET=4, LEFT_BRACE=5, 
		RIGHT_BRACE=6, COLON=7, COMMA=8, SEMICOLON=9, EQUALS=10, ARROW=11, FAT_ARROW=12, 
		PLUS=13, MINUS=14, ASTERISK=15, SLASH=16, PERCENT=17, NOT=18, AND=19, 
		OR=20, CARET=21, TILDE=22, AMPERSAND=23, BAR=24, EQUAL_EQUALS=25, NOT_EQUALS=26, 
		LESS_THAN=27, LESS_THAN_EQUALS=28, GREATER_THAN=29, GREATER_THAN_EQUALS=30, 
		DOT=31, VAL=32, LET=33, IF=34, ELSE=35, LOOP=36, TRADE=37, IMPORT=38, 
		EXPORT=39, BREAK=40, YIELD=41, NATIVE=42, LIST=43, OBJECT=44, TYPE=45, 
		NONE=46, TRUE=47, FALSE=48, INT_LITERAL=49, FLOAT_LITERAL=50, STRING_LITERAL=51, 
		ID=52, WHITE_SPACE=53, LINE_COMMENT=54, BLOCK_COMMENT=55;
	public static final int
		RULE_moduleFn = 0, RULE_pipeOp = 1, RULE_logicOrOp = 2, RULE_logicAndOp = 3, 
		RULE_equalityOp = 4, RULE_relationalOp = 5, RULE_additiveOp = 6, RULE_multiplicativeOp = 7, 
		RULE_unaryOp = 8, RULE_decl = 9, RULE_destructuringList = 10, RULE_stmt = 11, 
		RULE_expr = 12, RULE_pipeExpr = 13, RULE_logicOrExpr = 14, RULE_logicAndExpr = 15, 
		RULE_equalityExpr = 16, RULE_relationalExpr = 17, RULE_additiveExpr = 18, 
		RULE_multiplicativeExpr = 19, RULE_unaryExpr = 20, RULE_tupleItemList = 21, 
		RULE_listItemList = 22, RULE_objectItemList = 23, RULE_primaryExpr = 24, 
		RULE_postfixExpr = 25, RULE_postfixPart = 26, RULE_argList = 27, RULE_param = 28, 
		RULE_paramList = 29, RULE_lambda = 30, RULE_targetPath = 31, RULE_type = 32, 
		RULE_typeList = 33, RULE_objectTypeList = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"moduleFn", "pipeOp", "logicOrOp", "logicAndOp", "equalityOp", "relationalOp", 
			"additiveOp", "multiplicativeOp", "unaryOp", "decl", "destructuringList", 
			"stmt", "expr", "pipeExpr", "logicOrExpr", "logicAndExpr", "equalityExpr", 
			"relationalExpr", "additiveExpr", "multiplicativeExpr", "unaryExpr", 
			"tupleItemList", "listItemList", "objectItemList", "primaryExpr", "postfixExpr", 
			"postfixPart", "argList", "param", "paramList", "lambda", "targetPath", 
			"type", "typeList", "objectTypeList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", "','", "';'", 
			"'='", "'->'", "'=>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&&'", 
			"'||'", "'^'", "'~'", "'&'", "'|'", "'=='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", "'.'", "'val'", "'let'", "'if'", "'else'", "'loop'", "'trade'", 
			"'import'", "'export'", "'break'", "'yield'", "'native'", "'list'", "'object'", 
			"'type'", "'None'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", 
			"RIGHT_BRACE", "COLON", "COMMA", "SEMICOLON", "EQUALS", "ARROW", "FAT_ARROW", 
			"PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "NOT", "AND", "OR", 
			"CARET", "TILDE", "AMPERSAND", "BAR", "EQUAL_EQUALS", "NOT_EQUALS", "LESS_THAN", 
			"LESS_THAN_EQUALS", "GREATER_THAN", "GREATER_THAN_EQUALS", "DOT", "VAL", 
			"LET", "IF", "ELSE", "LOOP", "TRADE", "IMPORT", "EXPORT", "BREAK", "YIELD", 
			"NATIVE", "LIST", "OBJECT", "TYPE", "NONE", "TRUE", "FALSE", "INT_LITERAL", 
			"FLOAT_LITERAL", "STRING_LITERAL", "ID", "WHITE_SPACE", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PocketParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PocketParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleFnContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PocketParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ModuleFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterModuleFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitModuleFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitModuleFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleFnContext moduleFn() throws RecognitionException {
		ModuleFnContext _localctx = new ModuleFnContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_moduleFn);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					stmt();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8895547293581354L) != 0)) {
				{
				setState(76);
				expr();
				}
			}

			setState(79);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PipeOpContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(PocketParser.ARROW, 0); }
		public PipeOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterPipeOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitPipeOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitPipeOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeOpContext pipeOp() throws RecognitionException {
		PipeOpContext _localctx = new PipeOpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pipeOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ARROW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOrOpContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(PocketParser.OR, 0); }
		public LogicOrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLogicOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLogicOrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLogicOrOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicOrOpContext logicOrOp() throws RecognitionException {
		LogicOrOpContext _localctx = new LogicOrOpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_logicOrOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(OR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(PocketParser.AND, 0); }
		public LogicAndOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLogicAndOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLogicAndOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLogicAndOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicAndOpContext logicAndOp() throws RecognitionException {
		LogicAndOpContext _localctx = new LogicAndOpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logicAndOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(AND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityOpContext extends ParserRuleContext {
		public TerminalNode EQUAL_EQUALS() { return getToken(PocketParser.EQUAL_EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(PocketParser.NOT_EQUALS, 0); }
		public EqualityOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterEqualityOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitEqualityOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitEqualityOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityOpContext equalityOp() throws RecognitionException {
		EqualityOpContext _localctx = new EqualityOpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_equalityOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==EQUAL_EQUALS || _la==NOT_EQUALS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalOpContext extends ParserRuleContext {
		public TerminalNode LESS_THAN() { return getToken(PocketParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(PocketParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN_EQUALS() { return getToken(PocketParser.LESS_THAN_EQUALS, 0); }
		public TerminalNode GREATER_THAN_EQUALS() { return getToken(PocketParser.GREATER_THAN_EQUALS, 0); }
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterRelationalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitRelationalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitRelationalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_relationalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2013265920L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PocketParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PocketParser.MINUS, 0); }
		public AdditiveOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterAdditiveOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitAdditiveOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitAdditiveOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveOpContext additiveOp() throws RecognitionException {
		AdditiveOpContext _localctx = new AdditiveOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_additiveOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeOpContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(PocketParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(PocketParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(PocketParser.PERCENT, 0); }
		public MultiplicativeOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterMultiplicativeOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitMultiplicativeOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitMultiplicativeOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeOpContext multiplicativeOp() throws RecognitionException {
		MultiplicativeOpContext _localctx = new MultiplicativeOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiplicativeOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PocketParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(PocketParser.MINUS, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(PocketParser.VAL, 0); }
		public TerminalNode LET() { return getToken(PocketParser.LET, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==VAL || _la==LET) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestructuringListContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> ID() { return getTokens(PocketParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PocketParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public DestructuringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructuringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterDestructuringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitDestructuringList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitDestructuringList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestructuringListContext destructuringList() throws RecognitionException {
		DestructuringListContext _localctx = new DestructuringListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_destructuringList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(LEFT_BRACKET);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(100);
				match(ID);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(101);
					match(COMMA);
					setState(102);
					match(ID);
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(110);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DestructingStmtContext extends StmtContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public DestructuringListContext destructuringList() {
			return getRuleContext(DestructuringListContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(PocketParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public TerminalNode EXPORT() { return getToken(PocketParser.EXPORT, 0); }
		public DestructingStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterDestructingStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitDestructingStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitDestructingStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public TerminalNode BREAK() { return getToken(PocketParser.BREAK, 0); }
		public TerminalNode IF() { return getToken(PocketParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NativeStmtContext extends StmtContext {
		public TerminalNode NATIVE() { return getToken(PocketParser.NATIVE, 0); }
		public TerminalNode VAL() { return getToken(PocketParser.VAL, 0); }
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(PocketParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NativeStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterNativeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitNativeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitNativeStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclStmtContext extends StmtContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PocketParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public TerminalNode EXPORT() { return getToken(PocketParser.EXPORT, 0); }
		public TerminalNode COLON() { return getToken(PocketParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterDeclStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitDeclStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssgnStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PocketParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public AssgnStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterAssgnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitAssgnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitAssgnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclStmtContext extends StmtContext {
		public TerminalNode TYPE() { return getToken(PocketParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PocketParser.EQUALS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PocketParser.SEMICOLON, 0); }
		public TypeDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTypeDeclStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTypeDeclStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTypeDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		int _la;
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				expr();
				setState(113);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new DeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(115);
					match(EXPORT);
					}
				}

				setState(118);
				decl();
				setState(119);
				match(ID);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(120);
					match(COLON);
					setState(121);
					type();
					}
				}

				setState(124);
				match(EQUALS);
				setState(125);
				expr();
				setState(126);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new DestructingStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(128);
					match(EXPORT);
					}
				}

				setState(131);
				decl();
				setState(132);
				destructuringList();
				setState(133);
				match(EQUALS);
				setState(134);
				expr();
				setState(135);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new AssgnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				match(ID);
				setState(138);
				match(EQUALS);
				setState(139);
				expr();
				setState(140);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				match(BREAK);
				setState(143);
				match(IF);
				setState(144);
				expr();
				setState(145);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new NativeStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				match(NATIVE);
				setState(148);
				match(VAL);
				setState(149);
				match(ID);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(150);
					match(COLON);
					setState(151);
					type();
					}
				}

				setState(154);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new TypeDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(155);
				match(TYPE);
				setState(156);
				match(ID);
				setState(157);
				match(EQUALS);
				setState(158);
				type();
				setState(159);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public PipeExprContext pipeExpr() {
			return getRuleContext(PipeExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			pipeExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PipeExprContext extends ParserRuleContext {
		public List<LogicOrExprContext> logicOrExpr() {
			return getRuleContexts(LogicOrExprContext.class);
		}
		public LogicOrExprContext logicOrExpr(int i) {
			return getRuleContext(LogicOrExprContext.class,i);
		}
		public List<PipeOpContext> pipeOp() {
			return getRuleContexts(PipeOpContext.class);
		}
		public PipeOpContext pipeOp(int i) {
			return getRuleContext(PipeOpContext.class,i);
		}
		public PipeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterPipeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitPipeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitPipeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeExprContext pipeExpr() throws RecognitionException {
		PipeExprContext _localctx = new PipeExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pipeExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			logicOrExpr();
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					pipeOp();
					setState(167);
					logicOrExpr();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOrExprContext extends ParserRuleContext {
		public List<LogicAndExprContext> logicAndExpr() {
			return getRuleContexts(LogicAndExprContext.class);
		}
		public LogicAndExprContext logicAndExpr(int i) {
			return getRuleContext(LogicAndExprContext.class,i);
		}
		public List<LogicOrOpContext> logicOrOp() {
			return getRuleContexts(LogicOrOpContext.class);
		}
		public LogicOrOpContext logicOrOp(int i) {
			return getRuleContext(LogicOrOpContext.class,i);
		}
		public LogicOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLogicOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLogicOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLogicOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicOrExprContext logicOrExpr() throws RecognitionException {
		LogicOrExprContext _localctx = new LogicOrExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicOrExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			logicAndExpr();
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					logicOrOp();
					setState(176);
					logicAndExpr();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public List<LogicAndOpContext> logicAndOp() {
			return getRuleContexts(LogicAndOpContext.class);
		}
		public LogicAndOpContext logicAndOp(int i) {
			return getRuleContext(LogicAndOpContext.class,i);
		}
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLogicAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLogicAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLogicAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logicAndExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			equalityExpr();
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184);
					logicAndOp();
					setState(185);
					equalityExpr();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public List<EqualityOpContext> equalityOp() {
			return getRuleContexts(EqualityOpContext.class);
		}
		public EqualityOpContext equalityOp(int i) {
			return getRuleContext(EqualityOpContext.class,i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_equalityExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			relationalExpr();
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					equalityOp();
					setState(194);
					relationalExpr();
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public List<AdditiveExprContext> additiveExpr() {
			return getRuleContexts(AdditiveExprContext.class);
		}
		public AdditiveExprContext additiveExpr(int i) {
			return getRuleContext(AdditiveExprContext.class,i);
		}
		public List<RelationalOpContext> relationalOp() {
			return getRuleContexts(RelationalOpContext.class);
		}
		public RelationalOpContext relationalOp(int i) {
			return getRuleContext(RelationalOpContext.class,i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_relationalExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			additiveExpr();
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(202);
					relationalOp();
					setState(203);
					additiveExpr();
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MultiplicativeExprContext> multiplicativeExpr() {
			return getRuleContexts(MultiplicativeExprContext.class);
		}
		public MultiplicativeExprContext multiplicativeExpr(int i) {
			return getRuleContext(MultiplicativeExprContext.class,i);
		}
		public List<AdditiveOpContext> additiveOp() {
			return getRuleContexts(AdditiveOpContext.class);
		}
		public AdditiveOpContext additiveOp(int i) {
			return getRuleContext(AdditiveOpContext.class,i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_additiveExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			multiplicativeExpr();
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(211);
					additiveOp();
					setState(212);
					multiplicativeExpr();
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<MultiplicativeOpContext> multiplicativeOp() {
			return getRuleContexts(MultiplicativeOpContext.class);
		}
		public MultiplicativeOpContext multiplicativeOp(int i) {
			return getRuleContext(MultiplicativeOpContext.class,i);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitMultiplicativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitMultiplicativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multiplicativeExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			unaryExpr();
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220);
					multiplicativeOp();
					setState(221);
					unaryExpr();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryExpr);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				unaryOp();
				setState(229);
				unaryExpr();
				}
				break;
			case LEFT_PAREN:
			case LEFT_BRACKET:
			case LEFT_BRACE:
			case AMPERSAND:
			case IF:
			case LOOP:
			case TRADE:
			case IMPORT:
			case YIELD:
			case LIST:
			case OBJECT:
			case TRUE:
			case FALSE:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				postfixExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleItemListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public TupleItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTupleItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTupleItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTupleItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleItemListContext tupleItemList() throws RecognitionException {
		TupleItemListContext _localctx = new TupleItemListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tupleItemList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			expr();
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					match(COMMA);
					setState(236);
					expr();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(242);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListItemListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public ListItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterListItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitListItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitListItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListItemListContext listItemList() throws RecognitionException {
		ListItemListContext _localctx = new ListItemListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_listItemList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expr();
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(246);
					match(COMMA);
					setState(247);
					expr();
					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(253);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectItemListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PocketParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PocketParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PocketParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PocketParser.COLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public ObjectItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterObjectItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitObjectItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitObjectItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectItemListContext objectItemList() throws RecognitionException {
		ObjectItemListContext _localctx = new ObjectItemListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_objectItemList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			setState(257);
			match(COLON);
			setState(258);
			expr();
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(259);
					match(COMMA);
					setState(260);
					match(ID);
					setState(261);
					match(COLON);
					setState(262);
					expr();
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(268);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralExprContext extends PrimaryExprContext {
		public TerminalNode STRING_LITERAL() { return getToken(PocketParser.STRING_LITERAL, 0); }
		public StringLiteralExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterStringLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitStringLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitStringLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectExprContext extends PrimaryExprContext {
		public TerminalNode OBJECT() { return getToken(PocketParser.OBJECT, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public ObjectItemListContext objectItemList() {
			return getRuleContext(ObjectItemListContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public ObjectExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterObjectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitObjectExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitObjectExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends PrimaryExprContext {
		public TerminalNode LEFT_PAREN() { return getToken(PocketParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PocketParser.RIGHT_PAREN, 0); }
		public ParenExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopExprContext extends PrimaryExprContext {
		public TerminalNode LOOP() { return getToken(PocketParser.LOOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LoopExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLoopExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLoopExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLoopExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralExprContext extends PrimaryExprContext {
		public TerminalNode FLOAT_LITERAL() { return getToken(PocketParser.FLOAT_LITERAL, 0); }
		public FloatLiteralExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterFloatLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitFloatLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitFloatLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class YieldExprContext extends PrimaryExprContext {
		public TerminalNode YIELD() { return getToken(PocketParser.YIELD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public YieldExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterYieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitYieldExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitYieldExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralExprContext extends PrimaryExprContext {
		public TerminalNode INT_LITERAL() { return getToken(PocketParser.INT_LITERAL, 0); }
		public IntLiteralExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterIntLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitIntLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitIntLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExprContext extends PrimaryExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends PrimaryExprContext {
		public TerminalNode IF() { return getToken(PocketParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(PocketParser.LEFT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PocketParser.RIGHT_PAREN, 0); }
		public TerminalNode ELSE() { return getToken(PocketParser.ELSE, 0); }
		public IfExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends PrimaryExprContext {
		public TerminalNode TRUE() { return getToken(PocketParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PocketParser.FALSE, 0); }
		public BoolExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleExprContext extends PrimaryExprContext {
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public TupleItemListContext tupleItemList() {
			return getRuleContext(TupleItemListContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public TupleExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTupleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTupleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTupleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportExprContext extends PrimaryExprContext {
		public TerminalNode IMPORT() { return getToken(PocketParser.IMPORT, 0); }
		public TerminalNode LESS_THAN() { return getToken(PocketParser.LESS_THAN, 0); }
		public TargetPathContext targetPath() {
			return getRuleContext(TargetPathContext.class,0);
		}
		public TerminalNode GREATER_THAN() { return getToken(PocketParser.GREATER_THAN, 0); }
		public ImportExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterImportExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitImportExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitImportExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends PrimaryExprContext {
		public TerminalNode LIST() { return getToken(PocketParser.LIST, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public ListItemListContext listItemList() {
			return getRuleContext(ListItemListContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public ListExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterListExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitListExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends PrimaryExprContext {
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public IdExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primaryExpr);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_LITERAL:
				_localctx = new IntLiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(INT_LITERAL);
				}
				break;
			case FLOAT_LITERAL:
				_localctx = new FloatLiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(FLOAT_LITERAL);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING_LITERAL:
				_localctx = new StringLiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				match(STRING_LITERAL);
				}
				break;
			case ID:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(275);
				match(ID);
				}
				break;
			case LIST:
				_localctx = new ListExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(276);
				match(LIST);
				setState(277);
				match(LEFT_BRACKET);
				setState(278);
				listItemList();
				setState(279);
				match(RIGHT_BRACKET);
				}
				break;
			case OBJECT:
				_localctx = new ObjectExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(281);
				match(OBJECT);
				setState(282);
				match(LEFT_BRACKET);
				setState(283);
				objectItemList();
				setState(284);
				match(RIGHT_BRACKET);
				}
				break;
			case LEFT_BRACKET:
				_localctx = new TupleExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(286);
				match(LEFT_BRACKET);
				setState(287);
				tupleItemList();
				setState(288);
				match(RIGHT_BRACKET);
				}
				break;
			case LEFT_BRACE:
			case TRADE:
				_localctx = new LambdaExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(290);
				lambda();
				}
				break;
			case IF:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(291);
				match(IF);
				setState(292);
				match(LEFT_PAREN);
				setState(293);
				expr();
				setState(294);
				match(RIGHT_PAREN);
				setState(295);
				expr();
				setState(298);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(296);
					match(ELSE);
					setState(297);
					expr();
					}
					break;
				}
				}
				break;
			case LOOP:
				_localctx = new LoopExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(300);
				match(LOOP);
				setState(301);
				expr();
				}
				break;
			case YIELD:
				_localctx = new YieldExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(302);
				match(YIELD);
				setState(303);
				expr();
				setState(304);
				expr();
				setState(305);
				expr();
				setState(306);
				expr();
				}
				break;
			case IMPORT:
				_localctx = new ImportExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(308);
				match(IMPORT);
				setState(309);
				match(LESS_THAN);
				setState(310);
				targetPath();
				setState(311);
				match(GREATER_THAN);
				}
				break;
			case LEFT_PAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(313);
				match(LEFT_PAREN);
				setState(314);
				expr();
				setState(315);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExprContext extends ParserRuleContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode AMPERSAND() { return getToken(PocketParser.AMPERSAND, 0); }
		public List<PostfixPartContext> postfixPart() {
			return getRuleContexts(PostfixPartContext.class);
		}
		public PostfixPartContext postfixPart(int i) {
			return getRuleContext(PostfixPartContext.class,i);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitPostfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitPostfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_postfixExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AMPERSAND) {
				{
				setState(319);
				match(AMPERSAND);
				}
			}

			setState(322);
			primaryExpr();
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(323);
					postfixPart();
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(329);
				lambda();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixPartContext extends ParserRuleContext {
		public PostfixPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixPart; }
	 
		public PostfixPartContext() { }
		public void copyFrom(PostfixPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixCallContext extends PostfixPartContext {
		public TerminalNode LEFT_PAREN() { return getToken(PocketParser.LEFT_PAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PocketParser.RIGHT_PAREN, 0); }
		public PostfixCallContext(PostfixPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterPostfixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitPostfixCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitPostfixCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixMemberAccessContext extends PostfixPartContext {
		public TerminalNode DOT() { return getToken(PocketParser.DOT, 0); }
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public PostfixMemberAccessContext(PostfixPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterPostfixMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitPostfixMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitPostfixMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixPartContext postfixPart() throws RecognitionException {
		PostfixPartContext _localctx = new PostfixPartContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_postfixPart);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new PostfixMemberAccessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(DOT);
				setState(333);
				match(ID);
				}
				break;
			case LEFT_PAREN:
				_localctx = new PostfixCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(LEFT_PAREN);
				setState(335);
				argList();
				setState(336);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			expr();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(341);
				match(COMMA);
				setState(342);
				expr();
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PocketParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(ID);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(349);
				match(COLON);
				setState(350);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			param();
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(354);
				match(COMMA);
				setState(355);
				param();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(PocketParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(PocketParser.RIGHT_BRACE, 0); }
		public TerminalNode TRADE() { return getToken(PocketParser.TRADE, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode FAT_ARROW() { return getToken(PocketParser.FAT_ARROW, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRADE) {
				{
				setState(361);
				match(TRADE);
				}
			}

			setState(364);
			match(LEFT_BRACE);
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(365);
				paramList();
				setState(366);
				match(FAT_ARROW);
				}
				break;
			}
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(370);
					stmt();
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8895547293581354L) != 0)) {
				{
				setState(376);
				expr();
				}
			}

			setState(379);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetPathContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PocketParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PocketParser.ID, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(PocketParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(PocketParser.SLASH, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PocketParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PocketParser.DOT, i);
		}
		public TargetPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTargetPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTargetPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTargetPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetPathContext targetPath() throws RecognitionException {
		TargetPathContext _localctx = new TargetPathContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_targetPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(ID);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH || _la==DOT) {
				{
				{
				setState(382);
				_la = _input.LA(1);
				if ( !(_la==SLASH || _la==DOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				match(ID);
				}
				}
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdTypeExprContext extends TypeContext {
		public TerminalNode ID() { return getToken(PocketParser.ID, 0); }
		public IdTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterIdTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitIdTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitIdTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectTypeExprContext extends TypeContext {
		public TerminalNode OBJECT() { return getToken(PocketParser.OBJECT, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public ObjectTypeListContext objectTypeList() {
			return getRuleContext(ObjectTypeListContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public ObjectTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterObjectTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitObjectTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitObjectTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneTypeExprContext extends TypeContext {
		public TerminalNode NONE() { return getToken(PocketParser.NONE, 0); }
		public NoneTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterNoneTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitNoneTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitNoneTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeExprContext extends TypeContext {
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public TupleTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTupleTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTupleTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTupleTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaTypeExprContext extends TypeContext {
		public TerminalNode LEFT_BRACE() { return getToken(PocketParser.LEFT_BRACE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(PocketParser.RIGHT_BRACE, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode FAT_ARROW() { return getToken(PocketParser.FAT_ARROW, 0); }
		public LambdaTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterLambdaTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitLambdaTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitLambdaTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListTypeExprContext extends TypeContext {
		public TerminalNode LIST() { return getToken(PocketParser.LIST, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(PocketParser.LEFT_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(PocketParser.RIGHT_BRACKET, 0); }
		public ListTypeExprContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterListTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitListTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitListTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(ID);
				}
				break;
			case NONE:
				_localctx = new NoneTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				match(NONE);
				}
				break;
			case LEFT_BRACE:
				_localctx = new LambdaTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
				match(LEFT_BRACE);
				setState(395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(392);
					typeList();
					setState(393);
					match(FAT_ARROW);
					}
					break;
				}
				setState(397);
				type();
				setState(398);
				match(RIGHT_BRACE);
				}
				break;
			case LEFT_BRACKET:
				_localctx = new TupleTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(400);
				match(LEFT_BRACKET);
				setState(401);
				typeList();
				setState(402);
				match(RIGHT_BRACKET);
				}
				break;
			case LIST:
				_localctx = new ListTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				match(LIST);
				setState(405);
				match(LEFT_BRACKET);
				setState(406);
				type();
				setState(407);
				match(RIGHT_BRACKET);
				}
				break;
			case OBJECT:
				_localctx = new ObjectTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(409);
				match(OBJECT);
				setState(410);
				match(LEFT_BRACKET);
				setState(411);
				objectTypeList();
				setState(412);
				match(RIGHT_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			type();
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(417);
				match(COMMA);
				setState(418);
				type();
				}
				}
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectTypeListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PocketParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PocketParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PocketParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PocketParser.COLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PocketParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PocketParser.COMMA, i);
		}
		public ObjectTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).enterObjectTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PocketParserListener ) ((PocketParserListener)listener).exitObjectTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PocketParserVisitor ) return ((PocketParserVisitor<? extends T>)visitor).visitObjectTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectTypeListContext objectTypeList() throws RecognitionException {
		ObjectTypeListContext _localctx = new ObjectTypeListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_objectTypeList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(ID);
			setState(425);
			match(COLON);
			setState(426);
			type();
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(427);
					match(COMMA);
					setState(428);
					match(ID);
					setState(429);
					match(COLON);
					setState(430);
					type();
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(436);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u01b8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0005\u0000H\b\u0000\n\u0000\f\u0000K\t\u0000\u0001\u0000\u0003"+
		"\u0000N\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\nh\b"+
		"\n\n\n\f\nk\t\n\u0003\nm\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000bu\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b{\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0082\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0099\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a2"+
		"\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00aa"+
		"\b\r\n\r\f\r\u00ad\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00b3\b\u000e\n\u000e\f\u000e\u00b6\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00bc\b\u000f\n\u000f\f\u000f"+
		"\u00bf\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00c5\b\u0010\n\u0010\f\u0010\u00c8\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00ce\b\u0011\n\u0011\f\u0011\u00d1\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00d7\b\u0012"+
		"\n\u0012\f\u0012\u00da\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00e0\b\u0013\n\u0013\f\u0013\u00e3\t\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00e9\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u00ee\b\u0015\n\u0015\f\u0015\u00f1"+
		"\t\u0015\u0001\u0015\u0003\u0015\u00f4\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u00f9\b\u0016\n\u0016\f\u0016\u00fc\t\u0016\u0001"+
		"\u0016\u0003\u0016\u00ff\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0108\b\u0017\n"+
		"\u0017\f\u0017\u010b\t\u0017\u0001\u0017\u0003\u0017\u010e\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u012b\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u013e\b\u0018\u0001"+
		"\u0019\u0003\u0019\u0141\b\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0145"+
		"\b\u0019\n\u0019\f\u0019\u0148\t\u0019\u0001\u0019\u0003\u0019\u014b\b"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0153\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u0158\b\u001b\n\u001b\f\u001b\u015b\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0160\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0005\u001d\u0165\b\u001d\n\u001d\f\u001d\u0168\t\u001d\u0001\u001e\u0003"+
		"\u001e\u016b\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0171\b\u001e\u0001\u001e\u0005\u001e\u0174\b\u001e\n\u001e\f\u001e"+
		"\u0177\t\u001e\u0001\u001e\u0003\u001e\u017a\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0181\b\u001f\n"+
		"\u001f\f\u001f\u0184\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u018c\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003"+
		" \u019f\b \u0001!\u0001!\u0001!\u0005!\u01a4\b!\n!\f!\u01a7\t!\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u01b0\b\"\n\""+
		"\f\"\u01b3\t\"\u0001\"\u0003\"\u01b6\b\"\u0001\"\u0000\u0000#\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BD\u0000\b\u0001\u0000\u0019\u001a\u0001\u0000\u001b"+
		"\u001e\u0001\u0000\r\u000e\u0001\u0000\u000f\u0011\u0002\u0000\u000e\u000e"+
		"\u0012\u0012\u0001\u0000 !\u0001\u0000/0\u0002\u0000\u0010\u0010\u001f"+
		"\u001f\u01d3\u0000I\u0001\u0000\u0000\u0000\u0002Q\u0001\u0000\u0000\u0000"+
		"\u0004S\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\bW\u0001"+
		"\u0000\u0000\u0000\nY\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000"+
		"\u000e]\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012a"+
		"\u0001\u0000\u0000\u0000\u0014c\u0001\u0000\u0000\u0000\u0016\u00a1\u0001"+
		"\u0000\u0000\u0000\u0018\u00a3\u0001\u0000\u0000\u0000\u001a\u00a5\u0001"+
		"\u0000\u0000\u0000\u001c\u00ae\u0001\u0000\u0000\u0000\u001e\u00b7\u0001"+
		"\u0000\u0000\u0000 \u00c0\u0001\u0000\u0000\u0000\"\u00c9\u0001\u0000"+
		"\u0000\u0000$\u00d2\u0001\u0000\u0000\u0000&\u00db\u0001\u0000\u0000\u0000"+
		"(\u00e8\u0001\u0000\u0000\u0000*\u00ea\u0001\u0000\u0000\u0000,\u00f5"+
		"\u0001\u0000\u0000\u0000.\u0100\u0001\u0000\u0000\u00000\u013d\u0001\u0000"+
		"\u0000\u00002\u0140\u0001\u0000\u0000\u00004\u0152\u0001\u0000\u0000\u0000"+
		"6\u0154\u0001\u0000\u0000\u00008\u015c\u0001\u0000\u0000\u0000:\u0161"+
		"\u0001\u0000\u0000\u0000<\u016a\u0001\u0000\u0000\u0000>\u017d\u0001\u0000"+
		"\u0000\u0000@\u019e\u0001\u0000\u0000\u0000B\u01a0\u0001\u0000\u0000\u0000"+
		"D\u01a8\u0001\u0000\u0000\u0000FH\u0003\u0016\u000b\u0000GF\u0001\u0000"+
		"\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"LN\u0003\u0018\f\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OP\u0005\u0000\u0000\u0001P\u0001\u0001\u0000"+
		"\u0000\u0000QR\u0005\u000b\u0000\u0000R\u0003\u0001\u0000\u0000\u0000"+
		"ST\u0005\u0014\u0000\u0000T\u0005\u0001\u0000\u0000\u0000UV\u0005\u0013"+
		"\u0000\u0000V\u0007\u0001\u0000\u0000\u0000WX\u0007\u0000\u0000\u0000"+
		"X\t\u0001\u0000\u0000\u0000YZ\u0007\u0001\u0000\u0000Z\u000b\u0001\u0000"+
		"\u0000\u0000[\\\u0007\u0002\u0000\u0000\\\r\u0001\u0000\u0000\u0000]^"+
		"\u0007\u0003\u0000\u0000^\u000f\u0001\u0000\u0000\u0000_`\u0007\u0004"+
		"\u0000\u0000`\u0011\u0001\u0000\u0000\u0000ab\u0007\u0005\u0000\u0000"+
		"b\u0013\u0001\u0000\u0000\u0000cl\u0005\u0003\u0000\u0000di\u00054\u0000"+
		"\u0000ef\u0005\b\u0000\u0000fh\u00054\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000ld\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"no\u0005\u0004\u0000\u0000o\u0015\u0001\u0000\u0000\u0000pq\u0003\u0018"+
		"\f\u0000qr\u0005\t\u0000\u0000r\u00a2\u0001\u0000\u0000\u0000su\u0005"+
		"\'\u0000\u0000ts\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vw\u0003\u0012\t\u0000wz\u00054\u0000\u0000xy\u0005"+
		"\u0007\u0000\u0000y{\u0003@ \u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0005\n\u0000\u0000}~\u0003\u0018"+
		"\f\u0000~\u007f\u0005\t\u0000\u0000\u007f\u00a2\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0005\'\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0003\u0012\t\u0000\u0084\u0085\u0003\u0014\n\u0000\u0085\u0086"+
		"\u0005\n\u0000\u0000\u0086\u0087\u0003\u0018\f\u0000\u0087\u0088\u0005"+
		"\t\u0000\u0000\u0088\u00a2\u0001\u0000\u0000\u0000\u0089\u008a\u00054"+
		"\u0000\u0000\u008a\u008b\u0005\n\u0000\u0000\u008b\u008c\u0003\u0018\f"+
		"\u0000\u008c\u008d\u0005\t\u0000\u0000\u008d\u00a2\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005(\u0000\u0000\u008f\u0090\u0005\"\u0000\u0000\u0090"+
		"\u0091\u0003\u0018\f\u0000\u0091\u0092\u0005\t\u0000\u0000\u0092\u00a2"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005*\u0000\u0000\u0094\u0095\u0005"+
		" \u0000\u0000\u0095\u0098\u00054\u0000\u0000\u0096\u0097\u0005\u0007\u0000"+
		"\u0000\u0097\u0099\u0003@ \u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u00a2\u0005\t\u0000\u0000\u009b\u009c\u0005-\u0000\u0000\u009c\u009d"+
		"\u00054\u0000\u0000\u009d\u009e\u0005\n\u0000\u0000\u009e\u009f\u0003"+
		"@ \u0000\u009f\u00a0\u0005\t\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a1p\u0001\u0000\u0000\u0000\u00a1t\u0001\u0000\u0000\u0000\u00a1"+
		"\u0081\u0001\u0000\u0000\u0000\u00a1\u0089\u0001\u0000\u0000\u0000\u00a1"+
		"\u008e\u0001\u0000\u0000\u0000\u00a1\u0093\u0001\u0000\u0000\u0000\u00a1"+
		"\u009b\u0001\u0000\u0000\u0000\u00a2\u0017\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0003\u001a\r\u0000\u00a4\u0019\u0001\u0000\u0000\u0000\u00a5\u00ab"+
		"\u0003\u001c\u000e\u0000\u00a6\u00a7\u0003\u0002\u0001\u0000\u00a7\u00a8"+
		"\u0003\u001c\u000e\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a6"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u001b"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b4"+
		"\u0003\u001e\u000f\u0000\u00af\u00b0\u0003\u0004\u0002\u0000\u00b0\u00b1"+
		"\u0003\u001e\u000f\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00af"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u001d"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00bd"+
		"\u0003 \u0010\u0000\u00b8\u00b9\u0003\u0006\u0003\u0000\u00b9\u00ba\u0003"+
		" \u0010\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b8\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u001f\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c6\u0003\"\u0011"+
		"\u0000\u00c1\u00c2\u0003\b\u0004\u0000\u00c2\u00c3\u0003\"\u0011\u0000"+
		"\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7!\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cf\u0003$\u0012\u0000\u00ca\u00cb"+
		"\u0003\n\u0005\u0000\u00cb\u00cc\u0003$\u0012\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001"+
		"\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d0#\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d8\u0003&\u0013\u0000\u00d3\u00d4\u0003\f\u0006"+
		"\u0000\u00d4\u00d5\u0003&\u0013\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9%\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db"+
		"\u00e1\u0003(\u0014\u0000\u00dc\u00dd\u0003\u000e\u0007\u0000\u00dd\u00de"+
		"\u0003(\u0014\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\'\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5\u0003\u0010"+
		"\b\u0000\u00e5\u00e6\u0003(\u0014\u0000\u00e6\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e9\u00032\u0019\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9)\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ef\u0003\u0018\f\u0000\u00eb\u00ec\u0005\b\u0000\u0000\u00ec\u00ee"+
		"\u0003\u0018\f\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001"+
		"\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f4\u0005\b\u0000\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4+\u0001\u0000\u0000"+
		"\u0000\u00f5\u00fa\u0003\u0018\f\u0000\u00f6\u00f7\u0005\b\u0000\u0000"+
		"\u00f7\u00f9\u0003\u0018\f\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fd\u00ff\u0005\b\u0000\u0000\u00fe\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff-\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u00054\u0000\u0000\u0101\u0102\u0005\u0007"+
		"\u0000\u0000\u0102\u0109\u0003\u0018\f\u0000\u0103\u0104\u0005\b\u0000"+
		"\u0000\u0104\u0105\u00054\u0000\u0000\u0105\u0106\u0005\u0007\u0000\u0000"+
		"\u0106\u0108\u0003\u0018\f\u0000\u0107\u0103\u0001\u0000\u0000\u0000\u0108"+
		"\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b"+
		"\u0109\u0001\u0000\u0000\u0000\u010c\u010e\u0005\b\u0000\u0000\u010d\u010c"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e/\u0001"+
		"\u0000\u0000\u0000\u010f\u013e\u00051\u0000\u0000\u0110\u013e\u00052\u0000"+
		"\u0000\u0111\u013e\u0007\u0006\u0000\u0000\u0112\u013e\u00053\u0000\u0000"+
		"\u0113\u013e\u00054\u0000\u0000\u0114\u0115\u0005+\u0000\u0000\u0115\u0116"+
		"\u0005\u0003\u0000\u0000\u0116\u0117\u0003,\u0016\u0000\u0117\u0118\u0005"+
		"\u0004\u0000\u0000\u0118\u013e\u0001\u0000\u0000\u0000\u0119\u011a\u0005"+
		",\u0000\u0000\u011a\u011b\u0005\u0003\u0000\u0000\u011b\u011c\u0003.\u0017"+
		"\u0000\u011c\u011d\u0005\u0004\u0000\u0000\u011d\u013e\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005\u0003\u0000\u0000\u011f\u0120\u0003*\u0015\u0000"+
		"\u0120\u0121\u0005\u0004\u0000\u0000\u0121\u013e\u0001\u0000\u0000\u0000"+
		"\u0122\u013e\u0003<\u001e\u0000\u0123\u0124\u0005\"\u0000\u0000\u0124"+
		"\u0125\u0005\u0001\u0000\u0000\u0125\u0126\u0003\u0018\f\u0000\u0126\u0127"+
		"\u0005\u0002\u0000\u0000\u0127\u012a\u0003\u0018\f\u0000\u0128\u0129\u0005"+
		"#\u0000\u0000\u0129\u012b\u0003\u0018\f\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u013e\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0005$\u0000\u0000\u012d\u013e\u0003\u0018\f"+
		"\u0000\u012e\u012f\u0005)\u0000\u0000\u012f\u0130\u0003\u0018\f\u0000"+
		"\u0130\u0131\u0003\u0018\f\u0000\u0131\u0132\u0003\u0018\f\u0000\u0132"+
		"\u0133\u0003\u0018\f\u0000\u0133\u013e\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0005&\u0000\u0000\u0135\u0136\u0005\u001b\u0000\u0000\u0136\u0137\u0003"+
		">\u001f\u0000\u0137\u0138\u0005\u001d\u0000\u0000\u0138\u013e\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0005\u0001\u0000\u0000\u013a\u013b\u0003\u0018"+
		"\f\u0000\u013b\u013c\u0005\u0002\u0000\u0000\u013c\u013e\u0001\u0000\u0000"+
		"\u0000\u013d\u010f\u0001\u0000\u0000\u0000\u013d\u0110\u0001\u0000\u0000"+
		"\u0000\u013d\u0111\u0001\u0000\u0000\u0000\u013d\u0112\u0001\u0000\u0000"+
		"\u0000\u013d\u0113\u0001\u0000\u0000\u0000\u013d\u0114\u0001\u0000\u0000"+
		"\u0000\u013d\u0119\u0001\u0000\u0000\u0000\u013d\u011e\u0001\u0000\u0000"+
		"\u0000\u013d\u0122\u0001\u0000\u0000\u0000\u013d\u0123\u0001\u0000\u0000"+
		"\u0000\u013d\u012c\u0001\u0000\u0000\u0000\u013d\u012e\u0001\u0000\u0000"+
		"\u0000\u013d\u0134\u0001\u0000\u0000\u0000\u013d\u0139\u0001\u0000\u0000"+
		"\u0000\u013e1\u0001\u0000\u0000\u0000\u013f\u0141\u0005\u0017\u0000\u0000"+
		"\u0140\u013f\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0146\u00030\u0018\u0000\u0143"+
		"\u0145\u00034\u001a\u0000\u0144\u0143\u0001\u0000\u0000\u0000\u0145\u0148"+
		"\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147"+
		"\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146"+
		"\u0001\u0000\u0000\u0000\u0149\u014b\u0003<\u001e\u0000\u014a\u0149\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b3\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0005\u001f\u0000\u0000\u014d\u0153\u00054\u0000"+
		"\u0000\u014e\u014f\u0005\u0001\u0000\u0000\u014f\u0150\u00036\u001b\u0000"+
		"\u0150\u0151\u0005\u0002\u0000\u0000\u0151\u0153\u0001\u0000\u0000\u0000"+
		"\u0152\u014c\u0001\u0000\u0000\u0000\u0152\u014e\u0001\u0000\u0000\u0000"+
		"\u01535\u0001\u0000\u0000\u0000\u0154\u0159\u0003\u0018\f\u0000\u0155"+
		"\u0156\u0005\b\u0000\u0000\u0156\u0158\u0003\u0018\f\u0000\u0157\u0155"+
		"\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157"+
		"\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a7\u0001"+
		"\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015c\u015f\u0005"+
		"4\u0000\u0000\u015d\u015e\u0005\u0007\u0000\u0000\u015e\u0160\u0003@ "+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u01609\u0001\u0000\u0000\u0000\u0161\u0166\u00038\u001c\u0000\u0162"+
		"\u0163\u0005\b\u0000\u0000\u0163\u0165\u00038\u001c\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167;\u0001"+
		"\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016b\u0005"+
		"%\u0000\u0000\u016a\u0169\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000"+
		"\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u0170\u0005\u0005"+
		"\u0000\u0000\u016d\u016e\u0003:\u001d\u0000\u016e\u016f\u0005\f\u0000"+
		"\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016d\u0001\u0000\u0000"+
		"\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0175\u0001\u0000\u0000"+
		"\u0000\u0172\u0174\u0003\u0016\u000b\u0000\u0173\u0172\u0001\u0000\u0000"+
		"\u0000\u0174\u0177\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0179\u0001\u0000\u0000"+
		"\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0178\u017a\u0003\u0018\f\u0000"+
		"\u0179\u0178\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000"+
		"\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017c\u0005\u0006\u0000\u0000"+
		"\u017c=\u0001\u0000\u0000\u0000\u017d\u0182\u00054\u0000\u0000\u017e\u017f"+
		"\u0007\u0007\u0000\u0000\u017f\u0181\u00054\u0000\u0000\u0180\u017e\u0001"+
		"\u0000\u0000\u0000\u0181\u0184\u0001\u0000\u0000\u0000\u0182\u0180\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183?\u0001\u0000"+
		"\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u019f\u00054\u0000"+
		"\u0000\u0186\u019f\u0005.\u0000\u0000\u0187\u018b\u0005\u0005\u0000\u0000"+
		"\u0188\u0189\u0003B!\u0000\u0189\u018a\u0005\f\u0000\u0000\u018a\u018c"+
		"\u0001\u0000\u0000\u0000\u018b\u0188\u0001\u0000\u0000\u0000\u018b\u018c"+
		"\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018e"+
		"\u0003@ \u0000\u018e\u018f\u0005\u0006\u0000\u0000\u018f\u019f\u0001\u0000"+
		"\u0000\u0000\u0190\u0191\u0005\u0003\u0000\u0000\u0191\u0192\u0003B!\u0000"+
		"\u0192\u0193\u0005\u0004\u0000\u0000\u0193\u019f\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\u0005+\u0000\u0000\u0195\u0196\u0005\u0003\u0000\u0000\u0196"+
		"\u0197\u0003@ \u0000\u0197\u0198\u0005\u0004\u0000\u0000\u0198\u019f\u0001"+
		"\u0000\u0000\u0000\u0199\u019a\u0005,\u0000\u0000\u019a\u019b\u0005\u0003"+
		"\u0000\u0000\u019b\u019c\u0003D\"\u0000\u019c\u019d\u0005\u0004\u0000"+
		"\u0000\u019d\u019f\u0001\u0000\u0000\u0000\u019e\u0185\u0001\u0000\u0000"+
		"\u0000\u019e\u0186\u0001\u0000\u0000\u0000\u019e\u0187\u0001\u0000\u0000"+
		"\u0000\u019e\u0190\u0001\u0000\u0000\u0000\u019e\u0194\u0001\u0000\u0000"+
		"\u0000\u019e\u0199\u0001\u0000\u0000\u0000\u019fA\u0001\u0000\u0000\u0000"+
		"\u01a0\u01a5\u0003@ \u0000\u01a1\u01a2\u0005\b\u0000\u0000\u01a2\u01a4"+
		"\u0003@ \u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a6C\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a9\u00054\u0000\u0000\u01a9\u01aa\u0005\u0007\u0000\u0000"+
		"\u01aa\u01b1\u0003@ \u0000\u01ab\u01ac\u0005\b\u0000\u0000\u01ac\u01ad"+
		"\u00054\u0000\u0000\u01ad\u01ae\u0005\u0007\u0000\u0000\u01ae\u01b0\u0003"+
		"@ \u0000\u01af\u01ab\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b6\u0005\b\u0000\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6E\u0001\u0000\u0000\u0000*I"+
		"Miltz\u0081\u0098\u00a1\u00ab\u00b4\u00bd\u00c6\u00cf\u00d8\u00e1\u00e8"+
		"\u00ef\u00f3\u00fa\u00fe\u0109\u010d\u012a\u013d\u0140\u0146\u014a\u0152"+
		"\u0159\u015f\u0166\u016a\u0170\u0175\u0179\u0182\u018b\u019e\u01a5\u01b1"+
		"\u01b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}