package calculator;

import visitor.TimeVisitor;
import visitor.Visitor;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Time is a concrete class that represents time intervals for time computations
 */
public class MyTime implements Expression {
    private String currentDate = LocalDate.now().toString();
    private String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
    private String timezone = "+00:00";
    private String timeFormat = null;
    private final ZonedDateTime date;
    private final long dateInSeconds;

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
            else if (part.matches("(?i)am|pm")) {
                timeFormat = part.toUpperCase();
            } //Checking if the timezone was provided
            else if (part.matches("[+-]\\d{2}:\\d{2}")) {
                timezone = part;
            }
        }
        String fullDate;
        String pattern;
        if (timeFormat == null) {
            fullDate = String.format("%s %s %s", currentDate, currentTime, timezone);
            pattern = "yyyy-MM-dd HH:mm:ss z";
        } else {
            fullDate = String.format("%s %s %s %s", currentDate, currentTime, timeFormat, timezone);
            pattern = "yyyy-MM-dd hh:mm:ss a z";
        }
        date = ZonedDateTime.parse(fullDate, DateTimeFormatter.ofPattern(pattern));
        dateInSeconds = date.toEpochSecond();
    }

    public long toSeconds(){
        return dateInSeconds;
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
    }

    public void subtract(MyTime mt){
        long durationHours,durationMinutes,durationSeconds;
        Duration duration = Duration.between(mt.date, this.date);
        if (duration.toDays() == 0) {
            durationHours=duration.toHours() % 24;
        }
        else {durationHours=duration.toHours() % (24*duration.toDays());}
        if (durationHours == 0) {
            durationMinutes = duration.toMinutes() % 60;
        }
        else {durationMinutes = duration.toMinutes() % (60*durationHours);}
        if (durationMinutes == 0) {
            durationSeconds = duration.toSeconds() % 60;
        }
        else {durationSeconds = duration.toSeconds() % (60*durationMinutes);}
        System.out.println("Duration from " + date + " to " + mt.date + " : ");
        System.out.println(duration.toDays()+" days, "+ durationHours +" hours, "+
                        durationMinutes +" minutes and "+ durationSeconds +" seconds;");
        System.out.println("Or " + duration.getSeconds() + " seconds;");
        System.out.println("Or " + duration.toMinutes() + " minutes;");
        System.out.println("Or " + duration.toHours() + " hours;");
    }

    /*public MyTime add(MyTime mt){
        long sumInSeconds = this.dateInSeconds + mt.dateInSeconds;
        ZonedDateTime sumDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(sumInSeconds), ZoneId.systemDefault());
        String sumDateStr = sumDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        MyTime sum = new MyTime(sumDateStr);
        System.out.println("Addition of the dates " + date + " and " + mt.date +
                " corresponds to the following date : " + sum.getDate());
        return sum;
    }*/
    public MyTime add(MyRealNumber seconds) {
        long sumInSeconds = this.dateInSeconds + seconds.getRealNumber().longValue();
        ZonedDateTime sumDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(sumInSeconds), ZoneId.systemDefault());
        String sumDateStr = sumDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        MyTime sum = new MyTime(sumDateStr);
        System.out.println("Adding " + seconds + " seconds to the date " + date + " corresponds to the following date: " + sum.getDate());
        return sum;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    //method used in Main to convert the result to a date when adding or subtracting a long
    // (representing seconds) to a date
    public static String resultToDate(int result){
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(result, 0, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
