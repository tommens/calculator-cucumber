package parser;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.api.*;

public class TestPrefixParser {

    @Test
    void testPrefixPlus(){
        String input = "+(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Plus.class,e.getClass());
        Plus op = (Plus) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixMinus(){
        String input = "-(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Minus.class,e.getClass());
        Minus op = (Minus) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixTimes(){
        String input = "*(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Times.class,e.getClass());
        Times op = (Times) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixDivides(){
        String input = "/(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Divides.class,e.getClass());
        Divides op = (Divides) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixModulo(){
        String input = "%(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Modulo.class,e.getClass());
        Modulo op = (Modulo) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixPower(){
        String input = "^(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(Power.class,e.getClass());
        Power op = (Power) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixGCD(){
        String input = "gcd(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(GreatestCommonDivisor.class,e.getClass());
        GreatestCommonDivisor op = (GreatestCommonDivisor) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testPrefixLCM(){
        String input = "lcm(1,2,3)";
        Expression e = MyParser.parse(input);
        assertEquals(LeastCommonMultiple.class,e.getClass());
        LeastCommonMultiple op = (LeastCommonMultiple) e;
        assertEquals(Notation.PREFIX,op.notation);
    }
}
