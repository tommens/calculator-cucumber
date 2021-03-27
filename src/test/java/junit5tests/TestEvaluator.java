package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;
import visitor.Evaluator;

import java.math.BigInteger;
import java.util.Arrays;

public class TestEvaluator {

    @SuppressWarnings("unused")
    private Evaluator visitor;
    private Calculator calc;
    private BigInteger value1, value2;
    private Expression op;

    @BeforeEach
    public void setUp() {
        visitor = new Evaluator();
        calc = new Calculator();
        value1 = new BigInteger("8");
        value2 = new BigInteger("6");
    }

    @Test
    public void testEvaluatorMyNumber() {
        assertEquals( value1,
                      calc.eval(new MyNumber(value1)));
    }

    @Test
    public void testEvaluatorDivides() {
        try { op = new Divides(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
          assertEquals( value1.divide(value2),
                        calc.eval(op) );
          }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPlus() {
        try { op = new Plus(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1.add(value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorMinus() {
        try { op = new Minus(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1.subtract(value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorTimes() {
        try { op = new Times(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1.multiply(value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

}
