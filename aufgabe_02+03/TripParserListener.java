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
}