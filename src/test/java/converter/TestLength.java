package converter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class TestLength {

    @Test
    public void testToMeters() {
        Length length = new Length("km");
        double result = length.toMeters(5);
        double expected = 5000.0;
        assertEquals(expected, result);
    }

    @Test
    public void testFromMeters() {
        Length length = new Length("mm");
        double result = length.fromMeters(10);
        double expected = 10000.0;
        assertEquals(expected, result);
    }
    @Test
    public void testPrintLengthConversion() {
        double methodResult = Length.printConversion(1000, "m", "km").doubleValue();
        double expectedResult = BigDecimal.valueOf(1.0).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
