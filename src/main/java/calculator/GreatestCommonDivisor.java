package calculator;

import visitor.TimeVisitor;

import java.math.BigDecimal;
import java.util.List;

public class GreatestCommonDivisor extends Operation {
    public GreatestCommonDivisor(List<Expression> elist) throws IllegalConstruction {
        super(elist);
    }

    public GreatestCommonDivisor(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "GCD";
    }


    @Override
    public int op(int l, int r) {
        return Math.toIntExact(Utils.gcd((long) l, (long) r));
    }

    @Override
    public MyTime op(MyTime l, MyTime r) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyTime op(MyTime l, MyRealNumber seconds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal op(BigDecimal l, BigDecimal r) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyRationalNumber op(MyRationalNumber l, MyRationalNumber r) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(TimeVisitor v) {
        throw new UnsupportedOperationException();
    }
}
