package calculator;

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

    public MyNumber op(MyNumber n1, MyNumber n2) {
        int a = n1.getValue();
        int b = n1.getImaginary();

        int r = (int)Math.sqrt((a * a) + (b * b));
        return new MyNumber(r,0);
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
