package calculator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {

    private final String variable;
    private final int result;
    private final Expression expression;
    private String timeStamp;

    public Result(String variable, int result, Expression expression) {
        this.variable = variable;
        this.result = result;
        this.expression = expression;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss");
        this.timeStamp = df.format(new Date());
    }

    public String getVariable() {
        return variable;
    }

    public int getResult() {
        return result;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
