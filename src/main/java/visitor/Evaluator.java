package visitor;

import calculator.Expression;
import calculator.MyBoolean;
import calculator.Number;
import calculator.Operation;

import java.util.ArrayList;

public class Evaluator extends Visitor {

    private MyBoolean computedBoolvalue;
    private Number computedValue;

    public Number getResult() { return computedValue; }

    public MyBoolean getBoolresult(){return computedBoolvalue;}



    public void visit(Operation o) {
        ArrayList<Number> evaluatedArgs = new ArrayList<>();
        ArrayList<MyBoolean> evaluatedBoolArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
            evaluatedBoolArgs.add(computedBoolValue);
        }
        //second loop to accummulate all the evaluated subresults
        Number temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;

        MyBoolean tempBool = evaluatedBoolArgs.get(0);
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
