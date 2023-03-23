package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/** This class represents the arithmetic division operation "/".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Minus
 * @see Times
 * @see Plus
 */
public final class Divides extends Operation {

    /**
     * Class constructor specifying a number of Expressions to divide.
     *
     * @param elist The list of Expressions to divide
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Divides(List<Expression>,Notation)
     */
    public /*constructor*/ Divides(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to divide,
     * as well as the notation used to represent the operation.
     *
     * @param elist The list of Expressions to divide
     * @param n     The Notation to be used to represent the operation
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     * @see #Divides(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Divides(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "/";
        neutral = 1;
    }

    /**
     * The actual computation of the (binary) arithmetic division of two BigDecimal number
     *
     * @param l The first BigDecimal number
     * @param r The second BigDecimal number that should divide the first
     * @return The BigDecimal number that is the result of the division
     */

      /*public Double op(int l, int r) {
      Double res = (double) l / (double) r;
      return res; }
      */
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
            new_val = l_val.add(r_val.divide(BigDecimal.valueOf(10 * gap), MathContext.DECIMAL128));

        } else if (l_exp < r_exp) {
            exp = r_exp;
            int gap = r_exp - l_exp;
            new_val = r_val.add(l_val.divide(BigDecimal.valueOf(10 * gap), MathContext.DECIMAL128));
        } else {
            exp = l_exp;
            new_val = r_val.add(l_val);
        }


        return new MyNumber(new_val, exp);
    }
}
