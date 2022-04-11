package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

final public class Divides extends Operation
{


  public /*constructor*/ Divides(List<Expression> elist) throws IllegalConstruction {
	super(elist);
	symbol = "/";
	neutral = 1;
  }

    @Override
    public Number op(Number l, Number r) {
        if (r.equals(new Rational(0))) {
            throw new ArithmeticException(); // TODO change this to a custom exception
        }
        return l.divide(r);
    }

    public int op(int l, int r) {
      int val = (int)Double.NaN; // will be zero with Integer

      try {
          val = l/r;
      } catch (ArithmeticException e) {
          System.out.print(e.getMessage());
      }

      return val;
  }
}
