package calculator;

import visitor.TimeVisitor;
import visitor.Visitor;

import java.math.BigDecimal;

/**
 * MyNumber is an abstract class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
public abstract class MyNumber implements Expression {

    /**
     * abstract method to obtain the integer value contain in the object
     *
     * @return The integer number contain in the object
     */
    public abstract Integer getInteger();

    /**
     * abstract method to obtain the real number contain in the object
     *
     * @return The real number contained in the object
     */
    public abstract BigDecimal getRealNumber();


    /**
     * abstract method to obtain the rational number corresponding to the value of the object
     *
     * @return The rational number contain in the object
     */
    public abstract MyRationalNumber getRational() throws ArithmeticException;

    /**
     * accept method to implement the visitor design pattern to traverse arithmetic expressions.
     * Each number will pass itself to the visitor object to get processed by the visitor.
     *
     * @param v	The visitor object
     */
  public void accept(Visitor v) throws ArithmeticException{
      v.visit(this);
  }



    @Override
    public void accept(TimeVisitor v) {}

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
