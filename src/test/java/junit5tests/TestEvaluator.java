package junit5tests;

//Import Junit5 libraries for unit testing:
import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

class TestEvaluator {

    private Calculator calc;
    private int value1, value2, imaginary1, imaginary2, den;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        imaginary1 = 4;
        imaginary2 = 1;
        den = (value2 * value2) + (imaginary2 * imaginary2);
    }

    @Test
    void testEvaluatorMyNumber() {
        assertEquals( new MyNumber(value1), calc.eval(new MyNumber(value1)));
    }

    @Test
    void testEvaluatorMyComplexNumber() {
        assertEquals( new MyNumber(value1,imaginary1), calc.eval(new MyNumber(value1,imaginary1)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-", "sqrt", "||"})
    void testEvaluateOperations(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1),new MyNumber(value2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value1 + value2), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1 - value2), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber(value1 * value2), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(value1 / value2), calc.eval(new Divides(params)));
                case "sqrt"	->	assertEquals( new MyNumber((int) Math.sqrt(value1)), calc.eval(new Sqrt(params)));
                case "||"	->	assertEquals( new MyNumber(value1), calc.eval(new Modulus(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateComplexOperations(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1,imaginary1),new MyNumber(value2,imaginary2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value1 + value2,imaginary1 + imaginary2), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1 - value2, imaginary1 - imaginary2), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber((value1 * value2) - (imaginary1 * imaginary2), (value1 * imaginary2) + (value2 * imaginary1)), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(((value1 * value2) + (imaginary1 * imaginary2)) / den, ((imaginary1 * value2) - (value1 * imaginary2)) / den), calc.eval(new Divides(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

}
