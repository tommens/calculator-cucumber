package calculator;

import java.math.BigInteger;
import java.util.List;

final public class Exponents extends Operation {

    public /*constructor*/ Exponents(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "^";
        neutral = BigInteger.ONE;
    }

    public Exponents(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "^";
        neutral = BigInteger.ONE;
    }

    public BigInteger op(BigInteger l, BigInteger r) {
        return (l.pow(r.intValue()));
    }
}

