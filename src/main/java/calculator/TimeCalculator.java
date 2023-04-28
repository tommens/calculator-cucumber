package calculator;
import visitor.TimeEvaluator;
public class TimeCalculator {
    public MyTime eval(Expression e) {
        TimeEvaluator v = new TimeEvaluator();
        e.accept(v);
        return v.getResult();
    }
    public void print(Expression e) {
        System.out.println();
    }
}