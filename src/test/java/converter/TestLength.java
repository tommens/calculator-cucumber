package converter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestLength {

    @Test
    public void testToMeters() {
        Length length = new Length("KM");
        double result = length.toMeters(5);
        double expected = 5000.0;
        assertEquals(expected, result);
    }

    @Test
    public void testFromMeters() {
        Length length = new Length("MM");
        double result = length.fromMeters(10);
        double expected = 10000.0;
        assertEquals(expected, result);
    }
}
