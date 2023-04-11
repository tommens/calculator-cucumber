package converter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class TestArea {

    @Test
    public void testToSquareMeters() {
        Area area = new Area("km2");
        double result = area.toSquareMeters(5);
        double expected = 5e6;
        assertEquals(expected, result);
    }

    @Test
    public void testFromSquareMeters() {
        Area area = new Area("mm2");
        double result = area.fromSquareMeters(10);
        double expected = 1e7;
        assertEquals(expected, result);
    }

    @Test
    public void testPrintAreaConversion() {
        double methodResult = Area.printConversion(2, "m2", "km2").doubleValue();
        double expectedResult = BigDecimal.valueOf(2e-6).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
