package junit5tests;

import calculator.IllegalConstruction;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestDevideZero
{
    @Test
    public void testDevideZero() throws IllegalConstruction
    {
        assertEquals(new calculator.Divides(new java.util.ArrayList<>()).op(1,0), -1);
        assertNotEquals(new calculator.Divides(new java.util.ArrayList<>()).op(2,1), -1);
    }
}
