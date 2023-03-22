package calculator;

import visitor.Visitor;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Problem :
 * ---------
 * too large integers that are not supported by the internal data type (int)
 * used in the MyNumber class. int values are 32 bit in Java, so the values
 * range from -2^31 to 2^31-1. To deal with longer integer values, one could
 * use to “long” type to supports 64 bit integers, i.e., values range from
 * -2^63 to 2^63-1. But an even better alternative would be to use the
 * java.Math.BigInteger class which supports arbitrary-precision integers,
 * and which also provides a set of extra and useful operations that might be
 * useful to support (for modular arithmetic, GCD calculation, primality
 * testing, prime generation, bit manipulation).
 */
public class MyBigNumber extends Numbi //TODO : clear with abstract class
{
    protected BigInteger value;

    public MyBigNumber(BigInteger value)
    {
        this.value = value;
    }

    public BigInteger getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBigNumber that = (MyBigNumber) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public BigInteger countOps()
    {
        return BigInteger.ZERO;
    }

    /**
     * Counts the depth of nested expressions in an arithmetic expression
     * @return The depth of an arithmetic expression
     */
    @Override
    public BigInteger countDepth()
    {
        return BigInteger.ZERO;
    }

    /**
     * Counts the number of values recursively contained in an arithmetic expression
     * @return The number of values contained in an arithmetic expression
     */
    @Override
    public BigInteger countNbs()
    {
        return BigInteger.ONE;
    }

    public String toString()
    {
        return value.toString();
    }
}
