package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.api.*;
import visitor.Stringator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestGCD {

    private final String value1 = "8";
    private final String value2 = "12";
    private final String value3 = "4";
    private List<Expression> params;
    private Calculator c;

    @Test
    public void testGCD(){
        try {
            c = new Calculator();
            MyNumber mn1=new MyNumber(value1);
            MyNumber mn2=new MyNumber(value2);
            MyNumber mn3=new MyNumber(value3);
            params=new ArrayList<>();
            Collections.addAll(params,mn1,mn2);
            GCD gcd=new GCD(params);
            assertEquals(c.eval(gcd),c.eval(mn3));
        }catch(Exception e){}
    }
}
