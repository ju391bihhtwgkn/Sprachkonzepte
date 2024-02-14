// Generated from ./TripParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TripParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TITLE=1, ENTRY=2, DATE=3, WS=4, NEWLINE=5, OTHER=6;
	public static final int
		RULE_start = 0, RULE_line = 1, RULE_multiline = 2, RULE_value = 3, RULE_datevalue = 4, 
		RULE_entryvalue = 5, RULE_title = 6, RULE_date = 7, RULE_entry = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "line", "multiline", "value", "datevalue", "entryvalue", "title", 
			"date", "entry"
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
			null, "TITLE", "ENTRY", "DATE", "WS", "NEWLINE", "OTHER"
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
	public String getGrammarFileName() { return "TripParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TripParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TripParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			line();
			setState(19);
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
	public static class LineContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MultilineContext multiline() {
			return getRuleContext(MultilineContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			value();
			setState(22);
			multiline();
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
	public static class MultilineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(TripParser.NEWLINE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MultilineContext multiline() {
			return getRuleContext(MultilineContext.class,0);
		}
		public MultilineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterMultiline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitMultiline(this);
		}
	}

	public final MultilineContext multiline() throws RecognitionException {
		MultilineContext _localctx = new MultilineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiline);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(NEWLINE);
				setState(25);
				value();
				setState(26);
				multiline();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(NEWLINE);
				setState(29);
				value();
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
	public static class ValueContext extends ParserRuleContext {
		public DatevalueContext datevalue() {
			return getRuleContext(DatevalueContext.class,0);
		}
		public EntryvalueContext entryvalue() {
			return getRuleContext(EntryvalueContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				datevalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				entryvalue();
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
	public static class DatevalueContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public DatevalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datevalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterDatevalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitDatevalue(this);
		}
	}

	public final DatevalueContext datevalue() throws RecognitionException {
		DatevalueContext _localctx = new DatevalueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_datevalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			title();
			setState(37);
			date();
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
	public static class EntryvalueContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public EntryContext entry() {
			return getRuleContext(EntryContext.class,0);
		}
		public EntryvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entryvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterEntryvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitEntryvalue(this);
		}
	}

	public final EntryvalueContext entryvalue() throws RecognitionException {
		EntryvalueContext _localctx = new EntryvalueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_entryvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			title();
			setState(40);
			entry();
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
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TITLE() { return getToken(TripParser.TITLE, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(TITLE);
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(TripParser.DATE, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitDate(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(DATE);
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
	public static class EntryContext extends ParserRuleContext {
		public TerminalNode ENTRY() { return getToken(TripParser.ENTRY, 0); }
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TripParserListener ) ((TripParserListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ENTRY);
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
		"\u0004\u0001\u00061\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"#\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000"+
		"\u0000)\u0000\u0012\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000"+
		"\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006\"\u0001\u0000\u0000\u0000"+
		"\b$\u0001\u0000\u0000\u0000\n\'\u0001\u0000\u0000\u0000\f*\u0001\u0000"+
		"\u0000\u0000\u000e,\u0001\u0000\u0000\u0000\u0010.\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005\u0000\u0000\u0001"+
		"\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0016\u0003\u0006\u0003\u0000"+
		"\u0016\u0017\u0003\u0004\u0002\u0000\u0017\u0003\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0005\u0005\u0000\u0000\u0019\u001a\u0003\u0006\u0003\u0000"+
		"\u001a\u001b\u0003\u0004\u0002\u0000\u001b\u001f\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0005\u0005\u0000\u0000\u001d\u001f\u0003\u0006\u0003\u0000"+
		"\u001e\u0018\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001f\u0005\u0001\u0000\u0000\u0000 #\u0003\b\u0004\u0000!#\u0003\n\u0005"+
		"\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0007\u0001"+
		"\u0000\u0000\u0000$%\u0003\f\u0006\u0000%&\u0003\u000e\u0007\u0000&\t"+
		"\u0001\u0000\u0000\u0000\'(\u0003\f\u0006\u0000()\u0003\u0010\b\u0000"+
		")\u000b\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000+\r\u0001\u0000"+
		"\u0000\u0000,-\u0005\u0003\u0000\u0000-\u000f\u0001\u0000\u0000\u0000"+
		"./\u0005\u0002\u0000\u0000/\u0011\u0001\u0000\u0000\u0000\u0002\u001e"+
		"\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}