package junit5tests;

//Import Junit5 libraries for unit testing:

import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TestNotation {

    /* This is an auxilary method to avoid code duplication.
     */
	void testNotation(String s,Operation o,Notation n) {
		assertEquals(s, o.toString(n));
		o.notation = n;
		assertEquals(s, o.toString());
	}

	/* This is an auxilary method to avoid code duplication.
     */
	void testNotations(String symbol,BigDecimal value1,BigDecimal value2,Operation op) {
		//prefix notation:
		testNotation(symbol +" (" + value1.toString()+", " + value2.toString()+")", op, Notation.PREFIX);
		//infix notation:
		testNotation("( " + value1.toString() +" "+ symbol + " " + value2.toString()+" )", op, Notation.INFIX);
		//postfix notation:
		testNotation("(" + value1.toString() +", "+ value2.toString() +") "+ symbol, op, Notation.POSTFIX);
	}

	@ParameterizedTest
	@ValueSource(strings = {"*", "+", "/", "-"})
	void testOutput(String symbol) {
		BigDecimal value1 = new BigDecimal(8);
		BigDecimal value2 = new BigDecimal(6);
		Operation op = null;
		//List<Expression> params = new ArrayList<>(Arrays.asList(new MyNumber(value1),new MyNumber(value2)));
		List<Expression> params = Arrays.asList(new MyNumber(value1),new MyNumber(value2));
		try {
			//construct another type of operation depending on the input value
			//of the parameterised test
			switch (symbol) {
				case "+"	->	op = new Plus(params);
				case "-"	->	op = new Minus(params);
				case "*"	->	op = new Times(params);
				case "/"	->	op = new Divides(params);
				default		->	fail();
			}
		} catch (IllegalConstruction e) {
			fail();
		}
		testNotations(symbol, value1, value2, op);
	}

}
