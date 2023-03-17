package calculator.arithmetics;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Notation;
import calculator.Operation;

import java.util.List;

public class Facto extends Operation
{
    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     *
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
     *
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public Facto(List<Expression> elist, Notation notation) throws IllegalConstruction
    {
        super(elist, notation);
        symbol = "!";
        neutral = 1;
    }


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
     * Abstract method representing the actual binary arithmetic operation to compute
     *
     * @param l first argument of the binary operation
     * @param r second argument of the binary operation
     * @return result of computing the binary operation
     */
    @Override
    public int op(int l, int r)
    {
        return facto(l);
    }
}
