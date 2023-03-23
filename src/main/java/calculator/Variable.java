package calculator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Variable extends MyNumber {

    private final String name;
    private final Expression expression;
    private String timeStamp;

    public Variable(String name, int value, Expression expression) {
        super(value);
        this.name = name;
        this.expression = expression;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss");
        this.timeStamp = df.format(new Date());
    }

    public Variable(String name, int value, Expression expression, String timeStamp) {
        super(value);
        this.name = name;
        this.expression = expression;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss");
        this.timeStamp = timeStamp;
    }

    public String getVariable() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
