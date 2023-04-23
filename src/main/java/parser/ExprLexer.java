// Generated from parser/Expr.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, OPENBRACKET=5, CLOSEBRACKET=6, SEPARATOR=7, 
		INT=8, REAL=9, FRAC=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "OPENBRACKET", "CLOSEBRACKET", "SEPARATOR", 
			"INT", "REAL", "FRAC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "OPENBRACKET", "CLOSEBRACKET", "SEPARATOR", 
			"INT", "REAL", "FRAC"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\nI\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007%\b\u0007\u000b\u0007\f\u0007&\u0001\b\u0004\b*\b\b"+
		"\u000b\b\f\b+\u0001\b\u0001\b\u0004\b0\b\b\u000b\b\f\b1\u0001\b\u0001"+
		"\b\u0003\b6\b\b\u0001\b\u0004\b9\b\b\u000b\b\f\b:\u0003\b=\b\b\u0001\t"+
		"\u0004\t@\b\t\u000b\t\f\tA\u0001\t\u0001\t\u0004\tF\b\t\u000b\t\f\tG\u0000"+
		"\u0000\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0001\u0000\u0004\u0001\u00000"+
		"9\u0001\u0000..\u0003\u0000++--||\u0001\u0000__P\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000"+
		"\u0003\u0017\u0001\u0000\u0000\u0000\u0005\u0019\u0001\u0000\u0000\u0000"+
		"\u0007\u001b\u0001\u0000\u0000\u0000\t\u001d\u0001\u0000\u0000\u0000\u000b"+
		"\u001f\u0001\u0000\u0000\u0000\r!\u0001\u0000\u0000\u0000\u000f$\u0001"+
		"\u0000\u0000\u0000\u0011)\u0001\u0000\u0000\u0000\u0013?\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0005+\u0000\u0000\u0016\u0002\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0005-\u0000\u0000\u0018\u0004\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0005*\u0000\u0000\u001a\u0006\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0005/\u0000\u0000\u001c\b\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		"(\u0000\u0000\u001e\n\u0001\u0000\u0000\u0000\u001f \u0005)\u0000\u0000"+
		" \f\u0001\u0000\u0000\u0000!\"\u0005,\u0000\u0000\"\u000e\u0001\u0000"+
		"\u0000\u0000#%\u0007\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\'\u0010\u0001\u0000\u0000\u0000(*\u0007\u0000\u0000\u0000)(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-/\u0007\u0001\u0000\u0000"+
		".0\u0007\u0000\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002<\u0001\u0000"+
		"\u0000\u000035\u0005E\u0000\u000046\u0007\u0002\u0000\u000054\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000079\u0007"+
		"\u0000\u0000\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<3\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\u0012\u0001"+
		"\u0000\u0000\u0000>@\u0007\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CE\u0007\u0003\u0000\u0000DF\u0007\u0000"+
		"\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0014\u0001\u0000\u0000"+
		"\u0000\t\u0000&+15:<AG\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}