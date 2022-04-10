package visitor;

import calculator.Expression;
import calculator.Function;
import calculator.Number;
import calculator.Operation;

import java.util.ArrayList;

public class Evaluator extends Visitor {

    private Number computedValue;

    public Number getResult() { return computedValue; }

    public void visit(Number n) {
        computedValue = n;
    }

    public void visit(Operation o) {
        ArrayList<Number> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }
        //second loop to accummulate all the evaluated subresults
        Number temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;
    }

    public void visit(Function f) {

    }

}
