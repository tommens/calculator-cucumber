package junit5tests;

import calculator.BasesNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBasesNumber
{
    @Test
    void testgetBasesNumber()
    {
        BasesNumber n = new BasesNumber(2, "101");
        assertEquals(n.getBase(), 2);
        assertEquals(n.getValuetoString(), "101");
    }


    @Test
    void testsetBasesNumber()
    {
        BasesNumber n = new BasesNumber(2, "101");
        n.setBase(10);
        assertEquals(n.getBase(), 10);
        assertEquals(n.getValuetoString(), "101");

        n.setValue("111");
        assertEquals(n.getBase(), 10);
        assertEquals(n.getValuetoString(), "111");
    }


    @Test
    void testgetBasesNumber2()
    {
        BasesNumber n = new BasesNumber(2, "11");
        assertEquals(n.getValueToInt(), 3);
        n.setValue("111");
        assertEquals(n.getValueToInt(), 7);
    }

    @Test
    void testgetBasesNumber16()
    {
        BasesNumber n = new BasesNumber(16, "A");
        assertEquals(n.getValueToInt(), 10);
        n.setValue("FA");
        assertEquals(n.getValueToInt(), 250);
    }
}
