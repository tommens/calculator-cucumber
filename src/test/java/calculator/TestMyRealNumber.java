package calculator;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.MathContext;


public class TestMyRealNumber {

    private final String value = "0.0000000314159";
    private final String scienceValue = "3.14159E-8";
    private final MathContext mc = new MathContext(3);

    private MyRealNumber number , number2;

    @BeforeEach
    void setup(){
        number = new MyRealNumber(value);
        number2 = new MyRealNumber(value,mc);
    }

    @Test
    void testScientificNotation(){
        // Test if a MyRealNumber object created with the decimal notation
        // is equal to a MyRealNumber object created with the scientific notation
        MyRealNumber n = new MyRealNumber(scienceValue);
        assertEquals(n,number);
    }

    @Test
    void testToString(){
        // Test if the method toString return the value in the scientific notation
        // since the number contain a large number of 0
        assertEquals(scienceValue,number.toString());
    }

    @Test
    void testToDecimalString(){
        // Test the method to get the number as a String in the classic decimal notation
        assertEquals(value, number.toDecimalString());
    }


    @Test
    void testPrecision(){
        String s = "3.14E-8";
        assertEquals(s,number2.toString());
    }

    @Test
    void testPrecisionDecimal(){
        String s = "0.0000000314";
        assertEquals(s,number2.toDecimalString());
    }

    @Test
    void testGetRational(){
        MyRationalNumber r = MyRationalNumber.create(1,10);

        assertEquals(r,new MyRealNumber("0.1").getRational());
    }

    @Test
    void testEquals(){
        // Two distinct MyRealNumber have the same value
        assertEquals(new MyRealNumber(value), number);
        // Two MyNumbers containing a distinct value should not be equal:
        assertNotEquals(new MyRealNumber("2.1"),number);
        assertEquals(number, number); // Identity check
        assertNotEquals(new MyInteger(2),new MyRealNumber(2));
    }

    @Test
    void testInfiniteDecimal(){
        Calculator calculator = new Calculator();
        calculator.setPrecision(MathContext.UNLIMITED.getPrecision());
        BigDecimal res = calculator.evalReal(calculator.read("1/3"));
        assertEquals(MathContext.DECIMAL128.getPrecision(), res.precision());
    }


}
