package junit5tests;

//Import Junit5 libraries for unit testing:
import static java.lang.Math.pow;
import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

class TestEvaluator {

    private Calculator calc;
    private BigDecimal value1, value2, imaginary1, imaginary2;
    private int exp1, exp2;
    private Expression op;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = new BigDecimal(8);
        value2 = new BigDecimal(6);
        imaginary1 = new BigDecimal(4);
        imaginary2 = new BigDecimal(1);
        exp1 = 2;
        exp2 = 4;
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
        List<Expression> params = Arrays.asList(new MyNumber (value1),new MyNumber(value2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test

            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value1.add(value2)), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1.subtract(value2)), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber(value1.multiply(value2)), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(value1.divide(value2, MathContext.DECIMAL128)), calc.eval(new Divides(params)));
                case "sqrt"	->	assertEquals( new MyNumber(value1.sqrt(MathContext.DECIMAL128)), calc.eval(new Sqrt(params)));
                case "||"	->	assertEquals( new MyNumber(value1), calc.eval(new Modulus(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-"})

    void testEvaluateComplexOperations(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1,imaginary1),new MyNumber(value2,imaginary2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value1.add(value2, MathContext.DECIMAL128),imaginary1.add(imaginary2, MathContext.DECIMAL128)), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1.subtract(value2, MathContext.DECIMAL128),imaginary1.subtract(imaginary2)), calc.eval(new Minus(params)));
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateOperationsWithExp1(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber (value1,exp1),new MyNumber(value2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test

            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value1.add(value2.divide(BigDecimal.valueOf(pow(10,2)), MathContext.DECIMAL128)),2), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1.subtract(value2.divide(BigDecimal.valueOf(pow(10,2)), MathContext.DECIMAL128)),2), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber(value1.multiply(value2),exp1), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(value1.divide(value2, MathContext.DECIMAL128),exp1), calc.eval(new Divides(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateOperationsWithExp2(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber (value1),new MyNumber(value2,exp2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test   8 60000

            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value2.add(value1.divide(BigDecimal.valueOf(pow(10,4)), MathContext.DECIMAL128)),4), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1.subtract(value2.multiply(BigDecimal.valueOf(pow(10,4))), MathContext.DECIMAL128),0), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber(value1.multiply(value2),exp2), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(value1.divide(value2,MathContext.DECIMAL128),-4), calc.eval(new Divides(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateOperationsWithTwoExp(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber (value1,exp1),new MyNumber(value2,exp2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test

            switch (symbol) {
                case "+"	->	assertEquals( new MyNumber(value2.add(value1.divide(BigDecimal.valueOf(pow(10,2)), MathContext.DECIMAL128)),exp2), calc.eval(new Plus(params)));
                case "-"	->	assertEquals( new MyNumber(value1.subtract(value2.multiply(BigDecimal.valueOf(pow(10,2))), MathContext.DECIMAL128),exp1), calc.eval(new Minus(params)));
                case "*"	->	assertEquals( new MyNumber(value1.multiply(value2),exp1+exp2), calc.eval(new Times(params)));
                case "/"	->	assertEquals( new MyNumber(value1.divide(value2, MathContext.DECIMAL128),exp1-exp2), calc.eval(new Divides(params)));
                default		->	fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

}
