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
		MINUS=9, MULT=10, DIV=11, FUNCTION_IDENTIFIER=12, WS=13;
	public static final int
		RULE_expression = 0, RULE_parenthesed_expression = 1, RULE_function_call = 2, 
		RULE_term = 3, RULE_factor = 4, RULE_value = 5, RULE_number = 6, RULE_function_defintion = 7, 
		RULE_function_function_call = 8, RULE_function_parenthesed_expression = 9, 
		RULE_function_term = 10, RULE_function_factor = 11, RULE_function_value = 12, 
		RULE_variable = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "parenthesed_expression", "function_call", "term", "factor", 
			"value", "number", "function_defintion", "function_function_call", "function_parenthesed_expression", 
			"function_term", "function_factor", "function_value", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':='", "'x'", null, null, null, "'+'", "'-'", "'\u00D7'", 
			"'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT", "DECIMAL", "IMAGINARY", "PLUS", 
			"MINUS", "MULT", "DIV", "FUNCTION_IDENTIFIER", "WS"
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
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				term(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
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
			setState(32);
			match(T__0);
			setState(33);
			expression();
			setState(34);
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
			setState(36);
			match(FUNCTION_IDENTIFIER);
			setState(37);
			match(T__0);
			setState(38);
			term(0);
			setState(39);
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
			setState(42);
			factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(44);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(45);
						match(PLUS);
						setState(46);
						factor(0);
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(47);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(48);
						match(MINUS);
						setState(49);
						factor(0);
						}
						break;
					}
					} 
				}
				setState(54);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
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
			setState(56);
			value();
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(64);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(58);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(59);
						match(MULT);
						setState(60);
						value();
						}
						break;
					case 2:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(61);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(62);
						match(DIV);
						setState(63);
						value();
						}
						break;
					}
					} 
				}
				setState(68);
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
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				number();
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
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
		enterRule(_localctx, 12, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(74);
				match(MINUS);
				}
			}

			setState(77);
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
		enterRule(_localctx, 14, RULE_function_defintion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(FUNCTION_IDENTIFIER);
			setState(80);
			match(T__2);
			setState(81);
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
		enterRule(_localctx, 16, RULE_function_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(FUNCTION_IDENTIFIER);
			setState(84);
			match(T__0);
			setState(85);
			function_term(0);
			setState(86);
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
		enterRule(_localctx, 18, RULE_function_parenthesed_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__0);
			setState(89);
			function_term(0);
			setState(90);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_function_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(93);
			function_factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(95);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(96);
						match(PLUS);
						setState(97);
						function_factor(0);
						}
						break;
					case 2:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(98);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(99);
						match(MINUS);
						setState(100);
						function_factor(0);
						}
						break;
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public Function_valueContext function_value() {
			return getRuleContext(Function_valueContext.class,0);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_function_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			function_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(109);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(110);
						match(MULT);
						setState(111);
						function_value();
						}
						break;
					case 2:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(112);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(113);
						match(DIV);
						setState(114);
						function_value();
						}
						break;
					}
					} 
				}
				setState(119);
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
		enterRule(_localctx, 24, RULE_function_value);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				number();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				variable();
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				function_function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
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
		enterRule(_localctx, 26, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		case 10:
			return function_term_sempred((Function_termContext)_localctx, predIndex);
		case 11:
			return function_factor_sempred((Function_factorContext)_localctx, predIndex);
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
	private boolean function_term_sempred(Function_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_factor_sempred(Function_factorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2!\n\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\65\n"+
		"\5\f\5\16\58\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6C\n\6\f\6\16"+
		"\6F\13\6\3\7\3\7\3\7\5\7K\n\7\3\b\5\bN\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\7\fh\n\f\f\f\16\fk\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\rv\n"+
		"\r\f\r\16\ry\13\r\3\16\3\16\3\16\3\16\5\16\177\n\16\3\17\3\17\3\17\2\6"+
		"\b\n\26\30\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\3\3\2\7\t\2\u0083"+
		"\2 \3\2\2\2\4\"\3\2\2\2\6&\3\2\2\2\b+\3\2\2\2\n9\3\2\2\2\fJ\3\2\2\2\16"+
		"M\3\2\2\2\20Q\3\2\2\2\22U\3\2\2\2\24Z\3\2\2\2\26^\3\2\2\2\30l\3\2\2\2"+
		"\32~\3\2\2\2\34\u0080\3\2\2\2\36!\5\b\5\2\37!\5\20\t\2 \36\3\2\2\2 \37"+
		"\3\2\2\2!\3\3\2\2\2\"#\7\3\2\2#$\5\2\2\2$%\7\4\2\2%\5\3\2\2\2&\'\7\16"+
		"\2\2\'(\7\3\2\2()\5\b\5\2)*\7\4\2\2*\7\3\2\2\2+,\b\5\1\2,-\5\n\6\2-\66"+
		"\3\2\2\2./\f\4\2\2/\60\7\n\2\2\60\65\5\n\6\2\61\62\f\3\2\2\62\63\7\13"+
		"\2\2\63\65\5\n\6\2\64.\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2"+
		"\66\67\3\2\2\2\67\t\3\2\2\28\66\3\2\2\29:\b\6\1\2:;\5\f\7\2;D\3\2\2\2"+
		"<=\f\4\2\2=>\7\f\2\2>C\5\f\7\2?@\f\3\2\2@A\7\r\2\2AC\5\f\7\2B<\3\2\2\2"+
		"B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\13\3\2\2\2FD\3\2\2\2GK\5\16"+
		"\b\2HK\5\6\4\2IK\5\4\3\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\r\3\2\2\2LN\7"+
		"\13\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\t\2\2\2P\17\3\2\2\2QR\7\16\2\2"+
		"RS\7\5\2\2ST\5\26\f\2T\21\3\2\2\2UV\7\16\2\2VW\7\3\2\2WX\5\26\f\2XY\7"+
		"\4\2\2Y\23\3\2\2\2Z[\7\3\2\2[\\\5\26\f\2\\]\7\4\2\2]\25\3\2\2\2^_\b\f"+
		"\1\2_`\5\30\r\2`i\3\2\2\2ab\f\4\2\2bc\7\n\2\2ch\5\30\r\2de\f\3\2\2ef\7"+
		"\13\2\2fh\5\30\r\2ga\3\2\2\2gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j"+
		"\27\3\2\2\2ki\3\2\2\2lm\b\r\1\2mn\5\32\16\2nw\3\2\2\2op\f\4\2\2pq\7\f"+
		"\2\2qv\5\32\16\2rs\f\3\2\2st\7\r\2\2tv\5\32\16\2uo\3\2\2\2ur\3\2\2\2v"+
		"y\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\31\3\2\2\2yw\3\2\2\2z\177\5\16\b\2{\177"+
		"\5\34\17\2|\177\5\22\n\2}\177\5\24\13\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2"+
		"~}\3\2\2\2\177\33\3\2\2\2\u0080\u0081\7\6\2\2\u0081\35\3\2\2\2\16 \64"+
		"\66BDJMgiuw~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}