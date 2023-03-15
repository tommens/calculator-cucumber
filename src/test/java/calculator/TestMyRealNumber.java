package calculator;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class TestMyRealNumber {

    private final String value = "0.0000000314159";
    private final String scienceValue = "3.14159E-8";
    private final int precision = 3;

    private MyRealNumber number , number2;

    @BeforeEach
    void setup(){
        number = new MyRealNumber(value);
        number2 = new MyRealNumber(value,precision);
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


}
