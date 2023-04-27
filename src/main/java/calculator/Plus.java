package calculator;

import visitor.TimeVisitor;

import java.math.BigDecimal;
import java.util.List;

/** This class represents the arithmetic sum operation "+".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Minus
 * @see Times
 * @see Divides
 */
public final class Plus extends Operation
{

    /**
     * Class constructor specifying a number of Expressions to add.
     *
     * @param elist The list of Expressions to add
     * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
     * @see #Plus(List<Expression>,Notation)
     */
    public /*constructor*/ Plus(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to add,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of Expressions to add
     * @param n The Notation to be used to represent the operation
     * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
     * @see #Plus(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Plus(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "+";
        neutral = 0;
    }

    /**
     * The actual computation of the (binary) arithmetic addition of two integers
     * @param l The first integer
     * @param r The second integer that should be added to the first
     * @return The integer that is the result of the addition
     */
    public int op(int l, int r) {
        return (l+r);
    }
    /**
     * The actual computation of the (binary) arithmetic addition of two real numbers
     * @param l first argument of the binary operation
     * @param r second argument of the binary operation
     * @return The real number that is the result of the addition
     */
    @Override
    public BigDecimal op(BigDecimal l, BigDecimal r) {
        return l.add(r,mathContext);
    }


    /**
     * The actual computation of the (binary) arithmetic addition of two rational numbers
     *
     * @param l The first rational number
     * @param r The second rational number that should be added to the first
     * @return The rational number that is the result of the addition
     */
    @Override
    public MyRationalNumber op(MyRationalNumber l, MyRationalNumber r) {
        return l.add(r);
    }
    @Override
    public MyTime op(MyTime l, MyRealNumber seconds) {
        return l.add(seconds);
    }
    @Override
    public MyTime op(MyTime l, MyTime r) {
        throw new RuntimeException("Sorry, you can't add two dates");
    }

    @Override
    public void accept(TimeVisitor v) {
        v.visit(this);
    }
}
