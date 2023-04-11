package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class Modulus extends Operation
{
    public /*constructor*/ Modulus(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to modulus,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of Expressions to multiply
     * @param n The Notation to be used to represent the operation
     * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
     * @see #Modulus(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Modulus(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "*";
        neutral = 1;
    }

    public MyNumber op(MyNumber l, MyNumber r) {
        MyNumber a = new MyNumber(l.getValue(),l.getexp());
        MyNumber b = new MyNumber(l.getImaginary(),l.getImaginaryExp());


        try{
            MyNumber tmp1 = new Times(args).op(a,a);
            MyNumber tmp2 = new Times(args).op(b,b);
            MyNumber tmp = new Plus(args).op(tmp1,tmp2);

            BigDecimal sqrt = tmp.getValue().sqrt(MathContext.DECIMAL128);
            return  new MyNumber(sqrt,tmp.getexp());
        }
        catch (IllegalConstruction e)
        {
            return l;
        }
    }

    /**
     * The actual computation of the arithmetic modulus of a number
     * @param n The number
     * @return The number that is the result of the modulus
     */
    public MyNumber op(MyNumber n) {
        return op(n , null);
    }
}
