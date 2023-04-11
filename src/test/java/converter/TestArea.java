package converter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

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
}
