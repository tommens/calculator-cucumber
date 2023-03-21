package calculator;

import java.util.List;
import java.lang.Math;

public class Sqrt extends Operation
{
    public /*constructor*/ Sqrt(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    /**
     * Class constructor specifying a number of Expressions to square root,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of Expressions to multiply
     * @param n The Notation to be used to represent the operation
     * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
     * @see #Sqrt(List<Expression>)
     * @see Operation#Operation(List<Expression>,Notation)
     */
    public Sqrt(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "*";
        neutral = 1;
    }

    public MyNumber op(MyNumber n1, MyNumber n2) {
        int a = n1.getValue();
        int r = 0;
        int i = 0;
        if(!n1.isComplex()){
            if(a<0){
                double tmp = a * -1;
                i = (int)Math.sqrt(tmp);
            }
            else {
                r = (int)Math.sqrt(a);
            }
        }
        else{
            int b = n1.getImaginary();

            int z = (int)Math.sqrt((a * a) + (b * b));

            r = (int)Math.sqrt((double)(z+a)/2);

            i =(b/Math.abs(b)) * (int)Math.sqrt((double)(z-a)/2);
        }

        return new MyNumber(r,i);

    }

    /**
     * The actual computation of the (binary) arithmetic square root of one number
     * @param n The number
     * @return The number that is the result of the square root
     */
    public MyNumber op(MyNumber n) {
        return op(n , null);
    }
}

