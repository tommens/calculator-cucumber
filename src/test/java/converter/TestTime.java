package converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTime {
    @Test
    public void testToSeconds() {
        Time time = new Time("wk");
        double result = time.toSeconds(50);
        double expected = 3.024e7;
        assertEquals(expected, result);
    }

    @Test
    public void testFromSeconds() {
        Time time = new Time("yr");
        double result = time.fromSeconds(99);
        double expected = 3.1393e-6;
        assertEquals(expected, result,0.1e-6);
    }
    @Test
    public void testPrintTimeConversion() {
        double methodResult = Time.printConversion(2, "yr", "wk").doubleValue();
        double expectedResult = BigDecimal.valueOf(104).doubleValue();
        assertEquals(expectedResult,methodResult,1);
    }
}
