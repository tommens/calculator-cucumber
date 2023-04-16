package calculator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Software Engineering Lab
 * Faculty of Sciences
 *
 * @author tommens
 */
public class Main {

	/**
	 * This is the main method of the application.
	 * It provides examples of how to use it to construct and evaluate arithmetic expressions.
	 *
	 * @param args	Command-line parameters are not used in this version
	 */
	public static void main(String[] args) {

  	Expression e;
  	Calculator c = new Calculator();
	TimeCalculator tc = new TimeCalculator();
	try{

		e = new MyNumber(8);
		c.print(e);
		c.eval(e);

	    List<Expression> params = new ArrayList<>();
	    Collections.addAll(params, new MyNumber(3), new MyNumber(4), new MyNumber(5));
	    e = new Plus(params,Notation.PREFIX);
		c.printExpressionDetails(e);
		c.eval(e);
	
		List<Expression> params2 = new ArrayList<>();
		Collections.addAll(params2, new MyNumber(5), new MyNumber(3));
		e = new Minus(params2, Notation.INFIX);
		c.print(e);
		c.eval(e);

		List<Expression> params3 = new ArrayList<>();
		Collections.addAll(params3, new Plus(params), new Minus(params2));
		e = new Times(params3);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params4 = new ArrayList<>();
		Collections.addAll(params4, new Plus(params), new Minus(params2), new MyNumber(5));
		e = new Divides(params4,Notation.POSTFIX);
		c.print(e);
		c.eval(e);

		//Time computation
		List<Expression> params5 = new ArrayList<>();
		Collections.addAll(params5, new MyTime("2023-04-15 03:10:45 pm +01:00"),
				new MyTime("2023-04-15 06:00:00 am +00:00"));
		e = new Minus(params5, Notation.INFIX);
		tc.print(e);
		tc.eval(e);

		List<Expression> params6 = new ArrayList<>();
		//I create a MyTime object, then convert it to EpochSeconds to be able to do the subtraction.
		MyTime time = new MyTime("");
		long timeInSeconds = time.toSeconds();
		Collections.addAll(params6, new MyNumber((int)timeInSeconds));
		Collections.addAll(params6, new MyNumber(3600));
		e = new Minus(params6, Notation.INFIX);
		System.out.println(c.eval(e));
		System.out.println(MyTime.resultToDate(c.eval(e)));

		e = new Plus(params6, Notation.INFIX);
		System.out.println(c.eval(e));
		System.out.println(MyTime.resultToDate(c.eval(e)));
	}

	catch(IllegalConstruction exception) {
		System.out.println("cannot create operations without parameters");
		}
 	}

}
