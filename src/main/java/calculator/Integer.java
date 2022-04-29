package calculator;

import java.math.BigInteger;

public class Integer extends Number {

    private BigInteger value;

    public Integer(BigInteger value) {
        this.value = value;
    }

    @Override
    public Real toReal() {
        return new Real(value);
    }

    @Override
    public Number negate() {
        return new Integer(-value);
    }

    @Override
    protected Number add(Rational rat) {
        return rat.add(value);
    }

    @Override
    protected Number add(Real r) {
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
    protected Number divide(Rational rat) {
        return null;
    }

    @Override
    protected Number divide(Real r) {
        return null;
    }
}
