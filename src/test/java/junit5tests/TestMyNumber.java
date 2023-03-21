package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;

import java.util.ArrayList;

class TestMyNumber {

	private final int value = 8;

	private final int imaginary = 3;
	private MyNumber number;

	private MyNumber complexNumber;

	private  MyNumber onlyComplexNumber;
	
	@BeforeEach
	void setUp() {
		number = new MyNumber(value);
		complexNumber = new MyNumber(value,imaginary);
		onlyComplexNumber = new MyNumber(0,imaginary);
	}

	@Test
	void testEquals() {
		// Two distinct MyNumber, constructed separately (using a different constructor) but containing the same value should be equal
		assertEquals(new MyNumber(value), number);
		// Two MyNumbers containing a distinct value should not be equal:
		int otherValue = 7;
		assertNotEquals(new MyNumber(otherValue),number);
		assertEquals(number, number); // Identity check (for coverage, as this should always be true)
		assertNotEquals(number, value); // number is of type MyNumber, while value is of type int, so not equal
		assertNotEquals(number,null);

		assertEquals(new MyNumber(value,imaginary), complexNumber);
		assertNotEquals(complexNumber,number);
		assertEquals(complexNumber, complexNumber);
		assertNotEquals(complexNumber,null);

		assertEquals(new MyNumber(0,imaginary), onlyComplexNumber);
		assertNotEquals(complexNumber,onlyComplexNumber);
		assertEquals(onlyComplexNumber, onlyComplexNumber);
		assertNotEquals(onlyComplexNumber,null);

		try {
			assertNotEquals(new Times(new ArrayList<>()), number);
		}
		catch (IllegalConstruction e) {fail();}
	}

	@Test
	void testToString() {
		assertEquals(Integer.toString(value), number.toString());
		assertEquals(value +"+"+ imaginary +"i", complexNumber.toString());
		assertEquals(imaginary +"i", onlyComplexNumber.toString());
	}

}
