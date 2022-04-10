package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

import java.util.List;

public class Sin extends RealFunction{


    public Sin(List<Expression> elist) throws IllegalConstruction {
        super("sin", elist);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.sin(l.getValue(), mc));
    }
}
