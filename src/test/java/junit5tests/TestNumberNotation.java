package junit5tests;

//Import Junit5 libraries for unit testing:
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;


class TestNumberNotation {

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotation(MyNumber num, String s, NumberNotation n) {
        assertEquals(s, num.toString(n));
        num.notation = n;
        assertEquals(s, num.toString());
    }

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotations(MyNumber num, double O, int r) {
        //cartesian notation:
        String s = String.format("%d%+di", num.getValue(), num.getImaginary());
        testNotation(num, s, NumberNotation.CARTESIAN);
        //polar notation:
        s = String.format("%d*(cosine(%,.2f) + i*sine(%,.2f))", r, O, O);
        testNotation(num, s, NumberNotation.POLAR);
        //exponential notation:
        s = String.format("%de^(%,.2f*i)", r, O);
        testNotation(num, s, NumberNotation.EXPONENTIAL);
    }

    @Test
    void testOutput() {
        int value1 = 8;
        int value2 = 6;
        MyNumber num = new MyNumber(value1,value2);

        double O = Math.atan((double)value2/value1);
        int r = (int)Math.sqrt((value2 * value2) + (value1 * value1));

        testNotations(num,O,r);
    }

}
