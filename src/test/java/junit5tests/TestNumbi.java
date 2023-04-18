package junit5tests;

import calculator.MyBigNumber;
import calculator.MyNumber;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumbi
{
    @Test
    void testNumbi()
    {
        MyNumber n = new MyNumber(1);
        MyBigNumber m = new MyBigNumber(BigInteger.ONE);

        assertEquals(n.countDepth(), 0);
        assertEquals(n.countOps(), 0);
        assertEquals(n.countNbs(), 1);

        assertEquals(m.countDepth(), BigInteger.ZERO);
        assertEquals(m.countOps(), BigInteger.ZERO);
        assertEquals(m.countNbs(), BigInteger.ONE);
    }
}
