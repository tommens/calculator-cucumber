package parser;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.api.*;


public class TestPostfixParser {

    @Test
    void testPostfixPlus(){
        String input = "(1,2,3)+";
        Expression e = MyParser.parse(input);
        assertEquals(Plus.class,e.getClass());
        Plus op = (Plus) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }
    @Test
    void testPostfixMinus(){
        String input = "(1,2,3)-";
        Expression e = MyParser.parse(input);
        assertEquals(Minus.class,e.getClass());
        Minus op = (Minus) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }
    @Test
    void testPostfixTimes(){
        String input = "(1,2,3)*";
        Expression e = MyParser.parse(input);
        assertEquals(Times.class,e.getClass());
        Times op = (Times) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }
    @Test
    void testPostfixDivides(){
        String input = "(1,2,3)/";
        Expression e = MyParser.parse(input);
        assertEquals(Divides.class,e.getClass());
        Divides op = (Divides) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }

    @Test
    void testPostfixModulo(){
        String input = "(1,2,3)%";
        Expression e = MyParser.parse(input);
        assertEquals(Modulo.class,e.getClass());
        Modulo op = (Modulo) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }

    @Test
    void testPostfixPower(){
        String input = "(1,2,3)^";
        Expression e = MyParser.parse(input);
        assertEquals(Power.class,e.getClass());
        Power op = (Power) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }

    @Test
    void testPostfixGCD(){
        String input = "(1,2,3)gcd";
        Expression e = MyParser.parse(input);
        assertEquals(GreatestCommonDivisor.class,e.getClass());
        GreatestCommonDivisor op = (GreatestCommonDivisor) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }

    @Test
    void testPostfixLCM(){
        String input = "(1,2,3)lcm";
        Expression e = MyParser.parse(input);
        assertEquals(LeastCommonMultiple.class,e.getClass());
        LeastCommonMultiple op = (LeastCommonMultiple) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }
}
