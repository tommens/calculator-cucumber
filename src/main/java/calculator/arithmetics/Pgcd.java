package calculator.arithmetics;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Notation;
import calculator.Operation;
import java.util.List;


public class Pgcd extends Operation
{

    /**
     * It is not allowed to construct an operation with a null list of expressions.
     * Note that it is allowed to have an EMPTY list of arguments.
     *
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    protected Pgcd(List<Expression> elist) throws IllegalConstruction
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
    protected Pgcd(List<Expression> elist, Notation notation) throws IllegalConstruction
    {
        super(elist, notation);
        symbol = "pgcd";
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
    public int op(int l, int r)
    {
        return 0;
    }
}
