package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void testEvalInfixInteger(){
        int res = calculator.eval(calculator.read("1+2+3"));
        assertEquals(6,res);
    }

    @Test
    void testEvalPrefixInteger(){
        int res =calculator.eval(calculator.read("+(1,2,3)"));
        assertEquals(6,res);
    }

    @Test
    void testEvalPostfixInteger(){
        int res =calculator.eval(calculator.read("(1,2,3)+"));
        assertEquals(6,res);
    }

    @Test
    void testEvalPrefixReal(){
        BigDecimal res = calculator.evalReal(calculator.read("+(3.14,2.71,1)"));
        assertEquals(new BigDecimal("6.85"),res);
    }

    @Test
    void testEvalInfixReal(){
        BigDecimal res = calculator.evalReal(calculator.read("3.14+2.71+1"));
        assertEquals(new BigDecimal("6.85"),res);
    }

    @Test
    void testEvalPostfixReal(){
        BigDecimal res = calculator.evalReal(calculator.read("(3.14,2.71,1)+"));
        assertEquals(new BigDecimal("6.85"),res);
    }

    @Test
    void testEvalRationalPrefix(){
        MyRationalNumber res = calculator.evalRational(calculator.read("+(1_2,1_4,1_8)"));
        assertEquals(MyRationalNumber.create(7,8),res);
    }

    @Test
    void testEvalRationalInfix(){
        MyRationalNumber res = calculator.evalRational(calculator.read("1_2+1_4+1_8"));
        assertEquals(MyRationalNumber.create(7,8),res);
    }

    @Test
    void testEvalRationalPostfix(){
        MyRationalNumber res = calculator.evalRational(calculator.read("(1_2,1_4,1_8)+"));
        assertEquals(MyRationalNumber.create(7,8),res);
    }

    @Test
    void testSetTypeInteger() {
        String input = "1+3.14";
        calculator.setType(ArithmeticType.INTEGER);
        String res = calculator.evalExpression(input);
        assertEquals("4", res);
    }

    @Test
    void testSetTypeReal(){
        String input = "1+3.14";
        calculator.setType(ArithmeticType.REAL);
        String res = calculator.evalExpression(input);
        assertEquals("4.14", res);
    }

    @Test
    void testSetTypeRational(){
        String input = "1+1_2";
        calculator.setType(ArithmeticType.RATIONAL);
        String res = calculator.evalExpression(input);
        assertEquals(MyRationalNumber.create(3,2).toString(), res);
    }

    @Test
    void testSetPrecision(){
        int[] p = new int[]{1,3,10,15};
        for (int precision: p){
            calculator.setPrecision(precision);
            BigDecimal res = calculator.evalReal(calculator.read("1/3"));
            assertEquals(res.precision(),precision);
        }
    }

    @Test
    void testModifyMathContext(){
        int precision = 10;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        calculator.setPrecision(10);
        calculator.setRoundingMode(roundingMode);
        MathContext mc = calculator.getMathContext();
        assertEquals(precision,mc.getPrecision());
        assertEquals(roundingMode,mc.getRoundingMode());
    }

    @Test
    void testSetPrecisionNegative(){
        calculator.setPrecision(10);
        calculator.setPrecision(-1);
        assertEquals(10,calculator.getMathContext().getPrecision());
    }

    @Test
    void testSetPrecisionZero(){
        calculator.setPrecision(10);
        calculator.setPrecision(0);
        assertEquals(MathContext.UNLIMITED.getPrecision(),calculator.getMathContext().getPrecision());
    }

}
