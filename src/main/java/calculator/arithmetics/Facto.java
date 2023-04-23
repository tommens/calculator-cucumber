package calculator.arithmetics;

import calculator.*;

import java.util.List;

/**
 * Class to implement : factorial
 * @author Randi-Dcht
 */
public class Facto extends Operation
{


    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public Facto(List<Expression> elist) throws IllegalConstruction
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
    public Facto(List<Expression> elist, Notation notation) throws IllegalConstruction
    {
        super(elist, notation);
        symbol = "!";
        neutral = 1;
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
        return new MyNumber(facto(l.getInteger()));
    }


    /**
     * Allows to compute the factorial of a number
     * @param a : integer
     * @return a factorial (integer)
     */
    private int facto(int a)
    {
        int result = 1;
        for (int i = 1; i <= a; i++)
        {
            result *= i;
        }
        return result;
    }


    /**
     * Surcharge of op
     * @param l : integer
     */
    public MyNumber op(int l)
    {
        return op(new MyNumber(l), new MyNumber(0));
    }
}
