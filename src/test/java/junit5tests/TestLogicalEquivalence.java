package junit5tests;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogicalEquivalence {

    private final boolean value1 = true;
    private final boolean value2 = false;
    private LogicalEquivalence op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            op = new LogicalEquivalence(params);
            op.notation = Notation.INFIX; // reset the notation to infix (which is the default) before each test
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new LogicalEquivalence(null));
    }

    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalEquivalence le = new LogicalEquivalence(p, Notation.INFIX);
            assertEquals(op, le);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalEquivalence le = new LogicalEquivalence(p, Notation.INFIX);
            assertEquals(le.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalEquivalence(params));
    }
}
