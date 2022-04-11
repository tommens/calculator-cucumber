package junit5tests;

//Import Junit5 libraries for unit testing:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import calculator.MyBoolean;


public class TestMyBoolean {

    private final boolean value = true;
    private MyBoolean myBoolean;

    @BeforeEach
    public void setUp() {
        myBoolean = new MyBoolean(value);
    }

    @Test
    public void testEquals(){
        // Two distinct MyBoolean, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyBoolean(value), myBoolean);
        // Two MyNumbers containing a distinct value should not be equal:
        boolean otherValue = false;
        assertNotEquals(new MyBoolean(otherValue),myBoolean);
        assertEquals(myBoolean, myBoolean); // Identity check (for coverage, as this should always be true)
    }
}
