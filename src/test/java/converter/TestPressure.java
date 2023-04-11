package converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPressure {
    @Test
    public void testToPascals() {
        Pressure pressure = new Pressure("atm");
        double result = pressure.toPascals(5);
        double expected = 506625;
        assertEquals(expected, result);
    }

    @Test
    public void testFromPascals() {
        Pressure pressure = new Pressure("hPa");
        double result = pressure.fromPascals(10);
        double expected = 0.1;
        assertEquals(expected, result);
    }

    @Test
    public void testPrintPressureConversion() {
        double methodResult = Pressure.printConversion(15, "Pa", "bar").doubleValue();
        double expectedResult = BigDecimal.valueOf(0.00015).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
