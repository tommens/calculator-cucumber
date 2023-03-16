package junit5tests;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.MyNumber;
import calculator.Notation;
import calculator.arithmetics.Modulo;
import calculator.arithmetics.Ppcm;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.Module;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModulo
{

    @Test
    void testConstructor1()
    {
        assertThrows(IllegalConstruction.class, () -> new Modulo(null));
    }

    @Test
    void testConstructor2()
    {
        try {
            assertTrue(new Modulo(List.of(new MyNumber(1)), Notation.INFIX) instanceof Modulo);
        }catch (IllegalConstruction e){fail();}
    }

    @Test
    void testCalculatePpcm() throws IllegalConstruction
    {
        Modulo op = new Modulo(new ArrayList<Expression>());
        assertEquals(0, op.op(1, 1));
        assertEquals(6, op.op(13, 7));
        assertEquals(2, op.op(8, 6));
        assertEquals(20, op.op(100, 40));
        assertEquals(-1, op.op(0, 0));
        assertEquals(-1, op.op(50, 0));
    }
}
