package calculator;

import java.math.BigInteger;
import java.util.List;

final public class Minus extends Operation {

    public /*constructor*/ Minus(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "-";
        neutral = BigInteger.ZERO;
    }

    public Minus(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "-";
        neutral = BigInteger.ZERO;
    }

    public BigInteger op(BigInteger l, BigInteger r) {
        return (l.subtract(r));
    }
}
