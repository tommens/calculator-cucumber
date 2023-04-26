package converter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Currency extends Measurement {
    //Factors of different currency conversions to euros.
    final private double $_TO_€ = 0.91636347; //dollars
    final private double ¥_TO_€ = 0.0068542225; //yens
    final private double £_TO_€ = 1.1383746; //pounds
    final private double CNY_TO_€ = 0.13306189; //renminbis
    final private double CHF_TO_€ = 1.0144173; //swiss francs
    final private double €_TO_€ = 1.0; //euros

    private double factor;

    //This constructor will be useful to get the right factors.
    public Currency(String unit) {
        try {
            //We set the factor depending on the asked unit using the names
            //we defined at the beginning.
            unit = unit.toUpperCase(); //we put it in upper case to match the factors' names
            Field field = this.getClass().getDeclaredField(unit + "_TO_€");
            factor = field.getDouble(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Unknown unit, try something else");
        }
    }

    //This method converts a given value to meters, so that we can use the factor
    //to get the final desired value.
    public double toEuros(double value){
        return value*factor;
    }

    //This method converts a value that is in meters to the desired unit.
    public double fromEuros(double value){
        return value/factor;
    }

    //The method doing the whole conversion and printing the results.
    public static BigDecimal printConversion(double value, String fromUnit, String toUnit) {
        Currency from = new Currency(fromUnit);
        Currency to = new Currency(toUnit);

        double inMeters = from.toEuros(value);

        //We use BigDecimal and RoundingMode to avoid rounding errors.
        BigDecimal result = BigDecimal.valueOf(to.fromEuros(inMeters));
        int scale = 9;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        result = result.setScale(scale, roundingMode);

        System.out.println(value + fromUnit + " = " + result + toUnit);
        return result;
    }
}
