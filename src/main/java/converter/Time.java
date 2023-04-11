package converter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Time extends Measurement {
    //Factors of different time conversions to seconds.
    final private double ms_TO_s = 0.001; //milliseconds
    final private double mn_TO_s = 60; //minutes
    final private double h_TO_s = 3600; //hours
    final private double d_TO_s = 86400; //days
    final private double wk_TO_s = 604800; //weeks
    final private double yr_TO_s = 3.154e7; //years
    final private double s_TO_s = 1.0; //seconds

    private double factor;

    //This constructor will be useful to get the right factors.
    public Time(String unit) {
        try {
            //We set the factor depending on the asked unit using the names
            //we defined at the beginning.
            Field field = this.getClass().getDeclaredField(unit + "_TO_s");
            factor = field.getDouble(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unknown unit, try something else");
        }
    }

    //This method converts a given value to seconds, so that we can use the factor
    //to get the final desired value.
    public double toSeconds(double value){
        return value*factor;
    }

    //This method converts a value that is in seconds to the desired unit.
    public double fromSeconds(double value){
        return value/factor;
    }

    //The method doing the whole conversion and printing the results.
    public static BigDecimal printConversion(double value, String fromUnit, String toUnit) {
        Time from = new Time(fromUnit);
        Time to = new Time(toUnit);

        double inSeconds = from.toSeconds(value);

        //We use BigDecimal and RoundingMode to avoid rounding errors.
        BigDecimal result = BigDecimal.valueOf(to.fromSeconds(inSeconds));
        int scale = 9;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        result = result.setScale(scale, roundingMode);

        System.out.println(value + fromUnit + " = " + result + toUnit);
        return result;
    }
}
