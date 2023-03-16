package junit5tests;

import calculator.*;
import calculator.arithmetics.Pgcd;
import calculator.arithmetics.Ppcm;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPpcm
{
    @Test
    void testConstructor1()
    {
        assertThrows(IllegalConstruction.class, () -> new Ppcm(null));
    }

    @Test
    void testConstructor2()
    {
        try {
            assertTrue(new Ppcm(Arrays.asList(new MyNumber(1)), Notation.INFIX) instanceof Ppcm);
        }catch (IllegalConstruction e){fail();}
    }

    @Test
    void testCalculatePpcm() throws IllegalConstruction
    {
        Ppcm op = new Ppcm(new ArrayList<Expression>());
        assertEquals(24, op.op(8, 6));
        assertEquals(200, op.op(100, 40));
        assertEquals(0, op.op(0, 0));
        assertEquals(1, op.op(1, 1));
        assertEquals(91, op.op(13, 7));
    }
}
