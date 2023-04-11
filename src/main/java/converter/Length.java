package converter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length {
    //Factors of different length conversions to meters.
    final private double MM_TO_M = 0.001; //millimeters
    final private double CM_TO_M = 0.01; //centimeters
    final private double DM_TO_M = 0.1; //decimeters
    final private double DAM_TO_M = 10; //dekameters
    final private double HM_TO_M = 100; //hectometers
    final private double KM_TO_M = 1000; //kilometers
    final private double IN_TO_M = 0.0254; //inches
    final private double MI_TO_M = 1609.344; //miles
    final private double YD_TO_M = 0.9144; //yards
    final private double NM_TO_M = 1852; //nautical miles
    final private double FT_TO_M = 0.3048; //feet
    final private double M_TO_M = 1.0; //meters

    private double factor;

    //This constructor will be useful to get the right factors.
    public Length(String unit) {
        try {
            //We set the factor depending on the asked unit using the names
            //we defined at the beginning.
            unit = unit.toUpperCase(); //we put it in upper case to match the factors' names
            Field field = this.getClass().getDeclaredField(unit + "_TO_M");
            factor = field.getDouble(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unknown unit, try something else");
        }
    }

    //This method converts a given value to meters, so that we can use the factor
    //to get the final desired value.
    public double toMeters(double value){
        return value*factor;
    }

    //This method converts a value that is in meters to the desired unit.
    public double fromMeters(double value){
        return value/factor;
    }

    //The method doing the whole conversion and printing the results.
    public static void printConversion(double value, String fromUnit, String toUnit) {
        Length from = new Length(fromUnit);
        Length to = new Length(toUnit);

        double inMeters = from.toMeters(value);

        //We use BigDecimal and RoundingMode to avoid rounding errors.
        BigDecimal result = BigDecimal.valueOf(to.fromMeters(inMeters));
        int scale = 9;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        result = result.setScale(scale, roundingMode);

        System.out.println(value + fromUnit + " = " + result + toUnit);
    }
}
