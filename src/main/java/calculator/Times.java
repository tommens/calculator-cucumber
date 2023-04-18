package calculator;

import java.math.BigDecimal;
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
        int exp2;
        int exp3;
        int exp4;

        BigDecimal a = l.getValue();
        BigDecimal c = r.getValue();
        int a_exp = l.getexp();
        int c_exp = r.getexp();

        BigDecimal b = l.getImaginary();
        BigDecimal d = r.getImaginary();
        int b_exp = l.getImaginaryExp();
        int d_exp = r.getImaginaryExp();

        new_val=a.multiply(c);
        exp=a_exp+c_exp;
        MyNumber tmp1 = new MyNumber(new_val,exp);

        new_val=b.multiply(d);
        exp2=b_exp+d_exp;
        MyNumber tmp2 = new MyNumber(new_val,exp2);

        new_val=a.multiply(d);
        exp3=a_exp+d_exp;
        MyNumber tmp3 = new MyNumber(new_val,exp3);

        new_val=b.multiply(c);
        exp4=b_exp+c_exp;
        MyNumber tmp4 = new MyNumber(new_val,exp4);

        try{
            MyNumber real = new Minus(args).op(tmp1,tmp2);
            MyNumber imaginary = new Plus(args).op(tmp3,tmp4);

            return new MyNumber(real.getValue(), real.getexp(), imaginary.getValue(),imaginary.getexp());
        }
        catch (IllegalConstruction e)
        {
            return l;
        }
    }
}
