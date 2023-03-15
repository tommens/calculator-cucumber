package calculator;

import visitor.Visitor;

import java.util.Objects;

public class MyRationalNumber extends MyNumber {
    private final int nominator;
    private final int denominator;

    /**
     * Constructor method to create a rational number
     *
     * @param nominator   The integer value of the nominator
     * @param denominator The integer value of the denominator
     */
    private MyRationalNumber(int nominator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0");
        this.nominator = nominator;
        this.denominator = denominator;

    }


    /**
     * Factory method to create a rational number and check if the denominator is different from 0.
     *
     * @param nominator   The integer value of the nominator
     * @param denominator The integer value of the denominator
     * @return The rational number created
     */
    public static MyRationalNumber create(int nominator, int denominator) {
        return new MyRationalNumber(nominator, denominator).reduce();
    }

    /**
     * getter method to obtain the nominator and denominator contained in the object, representing the value of the rational number
     *
     * @return The integers nominator and denominator contained in the object
     */
    public Integer[] getValue() {
        return new Integer[]{nominator, denominator};
    }

    /**
     * Method to convert the rational number to an integer
     * @return The integer value of the rational number
     */
    @Override
    public Integer getInteger() {
        return nominator / denominator;
    }

    @Override
    public MyRationalNumber getRational() {
        return create(nominator, denominator);
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
        return "(" + nominator + "_/" + denominator + ")";
    }

    public MyRationalNumber add(MyRationalNumber other) {
        int newNominator = this.nominator * other.denominator + other.nominator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    public MyRationalNumber subtract(MyRationalNumber other) {
        int newNominator = this.nominator * other.denominator - other.nominator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    public MyRationalNumber multiply(MyRationalNumber other) {
        int newNominator = this.nominator * other.nominator;
        int newDenominator = this.denominator * other.denominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    public MyRationalNumber divide(MyRationalNumber other) throws IllegalArgumentException {

        int newNominator = this.nominator * other.denominator;
        int newDenominator = this.denominator * other.nominator;
        return new MyRationalNumber(newNominator, newDenominator).reduce();
    }

    /**
     * Method that reduces the rational number to its simplest form
     *
     * @return The rational number in its simplest form
     */
    private MyRationalNumber reduce() {
        int sign = nominator * denominator < 0 ? -1 : 1;
        int absNominator = Math.abs(nominator);
        int absDenominator = Math.abs(denominator);

        int gcd = gcd(absNominator, absDenominator);
        return new MyRationalNumber(sign * absNominator / gcd, absDenominator / gcd);
    }

    /**
     * Method that calculates the greatest common divisor of two integers
     *
     * @param a The first integer
     * @param b The second integer
     * @return The greatest common divisor of the two integers
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }

}


