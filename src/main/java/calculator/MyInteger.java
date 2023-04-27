package calculator;

import java.math.BigDecimal;

/**
 * This class represent an integer number
 * The class extends an abstract class MyNumber
 */
public class MyInteger extends MyNumber {

    private final int value;

    /**
     * Constructor method
     *
     * @param v The integer value to be contained in the object
     */
    public MyInteger(int v) {
        value = v;
    }

    /**
     * getter method to obtain the integer value contained in the object
     *
     * @return the integer number contained in the object
     */
    @Override
    public Integer getInteger() {
        return value;
    }

    /**
     * getter method to obtain the value as a real number
     *
     * @return The value as a real number
     */
    @Override
    public BigDecimal getRealNumber() {
        return new BigDecimal(value);
    }

    /**
     * getter method to obtain the rational number contained in the object
     *
     * @return the rational number contained in the object
     */
    @Override
    public MyRationalNumber getRational() {
        return MyRationalNumber.create(value, 1);
    }

    /**
     * Convert a number into a String to allow it to be printed.
     *
     * @return The String that is the result of the conversion.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }


    /**
     * Two MyInteger expressions are equal if the values they contain are equal
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
        if (!(o instanceof MyInteger)) {
            return false;
        }
        return this.value == ((MyInteger) o).value;
    }

    @Override
    public int hashCode() {
        return getInteger();
    }
}
