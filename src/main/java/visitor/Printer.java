package visitor;

import calculator.Expression;

public class Printer extends Evaluator {

    final private Expression currentExpression;

    public Printer(Expression e) {
        this.currentExpression = e;
        e.accept(this);
    }

    public void print() {
        System.out.println("The result of evaluating expression " + currentExpression);
        System.out.println("is: " + getResult() + ".");
        System.out.println();
    }

    public void printBool(){
        System.out.println("The result of evaluating expression " + currentExpression);
        System.out.println("is: " + getBoolResult() + ".");
        System.out.println();
    }

    public void detailedPrint() {
        print();
        System.out.print("It contains " + currentExpression.countDepth() + " levels of nested expressions, ");
        System.out.print(currentExpression.countOps() + " operations");
        System.out.println(" and " + currentExpression.countNbs() + " numbers.");
        System.out.println();
    }
}
