// Generated from parser/Expr.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OPENBRACKET=9, 
		CLOSEBRACKET=10, SEPARATOR=11, INT=12, REAL=13, FRAC=14;
	public static final int
		RULE_input = 0, RULE_expr = 1, RULE_prefixOperation = 2, RULE_infixOperation = 3, 
		RULE_postfixOperation = 4, RULE_values = 5, RULE_operator = 6, RULE_num = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"input", "expr", "prefixOperation", "infixOperation", "postfixOperation", 
			"values", "operator", "num"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'gcd'", "'lcm'", "'('", 
			"')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "OPENBRACKET", 
			"CLOSEBRACKET", "SEPARATOR", "INT", "REAL", "FRAC"
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			expr();
			setState(17);
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
	public static class ExprContext extends ParserRuleContext {
		public PrefixOperationContext prefixOperation() {
			return getRuleContext(PrefixOperationContext.class,0);
		}
		public InfixOperationContext infixOperation() {
			return getRuleContext(InfixOperationContext.class,0);
		}
		public PostfixOperationContext postfixOperation() {
			return getRuleContext(PostfixOperationContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				prefixOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				infixOperation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				postfixOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(22);
				num();
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
	public static class PrefixOperationContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public PrefixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOperationContext prefixOperation() throws RecognitionException {
		PrefixOperationContext _localctx = new PrefixOperationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prefixOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			operator();
			setState(26);
			values(0);
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
	public static class InfixOperationContext extends ParserRuleContext {
		public List<ValuesContext> values() {
			return getRuleContexts(ValuesContext.class);
		}
		public ValuesContext values(int i) {
			return getRuleContext(ValuesContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public InfixOperationContext infixOperation() {
			return getRuleContext(InfixOperationContext.class,0);
		}
		public InfixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterInfixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitInfixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitInfixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixOperationContext infixOperation() throws RecognitionException {
		InfixOperationContext _localctx = new InfixOperationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_infixOperation);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				values(0);
				setState(29);
				operator();
				setState(30);
				values(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				values(0);
				setState(33);
				operator();
				setState(34);
				infixOperation();
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
	public static class PostfixOperationContext extends ParserRuleContext {
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public PostfixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPostfixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPostfixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPostfixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixOperationContext postfixOperation() throws RecognitionException {
		PostfixOperationContext _localctx = new PostfixOperationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_postfixOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			values(0);
			setState(39);
			operator();
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
	public static class ValuesContext extends ParserRuleContext {
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(ExprParser.OPENBRACKET, 0); }
		public List<ValuesContext> values() {
			return getRuleContexts(ValuesContext.class);
		}
		public ValuesContext values(int i) {
			return getRuleContext(ValuesContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(ExprParser.CLOSEBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(ExprParser.SEPARATOR, 0); }
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		return values(0);
	}

	private ValuesContext values(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValuesContext _localctx = new ValuesContext(_ctx, _parentState);
		ValuesContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_values, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(42);
				num();
				}
				break;
			case 2:
				{
				setState(43);
				match(OPENBRACKET);
				setState(44);
				values(0);
				setState(45);
				match(CLOSEBRACKET);
				}
				break;
			case 3:
				{
				setState(47);
				match(OPENBRACKET);
				setState(48);
				expr();
				setState(49);
				match(CLOSEBRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValuesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_values);
					setState(53);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(54);
					match(SEPARATOR);
					setState(55);
					values(2);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	 
		public OperatorContext() { }
		public void copyFrom(OperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuloContext extends OperatorContext {
		public ModuloContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimesContext extends OperatorContext {
		public TimesContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LCMContext extends OperatorContext {
		public LCMContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterLCM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitLCM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitLCM(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GCDContext extends OperatorContext {
		public GCDContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterGCD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitGCD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitGCD(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends OperatorContext {
		public PlusContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends OperatorContext {
		public MinusContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DividesContext extends OperatorContext {
		public DividesContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDivides(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDivides(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDivides(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerContext extends OperatorContext {
		public PowerContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(61);
				match(T__0);
				}
				}
				break;
			case T__1:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(62);
				match(T__1);
				}
				}
				break;
			case T__2:
				_localctx = new TimesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(63);
				match(T__2);
				}
				}
				break;
			case T__3:
				_localctx = new DividesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(64);
				match(T__3);
				}
				}
				break;
			case T__4:
				_localctx = new ModuloContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(65);
				match(T__4);
				}
				}
				break;
			case T__5:
				_localctx = new PowerContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(66);
				match(T__5);
				}
				}
				break;
			case T__6:
				_localctx = new GCDContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(67);
				match(T__6);
				}
				}
				break;
			case T__7:
				_localctx = new LCMContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(68);
				match(T__7);
				}
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
	public static class NumContext extends ParserRuleContext {
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	 
		public NumContext() { }
		public void copyFrom(NumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends NumContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public IntegerContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealContext extends NumContext {
		public TerminalNode REAL() { return getToken(ExprParser.REAL, 0); }
		public RealContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FractionContext extends NumContext {
		public TerminalNode FRAC() { return getToken(ExprParser.FRAC, 0); }
		public FractionContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitFraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_num);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(INT);
				}
				break;
			case REAL:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(REAL);
				}
				break;
			case FRAC:
				_localctx = new FractionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(FRAC);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return values_sempred((ValuesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean values_sempred(ValuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000eM\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0018\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003%\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00054\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u00059\b\u0005\n\u0005"+
		"\f\u0005<\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006F\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007K\b\u0007\u0001\u0007\u0000"+
		"\u0001\n\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000T\u0000\u0010"+
		"\u0001\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000\u0004\u0019"+
		"\u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b&\u0001\u0000"+
		"\u0000\u0000\n3\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000\u0000\u000e"+
		"J\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012"+
		"\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0018"+
		"\u0003\u0004\u0002\u0000\u0014\u0018\u0003\u0006\u0003\u0000\u0015\u0018"+
		"\u0003\b\u0004\u0000\u0016\u0018\u0003\u000e\u0007\u0000\u0017\u0013\u0001"+
		"\u0000\u0000\u0000\u0017\u0014\u0001\u0000\u0000\u0000\u0017\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0003\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0003\f\u0006\u0000\u001a\u001b\u0003\n"+
		"\u0005\u0000\u001b\u0005\u0001\u0000\u0000\u0000\u001c\u001d\u0003\n\u0005"+
		"\u0000\u001d\u001e\u0003\f\u0006\u0000\u001e\u001f\u0003\n\u0005\u0000"+
		"\u001f%\u0001\u0000\u0000\u0000 !\u0003\n\u0005\u0000!\"\u0003\f\u0006"+
		"\u0000\"#\u0003\u0006\u0003\u0000#%\u0001\u0000\u0000\u0000$\u001c\u0001"+
		"\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000%\u0007\u0001\u0000\u0000"+
		"\u0000&\'\u0003\n\u0005\u0000\'(\u0003\f\u0006\u0000(\t\u0001\u0000\u0000"+
		"\u0000)*\u0006\u0005\uffff\uffff\u0000*4\u0003\u000e\u0007\u0000+,\u0005"+
		"\t\u0000\u0000,-\u0003\n\u0005\u0000-.\u0005\n\u0000\u0000.4\u0001\u0000"+
		"\u0000\u0000/0\u0005\t\u0000\u000001\u0003\u0002\u0001\u000012\u0005\n"+
		"\u0000\u000024\u0001\u0000\u0000\u00003)\u0001\u0000\u0000\u00003+\u0001"+
		"\u0000\u0000\u00003/\u0001\u0000\u0000\u00004:\u0001\u0000\u0000\u0000"+
		"56\n\u0001\u0000\u000067\u0005\u000b\u0000\u000079\u0003\n\u0005\u0002"+
		"85\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;\u000b\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000=F\u0005\u0001\u0000\u0000>F\u0005\u0002\u0000\u0000"+
		"?F\u0005\u0003\u0000\u0000@F\u0005\u0004\u0000\u0000AF\u0005\u0005\u0000"+
		"\u0000BF\u0005\u0006\u0000\u0000CF\u0005\u0007\u0000\u0000DF\u0005\b\u0000"+
		"\u0000E=\u0001\u0000\u0000\u0000E>\u0001\u0000\u0000\u0000E?\u0001\u0000"+
		"\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"F\r\u0001\u0000\u0000\u0000GK\u0005\f\u0000\u0000HK\u0005\r\u0000\u0000"+
		"IK\u0005\u000e\u0000\u0000JG\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JI\u0001\u0000\u0000\u0000K\u000f\u0001\u0000\u0000\u0000\u0006"+
		"\u0017$3:EJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}