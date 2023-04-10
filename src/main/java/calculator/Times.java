package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/** This class represents the arithmetic multiplication operation "*".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Minus
 * @see Plus
 * @see Divides
 */
public final class Times extends Operation {
    /**
     * Class constructor specifying a number of Expressions to multiply.
     *
     * @param elist The list of Expressions to multiply
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Times(List<Expression>,Notation)
     */
    public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to multiply,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of Expressions to multiply
     * @param n     The Notation to be used to represent the operation
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Times(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Times(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "*";
        neutral = 1;
    }


    /**
     * The actual computation of the (binary) arithmetic multiplication of two BigDecimal number
     *
     * @param l The first BigDecimal number
     * @param r The second BigDecimal number that should be multiplied with the first
     * @return The BigDecimal number that is the result of the multiplication
     */

    //public int op(int l, int r) { return (l*r); }
    public MyNumber op(MyNumber l, MyNumber r) {
        BigDecimal new_val;
        int exp;

        BigDecimal l_val = l.getValue();
        BigDecimal r_val = r.getValue();
        int l_exp = l.getexp();
        int r_exp = r.getexp();

        new_val=l_val.multiply(r_val);
        exp=l_exp+r_exp;

        return new MyNumber(new_val, exp);
    }
}
