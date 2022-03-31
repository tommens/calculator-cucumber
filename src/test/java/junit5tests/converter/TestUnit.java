package junit5tests.converter;

import calculator.Calculator;
import converter.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static converter.Unit.convert;
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

    @Test
    void testConvertLength() {
        var actual = convert("1", Unit.Centimeter, Unit.Meter, new Calculator());
        var expected = "1/100"; //TODO change tp 0.01 when real will be implemented
        assert actual.equals(expected);
    }

    @Test
    void testConvertMass() {
        var actual = convert("1", Unit.Gram, Unit.Kilogram, new Calculator());
        var expected = "1/1000";
        assert actual.equals(expected);
    }

    @Test
    void testConvertSpeed() {
        var actual = convert("1", Unit.KilometerPerHour, Unit.MeterPerSecond, new Calculator());
        var expected = "1/3.6";
        assert actual.equals(expected);
    }

    @Test
    void testConvertTime() {
        var actual = convert("1", Unit.Second, Unit.Minute, new Calculator());
        var expected = "1/60";
        System.out.println(actual);
        assert actual.equals(expected);
    }

    @Test
    void testConvertTemperature() {
        var actual = convert("1", Unit.Celsius, Unit.Fahrenheit, new Calculator());
        var expected = "1/1.8+32";
        assert actual.equals(expected);
    }

    @Test
    void testConvertVolume() {
        var actual = convert("1", Unit.Milliliter, Unit.Liter, new Calculator());
        var expected = "1/1000";
        assert actual.equals(expected);
    }
}
