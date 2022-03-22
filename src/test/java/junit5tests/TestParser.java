package junit5tests;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class TestParser {


    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testParseInteger() {
        String expr = "5";
        assertEquals(new MyNumber(5), Parser.parse(expr));
    }

    /*
    @Test
    public void testParseDecimal() {
        fail(); // Not yet implemented
    }

    @Test
    public void testParseImaginary() {
        fail(); // Not yet implemented
    }
    */

    @Test
    public void testParseAddition() throws Exception {
        String expr = "1+2";
        assertEquals(
                new Plus(List.of(new MyNumber(1), new MyNumber(2))),
                Parser.parse(expr)
        );
    }

    @Test
    public void testParseDifference() throws Exception {
        String expr = "1-2";
        assertEquals(
                new Minus(List.of(new MyNumber(1), new MyNumber(2))),
                Parser.parse(expr)
        );
    }

    @Test
    public void testParseMultiplication() throws Exception {
        String expr = "1*2";
        assertEquals(
                new Times(List.of(new MyNumber(1), new MyNumber(2))),
                Parser.parse(expr)
        );
    }

    @Test
    public void testParseDivision() throws Exception {
        String expr = "1/2";
        assertEquals(
                new Divides(List.of(new MyNumber(1), new MyNumber(2))),
                Parser.parse(expr)
        );
    }

    @Test
    public void testParsePriority() throws Exception {
        String expr = "1 + 2 * 3";
        assertEquals(
                new Plus(List.of(new MyNumber(1),
                        new Times(List.of(new MyNumber(2), new MyNumber(3))))),
                Parser.parse(expr)
        );
    }

    @Test
    public void testParseParentheses() throws Exception {
        String expr = "(1 + 2) * 3";
        assertEquals(
                new Times(List.of(
                    new Plus(List.of(new MyNumber(1), new MyNumber(2))),
                    new MyNumber(3))),
                Parser.parse(expr)
        );
    }
}
