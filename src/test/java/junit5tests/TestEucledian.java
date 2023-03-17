package junit5tests;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.MyNumber;
import calculator.Notation;
import calculator.arithmetics.Eucledian;
import calculator.arithmetics.Modulo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEucledian
{

    @Test
    void testConstructor1()
    {
        assertThrows(IllegalConstruction.class, () -> new Eucledian(null));
    }

    @Test
    void testConstructor2()
    {
        try {
            assertTrue(new Eucledian(List.of(new MyNumber(1)), Notation.INFIX) instanceof Eucledian);
        }catch (IllegalConstruction e){fail();}
    }

    @Test
    void testCalculateEuclidian() throws IllegalConstruction
    {
        Eucledian op = new Eucledian(new ArrayList<Expression>());
        assertEquals(8, op.op(24, 16));
        assertEquals(27, op.op(81, 27));
        assertEquals(5, op.op(50, 15));
        assertEquals(12, op.op(144, 60));
    }
}
