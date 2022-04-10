package visitor;

import calculator.*;
import calculator.Number;

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
        //second loop to accumulate all the evaluated subresults
        Number temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;
    }

    public void visit(Function f) {
        // Evaluate the expression
        f.getArgs().get(0).accept(this);

        Real argument = getResult().toReal(); // Assume for now that all functions are on reals
        // store the accumulated result
        computedValue = f.op(argument); // compute the result
    }

}
