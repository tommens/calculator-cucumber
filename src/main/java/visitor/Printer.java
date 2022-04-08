package visitor;

import calculator.Expression;
import calculator.Number;
import calculator.Operation;

import java.util.ArrayList;

public abstract class Printer extends Visitor {

    protected String printBuffer = "";

    public String getBuffer() {
        return printBuffer;
    }

    @Override
    public void visit(Number n) {
        printBuffer = n.toString();
    }


    @Override
    public void visit(Operation o) {
        ArrayList<String> printedStrings = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            printedStrings.add(printBuffer);
            printBuffer = "";
        }
        int max = o.args.size();
        String temp = "";
        for(int counter=1; counter<max; counter++) {
            temp = writeExpression(o, printedStrings, counter);
        }
        printBuffer = temp;
    }

    protected abstract String writeExpression(Operation o, ArrayList<String> strings, int counter);

}
