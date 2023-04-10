package calculator;

import java.util.List;
import java.math.BigInteger;

import static calculator.Utils.computeGCD;

public class GreatestCommonDivisor extends Operation{
    public GreatestCommonDivisor(List<Expression> elist) throws IllegalConstruction {
        super(elist);
    }

    public GreatestCommonDivisor(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "GCD";
    }


    @Override
    public int op(int l, int r) {
        return computeGCD(l,r);
    }
}
