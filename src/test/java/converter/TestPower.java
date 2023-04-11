package converter;

import org.junit.jupiter.api.Test;

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
}
