// Generated from /home/thomas/Desktop/calc/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DECIMAL=6, IMAGINARY=7, PLUS=8, 
		MINUS=9, MULT=10, DIV=11, POW=12, FUNCTION_IDENTIFIER=13, WS=14;
	public static final int
		RULE_expression = 0, RULE_parenthesed_expression = 1, RULE_function_call = 2, 
		RULE_term = 3, RULE_factor = 4, RULE_pow = 5, RULE_value = 6, RULE_number = 7, 
		RULE_function_defintion = 8, RULE_function_function_call = 9, RULE_function_parenthesed_expression = 10, 
		RULE_function_term = 11, RULE_function_factor = 12, RULE_function_pow = 13, 
		RULE_function_value = 14, RULE_variable = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "parenthesed_expression", "function_call", "term", "factor", 
			"pow", "value", "number", "function_defintion", "function_function_call", 
			"function_parenthesed_expression", "function_term", "function_factor", 
			"function_pow", "function_value", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':='", "'x'", null, null, null, "'+'", "'-'", "'\u00D7'", 
			"'/'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT", "DECIMAL", "IMAGINARY", "PLUS", 
			"MINUS", "MULT", "DIV", "POW", "FUNCTION_IDENTIFIER", "WS"
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
	public String getGrammarFileName() { return "CalculatorExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Function_defintionContext function_defintion() {
			return getRuleContext(Function_defintionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				term(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				function_defintion();
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

	public static class Parenthesed_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Parenthesed_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesed_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterParenthesed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitParenthesed_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitParenthesed_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parenthesed_expressionContext parenthesed_expression() throws RecognitionException {
		Parenthesed_expressionContext _localctx = new Parenthesed_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parenthesed_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			expression();
			setState(38);
			match(T__1);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(FUNCTION_IDENTIFIER);
			setState(41);
			match(T__0);
			setState(42);
			term(0);
			setState(43);
			match(T__1);
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(46);
			factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(54);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(48);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(49);
						match(PLUS);
						setState(50);
						factor(0);
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(51);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(52);
						match(MINUS);
						setState(53);
						factor(0);
						}
						break;
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CalculatorExpressionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorExpressionParser.DIV, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(60);
			pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(68);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(62);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(63);
						match(MULT);
						setState(64);
						pow(0);
						}
						break;
					case 2:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(65);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(66);
						match(DIV);
						setState(67);
						pow(0);
						}
						break;
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class PowContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorExpressionParser.POW, 0); }
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		return pow(0);
	}

	private PowContext pow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PowContext _localctx = new PowContext(_ctx, _parentState);
		PowContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(74);
			value();
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pow);
					setState(76);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(77);
					match(POW);
					setState(78);
					value();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Parenthesed_expressionContext parenthesed_expression() {
			return getRuleContext(Parenthesed_expressionContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				number();
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				parenthesed_expression();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CalculatorExpressionParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CalculatorExpressionParser.DECIMAL, 0); }
		public TerminalNode IMAGINARY() { return getToken(CalculatorExpressionParser.IMAGINARY, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(89);
				match(MINUS);
				}
			}

			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DECIMAL) | (1L << IMAGINARY))) != 0)) ) {
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

	public static class Function_defintionContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_defintionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_defintion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_defintion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_defintion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_defintion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defintionContext function_defintion() throws RecognitionException {
		Function_defintionContext _localctx = new Function_defintionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_defintion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(FUNCTION_IDENTIFIER);
			setState(95);
			match(T__2);
			setState(96);
			function_term(0);
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

	public static class Function_function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_function_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_function_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_function_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_function_callContext function_function_call() throws RecognitionException {
		Function_function_callContext _localctx = new Function_function_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(FUNCTION_IDENTIFIER);
			setState(99);
			match(T__0);
			setState(100);
			function_term(0);
			setState(101);
			match(T__1);
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

	public static class Function_parenthesed_expressionContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_parenthesed_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parenthesed_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_parenthesed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_parenthesed_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_parenthesed_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parenthesed_expressionContext function_parenthesed_expression() throws RecognitionException {
		Function_parenthesed_expressionContext _localctx = new Function_parenthesed_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_parenthesed_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(104);
			function_term(0);
			setState(105);
			match(T__1);
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

	public static class Function_termContext extends ParserRuleContext {
		public Function_factorContext function_factor() {
			return getRuleContext(Function_factorContext.class,0);
		}
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public Function_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_termContext function_term() throws RecognitionException {
		return function_term(0);
	}

	private Function_termContext function_term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_termContext _localctx = new Function_termContext(_ctx, _parentState);
		Function_termContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_function_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			function_factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(110);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(111);
						match(PLUS);
						setState(112);
						function_factor(0);
						}
						break;
					case 2:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(113);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(114);
						match(MINUS);
						setState(115);
						function_factor(0);
						}
						break;
					}
					} 
				}
				setState(120);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_factorContext extends ParserRuleContext {
		public Function_powContext function_pow() {
			return getRuleContext(Function_powContext.class,0);
		}
		public Function_factorContext function_factor() {
			return getRuleContext(Function_factorContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CalculatorExpressionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorExpressionParser.DIV, 0); }
		public Function_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_factor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_factor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_factorContext function_factor() throws RecognitionException {
		return function_factor(0);
	}

	private Function_factorContext function_factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_factorContext _localctx = new Function_factorContext(_ctx, _parentState);
		Function_factorContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_function_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(122);
			function_pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(130);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(124);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(125);
						match(MULT);
						setState(126);
						function_pow(0);
						}
						break;
					case 2:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(127);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(128);
						match(DIV);
						setState(129);
						function_pow(0);
						}
						break;
					}
					} 
				}
				setState(134);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_powContext extends ParserRuleContext {
		public Function_valueContext function_value() {
			return getRuleContext(Function_valueContext.class,0);
		}
		public Function_powContext function_pow() {
			return getRuleContext(Function_powContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorExpressionParser.POW, 0); }
		public Function_powContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_pow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_pow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_pow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_powContext function_pow() throws RecognitionException {
		return function_pow(0);
	}

	private Function_powContext function_pow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_powContext _localctx = new Function_powContext(_ctx, _parentState);
		Function_powContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_function_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(136);
			function_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Function_powContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_function_pow);
					setState(138);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(139);
					match(POW);
					setState(140);
					function_value();
					}
					} 
				}
				setState(145);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_valueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Function_function_callContext function_function_call() {
			return getRuleContext(Function_function_callContext.class,0);
		}
		public Function_parenthesed_expressionContext function_parenthesed_expression() {
			return getRuleContext(Function_parenthesed_expressionContext.class,0);
		}
		public Function_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_valueContext function_value() throws RecognitionException {
		Function_valueContext _localctx = new Function_valueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_value);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				number();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				variable();
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				function_function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				function_parenthesed_expression();
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

	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__3);
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
		case 3:
			return term_sempred((TermContext)_localctx, predIndex);
		case 4:
			return factor_sempred((FactorContext)_localctx, predIndex);
		case 5:
			return pow_sempred((PowContext)_localctx, predIndex);
		case 11:
			return function_term_sempred((Function_termContext)_localctx, predIndex);
		case 12:
			return function_factor_sempred((Function_factorContext)_localctx, predIndex);
		case 13:
			return function_pow_sempred((Function_powContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pow_sempred(PowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_term_sempred(Function_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_factor_sempred(Function_factorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_pow_sempred(Function_powContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u009d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\5\2%\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7R\n\7\f\7\16\7U"+
		"\13\7\3\b\3\b\3\b\5\bZ\n\b\3\t\5\t]\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\7\rw\n\r\f\r\16\rz\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0085\n\16\f\16\16\16\u0088\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u0090\n\17\f\17\16\17\u0093\13\17\3\20\3\20\3\20\3\20\5\20\u0099"+
		"\n\20\3\21\3\21\3\21\2\b\b\n\f\30\32\34\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\3\3\2\7\t\2\u009d\2$\3\2\2\2\4&\3\2\2\2\6*\3\2\2\2\b/"+
		"\3\2\2\2\n=\3\2\2\2\fK\3\2\2\2\16Y\3\2\2\2\20\\\3\2\2\2\22`\3\2\2\2\24"+
		"d\3\2\2\2\26i\3\2\2\2\30m\3\2\2\2\32{\3\2\2\2\34\u0089\3\2\2\2\36\u0098"+
		"\3\2\2\2 \u009a\3\2\2\2\"%\5\b\5\2#%\5\22\n\2$\"\3\2\2\2$#\3\2\2\2%\3"+
		"\3\2\2\2&\'\7\3\2\2\'(\5\2\2\2()\7\4\2\2)\5\3\2\2\2*+\7\17\2\2+,\7\3\2"+
		"\2,-\5\b\5\2-.\7\4\2\2.\7\3\2\2\2/\60\b\5\1\2\60\61\5\n\6\2\61:\3\2\2"+
		"\2\62\63\f\4\2\2\63\64\7\n\2\2\649\5\n\6\2\65\66\f\3\2\2\66\67\7\13\2"+
		"\2\679\5\n\6\28\62\3\2\2\28\65\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;"+
		"\t\3\2\2\2<:\3\2\2\2=>\b\6\1\2>?\5\f\7\2?H\3\2\2\2@A\f\4\2\2AB\7\f\2\2"+
		"BG\5\f\7\2CD\f\3\2\2DE\7\r\2\2EG\5\f\7\2F@\3\2\2\2FC\3\2\2\2GJ\3\2\2\2"+
		"HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JH\3\2\2\2KL\b\7\1\2LM\5\16\b\2MS\3\2"+
		"\2\2NO\f\3\2\2OP\7\16\2\2PR\5\16\b\2QN\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2T\r\3\2\2\2US\3\2\2\2VZ\5\20\t\2WZ\5\6\4\2XZ\5\4\3\2YV\3\2\2\2Y"+
		"W\3\2\2\2YX\3\2\2\2Z\17\3\2\2\2[]\7\13\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2"+
		"\2\2^_\t\2\2\2_\21\3\2\2\2`a\7\17\2\2ab\7\5\2\2bc\5\30\r\2c\23\3\2\2\2"+
		"de\7\17\2\2ef\7\3\2\2fg\5\30\r\2gh\7\4\2\2h\25\3\2\2\2ij\7\3\2\2jk\5\30"+
		"\r\2kl\7\4\2\2l\27\3\2\2\2mn\b\r\1\2no\5\32\16\2ox\3\2\2\2pq\f\4\2\2q"+
		"r\7\n\2\2rw\5\32\16\2st\f\3\2\2tu\7\13\2\2uw\5\32\16\2vp\3\2\2\2vs\3\2"+
		"\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\31\3\2\2\2zx\3\2\2\2{|\b\16\1\2|}"+
		"\5\34\17\2}\u0086\3\2\2\2~\177\f\4\2\2\177\u0080\7\f\2\2\u0080\u0085\5"+
		"\34\17\2\u0081\u0082\f\3\2\2\u0082\u0083\7\r\2\2\u0083\u0085\5\34\17\2"+
		"\u0084~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\33\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\b\17\1\2\u008a\u008b\5\36\20\2\u008b\u0091\3\2\2\2\u008c\u008d"+
		"\f\3\2\2\u008d\u008e\7\16\2\2\u008e\u0090\5\36\20\2\u008f\u008c\3\2\2"+
		"\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\35"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0099\5\20\t\2\u0095\u0099\5 \21\2"+
		"\u0096\u0099\5\24\13\2\u0097\u0099\5\26\f\2\u0098\u0094\3\2\2\2\u0098"+
		"\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\37\3\2\2"+
		"\2\u009a\u009b\7\6\2\2\u009b!\3\2\2\2\20$8:FHSY\\vx\u0084\u0086\u0091"+
		"\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}