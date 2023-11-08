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
                        "DepartureDate:    1/1/23\n" +
                        "ReturnDate: 23/11/2023\n" +
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
        System.out.printf("\nTrip.toString() = \n%s%n", ast);

        if(staticSemanticTest(ast.toString())){
            System.out.println("Static Test successful");
        } else{
            System.exit(1);
        }
        if(dynamicSemanticTest(ast.toString())){
            System.out.println("Dynamic Test successful");
        } else{
            System.exit(1);
        }

    }

    /*Entry muss 5 - 20 Zeichen haben*/
    public static boolean staticSemanticTest(String ast) {
        int count = 0;
        int startIndex = -1;
        for (int i = 0; i < ast.length(); i++) {
            char c = ast.charAt(i);
            if (c == '[') {
                startIndex = i;
            } else if (c == ']' && startIndex != -1) {
                count += (i - startIndex + 1);
                if(count < 5 && count > 20){
                    System.out.println("Statischer Fehler, Entry hat nicht 5-20 Zeichen");
                    System.exit(1);
                }
                startIndex = -1;
            }
        }
        return true;
    }
    

    /*2. Datum muss zeitlich später sein als erstes*/
    public static boolean dynamicSemanticTest(String ast) {
        String datePattern = "(\\d{1,2}/\\d{1,2}/\\d{2,4})";
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(ast);

        int count = 0;
        String[] dates = new String[2]; // Store up to two dates for comparison

        while (matcher.find()) {
            if (count >= 2) {
                System.out.println("Found more than 2 DATE expressions. Comparing the first 2 dates.");
                break;
            }
            dates[count] = matcher.group(1);
            count++;
        }

        if (count == 2) {
            String[] date1Parts = dates[0].split("/");
            String[] date2Parts = dates[1].split("/");
            if (date1Parts.length == 3 && date2Parts.length == 3) {
                int day1 = Integer.parseInt(date1Parts[0]);
                int month1 = Integer.parseInt(date1Parts[1]);
                int year1 = Integer.parseInt(date1Parts[2]);

                int day2 = Integer.parseInt(date2Parts[0]);
                int month2 = Integer.parseInt(date2Parts[1]);
                int year2 = Integer.parseInt(date2Parts[2]);

                if (year1 < year2 || (year1 == year2 && month1 < month2) || (year1 == year2 && month1 == month2 && day1 < day2)) {
                    System.out.println("The first date is earlier than the second date.");
                    return true;
                } else if (year1 == year2 && month1 == month2 && day1 == day2) {
                    System.out.println("The two dates are the same.");
                    return false;
                } else {
                    System.out.println("The first date is later than the second date.");
                    return false;
                }
            }
        } else {
            System.out.println("Insufficient DATE expressions found for comparison.");
            return false;
        }
        return false;
    }
}
