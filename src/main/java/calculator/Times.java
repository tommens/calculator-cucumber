package calculator;

import java.math.BigInteger;
import java.util.List;

final public class Times extends Operation {

    public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "*";
        neutral = BigInteger.ONE;
    }

    public Times(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "*";
        neutral = BigInteger.ONE;
    }

    public BigInteger op(BigInteger l, BigInteger r) {
        return (l.multiply(r));
    }
}
