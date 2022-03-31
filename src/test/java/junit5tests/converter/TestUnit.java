package junit5tests.converter;

import converter.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static converter.Unit.getUnitCategories;

public class TestUnit {
    @Test
    public void getUnitsByCategory() {
        List<Unit> units = Unit.getUnitsByCategory("Length");
        List<Unit> comparatives = List.of(Unit.Nanometer, Unit.Micronmeter, Unit.Millimeter, Unit.Centimeter,
                Unit.Decimeter, Unit.Meter, Unit.Decameter, Unit.Hectometer, Unit.Kilometer, Unit.Inch, Unit.Feet,
                Unit.Yard, Unit.Mile, Unit.NauticalMile);
        Assertions.assertEquals(comparatives, units);
    }

    @Test
    void getCategoriesTest() {
        List<String> comparatives = List.of("Area", "Data Transfer Rate", "Data Storage", "Energy", "Frequency",
                "Length", "Mass", "Plane Angle", "Pressure", "Speed", "Time", "Volume", "Temperature");
        List<String> categories = getUnitCategories();
        Assertions.assertEquals(comparatives, categories);
    }

    @Test
    void getUnitByNameTest() {
        Unit comparative = Unit.Minute;
        var unit = Unit.getUnitByName("Minute");
        assert unit != null;
        Assertions.assertEquals(comparative, unit);
    }

}
