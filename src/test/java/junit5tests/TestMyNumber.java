package junit5tests;

//Import Junit5 libraries for unit testing:

import calculator.Calculator;
import calculator.IllegalConstruction;
import calculator.MyNumber;
import calculator.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyNumber {

	private final BigInteger value = new BigInteger("8");
	private MyNumber number;
	Calculator c;

	@BeforeEach
	public void setUp() {
		c = new Calculator();
		number = new MyNumber(value);
	}

	@Test
	public void testEquals() {
		// Two distinct MyNumber, constructed separately (using a different constructor) but containing the same value should be equal
		assertEquals(new MyNumber(value), number);
		// Two MyNumbers containing a distinct value should not be equal:
		BigInteger otherValue = new BigInteger("7");
		assertNotEquals(new MyNumber(otherValue),number);
		assertEquals(number, number); // Identity check (for coverage, as this should always be true)
		assertNotEquals(number, value);
		try {
			assertNotEquals(new Times(new ArrayList<>()), number);
		}
		catch (IllegalConstruction e) {fail();}
	}

	@Test
	public void testCountDepth() {
		//test whether a number has zero depth (i.e. no nested expressions)
		assertEquals(Integer.valueOf(0), c.count(number).getCountDepth());
	}

	@Test
	public void testCountOps() {
		//test whether a number contains zero operations
		assertEquals(Integer.valueOf(0), c.count(number).getCountOps());
	}

	@Test
	public void testCountNbs() {
		//test whether a number contains 1 number
		assertEquals(Integer.valueOf(1), c.count(number).getCountNbs());
	}

	@Test
	public void testToString() {
		assertEquals(value.toString(), number.getValue().toString());
	}

	@Test
	public void testMemoryOverflow(){
		// test if overflow integers are corrected by BigInteger
		BigInteger t1=new BigInteger("999999999999999999999");
		BigInteger t3=new BigInteger("-999999999999999999999");
		assertTrue(t1.intValue()<Integer.MAX_VALUE);
		assertTrue(t3.intValue()>Integer.MIN_VALUE);
	}

	@Test
	public void testNumberBase2(){
		// test if BigInteger uses correctly bases
		BigInteger bn1=new BigInteger("11",2);
		BigInteger bn2=new BigInteger("f",16);
		assertEquals(bn1.intValue(),3);
		assertEquals(bn2.intValue(),15);
	}

}
