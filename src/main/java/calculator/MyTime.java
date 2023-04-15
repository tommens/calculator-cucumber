package calculator;

import visitor.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Time is a concrete class that represents time intervals for time computations
 */
public class MyTime implements Expression {
    private String currentDate = LocalDate.now().toString();
    private String currentTime = "00:00:00";
    private String timezone = "+00:00";
    private String timeFormat = null;
    private ZonedDateTime date;
    private long dateInSeconds = 0;
    private final int SECONDS_IN_A_MINUTE = 60;
    private final int SECONDS_IN_AN_HOUR = 3600;
    private final int SECONDS_IN_A_DAY = 86400;

    /**
     * Constructor method for Time class
     *
     * @param input the String corresponding to the date
     */
    public MyTime(String input) {
        //I split the input in parts to check which format is provided.
        //Each part represents a specification in the date given (date, time, timezone, format)
        String[] inputParts = input.split(" ");
        for (String part : inputParts) {
            //Checking if the part is in the format yyyy-MM-dd
            if (part.matches("\\d{4}-\\d{2}-\\d{2}")) {
                currentDate = part;
            } //Checking if the part is a time (hh:mm:ss with ss being optional)
            else if (part.matches("\\d{2}:\\d{2}(:\\d{2})?") && !part.startsWith("+") && !part.startsWith("-")) {
                if (part.length() == 5) {
                    //We add :00 at the end of the String if no seconds were provided
                    currentTime = part + ":00";
                } else {
                    currentTime = part;
                }
            }//Changing the time format depending on what was provided
            else if (part.equalsIgnoreCase("am") || part.equalsIgnoreCase("pm")) {
                timeFormat = part.toLowerCase();
            } //Checking if the timezone was provided
            else if (part.matches("[+-]\\d{2}:\\d{2}")) {
                timezone = part;
            }
        }

        String fullDate;
        String pattern;
        if (timeFormat != null) {
            fullDate = String.format("%s %s %s %s", currentDate, currentTime, timeFormat, timezone);
            pattern = "yyyy-MM-dd HH:mm:ss a z";
        } else {
            fullDate = String.format("%s %s %s", currentDate, currentTime, timezone);
            pattern = "yyyy-MM-dd hh:mm:ss z";
        }

        date = ZonedDateTime.parse(fullDate, DateTimeFormatter.ofPattern(pattern));
        dateInSeconds = date.toEpochSecond();
    }

    /**
     * Accept method to implement the visitor design pattern to traverse arithmetic expressions.
     * Each time interval will pass itself to the visitor object to get processed by the visitor.
     *
     * @param v The visitor object
     */
    @Override
    public void accept(Visitor v) {}
    @Override
    public void accept(TimeVisitor v) {
        v.visit(this);
    }
    @Override
    public int countOps() {
        return 0;
    }
    @Override
    public int countNbs() {
        return 1;
    }
    @Override
    public int countDepth() {
        return 1;
    }/*
    public long inSeconds() {
        return dateInSeconds;
    }
    public long inMinutes() {
        return dateInSeconds / SECONDS_IN_A_MINUTE;
    }
    public long inHours() {
        return dateInSeconds / SECONDS_IN_AN_HOUR;
    }
    public long inDays() {
        return dateInSeconds / SECONDS_IN_A_DAY;
    }*/

    public void subtract(MyTime mt){
        Duration duration = Duration.between(this.date, mt.date);

        System.out.println("Duration from " + date + "to " + mt.date + ":");
        System.out.printf(duration.toDays()+" days, "+duration.toHours() % 24+" hours, "+
                        duration.toMinutes() % 1440+" minutes and "+duration.getSeconds() % 86400+" seconds;");
        System.out.println("Or " + duration.getSeconds() + " seconds;");
        System.out.println("Or " + duration.toMinutes() + " minutes;");
        System.out.println("Or " + duration.toHours() + " hours;");
    }

}
