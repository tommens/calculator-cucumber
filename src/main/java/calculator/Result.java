package calculator;

public class Result {

    private final String variable;
    private final int result;
    private final Expression expression;

    public Result(String variable, int result, Expression expression) {
        this.variable = variable;
        this.result = result;
        this.expression = expression;
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
}
