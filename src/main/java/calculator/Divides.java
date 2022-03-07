package calculator;

import java.util.List;

final public class Divides extends Operation
{

  public /*constructor*/ Divides(List<Expression> elist) throws IllegalConstruction {
	this(elist, null);
  }

  public Divides(List<Expression> elist, Notation n) throws IllegalConstruction {
	super(elist,n);
	symbol = "/";
	neutral = 1;
  }
  
  public int op(int l, int r) {
      int val = 0;

      try {
          val = l/r;
      } catch (ArithmeticException e) {
          System.out.print(e.getMessage());
      }

      return val;
  }
}
