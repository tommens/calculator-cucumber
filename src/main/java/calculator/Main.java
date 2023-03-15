package calculator;

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

	try {

		e = new MyInteger(8);
		c.print(e);
		c.eval(e);

		List<Expression> params = new ArrayList<>();
		Collections.addAll(params, new MyInteger(3), new MyInteger(4), new MyInteger(5));
		e = new Plus(params, Notation.PREFIX);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params2 = new ArrayList<>();
		Collections.addAll(params2, new MyInteger(5), new MyInteger(3));
		e = new Minus(params2, Notation.INFIX);
		c.print(e);
		c.eval(e);

		List<Expression> params3 = new ArrayList<>();
		Collections.addAll(params3, new Plus(params), new Minus(params2));
		e = new Times(params3);
		c.printExpressionDetails(e);
		c.eval(e);

		List<Expression> params4 = new ArrayList<>();
		Collections.addAll(params4, new Plus(params), new Minus(params2), new MyInteger(5));
		e = new Divides(params4, Notation.POSTFIX);
		c.print(e);
		c.eval(e);


		// rational numbers
		e = MyRationalNumber.create(5, 6);
		c.printRational(e);
		c.evalRational(e);

		List<Expression> paramsRational1 = new ArrayList<>();
		Collections.addAll(paramsRational1, MyRationalNumber.create(1, 2), MyRationalNumber.create(1, 3));
		e = new Plus(paramsRational1, Notation.PREFIX);
		c.printRational(e);
		c.evalRational(e);

		List<Expression> paramsRational2 = new ArrayList<>();
		Collections.addAll(paramsRational2, MyRationalNumber.create(1, 2), MyRationalNumber.create(1, 3));
		e = new Minus(paramsRational2, Notation.INFIX);
		c.printRational(e);
		c.evalRational(e);

		List<Expression> paramsRational3 = new ArrayList<>();
		Collections.addAll(paramsRational3, MyRationalNumber.create(1, 2), MyRationalNumber.create(1, 3), new MyInteger(3));
		e = new Times(paramsRational3, Notation.POSTFIX);
		c.printRational(e);
		c.evalRational(e);

		List<Expression> paramsRational4 = new ArrayList<>();
		Collections.addAll(paramsRational4, MyRationalNumber.create(1, 2), MyRationalNumber.create(1, 3));
		e = new Divides(paramsRational4, Notation.INFIX);
		c.printRational(e);
		c.evalRational(e);
	}

	catch(IllegalConstruction exception) {
		System.out.println("cannot create operations without parameters");
		}
 	}

}
