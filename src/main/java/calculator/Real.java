package calculator;

import java.math.BigDecimal;
import java.math.BigInteger;


public class Real extends Number implements Expression, Comparable<BigDecimal>{
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
        BigDecimal A = BigDecimal.valueOf(val);
        BigDecimal result = new BigDecimal(String.valueOf(value.add(A)));
        return new Real(result);
    }

    @Override
    protected Number add(Rational rat) {
        BigDecimal A = BigInteger.toBigDecimal(rat);
        BigDecimal result = new BigDecimal(String.valueOf(value.add(A)));
        return new Real(result);
    }

    @Override
    protected Number add(Real r) {
        BigDecimal result = new BigDecimal(String.valueOf(value.add(r.value)));
        return new Real(result);
    }

    @Override
    public Number multiply(Number val) {
        BigDecimal A = BigDecimal.valueOf(val);
        BigDecimal result = new BigDecimal(String.valueOf(value.multiply(A)));
        return new Real(result);

    }

    @Override
    protected Number multiply(Rational rat) {
        BigDecimal A = BigInteger.toBigDecimal(rat);
        BigDecimal result = new BigDecimal(String.valueOf(value.multiply(A)));
        return new Real(result);
    }

    @Override
    protected Number multiply(Real r) {
        BigDecimal result = new BigDecimal(String.valueOf(value.add(r.value)));
        return new Real(result);

    }

    @Override
    public Number divide(Number val) {

        BigDecimal A = BigDecimal.valueOf(val);
        BigDecimal result = new BigDecimal(String.valueOf(value.divide(A)));
        return new Real(result);
    }

    @Override
    protected Number divide(Rational rat) {
        BigDecimal A = BigInteger.toBigDecimal(rat);
        BigDecimal result = new BigDecimal(String.valueOf(value.divide(A)));
        return new Real(result);
    }

    @Override
    protected Number divide(Real r) {
        BigDecimal result = new BigDecimal(String.valueOf(value.divide(r.value)));
        return new Real(result);
    }

    @Override
    public int compareTo(BigDecimal o) {
        return value.compareTo(o);
    }
}
