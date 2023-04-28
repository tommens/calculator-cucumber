package calculator;

import visitor.TimeVisitor;

import java.math.BigDecimal;
import java.util.List;

/** This class represents the arithmetic multiplication operation "*".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Minus
 * @see Plus
 * @see Divides
 */
public final class Times extends Operation
{
 /**
  * Class constructor specifying a number of Expressions to multiply.
  *
  * @param elist The list of Expressions to multiply
  * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
  * @see #Times(List<Expression>,Notation)
  */
 public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
  this(elist, null);
 }

 /**
  * Class constructor specifying a number of Expressions to multiply,
  * as well as the Notation used to represent the operation.
  *
  * @param elist The list of Expressions to multiply
  * @param n The Notation to be used to represent the operation
  * @throws IllegalConstruction    If an empty list of expressions if passed as parameter
  * @see #Times(List<Expression>)
  * @see Operation#Operation(List<Expression>,Notation)
  */
 public Times(List<Expression> elist, Notation n) throws IllegalConstruction {
  super(elist,n);
  symbol = "*";
  neutral = 1;
 }

 /**
  * The actual computation of the (binary) arithmetic multiplication of two integers
  * @param l The first integer
  * @param r The second integer that should be multiplied with the first
  * @return The integer that is the result of the multiplication
  */
 public int op(int l, int r)
 { return (l*r);
 }

 /**
  * The actual computation of the (binary) arithmetic multiplication of two real numbers
  * @param l first argument of the binary operation
  * @param r second argument of the binary operation
  * @return The real number that is the result of the multiplication
  */
 @Override
 public BigDecimal op(BigDecimal l, BigDecimal r) {
  return l.multiply(r,mathContext);
 }

 /**
  * The actual computation of the (binary) arithmetic multiplication of two rational numbers
  * @param l The first rational number
  * @param r The second rational number that should be multiplied with the first
  * @return The rational number that is the result of the multiplication
  */

 @Override
 public MyRationalNumber op(MyRationalNumber l, MyRationalNumber r) {
  return l.multiply(r);
 }

 @Override
 public MyTime op(MyTime l, MyTime r) {
  throw new RuntimeException("Sorry, you can't multiply two dates.");
 }

 @Override
 public MyTime op(MyTime l, MyRealNumber seconds) {
  throw new RuntimeException("Sorry, you can't multiply a date and a number.");
 }

 @Override
 public void accept(TimeVisitor v) {}
}
