package converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPower {
    @Test
    public void testToWatts() {
        Power power = new Power("PW");
        double result = power.toWatts(5);
        double expected = 5e15;
        assertEquals(expected, result);
    }

    @Test
    public void testFromWatts() {
        Power power = new Power("kW");
        double result = power.fromWatts(10);
        double expected = 0.01;
        assertEquals(expected, result);
    }

    @Test
    public void testPrintPowerConversion() {
        double methodResult = Power.printConversion(10, "MW", "W").doubleValue();
        double expectedResult = BigDecimal.valueOf(10e6).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
