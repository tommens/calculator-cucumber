package visitor;

import calculator.Expression;
import calculator.MyNumber;
import calculator.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * RealNumberEvaluator is a concrete visitor that serves to
 * compute and evaluate the result of arithmetic expressions
 */
public class RealNumberEvaluator extends Visitor {

    /**
     * The result of the evaluation will be stored in this private variable
     */
    private BigDecimal computedValue;


    /**
     * Getter method to obtain the result of the evaluation
     *
     * @return a BigDecimal object containing the result of the evaluation
     */
    public BigDecimal getResult() {
        return computedValue;
    }

    /**
     * Use the visitor design pattern to visit a number.
     *
     * @param n The number being visited
     */
    @Override
    public void visit(MyNumber n) {
        computedValue = n.getRealNumber();
    }

    /**
     * Use the visitor design pattern to visit an operation
     *
     * @param o The operation being visited
     */
    @Override
    public void visit(Operation o) throws ArithmeticException{
        ArrayList<BigDecimal> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for (Expression a : o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }
        //second loop to accumulate all the evaluated subresults
        BigDecimal temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for (int counter = 1; counter < max; counter++) {
            temp = o.op(temp, evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;
    }
}
