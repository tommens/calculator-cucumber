package junit5tests;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogicalXor {

    private final boolean value1 = true;
    private final boolean value2 = false;
    private LogicalXor op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            op = new LogicalXor(params);
            op.notation = Notation.INFIX; // reset the notation to infix (which is the default) before each test
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new LogicalXor(null));
    }

    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalXor lx = new LogicalXor(p, Notation.INFIX);
            assertEquals(op, lx);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalXor lx = new LogicalXor(p, Notation.INFIX);
            assertEquals(lx.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalXor(params));
    }
}
