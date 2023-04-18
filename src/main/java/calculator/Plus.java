package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static java.lang.Math.pow;

/** This class represents the arithmetic sum operation "+".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Minus
 * @see Times
 * @see Divides
 */
public final class Plus extends Operation
 {

  /**
   * Class constructor specifying a number of Expressions to add.
   *
   * @param elist The list of Expressions to add
   * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
   * @see #Plus(List<Expression>,Notation)
   */
  public /*constructor*/ Plus(List<Expression> elist) throws IllegalConstruction {
	this(elist, null);
  }

  /**
   * Class constructor specifying a number of Expressions to add,
   * as well as the Notation used to represent the operation.
   *
   * @param elist The list of Expressions to add
   * @param n The Notation to be used to represent the operation
   * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
   * @see #Plus(List<Expression>)
   * @see Operation#Operation(List<Expression>,Notation)
   */
  public Plus(List<Expression> elist, Notation n) throws IllegalConstruction {
  	super(elist,n);
  	symbol = "+";
  	neutral = 0;
  }

private MyNumber addition(BigDecimal l, int l_exp, BigDecimal r, int r_exp){
    BigDecimal new_val;
    int exp;

    if (l_exp>r_exp){
        exp=l_exp;
        int gap=l_exp-r_exp;
        new_val = l.add(r.divide(BigDecimal.valueOf(pow(10,gap)), MathContext.DECIMAL128));

    }
    else if (l_exp<r_exp){
        exp=r_exp;
        int gap=r_exp-l_exp;
        new_val = r.add(l.divide(BigDecimal.valueOf(pow(10,gap)), MathContext.DECIMAL128));
    }
    else {
        exp=l_exp;
        new_val = r.add(l);
    }
    return new MyNumber(new_val,exp);
}

  /**
   * The actual computation of the (binary) arithmetic addition of two integers
   *
   * @param l The first BigDecimal number
   * @param r The second BigDecimal number that should be added to the first
   * @return The BigDecimal number that is the result of the addition
   */
  public MyNumber op(MyNumber l, MyNumber r) {

      BigDecimal l_val =  l.getValue();
      BigDecimal r_val =  r.getValue();
      int l_exp = l.getexp();
      int r_exp = r.getexp();

      MyNumber real = addition(l_val,l_exp,r_val,r_exp);

      BigDecimal li_val =  l.getImaginary();
      BigDecimal ri_val =  r.getImaginary();
      int li_exp = l.getImaginaryExp();
      int ri_exp = r.getImaginaryExp();

      MyNumber imaginary = addition(li_val,li_exp,ri_val,ri_exp);


      return new MyNumber(real.getValue(),real.getexp(),imaginary.getValue(),imaginary.getexp());
  }

  //public int op(int l, int r) {return (l+r);}
}
