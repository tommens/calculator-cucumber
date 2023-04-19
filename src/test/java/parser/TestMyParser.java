package parser;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Expression;
import calculator.Notation;
import calculator.Operation;
import org.junit.jupiter.api.*;


public class TestMyParser {

    @Test
    void testPrefix(){
        String testString = "+(1,2,3)";
        Expression e = MyParser.parse(testString);
        Operation op = (Operation) e;
        assertEquals(Notation.PREFIX,op.notation);
    }

    @Test
    void testInfix(){
        String testString = "3+2";
        Expression e = MyParser.parse(testString);
        Operation op = (Operation) e;
        assertEquals(Notation.INFIX,op.notation);
    }

    @Test
    void testPostfix(){
        String testString = "(3,6,8)-";
        Expression e = MyParser.parse(testString);
        Operation op = (Operation) e;
        assertEquals(Notation.POSTFIX,op.notation);
    }

    @Test
    void testMultipleExpr(){
        String testString = "+(1,2,(*(6,3,(-(7,3)))))";
        String expectedString = "+ (1, 2, * (6, 3, - (7, 3)))";
        Expression e = MyParser.parse(testString);
        assertEquals(expectedString,e.toString());
    }

    @Test
    void testMultipleTypeExpr(){
        String testString = "-(1,(1+2))";
        String expectedString = "- (1, ( 1 + 2 ))";
        Expression e = MyParser.parse(testString);
        assertEquals(expectedString,e.toString());
    }
}
