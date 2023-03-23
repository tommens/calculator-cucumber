package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/** This class represents the arithmetic operation "-".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Plus
 * @see Times
 * @see Divides
 */
public final class Minus extends Operation {

    /**
     * Class constructor specifying a number of Expressions to subtract.
     *
     * @param elist The list of Expressions to subtract
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Minus(List<Expression>,Notation)
     */
    public /*constructor*/ Minus(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to subtract,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of Expressions to subtract
     * @param n     The Notation to be used to represent the operation
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Minus(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Minus(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "-";
        neutral = 0;
    }

    /**
     * The actual computation of the (binary) arithmetic subtraction of two integers
     *
     * @param l The first BigDecimal number
     * @param r The second BigDecimal number that should be subtracted from the first
     * @return The BigDecimal number that is the result of the subtraction
     */
    //public int op(int l, int r) {return (l-r);}
    public MyNumber op(MyNumber l, MyNumber r) {
        BigDecimal new_val;
        int exp;

        BigDecimal l_val = l.getValue();
        BigDecimal r_val = r.getValue();
        int l_exp = l.getexp();
        int r_exp = r.getexp();

        if (l_exp > r_exp) {
            exp = l_exp;
            int gap = l_exp - r_exp;
            new_val = l_val.subtract(r_val.divide(BigDecimal.valueOf(10 * gap), MathContext.DECIMAL128));

        } else if (l_exp < r_exp) {
            exp = r_exp;
            int gap = r_exp - l_exp;
            new_val = r_val.subtract(l_val.divide(BigDecimal.valueOf(10 * gap), MathContext.DECIMAL128));
        } else {
            exp = l_exp;
            new_val = r_val.subtract(l_val);
        }
        return new MyNumber(new_val, exp);
    }
}
