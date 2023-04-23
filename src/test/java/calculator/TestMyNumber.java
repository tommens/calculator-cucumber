package calculator;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class TestMyNumber {

	private final int value =8;
	private MyNumber number;
	
	@BeforeEach
	void setUp() {
		number = new MyInteger(value);
	}

	@Test
	void testEquals() {
		// Two distinct MyNumber, constructed separately (using a different constructor) but containing the same value should be equal
		assertEquals(new MyInteger(value), number);
		// Two MyNumbers containing a distinct value should not be equal:
		int otherValue = 7;
		assertNotEquals(new MyInteger(otherValue),number);
		assertEquals(number, number); // Identity check (for coverage, as this should always be true)
		assertNotEquals(number, value); // number is of type MyNumber, while value is of type int, so not equal
		try {
			assertNotEquals(new Times(new ArrayList<>()), number);
		}
		catch (IllegalConstruction e) {fail();}
	}

	@Test
	void testToString() {
		assertEquals(Integer.toString(value), number.toString());
	}

}
