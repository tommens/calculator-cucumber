package calculator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Variable extends MyNumber {

    private String name;
    private Expression expression;
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
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String toStringDetails() {
        return this.timeStamp + " : " + this.name + " = " + this.getValue() + " = " + this.expression;
    }
}
