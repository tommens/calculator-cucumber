package calculator;

//Import Junit5 libraries for unit testing:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TestMyRationalNumber {

	private final int nominator =8, denominator = 6, reducedNominator = 4, reducedDenominator = 3;
	private MyRationalNumber number;
	
	@BeforeEach
	void setUp() {
		number = MyRationalNumber.create(nominator, denominator);
	}

	@Test
	void testEquals() {
		assertEquals( MyRationalNumber.create(nominator*4, denominator*4), number);
		assertEquals( MyRationalNumber.create(nominator, denominator), number);
		// Two distinct MyNumber, constructed separately (using a different constructor) but containing the same value should be equal
		// Two MyNumbers containing a distinct value should not be equal:
		assertNotEquals( MyRationalNumber.create(denominator, nominator), number);
		assertEquals(number, number); // Identity check (for coverage, as this should always be true)
		assertNotEquals(number, 8); // number is of type MyNumber, while value is of type int, so not equal

	}

	@Test
	void testDenominatorZero() {
		assertThrows(ArithmeticException.class, () -> MyRationalNumber.create(1, 0));
	}

	@Test
	void testToString() {
		assertEquals(reducedNominator + "_/" + reducedDenominator, number.toString());
	}

	@Test
	void testNegativeNumber() {
		assertEquals(MyRationalNumber.create(-nominator, denominator), MyRationalNumber.create(nominator, -denominator));
		assertEquals(MyRationalNumber.create(-nominator, -denominator), MyRationalNumber.create(nominator, denominator));
		assertNotEquals(MyRationalNumber.create(-nominator, -denominator), MyRationalNumber.create(-nominator, denominator));
	}

	@Test
	void testAdd(){
		assertEquals(MyRationalNumber.create(7, 20), MyRationalNumber.create(1, 4).add(MyRationalNumber.create(1, 10)));
	}

	@Test
	void testSubtract(){
		assertEquals(MyRationalNumber.create(3, 20), MyRationalNumber.create(1, 4).subtract(MyRationalNumber.create(1, 10)));
	}

	@Test
	void testMultiply(){
		assertEquals(MyRationalNumber.create(35, 40), MyRationalNumber.create(5, 4).multiply(MyRationalNumber.create(7, 10)));
	}

	@Test
	void testDivide(){
		assertEquals(MyRationalNumber.create(50, 28), MyRationalNumber.create(5, 4).divide(MyRationalNumber.create(7, 10)));
		assertThrows(ArithmeticException.class, () -> MyRationalNumber.create(1, 4).divide(MyRationalNumber.create(0, 10)));
		assertEquals(MyRationalNumber.create(0, 1), MyRationalNumber.create(0, 4).divide(MyRationalNumber.create(7, 10)));
		assertEquals(MyRationalNumber.create(0, 1), MyRationalNumber.create(0, 4).divide(MyRationalNumber.create(6, 10)));
		assertEquals(MyRationalNumber.create(3, 3), MyRationalNumber.create(-3, 1).divide(MyRationalNumber.create(-3, 1)));
	}

	@Test
	void testGetValue(){
		assertEquals(reducedNominator, number.getValue()[0]);
		assertEquals(reducedDenominator, number.getValue()[1]);
	}

	@Test
	void testGetInteger(){
		assertEquals(1, number.getInteger());
	}

	@Test
	void testGetRational(){
		assertEquals(number, number.getRational());
	}

	@Test
	void testGetRealNumber(){
		assertEquals(new BigDecimal("1.4"), MyRationalNumber.create(7,5).getRealNumber());
	}






}
