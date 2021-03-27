package calculator;

import java.math.BigInteger;
import java.util.List;

final public class Plus extends Operation {

    public /*constructor*/ Plus(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "+";
        neutral = BigInteger.ZERO;
    }

    public Plus(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "+";
        neutral = BigInteger.ZERO;
    }

    public BigInteger op(BigInteger l, BigInteger r) {
        return (l.add(r));
    }
}
