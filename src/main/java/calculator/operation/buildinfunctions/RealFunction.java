package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Function;
import calculator.IllegalConstruction;
import calculator.Number;
import visitor.Visitor;

import java.util.List;


public abstract class RealFunction extends Function {

    Expression expression;

    public RealFunction(String name, List<Expression> elist) throws IllegalConstruction {
        super(name, elist);
    }


    public abstract Number op(Number l);

    @Override
    public void accept(Visitor v) {
        for (Expression a : getArgs()) {
            a.accept(v);
        }
        v.visit(this);
    }

}
