package visitor;

import calculator.Expression;
import calculator.MyBoolean;
import calculator.MyNumber;
import calculator.Operation;

import java.util.ArrayList;

public class Evaluator extends Visitor {

    private int computedValue;
    private boolean computedBoolValue;

    public Integer getResult() { return computedValue; }

    public Boolean getBoolResult(){return computedBoolValue;}

    public void visit(MyNumber n) {
        computedValue = n.getValue();
    }

    public void visit(Operation o) {
        ArrayList<Integer> evaluatedArgs = new ArrayList<>();
        ArrayList<Boolean> evaluatedBoolArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
            evaluatedBoolArgs.add(computedBoolValue);
        }
        //second loop to accummulate all the evaluated subresults
        int temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;

        boolean tempBool = evaluatedBoolArgs.get(0);
        for (int i=1; i<evaluatedBoolArgs.size(); i++){
            tempBool = o.op(tempBool, evaluatedBoolArgs.get(i));
        }

        computedBoolValue = tempBool;

    }

    @Override
    public void visit(MyBoolean b) {
        computedBoolValue = b.getValue();
    }


}
