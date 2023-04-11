package converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnergy {
    @Test
    public void testToJoules() {
        Energy energy = new Energy("cal");
        double result = energy.toJoules(5);
        double expected = 20.92;
        assertEquals(expected, result);
    }

    @Test
    public void testFromJoules() {
        Energy energy = new Energy("cal");
        double result = energy.fromJoules(10);
        double expected = 2.39006;
        assertEquals(expected, result,0.001);
    }

    @Test
    public void testPrintEnergyConversion() {
        double methodResult = Energy.printConversion(10, "J", "kWh").doubleValue();
        double expectedResult = BigDecimal.valueOf(2.778e-6).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
