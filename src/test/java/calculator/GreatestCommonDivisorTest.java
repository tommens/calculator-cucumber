package calculator;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {

    private final int value1 = 8;
    private final int value2 = 10;
    private final int value3 = 4;
    private final int value4 = 5;

    private GreatestCommonDivisor op;
    private List<Expression> params;

    @BeforeEach
    void setUp() {
        params = Arrays.asList(new MyNumber(value1),new MyNumber(value2));
        try { op = new GreatestCommonDivisor(params); }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should not be equal
        List<Expression> p = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            GreatestCommonDivisor e = new GreatestCommonDivisor(p, Notation.INFIX);
            assertEquals(op, e);
        }
        catch(IllegalConstruction e) { fail(); }
    }


}