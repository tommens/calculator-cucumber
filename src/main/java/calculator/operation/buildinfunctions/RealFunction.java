package calculator.operation.buildinfunctions;

import calculator.*;
import visitor.Visitor;

import java.math.MathContext;
import java.util.List;


public abstract class RealFunction extends Function {

    protected MathContext mc = MathContext.DECIMAL128;

    public RealFunction(String name, Expression expression) {
        super(name, expression);
    }

    public abstract Real op(Real l);

}
