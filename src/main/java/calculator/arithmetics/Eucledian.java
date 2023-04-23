package calculator.arithmetics;

import calculator.*;

import java.util.List;


/**
 * Class to implement : euclidean
 * @author Randi-Dcht
 */
public class Eucledian extends Operation
{


    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public Eucledian(List<Expression> elist) throws IllegalConstruction
    {
        this(elist, null);
    }


    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @param notation The notation used to display the operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public Eucledian(List<Expression> elist, Notation notation) throws IllegalConstruction
    {
        super(elist, notation);
        symbol = "gcd";
        neutral = 0;
    }

    /**
     * Abstract method representing the actual binary arithmetic operation to compute
     *
     * @param l first argument of the binary operation
     * @param r second argument of the binary operation
     * @return result of computing the binary operation
     */
    @Override
    public MyNumber op(MyNumber l, MyNumber r)
    {
        return new MyNumber(eucledianAlgo(l.getInteger(), r.getInteger()));
    }


    /**
     * Algorithm to compute the eucledian
     * @param a : integer
     * @param b : integer
     * @return eucledian (integer)
     */
    private int eucledianAlgo(int a, int b)
    {
        if (b == 0)
            return a;
        return eucledianAlgo(b, a % b);
    }
}
