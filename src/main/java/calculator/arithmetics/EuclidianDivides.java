package calculator.arithmetics;

import calculator.*;

import java.util.List;


/**
 * Class to implement : euclidean division
 * @author Randi-Dcht
 * @param : elist The list of expressions passed as argument to the arithmetic operation
 * @param : notation The notation used to display the operation
 * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
 */
public class EuclidianDivides extends Operation
{


    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public EuclidianDivides(List<Expression> elist) throws IllegalConstruction
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
    public EuclidianDivides(List<Expression> elist, Notation notation) throws IllegalConstruction
    {
        super(elist, notation);
        symbol = "//";
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
        return new MyNumber( euclidianDivision(l.getInteger(), r.getInteger())[1]);
    }


    /**
     * Algorithm to compute the euclidean division
     * @param a : integer
     * @param b : integer
     * @return euclidean division (integer)
     */
    public int[] euclidianDivision(int a, int b)
    {
        if (b == 0)
            return new int[]{-1, -1};

         int q = 0;
         int r = a;

         while (r >= b)
         {
             r -= b;
             q++;
         }
         return new int[]{q, r};
    }


    /**
     * Abstract method representing the actual binary arithmetic operation to compute
     * @param l first argument of the binary operation
     * @param r second argument of the binary operation
     * @return result of computing the binary operation (remainder)
     */
}
