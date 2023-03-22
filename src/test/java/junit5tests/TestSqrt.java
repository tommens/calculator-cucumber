package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestSqrt {

    private final int value1 = 8;
    private final int value2 = 16;
    private Sqrt op;
    private List<Expression> params;

    @BeforeEach
    void setUp() {
        params = Arrays.asList(new MyNumber(value1),new MyNumber(value2));
        try {
            op = new Sqrt(params);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new Sqrt(null));
    }

    @Test
    void testConstructor2() {
        // A Plus expression should not be the same as a Times expression
        try {
            assertNotSame(op, new Sqrt(new ArrayList<>()));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should not be equal
        List<Expression> p = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            Sqrt e = new Sqrt(p, Notation.INFIX);
            assertEquals(op, e);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    void testNull() {
        assertDoesNotThrow(() -> op==null); // Direct way to test if the null case is handled.
    }

    @Test
    void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        List<Expression> p = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            Sqrt e = new Sqrt(p, Notation.INFIX);
            assertEquals(e.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new Sqrt(params));
    }

    @Test
    void testComplexSolution1(){
        int value3 = -1;
        MyNumber sol = op.op(new MyNumber(value3));
        assertTrue(sol.isComplex());
    }

    @Test
    void testComplexSolution2(){
        MyNumber sol = op.op(new MyNumber(value1,value2));
        assertTrue(sol.isComplex());
    }

    @Test
    void testComplexSolution3(){
        MyNumber sol = op.op(new MyNumber(0,value2));
        assertTrue(sol.isComplex());
    }

    @Test
    void testRealSolution(){
        MyNumber sol = op.op(new MyNumber(value1));
        assertFalse(sol.isComplex());
    }

}
