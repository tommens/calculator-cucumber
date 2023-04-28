package visitor;

import calculator.Expression;
import calculator.Operation;

public class Counter implements CounterVisitor{

    private int countDepth=0, countOps=0, countNbs=0;
    @Override
    public void visit(Expression expression) {
        visit(expression, 0);

    }

    private void visit(Expression expression, int currentDepth){
        if (expression instanceof Operation) {
            for (Expression e : ((Operation) expression).getArgs()) {
                visit(e, currentDepth+1);
            }
            updateCounters(currentDepth+1, 1, 0);


        } else {
            updateCounters(currentDepth, 0, 1);
        }

    }

    private void updateCounters(int depth, int ops, int nbs) {
        if (depth > countDepth) {
            countDepth = depth;
        }
        countOps += ops;
        countNbs += nbs;
    }

    public int getCountDepth() {
        return countDepth;
    }

    public int getCountOps() {
        return countOps;
    }

    public int getCountNbs() {
        return countNbs;
    }
}
