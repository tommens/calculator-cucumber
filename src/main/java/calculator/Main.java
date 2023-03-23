package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Département d'Informatique
 * Faculté des Sciences
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

	try{

		e = new MyNumber(new BigDecimal(-8.5) );
		c.print(e);
		c.eval(e);

	    List<Expression> params = new ArrayList<>();
	    Collections.addAll(params, new MyNumber(new BigDecimal(-3.5) ), new MyNumber(new BigDecimal(-4) ), new MyNumber(new BigDecimal(5)));
	    e = new Plus(params,Notation.PREFIX);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params7 = new ArrayList<>();
		Collections.addAll(params7, new MyNumber(new BigDecimal(-3) ), new MyNumber(new BigDecimal(-4) ), new MyNumber(new BigDecimal(5)));
		e = new Plus(params7,Notation.PREFIX);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params2 = new ArrayList<>();
		Collections.addAll(params2, new MyNumber(new BigDecimal(-5)), new MyNumber(new BigDecimal(3)));
		e = new Minus(params2, Notation.INFIX);
		c.print(e);
		c.eval(e);

		List<Expression> params5 = new ArrayList<>();
		Collections.addAll(params5, new MyNumber(new BigDecimal(6.95)), new MyNumber(new BigDecimal(7.40)));
		e = new Minus(params5, Notation.INFIX);
		c.print(e);
		c.eval(e);

		List<Expression> params6 = new ArrayList<>();
		Collections.addAll(params6, new MyNumber(new BigDecimal(7)), new MyNumber(new BigDecimal(2)));
		e = new Divides(params6, Notation.INFIX);
		c.print(e);
		c.eval(e);

		List<Expression> params3 = new ArrayList<>();
		Collections.addAll(params3, new Plus(params), new Minus(params2));
		e = new Times(params3);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params4 = new ArrayList<>();
		Collections.addAll(params4, new Plus(params), new Minus(params2), new MyNumber(new BigDecimal(-5)));
		e = new Divides(params4,Notation.POSTFIX);
		c.print(e);
		c.eval(e);


	}

	catch(IllegalConstruction exception) {
		System.out.println("cannot create operations without parameters");
		}
 	}

}
