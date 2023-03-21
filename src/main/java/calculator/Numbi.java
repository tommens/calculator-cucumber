package calculator;

import calculator.Expression;
import visitor.Visitor;

// add extend Number to make it a number

public abstract class Numbi implements Expression
{
    /**
     * accept is a method needed to implement the visitor design pattern
     *
     * @param v The visitor object being passed as a parameter
     */
    //@Override
    public void accept(Visitor v)
    {
        v.visit(this);
    }

    /**
     * Counts the depth of nested expressions in an arithmetic expression
     * @return The depth of an arithmetic expression
     */
    //@Override
    public abstract <E extends Number> E countDepth();

    /**
     * Counts the number of operations recursively contained in an arithmetic expression
     * @return The number of operations contained in an arithmetic expression
     */
    //@Override
    public abstract <E extends Number> E countOps();
    /**
     * Counts the number of values recursively contained in an arithmetic expression
     * @return The number of values contained in an arithmetic expression
     */
    //@Override
    public abstract <E extends Number> E countNbs();

    public abstract <E extends Number> E getValue();
}
