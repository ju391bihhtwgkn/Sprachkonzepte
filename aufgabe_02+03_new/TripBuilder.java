import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class TripBuilder extends TripParserBaseListener {
    private final Stack<Trip> stack;

    public TripBuilder() {
        this.stack = new Stack<>();
        List<Line> lines = new ArrayList<>(); // Create an empty list of lines
        Trip trip = new Trip(lines); // Pass the empty list to the Trip constructor
        stack.push(trip);
    }

    public Trip build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);

        Trip trip = stack.pop();
        return trip;
    }

    @Override
    public void enterDatevalue(TripParser.DatevalueContext ctx) {
        Trip trip = stack.pop();

        String title = ctx.getChild(0).getText(); // Get text of first child (TITLE)
        String date = ctx.getChild(1).getText(); // Get text of second child (DATE)

        DateLine dateLine = new DateLine(title, date);

        trip.addLine(dateLine);

        stack.push(trip);
    }

    @Override
    public void enterEntryvalue(TripParser.EntryvalueContext ctx) {
        Trip trip = stack.pop();

        String title = ctx.getChild(0).getText(); // Get text of first child (TITLE)
        String entry = ctx.getChild(1).getText(); // Get text of second child (ENTRY)

        EntryLine entryLine = new EntryLine(title, entry);

        //statische Semantiküberprüfung direkt beim Erzeugen des AST-Objekts
        if(entryLine.check()){
            System.out.println("Statische Überprüfung erfolgreich: Entry < 50 ");
        }else {
            throw new RuntimeException("Entry ist länger als 50 Zeichen.");
        }

        trip.addLine(entryLine);

        stack.push(trip);
    }
}
