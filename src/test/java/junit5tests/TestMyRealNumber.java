package junit5tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;

import java.util.ArrayList;

class TestMyRealNumber {

    private final Double value =8.5;
    private MyRealNumber number;

    @BeforeEach
    void setUp() {
        number = new MyRealNumber(value);
    }

    @Test
    void testEquals() {
        // Two distinct MyRealNumber, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyRealNumber(value), number);
        // Two MyRealNumbers containing a distinct value should not be equal:
        Double otherValue = 7.7;
        assertNotEquals(new MyRealNumber(otherValue),number);
        assertEquals(number, number); // Identity check (for coverage, as this should always be true)
        assertNotEquals(number, value); // number is of type MyRealNumber, while value is of type double, so not equal
        try {
            assertNotEquals(new Times(new ArrayList<>()), number);
        }
        catch (IllegalConstruction e) {fail();}
    }

    @Test
    void testToString() {
        assertEquals(Double.toString(value), number.toString());
    }

}
