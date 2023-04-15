package visitor;

import calculator.Expression;
import calculator.MyNumber;
import calculator.MyTime;
import calculator.Operation;

import java.util.ArrayList;

public class TimeEvaluator extends TimeVisitor{
    /** The result of the evaluation will be stored in this private variable */
    private MyTime computedValue;

    /** getter method to obtain the result of the evaluation
     *
     * @return an Integer object containing the result of the evaluation
     */
    public MyTime getResult() { return computedValue; }

    /** Use the visitor design pattern to visit a number.
     *
     * @param t The number being visited
     */
    public void visit(MyTime t) {
        computedValue = t;
    }

    /** Use the visitor design pattern to visit an operation
     *
     * @param o The operation being visited
     */
    public void visit(Operation o) {
        ArrayList<MyTime> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }
        //second loop to accumulate all the evaluated sub-results
        MyTime temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;
    }
}
