package junit5tests;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Complex;

import java.math.BigDecimal;

import calculator.Number;
import calculator.Rational;
import calculator.Real;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestComplex {

    private final BigDecimal real = BigDecimal.valueOf(1);
    private final BigDecimal imaginary = BigDecimal.valueOf(2);
    private Complex c1;
    private Complex c2;


    @BeforeEach
    public void setUp() {
        c1 = new Complex(real, imaginary);
        c2 = new Complex(real, imaginary);
    }

    @Test
    public void testEquals() {
        assertEquals(BigDecimal.valueOf(1), c1.getReal());
        assertEquals(BigDecimal.valueOf(2), c1.getImaginary());
    }

    @Test
    public void testAdd(){

        Complex c3 = (Complex) c1.add(c2);


        assertEquals(BigDecimal.valueOf(2), c3.getReal());
        assertEquals(BigDecimal.valueOf(4), c3.getImaginary());
    }


    @Test
    public void testMultiply(){

        Complex c3 = (Complex) c1.multiply(c2);
        assertEquals(BigDecimal.valueOf(-3), c3.getReal());
        assertEquals(BigDecimal.valueOf(4), c3.getImaginary());
    }

    @Test
    public void testDivide(){

        Complex c3 = (Complex) c1.divide(c2);
        assertEquals(BigDecimal.valueOf(1), c3.getReal());
        assertEquals(BigDecimal.valueOf(0), c3.getImaginary());

        Complex c4 = new Complex(BigDecimal.valueOf(20), BigDecimal.valueOf(-4));
        Complex c5 = new Complex(BigDecimal.valueOf(3), BigDecimal.valueOf(2));

        Complex c6 = (Complex) c4.divide(c5);
        assertEquals(BigDecimal.valueOf(4), c6.getReal());
        assertEquals(BigDecimal.valueOf(-4), c6.getImaginary());
    }

    @Test
    public void testToString(){
        Complex c1 = new Complex(real, imaginary);
        assertEquals("1 + 2i", c1.toString());
    }

    @Test
    public void testConjugate(){

        Complex c3 = c1.conjugate();
        assertEquals(BigDecimal.valueOf(1), c3.getReal());
        assertEquals(BigDecimal.valueOf(-2), c3.getImaginary());
    }


}
