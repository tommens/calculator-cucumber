package parser;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.api.*;


public class TestTokens {

    @Test
    void testInteger(){
        String input = "12";
        Expression e = MyParser.parse(input);
        assertEquals(MyInteger.class,e.getClass());
    }

    @Test
    void testRealNumber(){
        String input = "1.2";
        Expression e = MyParser.parse(input);
        assertEquals(MyRealNumber.class,e.getClass());
    }

    @Test
    void testRealNumber2(){
        String[] input = new String[]{"1.2E10","1.2E+10","1.2E-10"};
        for (String c : input){
            Expression e = MyParser.parse(c);
            assertEquals(MyRealNumber.class,e.getClass());
        }
    }

    @Test
    void testPi(){
        String input = "π";
        Expression e = MyParser.parse(input);
        assertEquals(MyRealNumber.class,e.getClass());
    }

    @Test
    void testEuler(){
        String input = "e";
        Expression e = MyParser.parse(input);
        assertEquals(MyRealNumber.class,e.getClass());
    }

    @Test
    void testRational(){
        String input = "1_2";
        Expression e = MyParser.parse(input);
        assertEquals(MyRationalNumber.class,e.getClass());
    }

}
