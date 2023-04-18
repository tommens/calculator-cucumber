package junit5tests;

import calculator.MyBigNumber;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyBigNumber
{
    @Test
    void testConstructor()
    {
        assertTrue(new MyBigNumber(BigInteger.valueOf(8)) instanceof MyBigNumber);
    }

    @Test
    void testToString()
    {
        assertEquals("8", new MyBigNumber(BigInteger.valueOf(8)).toString());
    }

    @Test
    void testEquals()
    {
        assertTrue(new MyBigNumber(BigInteger.valueOf(8)).equals(new MyBigNumber(BigInteger.valueOf(8))));
        assertFalse(new MyBigNumber(BigInteger.valueOf(8)).equals(new MyBigNumber(BigInteger.valueOf(7))));
    }

    @Test
    void testHashCode()
    {
        assertEquals(new MyBigNumber(BigInteger.valueOf(8)).hashCode(), new MyBigNumber(BigInteger.valueOf(8)).hashCode());
        assertNotEquals(new MyBigNumber(BigInteger.valueOf(8)).hashCode(), new MyBigNumber(BigInteger.valueOf(7)).hashCode());
    }

    @Test
    void testGetValue()
    {
        assertEquals(BigInteger.valueOf(8), new MyBigNumber(BigInteger.valueOf(8)).getValue());
    }
}
