package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Number;

import java.util.List;


public class Identity extends RealFunction {

    public Identity(List<Expression> elist) throws IllegalConstruction {
        super("identity", elist);
    }

    @Override
    public Number op(Number l) {
        return l;
    }
}
