package junit5tests;

//Import Junit5 libraries for unit testing:

import calculator.Calculator;
import calculator.IllegalConstruction;
import calculator.MyNumber;
import calculator.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyNumber {

	private final int value = 8;
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
		int otherValue = 7;
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
		assertEquals(Integer.toString(value), number.getValue().toString());
	}

}
