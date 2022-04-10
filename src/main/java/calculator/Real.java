package calculator;

import java.math.BigDecimal;


public class Real extends Number implements Expression{
    private BigDecimal value;

    /**
     * Constructor
     * @param value the value of the real number
     */
    public /*constructor*/ Real(BigDecimal value) {
        this.value = value;
    }

    /**
     * Converts a Rational to a Real number
     * @param rat
     */
    public /*constructor*/ Real(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        value = num.divide(den);
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public /*constructor*/ Real(int value) {
        this.value = new BigDecimal(value);
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public Real(long value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public Number negate() {
        return new Real(value.negate());
    }



    @Override
    public Number add(Number val) {
        if(val instanceof Rational rat){
            return add(rat);
        }else if(val instanceof Real r){
            return add(r);
        }
        return null;
    }

    @Override
    protected Number add(Rational rat) {
        Real rati = new Real(rat);

        BigDecimal result = value.add(rati.getValue());
        return new Real(result);
    }

    @Override
    protected Number add(Real r) {
        BigDecimal result = value.add(r.value);
        return new Real(result);
    }



    @Override
    public Number multiply(Number val) {
        if(val instanceof Rational rat){
            return multiply(rat);
        }else if(val instanceof Real r){
            return multiply(r);
        }
        return null;
    }

    @Override
    protected Number multiply(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        BigDecimal result = num.divide(den);
        BigDecimal multi = value.multiply(result);
        return new Real(multi);
    }

    @Override
    protected Number multiply(Real r) {
        BigDecimal result = value.multiply(r.value);
        return new Real(result);

    }



    @Override
    public Number divide(Number val) {
        if(val instanceof Rational rat){
            return divide(rat);
        }else if(val instanceof Real r){
            return divide(r);
        }
        return null;
    }

    @Override
    protected Number divide(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        BigDecimal result = num.divide(den);
        BigDecimal divi = value.divide(result);
        return new Real(divi);
    }

    @Override
    protected Number divide(Real r) {
        BigDecimal result = value.divide(r.value);
        return new Real(result);
    }


}
