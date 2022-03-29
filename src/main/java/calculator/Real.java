package calculator;

import java.math.BigDecimal;
import java.math.BigInteger;


public class Real extends Number implements Comparable<BigDecimal>{
     private BigDecimal value;

    public /*constructor*/ Real(BigDecimal value) {
        this.value = value;
    }

    @Override
    public Number negate() {
        return new Real(value.negate());
    }

    @Override
    public Number add(Number val) {
        return null;
    }

    @Override
    protected Number add(Rational rat) {
        return null;
    }

    @Override
    protected Number add(Real r) {
        return null;
    }

    @Override
    public Number multiply(Number val) {
        return null;
    }

    @Override
    protected Number multiply(Rational rat) {
        return null;
    }

    @Override
    protected Number multiply(Real r) {
        return null;
    }

    @Override
    public Number divide(Number val) {
        return null;
    }

    @Override
    protected Number divide(Rational rat) {
        return null;
    }

    @Override
    protected Number divide(Real r) {
        return null;
    }

    @Override
    public int compareTo(BigDecimal o) {
        return 0;
    }
}
