package calculator;

import java.math.BigInteger;

public class Rational extends Number implements Expression{

    protected BigInteger numerator;
    protected BigInteger denominator;

    /**
     * Constructs a Rational integer representing 1.
     */
    public /*constructor*/ Rational() {
        numerator = BigInteger.ZERO;
        denominator = BigInteger.ONE;
    }

    @Override
    public Number negate() {
        return new Rational(numerator.negate(), denominator);
    }

    @Override
    public Number add(Number val) {
        if (val instanceof Rational rat) {
            return new Rational(numerator.multiply(rat.denominator).add(rat.numerator.multiply(denominator)),
                                denominator.multiply(rat.denominator));
        }
        return null;
    }

    @Override
    public Number subtract(Number val) {
        if (val instanceof Rational rat) {
            return add(rat.negate());
        }
        return null;
    }

    @Override
    public Number multiply(Number val) {
        if (val instanceof Rational rat) {
            return new Rational(numerator.multiply(rat.numerator),
                                denominator.multiply(rat.denominator));
        }
        return null;
    }

    @Override
    public Number divide(Number val) {
        if (val instanceof Rational rat) {
            if (rat.equals(new Rational(0))) {
                throw new ArithmeticException(); // TODO do it better
            }
            return multiply(new Rational(rat.denominator, rat.numerator));
        }
        return null;
    }

    /**
     * Creates a Rational number with the numerator and denominator set in parameters.
     * @param numerator the numerator
     * @param denominator the denominator
     */
    protected Rational(BigInteger numerator, BigInteger denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     * Creates a Rational corresponding number
     * @param number the number to store
     */
    public /*constructor*/ Rational(long number) {
        this(BigInteger.valueOf(number), BigInteger.ONE);
    }

    public /*constructor*/ Rational(String numerator, String denominator) {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    /**
     * The representation of a fraction is typically using a simplified version. This method simplifies a Rational.
     */
    private void simplify() {
        if (!denominator.equals(BigInteger.ZERO)) {
            BigInteger gcd = numerator.gcd(denominator);
            numerator = numerator.divide(gcd);
            denominator = denominator.divide(gcd);
        }
    }

    @Override
    public String toString() {
        String representation = numerator.toString();
        if (!denominator.equals(BigInteger.ONE)) {
            representation += "/" + denominator;
        }
        return representation;
    }

    //Two MyNumber expressions are equal if the values they contain are equal
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof Number)) {
            return false;
        }

        if (o instanceof Rational r) {
            return numerator.equals(r.numerator) && denominator.equals(r.denominator); // TODO handle multiples
        } else {
            // If the object is of another type then return false
            return false;
        }

    }

    // The method hashCode() needs to be overridden if the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
