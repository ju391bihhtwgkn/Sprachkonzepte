import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Stack;

public final class TripBuilder extends TripParserBaseListener {
    private Stack<Trip> stack = new Stack<Trip>();
    int multcounter = 1;

    public Trip build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitValue(TripParser.ValueContext ctx) {
        String value = ctx.getText();
        stack.push(new Value(value));
        System.out.println("Value to add to stack: " + value);

    }

    @Override
    public void exitLine(TripParser.LineContext ctx) {
        String value = ctx.value().getText();
        Trip right = stack.pop(); // The right child
        stack.push(new Line(value, right));
        System.out.println("Line to add to stack: " + value);

    }

    @Override
    public void exitMultiline(TripParser.MultilineContext ctx) {
        String newline = ctx.NEWLINE().getText();


        if (ctx.multiline() != null) {
            Trip right = stack.pop();
            Trip value = stack.pop();
            stack.push(new MultiLine(newline, value, right));
            System.out.println("MultiLineRight to add to stack: " +  right);

        } else {
            Trip value = stack.pop();
            stack.push(new MultiLine(newline, value));
            System.out.println("MultiLine to add to stack: " + newline+ value);
        }
    }


}


