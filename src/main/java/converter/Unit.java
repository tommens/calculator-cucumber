package converter;

import java.math.BigDecimal;

public enum Unit {
    // ******** Area ********
    SquareMillimeter("Area", "Square Millimeter", "1000000"),
    SquareCentimeter("Area", "Square Centimeter", "10000"),
    SquareDecimeter("Area", "Square Decimeter", "100"),
    SquareMeter("Area", "Square Meter", "1"),
    Are("Area", "Are", "0,01"),
    Centiare("Area", "Centiare", "1"),
    SquareKilometer("Area", "Square Kilometer", "1e-6"),
    Hectare("Area", "Hectare", "9,999944100002329907e-5"),
    SquareInch("Area", "Square Inch", "1549,9944354892320462"),
    SquareFoot("Area", "Square Feet", "10,763850246452999926"),
    SquareMile("Area", "Square Mile", "3,861e-7"),
    SquareYard("Area", "Square Yard", "1,195983360717"),
    Acre("Area", "Acre", "0,00024710400014814050363"),

    // ******** Data Transfer Rate ********
    BitPerSecond("Data Transfer Rate", "Bit Per Second", "1"),
    KilobitPerSecond("Data Transfer Rate", "Kilobit Per Second", "0,001"),
    KilobytePerSecond("Data Transfer Rate", "Kilobyte Per Second", "0,000125"),
    KibibitPerSecond("Data Transfer Rate", "Kibibit Per Second", "0,000976563"),
    MegabitPerSecond("Data Transfer Rate", "Megabit Per Second", "1e-6"),
    MegabytePerSecond("Data Transfer Rate", "Megabyte Per Second", "1,25e-7"),
    MebibitPerSecond("Data Transfer Rate", "Mebibit Per Second", "9.5367e-7"),
    GigabitPerSecond("Data Transfer Rate", "Gigabit Per Second", "9.99995474e-10"),
    GigabytePerSecond("Data Transfer Rate", "Gigabyte Per Second", "1.2499943425e-10"),
    GibibitPerSecond("Data Transfer Rate", "Gibibit Per Second", "9.313183594495e-10"),
    TerabitPerSecond("Data Transfer Rate", "Terabit Per Second", "9.999954739999937644e-13"),
    TerabytePerSecond("Data Transfer Rate", "Terabyte Per Second", "1.249994342499992206e-13"),
    TebibitPerSecond("Data Transfer Rate", "Tebibit Per Second", "9.094905853999023548e-13"),

    // ******** Data Storage ********
    Bit("Data Storage","Bit","8"),
    Kilobit("Data Storage","Kilobit","0,008"),
    Kibibit("Data Storage","Kibibit","0,0078125"),
    Megabit("Data Storage","Megabit","8e-6"),
    Mebibit("Data Storage","Mebibit","7,6294e-6"),
    Gigabit("Data Storage","Gigabit","8e-9"),
    Gibibit("Data Storage","Gibibit","7,4506e-9"),
    Terabit("Data Storage","Terabit","8e-12"),
    Tebibit("Data Storage","Tebibit","7,276e-12"),
    Petabit("Data Storage","Petabit","8e-15"),
    Pebibit("Data Storage","Bit","7,1054e-15"),
    Kilobyte("Data Storage","Kilobyte","0,001"),
    Megabyte("Data Storage","Megabyte","1e-6"),
    Mebibyte("Data Storage","Mebibyte","9,5367e-7"),
    Gigabyte("Data Storage","Gigabyte","1e-9"),
    Gibibyte("Data Storage","Gibibyte","9.3132e-10"),
    Terabyte("Data Storage", "Byte", "1e-12"),
    Tebibyte("Data Storage", "Tebibyte", "9.0949e-13"),
    Petabyte("Data Storage", "Petabyte", "1e-15"),
    Pebibyte("Data Storage", "Pebibyte", "8.8818e-16"),

    // ******** Energy or Work ********
    Joule("Energy", "Joule", "1"),
    Kilojoule("Energy", "Kilojoule", "0,001"),
    Gramcalorie("Energy", "Gram Calorie", "0.239006"),
    Kilocalorie("Energy", "Kilocalorie", "0.000239006"),
    WattHour("Energy", "Watt Hour", "0.000277778"),
    KiloWattHour("Energy", "Kilowatt Hour", "2.7778e-7"),
    Electronvolt("Energy", "Electronvolt", "6.24155928e+18"),
    BritishThermalUnit("Energy", "British thermal unit", "0.000947817"),
    USTherm("Energy", "US Therm", "9.4804e-9"),
    FootPound("Energy", "Foot-pound", "0.737562"),

    // ******** Energy or Work ********
    Hertz("Frequency","Hertz","1"),
    Kilohertz("Frequency","Kilohertz","0,001"),
    Megahertz("Frequency","Megahertz","1e-6"),
    Gigahertz("Frequency","Gigahertz","1e-9"),


    // ******** Length ********
    Nanometer("Length", "Nanometer", "1e+9"),
    Micronmeter("Length", "Micronmeter", "1e+6"),
    Millimeter("Length", "Millimeter",  "1000"),
    Centimeter("Length", "Centimeter","100"),
    Decimeter("Length", "Decimeter", "10"),
    Meter("Length", "Meter", "1"),
    Decameter("Length", "Decameter", "0,1"),
    Hectometer("Length", "Hectometer", "0,01"),
    Kilometer("Length", "Kilometer", "0,001"),
    Inch("Length", "Inches", "39,37008"),
    Feet("Length", "Feet", "3,28084"),
    Yard("Length", "Yard", "1,093613"),
    Mile("Length", "Mile", "0,000621"),
    NauticalMile("Length", "NauticalMile", "0,000539957"),

    // ******** Mass ********
    Nanogram("Mass", "Nanogram", "1e+9"),
    Microgram("Mass", "Microgram", "1e+6"),
    Milligram("Mass", "Milligram", "1000"),
    Centigram("Mass", "Centigram", "100"),
    Decigram("Mass", "Decigram", "10"),
    Gram("Mass", "Gram", "1"),
    Kilogram("Mass", "Kilogram", "0,001"),
    Tonne("Mass", "Tonne", "1e-6"),
    ImperialTon("Mass", "Imperial Ton", "9,8421e-7"),
    USTon("Mass", "US Ton", "1,1023e-6"),
    Stone("Mass", "Stone", "0,000157473"),
    Pound("Mass", "Pound", "0,00220462"),
    Ounce("Mass", "Ounce", "0,035274"),

    // ******** Plane Angle ********
    Degree("Plane Angle", "Degree", "1"),
    Gradian("Plane Angle", "Gradian", "1,11111"),
    Milliradian("Plane Angle", "Milliradian", "17,4533"),
    MinuteOfArc("Plane Angle", "Minute Of Arc", "60"),
    Radian("Plane Angle", "Radian", "0.0174533"),
    SecondOfArc("Plane Angle", "Second Of Arc", "3600"),

    // ******** Pressure ********
    Pascal("Pressure", "Pascal", "1"),
    Bar("Pressure", "Bar", "1e-5"),
    PoundPerSquareInch("Pressure", "Pound Per Square Inch", "0.000145038"),
    StandardAtmosphere("Pressure", "Standard atmosphere", "9.8692e-6"),
    Torr("Pressure", "Torr", "0.00750062"),

    // ******** Speed ********
    MeterPerSecond("Speed", "Meter Per Second", "1"),
    MilesPerHour("Speed", "Miles Per Hour", "2,23694"),
    FootPerSecond("Speed", "Foot Per Second", "3,28084"),
    KilometerPerHour("Speed", "Kilometer Per Hour", "3,6"),
    Knot("Speed", "Knot", "1,94384"),

    // ******** Time ********
    Nanosecond("Time", "Nanosecond", "6e+10"),
    Microsecond("Time", "Microsecond", "6e+7"),
    Millisecond("Time", "Millisecond", "60000"),
    Second("Time", "Second", "60"),
    Hour("Time", "Hour", "0,0166667"),

    // ******** Volume ********
    CubicMeter("Volume", "Cubic Meter", "1"),
    Liter("Volume", "Liter", "1000"),
    Milliliter("Volume", "Milliliter", "1e+6"),
    CubicFoot("Volume", "Cubic Foot", "35.3147"),
    CubicInch("Volume", "Cubic Inch", "61023.7"),


    ;


    private final String type;
    private final String name;
    private final String converter;

    Unit(String type, String name, String converter) {
        this.type = type;
        this.name = name;
        this.converter = converter;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getConverter() {
        return converter;
    }
}
