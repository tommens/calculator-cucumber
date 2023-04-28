package calculator;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import visitor.Counter;
import visitor.Visitor;

import java.util.Arrays;
import java.util.List;

class TestOperation {

	private Operation o;
	private Operation o2;

	Counter counter;

	@BeforeEach
	void setUp() throws Exception {
		List<Expression> params1 = Arrays.asList(new MyInteger(3), new MyInteger(4), new MyInteger(5));
		List<Expression> params2 = Arrays.asList(new MyInteger(5), new MyInteger(4));
		List<Expression> params3 = Arrays.asList(new Plus(params1), new Minus(params2), new MyInteger(7));
		o = new Divides(params3);
		o2 = new Divides(params3);

		counter = new Counter();
		o.accept(counter);
	}

	@Test
	void testEquals() {
		assertEquals(o,o2);
	}

	@Test
	void testCountDepth() {
		assertEquals(2, counter.getCountDepth());
	}

	@Test
	void testCountOps() {
		assertEquals(3, counter.getCountOps());
	}

	@Test
	void testCountNbs() {
		assertEquals(Integer.valueOf(6), counter.getCountNbs());
	}

}
