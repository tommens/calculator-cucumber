package junit5tests;

import calculator.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestVariable {

    Expression e;
    Calculator c = new Calculator();

    @Test
    public void testVariable() {
        try {
            e = new MyNumber(new BigDecimal(8));
            c.print(e);
            c.eval(e);

            List<Expression> params = new ArrayList<>();
            Collections.addAll(params, new MyNumber(new BigDecimal(3)), new MyNumber(new BigDecimal(4)), new MyNumber(new BigDecimal(5)));
            e = new Plus(params, Notation.PREFIX);
            c.printExpressionDetails(e);
            c.eval(e);
            Variable v = new Variable("a",c.eval(e),e);
            assert v.getName().equals("a");
            assert v.getValue().equals(new BigDecimal(12));
            assert v.getExpression().equals(e);
            System.out.println(v.toStringDetails());

            List<Expression> params2 = new ArrayList<>();
            Collections.addAll(params2, new MyNumber(new BigDecimal(5)), new MyNumber(new BigDecimal(3)));
            e = new Minus(params2, Notation.INFIX);
            c.print(e);
            c.eval(e);

            List<Expression> params3 = new ArrayList<>();
            Collections.addAll(params3, v, new Minus(params2));
            e = new Times(params3);
            c.printExpressionDetails(e);
            c.eval(e);

            List<Expression> params4 = new ArrayList<>();
            Collections.addAll(params4, new Plus(params), new Minus(params2), new MyNumber(new BigDecimal(5)));
            e = new Divides(params4, Notation.POSTFIX);
            c.print(e);
            c.eval(e);
        } catch (IllegalConstruction exception) {
            fail("IllegalConstruction");
        }
    }

}