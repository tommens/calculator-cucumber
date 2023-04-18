package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static java.lang.Math.pow;

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

    private MyNumber subtraction(BigDecimal l, int l_exp, BigDecimal r, int r_exp){
        BigDecimal new_val;
        int exp;

        if (l_exp > r_exp) {
            exp = l_exp;
            int gap = l_exp - r_exp;
            new_val = l.subtract(r.divide(BigDecimal.valueOf(pow(10,gap)), MathContext.DECIMAL128));

        } else if (l_exp < r_exp) {
            exp = l_exp;
            int gap = r_exp - l_exp;
            new_val = l.subtract(r.multiply(BigDecimal.valueOf(pow(10,gap))), MathContext.DECIMAL128);
        } else {
            exp = l_exp;
            new_val = l.subtract(r);
        }

        return new MyNumber(new_val,exp);

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

        BigDecimal l_val = l.getValue();
        BigDecimal r_val = r.getValue();
        int l_exp = l.getexp();
        int r_exp = r.getexp();

        MyNumber real = subtraction(l_val,l_exp,r_val,r_exp);

        BigDecimal li_val =  l.getImaginary();
        BigDecimal ri_val =  r.getImaginary();
        int li_exp = l.getImaginaryExp();
        int ri_exp = r.getImaginaryExp();

        MyNumber imaginary = subtraction(li_val,li_exp,ri_val,ri_exp);

        return new MyNumber(real.getValue(),real.getexp(),imaginary.getValue(),imaginary.getexp());
    }
}
