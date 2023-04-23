package calculator;

import visitor.Visitor;

import java.math.BigDecimal;
import java.util.Objects;

public class MyRationalNumber extends MyNumber {
    private Long nominator;
    private Long denominator;

    /**
     * Constructor method to create a rational number
     *
     * @param nominator   The integer value of the nominator
     * @param denominator The integer value of the denominator
     */
    private MyRationalNumber(Long nominator, Long denominator) throws  IllegalArgumentException{
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0");
        this.nominator = nominator;
        this.denominator = denominator;

    }

    /**
     * Constructor method to create a rational number from a BigDecimal value
     * @param value The BigDecimal value to be converted to a rational number
     */
    private MyRationalNumber(BigDecimal value) {
        this(value.unscaledValue().longValue(), pow(10L, value.scale()));

    }

    //create a methode that convert a BigDecimal to a rational number

    /**
     * Factory method to create a rational number and check if the denominator is different from 0.
     *
     * @param nominator   The integer value of the nominator
     * @param denominator The integer value of the denominator
     * @return The rational number created
     * @throws IllegalArgumentException
     */
    public static MyRationalNumber create(Long nominator, Long denominator) throws IllegalArgumentException {
        return new MyRationalNumber(nominator, denominator).reduce();
    }

    public static MyRationalNumber create(int nominator, int denominator) throws IllegalArgumentException {
        return new MyRationalNumber((long) nominator, (long) denominator).reduce();
    }


    /**
     * Factory method to create a rational number from a BigDecimal value
     * @param value The BigDecimal value to be converted to a rational number
     * @return The rational number created
     * @throws IllegalArgumentException
     */
    public static MyRationalNumber create(BigDecimal value) throws IllegalArgumentException {
        return new MyRationalNumber(value).reduce();
    }

    /**
     * getter method to obtain the nominator and denominator contained in the object, representing the value of the rational number
     *
     * @return The integers nominator and denominator contained in the object
     */
    public Long[] getValue() {
        return new Long[]{nominator, denominator};
    }

    /**
     * Method to convert the rational number to an integer
     * @return The integer value of the rational number
     */
    @Override
    public Integer getInteger() {
        return (int)(nominator / denominator);
    }

    /**
     * Method to return the rational number itself
     * @return The rational number itself
     */
    @Override
    public MyRationalNumber getRational() {
        return create(nominator, denominator);
    }

    /**
     * Method to convert the rational number to a BigDecimal
     * @return The BigDecimal value of the rational number
     */
    public BigDecimal getRealNumber() {
        return new MyRealNumber(nominator, denominator).getRealNumber();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public int countDepth() {
        return 0;
    }

    @Override
    public int countOps() {
        return 0;
    }

    @Override
    public int countNbs() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof MyRationalNumber that)) return false;
        return nominator == that.nominator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }

    @Override
    public String toString() {
        return nominator + "_/" + denominator;
    }

    /**
     * Method that adds two rational numbers
     *
     * @param other The rational number to be added
     * @return The result of the addition
     */
    public MyRationalNumber add(MyRationalNumber other) {
        Long newNominator = this.nominator * other.denominator + other.nominator * this.denominator;
        Long newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    /**
     * Method that subtracts two rational numbers
     *
     * @param other The rational number to subtract
     * @return The result of the subtraction
     */
    public MyRationalNumber subtract(MyRationalNumber other) {
        Long newNominator = this.nominator * other.denominator - other.nominator * this.denominator;
        Long newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    /**
     * Method that multiplies two rational numbers
     *
     * @param other The rational number which will multiply the first one
     * @return The result of the multiplication
     */
    public MyRationalNumber multiply(MyRationalNumber other) {
        Long newNominator = this.nominator * other.nominator;
        Long newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    /**
     * Method that divides two rational numbers
     *
     * @param other The rational number which will divide the first one
     * @return The result of the division
     */
    public MyRationalNumber divide(MyRationalNumber other) throws IllegalArgumentException {

        Long newNominator = this.nominator * other.denominator;
        Long newDenominator = this.denominator * other.nominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    /**
     * Method that reduces the rational number to its simplest form
     *
     * @return The rational number in its simplest form
     */
    private MyRationalNumber reduce() throws IllegalArgumentException{
        int sign = nominator >= 0L ? (denominator > 0L ? 1 : -1) : (denominator > 0L ? -1 : 1);
        Long absNominator = Math.abs(nominator);
        Long absDenominator = Math.abs(denominator);

        Long gcd = gcd(absNominator, absDenominator);
        return new MyRationalNumber(sign * absNominator / gcd, absDenominator / gcd);
    }

    /**
     * Method that calculates the greatest common divisor of two integers
     *
     * @param a The first integer
     * @param b The second integer
     * @return The greatest common divisor of the two integers
     */
    private Long gcd(Long a, Long b) {
        return b == 0 ? a : gcd(b, a % b);

    }

    private static long pow(long base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

}


