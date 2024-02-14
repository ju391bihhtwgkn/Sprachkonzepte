import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public final class TripToAst {
    private TripToAst() { }

    public static void main(String[] args) throws Exception {
        TripLexer lexer = new TripLexer(CharStreams.fromString(
                "TripTitle: [Sales Conference in New York]\n" +
                        "ArrivalDate:    1/111/24\n" +
                        "DepartureDate:    03/01/2023\n" +
                        "City:       [New York City]\n" +
                        "Country: [United States]\n" +
                        "Purpose:    [Discuss sales strategy and meet with clients.]"));
        TripParser parser = new TripParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n", parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        Trip ast = new TripBuilder().build(tree);
        System.out.printf("\nTrip.toString() = \n%s%n", ast.toString());

        //dynamische Semantik -> Weiterverarbeitung des ASTs -> Dates werden geparsed und verglichen
        LocalDate startDate = ast.findTripStartDate();
        System.out.println("Trip starts on: " + startDate);

    }

}
