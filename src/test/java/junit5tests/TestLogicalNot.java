package junit5tests;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogicalNot {

    private final boolean value1 = true;
    private LogicalNot op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(List.of(new MyBoolean(value1)));
        try {
            op = new LogicalNot(params);
            op.notation = Notation.PREFIX; // reset the notation to infix (which is the default) before each test
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new LogicalNot(null));
    }

    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(List.of(new MyBoolean(value1)));
        try {
            LogicalNot ln = new LogicalNot(p, Notation.PREFIX);
            assertEquals(op, ln);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    //@Test
    //public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        //ArrayList<Expression> p = new ArrayList<>(List.of(new MyBoolean(value1)));
        //try {
            //LogicalAnd e = new LogicalAnd(p, Notation.INFIX);
            //assertEquals(e.hashCode(), op.hashCode());
        //}
        //catch(IllegalConstruction e) { fail(); }
    //}

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalNot(params));
    }
}


