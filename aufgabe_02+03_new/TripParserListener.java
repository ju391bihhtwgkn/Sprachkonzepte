// Generated from ./TripParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TripParser}.
 */
public interface TripParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TripParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TripParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TripParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(TripParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(TripParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#multiline}.
	 * @param ctx the parse tree
	 */
	void enterMultiline(TripParser.MultilineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#multiline}.
	 * @param ctx the parse tree
	 */
	void exitMultiline(TripParser.MultilineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TripParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TripParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#datevalue}.
	 * @param ctx the parse tree
	 */
	void enterDatevalue(TripParser.DatevalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#datevalue}.
	 * @param ctx the parse tree
	 */
	void exitDatevalue(TripParser.DatevalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#entryvalue}.
	 * @param ctx the parse tree
	 */
	void enterEntryvalue(TripParser.EntryvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#entryvalue}.
	 * @param ctx the parse tree
	 */
	void exitEntryvalue(TripParser.EntryvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(TripParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(TripParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(TripParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(TripParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link TripParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(TripParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TripParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(TripParser.EntryContext ctx);
}