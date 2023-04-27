package converter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Power extends Measurement {
    //Factors of different power conversions to watts.
    final private double kW_TO_W = 1000; //kilowatts
    final private double MW_TO_W = 1e6; //megawatt
    final private double GW_TO_W = 1e9; //gigawatt
    final private double TW_TO_W = 1e12; //terawatts
    final private double PW_TO_W = 1e15; //petawatts
    final private double W_TO_W = 1.0; //watts

    private double factor;

    //This constructor will be useful to get the right factors.
    public Power(String unit) {
        try {
            //We set the factor depending on the asked unit using the names
            //we defined at the beginning.
            Field field = this.getClass().getDeclaredField(unit + "_TO_W");
            factor = field.getDouble(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unknown unit, try something else");
        }
    }

    //This method converts a given value to watts, so that we can use the factor
    //to get the final desired value.
    public double toWatts(double value){
        return value*factor;
    }

    //This method converts a value that is in watts to the desired unit.
    public double fromWatts(double value){
        return value/factor;
    }

    //The method doing the whole conversion and printing the results.
    public static BigDecimal printConversion(double value, String fromUnit, String toUnit) {
        Power from = new Power(fromUnit);
        Power to = new Power(toUnit);

        double inWatts = from.toWatts(value);

        //We use BigDecimal and RoundingMode to avoid rounding errors.
        BigDecimal result = BigDecimal.valueOf(to.fromWatts(inWatts));
        int scale = 9;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        result = result.setScale(scale, roundingMode);

        System.out.println(value + fromUnit + " = " + result + toUnit);
        return result;
    }
}
