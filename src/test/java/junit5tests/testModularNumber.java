package junit5tests;

//Import Junit5 libraries for unit testing:

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testModularNumber {
    private ModularNumber mn1=new ModularNumber("4","3");
    private ModularNumber mn2=new ModularNumber("5","3");
    private ModularNumber mn3=new ModularNumber("10","6");
    private List<Expression> params;
    Calculator c;

    @Test
    public void testEqualityNumber(){
        assertEquals(mn1.getValue(),BigInteger.ONE);
    }

    @Test
    public void testAdditionCongruence(){
        c=new Calculator();
        params = new ArrayList<>(Arrays.asList(mn1,mn2));
        try {
            assertEquals(c.eval(new Plus(params)), new BigInteger("3"));
            assertNotEquals(c.eval(new Plus(params)), new BigInteger("2"));
        }catch(IllegalConstruction e){fail();}
    }

    @Test
    public void testSubtractionCongruence(){
        c=new Calculator();
        params = new ArrayList<>(Arrays.asList(mn1,mn2));
        try {
            assertEquals(c.eval(new Minus(params)), new BigInteger("-1"));
            assertNotEquals(c.eval(new Minus(params)), new BigInteger("0"));
        }catch(IllegalConstruction e){fail();}
    }

    @Test
    public void testMultiplicationCongruence(){
        c=new Calculator();
        params = new ArrayList<>(Arrays.asList(mn1,mn2));
        try {
            assertEquals(c.eval(new Times(params)), new BigInteger("2"));
            assertNotEquals(c.eval(new Times(params)), new BigInteger("3"));
        }catch(IllegalConstruction e){fail();}
    }

    @Test
    public void testDivisionCongruence(){
        c=new Calculator();
        params = new ArrayList<>(Arrays.asList(mn3,mn2));
        try {
            assertEquals(c.eval(new Divides(params)), new BigInteger("2"));
            assertNotEquals(c.eval(new Divides(params)), new BigInteger("3"));
        }catch(IllegalConstruction e){fail();}
    }

    @Test
    public void testExponentCongruence(){
        c=new Calculator();
        params = new ArrayList<>(Arrays.asList(mn3,mn2));
        try {
            assertEquals(c.eval(new Exponents(params)), new BigInteger("16"));
            assertNotEquals(c.eval(new Exponents(params)), new BigInteger("2"));
        }catch(IllegalConstruction e){fail();}
    }

    @Test
    public void testModularInverse(){
        c=new Calculator();
        assertEquals(mn2.getModularInverse(),new BigInteger("2"));
    }
}
