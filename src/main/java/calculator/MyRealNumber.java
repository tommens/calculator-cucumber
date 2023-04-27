package calculator;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class represent a real number
 * The class extends an abstract class MyNumber
 */
public class MyRealNumber extends MyNumber {

    private final BigDecimal value;


    /**
     * Constructor method
     *
     * @param v The real number to be contained in the object
     */
    public MyRealNumber(String v) {
        value = new BigDecimal(v);
    }

    /**
     * Constructor method
     * @param v The real number to be contained in the object
     */
    public MyRealNumber(double v){
        value = new BigDecimal(v);
    }


    /**
     * Constructor method
     *
     * @param v  The real number to be contained in the object
     * @param mc The MathContext containing the precision and the rounding mode to be used
     */
    public MyRealNumber(String v, MathContext mc) {
        value = new BigDecimal(v, mc);
    }

    public MyRealNumber(Long nominator, Long denominator) {
        value = new BigDecimal(nominator).divide(new BigDecimal(denominator), MathContext.DECIMAL128);
    }

    /**
     * getter method to obtain the value contained in the object as an integer
     *
     * @return The value contained in the object as an integer
     */
    @Override
    public Integer getInteger() {
        return value.intValue();
    }

    /**
     * getter method to obtain the real number contained in the object
     *
     * @return The real number contained in the object
     */
    @Override
    public BigDecimal getRealNumber() {
        return value;
    }

    /**
     * getter method to obtain the value contained in the object as a rational number
     *
     * @return The value contained in the object as a rational number
     */
    @Override
    public MyRationalNumber getRational() {
        return MyRationalNumber.create(value);
    }


    /**
     * Convert a number into a String to allow it to be printed.
     *
     * @return The String that is the result of the conversion.
     */
    @Override
    public String toString() {
        return value.toString();
    }


    /**
     * Two MyRealNumber expressions are equal if the values they contain are equal
     *
     * @param o The object to compare to
     * @return A boolean representing the result of the equality test
     */
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof MyRealNumber)) {
            return false;
        }
        return this.value.equals(((MyRealNumber) o).value);
    }

    //generate hashcode
    @Override
    public int hashCode() {
        return value.hashCode();
    }


    /**
     * Return the value as a string in the classic decimal notation
     *
     * @return A String representing the value in classic decimal notation
     */
    public String toDecimalString() {
        return value.toPlainString();
    }
}
