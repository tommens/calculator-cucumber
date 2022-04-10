package calculator.operation.buildinfunctions;

import calculator.*;
import visitor.Visitor;

import java.math.MathContext;
import java.util.List;


public abstract class RealFunction extends Function {

    protected MathContext mc = MathContext.DECIMAL128;

    public RealFunction(String name, List<Expression> elist) throws IllegalConstruction {
        super(name, elist);
    }


    public abstract Real op(Real l);

    @Override
    public void accept(Visitor v) {
        for (Expression a : getArgs()) {
            a.accept(v);
        }
        v.visit(this);
    }

}
