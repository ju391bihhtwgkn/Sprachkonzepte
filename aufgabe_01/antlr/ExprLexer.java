// Generated from java-escape by ANTLR 4.11.1
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
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Clock=1, WS=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Clock", "Normal", "Noon", "Midnight", "Hour", "Minute", "Meridiem", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Clock", "WS"
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
	public String getGrammarFileName() { return "ExprLexer.g4"; }

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
		"\u0004\u0000\u0002X\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0015\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"(\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004C\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006P\b\u0006\u0001\u0007"+
		"\u0004\u0007S\b\u0007\u000b\u0007\f\u0007T\u0001\u0007\u0001\u0007\u0000"+
		"\u0000\b\u0001\u0001\u0003\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b"+
		"\u0000\r\u0000\u000f\u0002\u0001\u0000\u0005\u0001\u000002\u0001\u0000"+
		"19\u0001\u000005\u0001\u000009\u0003\u0000\t\n\r\r  X\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0014\u0001"+
		"\u0000\u0000\u0000\u0003\u0016\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000"+
		"\u0000\u0000\u0007<\u0001\u0000\u0000\u0000\tB\u0001\u0000\u0000\u0000"+
		"\u000bD\u0001\u0000\u0000\u0000\rO\u0001\u0000\u0000\u0000\u000fR\u0001"+
		"\u0000\u0000\u0000\u0011\u0015\u0003\u0003\u0001\u0000\u0012\u0015\u0003"+
		"\u0005\u0002\u0000\u0013\u0015\u0003\u0007\u0003\u0000\u0014\u0011\u0001"+
		"\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0002\u0001\u0000\u0000\u0000\u0016\u0017\u0003"+
		"\t\u0004\u0000\u0017\u0018\u0005:\u0000\u0000\u0018\u0019\u0003\u000b"+
		"\u0005\u0000\u0019\u001a\u0005 \u0000\u0000\u001a\u001b\u0003\r\u0006"+
		"\u0000\u001b\u0004\u0001\u0000\u0000\u0000\u001c\u001d\u0005N\u0000\u0000"+
		"\u001d\u001e\u0005o\u0000\u0000\u001e\u001f\u0005o\u0000\u0000\u001f("+
		"\u0005n\u0000\u0000 !\u00051\u0000\u0000!\"\u00052\u0000\u0000\"#\u0005"+
		" \u0000\u0000#$\u0005n\u0000\u0000$%\u0005o\u0000\u0000%&\u0005o\u0000"+
		"\u0000&(\u0005n\u0000\u0000\'\u001c\u0001\u0000\u0000\u0000\' \u0001\u0000"+
		"\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005M\u0000\u0000*+\u0005"+
		"i\u0000\u0000+,\u0005d\u0000\u0000,-\u0005n\u0000\u0000-.\u0005i\u0000"+
		"\u0000./\u0005g\u0000\u0000/0\u0005h\u0000\u00000=\u0005t\u0000\u0000"+
		"12\u00051\u0000\u000023\u00052\u0000\u000034\u0005 \u0000\u000045\u0005"+
		"m\u0000\u000056\u0005i\u0000\u000067\u0005d\u0000\u000078\u0005n\u0000"+
		"\u000089\u0005i\u0000\u00009:\u0005g\u0000\u0000:;\u0005h\u0000\u0000"+
		";=\u0005t\u0000\u0000<)\u0001\u0000\u0000\u0000<1\u0001\u0000\u0000\u0000"+
		"=\b\u0001\u0000\u0000\u0000>?\u00051\u0000\u0000?C\u0007\u0000\u0000\u0000"+
		"@A\u00050\u0000\u0000AC\u0007\u0001\u0000\u0000B>\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000C\n\u0001\u0000\u0000\u0000DE\u0007\u0002\u0000"+
		"\u0000EF\u0007\u0003\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005p\u0000"+
		"\u0000HI\u0005.\u0000\u0000IJ\u0005m\u0000\u0000JP\u0005.\u0000\u0000"+
		"KL\u0005a\u0000\u0000LM\u0005.\u0000\u0000MN\u0005m\u0000\u0000NP\u0005"+
		".\u0000\u0000OG\u0001\u0000\u0000\u0000OK\u0001\u0000\u0000\u0000P\u000e"+
		"\u0001\u0000\u0000\u0000QS\u0007\u0004\u0000\u0000RQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0006\u0007\u0000\u0000W\u0010"+
		"\u0001\u0000\u0000\u0000\u0007\u0000\u0014\'<BOT\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}