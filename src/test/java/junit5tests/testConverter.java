package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;
import visitor.Stringator;
import visitor.Visitor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testConverter {

    private final String value1 = "11";
    private final String value2 = "3";
    private final int radix = 2;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testNumberRadix(){
        try {
            MyNumber number1 = new MyNumber(value1, radix);
            Converter number2 = new Converter(new MyNumber(value2), radix);
            assertEquals(number1.getValue().toString(), number2.getValue().toString());
        }catch (Exception e){}
    }
}
