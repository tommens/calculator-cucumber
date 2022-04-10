package converter;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit class represents all units possible
 */
public enum Unit {
    // ******** Area ********
    SquareMillimeter("Area", "Square Millimeter", "1000000", "0"),
    SquareCentimeter("Area", "Square Centimeter", "10000", "0"),
    SquareDecimeter("Area", "Square Decimeter", "100", "0"),
    SquareMeter("Area", "Square Meter", "1", "0"),
    Are("Area", "Are", "0.01", "0"),
    Centiare("Area", "Centiare", "1", "0"),
    SquareKilometer("Area", "Square Kilometer", "1e-6", "0"),
    Hectare("Area", "Hectare", "9.999944100002329907e-5", "0"),
    SquareInch("Area", "Square Inch", "1549.9944354892320462", "0"),
    SquareFoot("Area", "Square Feet", "10.763850246452999926", "0"),
    SquareMile("Area", "Square Mile", "3.861e-7", "0"),
    SquareYard("Area", "Square Yard", "1.195983360717", "0"),
    Acre("Area", "Acre", "0.00024710400014814050363", "0"),

    // ******** Data Transfer Rate ********
    BitPerSecond("Data Transfer Rate", "Bit Per Second", "1", "0"),
    KilobitPerSecond("Data Transfer Rate", "Kilobit Per Second", "0.001", "0"),
    KilobytePerSecond("Data Transfer Rate", "Kilobyte Per Second", "0.000125", "0"),
    KibibitPerSecond("Data Transfer Rate", "Kibibit Per Second", "0.000976563", "0"),
    MegabitPerSecond("Data Transfer Rate", "Megabit Per Second", "1e-6", "0"),
    MegabytePerSecond("Data Transfer Rate", "Megabyte Per Second", "1.25e-7", "0"),
    MebibitPerSecond("Data Transfer Rate", "Mebibit Per Second", "9.5367e-7", "0"),
    GigabitPerSecond("Data Transfer Rate", "Gigabit Per Second", "9.99995474e-10", "0"),
    GigabytePerSecond("Data Transfer Rate", "Gigabyte Per Second", "1.2499943425e-10", "0"),
    GibibitPerSecond("Data Transfer Rate", "Gibibit Per Second", "9.313183594495e-10", "0"),
    TerabitPerSecond("Data Transfer Rate", "Terabit Per Second", "9.999954739999937644e-13", "0"),
    TerabytePerSecond("Data Transfer Rate", "Terabyte Per Second", "1.249994342499992206e-13", "0"),
    TebibitPerSecond("Data Transfer Rate", "Tebibit Per Second", "9.094905853999023548e-13", "0"),

    // ******** Data Storage ********
    Bit("Data Storage","Bit","8", "0"),
    Kilobit("Data Storage","Kilobit","0.008", "0"),
    Kibibit("Data Storage","Kibibit","0.0078125", "0"),
    Megabit("Data Storage","Megabit","8e-6", "0"),
    Mebibit("Data Storage","Mebibit","7.6294e-6", "0"),
    Gigabit("Data Storage","Gigabit","8e-9", "0"),
    Gibibit("Data Storage","Gibibit","7.4506e-9", "0"),
    Terabit("Data Storage","Terabit","8e-12", "0"),
    Tebibit("Data Storage","Tebibit","7.276e-12", "0"),
    Petabit("Data Storage","Petabit","8e-15", "0"),
    Pebibit("Data Storage","Bit","7.1054e-15", "0"),
    Kilobyte("Data Storage","Kilobyte","0.001", "0"),
    Megabyte("Data Storage","Megabyte","1e-6", "0"),
    Mebibyte("Data Storage","Mebibyte","9.5367e-7", "0"),
    Gigabyte("Data Storage","Gigabyte","1e-9", "0"),
    Gibibyte("Data Storage","Gibibyte","9.3132e-10", "0"),
    Terabyte("Data Storage", "Byte", "1e-12", "0"),
    Tebibyte("Data Storage", "Tebibyte", "9.0949e-13", "0"),
    Petabyte("Data Storage", "Petabyte", "1e-15", "0"),
    Pebibyte("Data Storage", "Pebibyte", "8.8818e-16", "0"),

    // ******** Energy or Work ********
    Joule("Energy", "Joule", "1", "0"),
    Kilojoule("Energy", "Kilojoule", "0.001", "0"),
    Gramcalorie("Energy", "Gram Calorie", "0.239006", "0"),
    Kilocalorie("Energy", "Kilocalorie", "0.000239006", "0"),
    WattHour("Energy", "Watt Hour", "0.000277778", "0"),
    KiloWattHour("Energy", "Kilowatt Hour", "2.7778e-7", "0"),
    Electronvolt("Energy", "Electronvolt", "6.24155928e+18", "0"),
    BritishThermalUnit("Energy", "British thermal unit", "0.000947817", "0"),
    USTherm("Energy", "US Therm", "9.4804e-9", "0"),
    FootPound("Energy", "Foot-pound", "0.737562", "0"),

    // ******** Energy or Work ********
    Hertz("Frequency","Hertz","1", "0"),
    Kilohertz("Frequency","Kilohertz","0.001", "0"),
    Megahertz("Frequency","Megahertz","1e-6", "0"),
    Gigahertz("Frequency","Gigahertz","1e-9", "0"),

    // ******** Length ********
    Nanometer("Length", "Nanometer", "1e+9", "0"),
    Micronmeter("Length", "Micronmeter", "1e+6", "0"),
    Millimeter("Length", "Millimeter",  "1000", "0"),
    Centimeter("Length", "Centimeter","100", "0"),
    Decimeter("Length", "Decimeter", "10", "0"),
    Meter("Length", "Meter", "1", "0"),
    Decameter("Length", "Decameter", "0.1", "0"),
    Hectometer("Length", "Hectometer", "0.01", "0"),
    Kilometer("Length", "Kilometer", "0.001", "0"),
    Inch("Length", "Inches", "39.37008", "0"),
    Feet("Length", "Feet", "3.28084", "0"),
    Yard("Length", "Yard", "1.093613", "0"),
    Mile("Length", "Mile", "0.000621", "0"),
    NauticalMile("Length", "NauticalMile", "0.000539957", "0"),

    // ******** Mass ********
    Nanogram("Mass", "Nanogram", "1e+9", "0"),
    Microgram("Mass", "Microgram", "1e+6", "0"),
    Milligram("Mass", "Milligram", "1000", "0"),
    Centigram("Mass", "Centigram", "100", "0"),
    Decigram("Mass", "Decigram", "10", "0"),
    Gram("Mass", "Gram", "1", "0"),
    Kilogram("Mass", "Kilogram", "0.001", "0"),
    Tonne("Mass", "Tonne", "1e-6", "0"),
    ImperialTon("Mass", "Imperial Ton", "9.8421e-7", "0"),
    USTon("Mass", "US Ton", "1.1023e-6", "0"),
    Stone("Mass", "Stone", "0.000157473", "0"),
    Pound("Mass", "Pound", "0.00220462", "0"),
    Ounce("Mass", "Ounce", "0.035274", "0"),

    // ******** Plane Angle ********
    Degree("Plane Angle", "Degree", "1", "0"),
    Gradian("Plane Angle", "Gradian", "1.11111", "0"),
    Milliradian("Plane Angle", "Milliradian", "17.4533", "0"),
    MinuteOfArc("Plane Angle", "Minute Of Arc", "60", "0"),
    Radian("Plane Angle", "Radian", "0.0174533", "0"),
    SecondOfArc("Plane Angle", "Second Of Arc", "3600", "0"),

    // ******** Pressure ********
    Pascal("Pressure", "Pascal", "1", "0"),
    Bar("Pressure", "Bar", "1e-5", "0"),
    PoundPerSquareInch("Pressure", "Pound Per Square Inch", "0.000145038", "0"),
    StandardAtmosphere("Pressure", "Standard atmosphere", "9.8692e-6", "0"),
    Torr("Pressure", "Torr", "0.00750062", "0"),

    // ******** Speed ********
    MeterPerSecond("Speed", "Meter Per Second", "1", "0"),
    MilesPerHour("Speed", "Miles Per Hour", "2.23694", "0"),
    FootPerSecond("Speed", "Foot Per Second", "3.28084", "0"),
    KilometerPerHour("Speed", "Kilometer Per Hour", "3.6", "0"),
    Knot("Speed", "Knot", "1.94384", "0"),

    // ******** Time ********
    Yoctosecond("Time", "Yoctosecond", "1e+27", "0"),
    Zeptosecond("Time", "Zeptosecond", "1e+24", "0"),
    Attosecond("Time", "Attosecond", "1e+21", "0"),
    Femtosecond("Time", "Femtosecond", "1e+18", "0"),
    Picosecond("Time", "Picosecond", "1e+15", "0"),
    Nanosecond("Time", "Nanosecond", "6e+10", "0"),
    Microsecond("Time", "Microsecond", "6e+7", "0"),
    Millisecond("Time", "Millisecond", "60000", "0"),
    Second("Time", "Second", "60", "0"),
    Minute("Time", "Minute", "1", "0"),
    Hour("Time", "Hour", "0.0166667", "0"),

    // ******** Volume ********
    CubicMeter("Volume", "Cubic Meter", "1", "0"),
    Liter("Volume", "Liter", "1000", "0"),
    Milliliter("Volume", "Milliliter", "1e+6", "0"),
    CubicFoot("Volume", "Cubic Foot", "35.3147", "0"),
    CubicInch("Volume", "Cubic Inch", "61023.7", "0"),

    // ******** Temperature ********
    Celsius("Temperature", "Celsius", "1", "0"),
    Fahrenheit("Temperature", "Fahrenheit", "1.8", "32"),
    Kelvin("Temperature", "Kelvin", "1", "273.15")
    ;

    /**
     * The category of the unit.
     */
    private final String unitCategory;

    /**
     * The name of the unit.
     */
    private final String unitName;

    /**
     * The factor to convert unit.
     */
    private final String unitRatio;

    /**
     * The offset to convert unit.
     */
    private final String unitConstant;

    /**
     * Constructor.
     * @param unitCategory  The category of the unit.
     * @param unitName      The name of the unit.
     * @param unitRatio     The factor to convert unit.
     * @param unitConstant  The offset to convert unit.
     */
    Unit(String unitCategory, String unitName, String unitRatio, String unitConstant) {
        this.unitCategory = unitCategory;
        this.unitName = unitName;
        this.unitRatio = unitRatio;
        this.unitConstant = unitConstant;
    }

    /**
     * Get the category of the unit.
     * @return The category of the unit.
     */
    public String getUnitCategory() {
        return unitCategory;
    }

    /**
     * Get the name of the unit.
     * @return The name of the unit.
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Get the factor to convert unit.
     * @return The factor to convert unit.
     */
    public String getUnitRatio() {
        return unitRatio;
    }

    /**
     * Get the offset to convert unit.
     * @return The offset to convert unit.
     */
    public String getUnitConstant() {
        return unitConstant;
    }

    /**
     * Get units list from category.
     * @param unitCategory  The category of the unit.
     * @return              The units list from category.
     */
    public static List<Unit> getUnitsByCategory(String unitCategory) {
        List<Unit> units = new ArrayList<>();
        for (Unit unit : Unit.values()) {
            if (unit.getUnitCategory().equals(unitCategory)) {
                units.add(unit);
            }
        }
        return units;
    }

    /**
     * Get unit from name.
     * @param unitName  The name of the unit.
     * @return          The unit from name.
     */
    public static Unit getUnitByName(String unitName) {
        for (Unit unit : Unit.values()) {
            if (unit.getUnitName().equals(unitName)) {
                return unit;
            }
        }
        return null;
    }

    /**
     * Get all categories possible.
     * @return All categories possible.
     */
    public static List<String> getUnitCategories() {
        List<String> unitCategories = new ArrayList<>();
        for (Unit unit : Unit.values()) {
            if (!unitCategories.contains(unit.getUnitCategory())) {
                unitCategories.add(unit.getUnitCategory());
            }
        }
        return unitCategories;
    }

    /**
     * Convert the value from the first unit to the second unit
     * @param input     The value to convert
     * @param fromUnit  The unit to convert from
     * @param toUnit    The unit to convert to
     * @return          The converted value in a string
     */
    // Here because of the use of the enum and easier to test
    public static String convert(String input, Unit fromUnit, Unit toUnit, Calculator calculator) {
        Expression expr = Parser.parse(
                "(" + input + "-" + fromUnit.getUnitConstant() +")" + "/" + fromUnit.getUnitRatio()
                        + "×" + toUnit.getUnitRatio() + "+" + toUnit.getUnitConstant());
        return calculator.eval(expr).toString();
    }
}