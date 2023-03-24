package calculator;

import visitor.Visitor;

/**
 * Numbi is an abstract class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
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
     * The getValue method is used to obtain the value contained in the object
     * @return The value contained in the object
     */
    public abstract <E extends Number> E getValue();
}
