import java.util.regex.*;

public class Aufgabe01 {
    public static void main(String[] args) {
        String[] inputs = {
            "xxx %d yyy%n",
            "xxx% 012d yyy%%",
            "xxx%1$d yyy",
            "%1$0+(32.10fyyy",
            "Wochentag: %tA Uhrzeit: %tT"
        };

        for (String input : inputs) {
            findFormatSpecifiers(input);
        }
    }
    public static void findFormatSpecifiers(String input) {

        String regex = getFormatterRegex();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int prevEnd = 0;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            String text = input.substring(prevEnd, start);
            String specifier = input.substring(start, end);

            if(!text.isEmpty()) {
                System.out.printf("TEXT(\"%s\")", text);
            }
            System.out.printf("FORMAT(\"%s\")", specifier);

            prevEnd = end;
        }

        if (prevEnd < input.length()) {
            String text = input.substring(prevEnd);
            System.out.printf("TEXT(\"%s\")", text);
        }

        System.out.println();
    }


    //   according to java.util.Formatter
    //   %[argument_index$][flags][width][.precision]conversion
    private static String getFormatterRegex() {
        String argumentIndexRegex = "%(\\d+\\$)?";
        String flagsRegex = "([-#+ 0,(]*)";
        String widthRegex = "(\\d+)?";
        String precisionRegex = "(\\.\\d+)?";
        String conversionRegex = "[a-zA-Z%]";

        // Time-related specifiers
        String timeSpecifierRegex = "[tT]([a-zA-Z])";

        return argumentIndexRegex + flagsRegex + widthRegex + precisionRegex + "(" + timeSpecifierRegex + "|" + conversionRegex + ")";
    }
}
