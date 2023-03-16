package junit5tests;

import calculator.*;
import calculator.arithmetics.Pgcd;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPgcd
{

    @Test
    void testConstructor1()
    {
        assertThrows(IllegalConstruction.class, () -> new Pgcd(null));
    }

    @Test
    void testConstructor2()
    {
        try {
            assertTrue(new Pgcd(Arrays.asList(new MyNumber(1)), Notation.INFIX) instanceof Pgcd);
        }catch (IllegalConstruction e){fail();}
    }

    @Test
    void testCalculatePgcd() throws IllegalConstruction
    {
        List<Expression> params = Arrays.asList(new MyNumber(8), new MyNumber(6));
        Pgcd op = new Pgcd(params);
        assertEquals(2, op.op(8, 6));
        assertEquals(20, op.op(100, 40));
        assertEquals(0, op.op(0, 0));
        assertEquals(1, op.op(1, 1));
        assertEquals(1, op.op(13, 7));
    }
}
