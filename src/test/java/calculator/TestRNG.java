package calculator;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestRNG implements TestInterface{

	private final int min = 5;
	private final int max = 10;
	private RNG op;
	private List<Expression> params;

	@BeforeEach
	public void setUp() {
		params = new ArrayList<>(Arrays.asList(new MyNumber(min), new MyNumber(max)));
		try {
			op = new RNG(params);
		}
		catch(IllegalConstruction e) { fail(); }
	}

	/*
	not sure what AssertEqual I should test in an RNG case
	*/
	
	/*
	 * @Test public void testInterval() { fail("Not yet implemented");
	 * 
	 * }
	 */
	
	@Test
	public void testNullParamList() {
		params = null;
		assertThrows(IllegalConstruction.class, () -> op = new RNG(params));
	}

	@Override
	public void testCompute() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void testCountDepth() {
		assertEquals(Integer.valueOf(1), op.countDepth());
	}

	@Override
	public void testCountOps() {
		assertEquals(Integer.valueOf(1), op.countOps());
	}

	@Override
	public void testCountNbs() {
		assertEquals(Integer.valueOf(2), op.countNbs());

	}

	@Override
	public void testEquals() {
		assertDoesNotThrow(() -> op.equals(null));
	}

}
