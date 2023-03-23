package calculator;

import visitor.Visitor;

import java.math.BigDecimal;

import static java.lang.Math.pow;


/**
 * MyNumber is a concrete class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
public class MyNumber implements Expression
{
    public RealNumberNotation notation = RealNumberNotation.TRADITIONAL;
  private final BigDecimal value;
  private final int exp;


    /** getter method to obtain the value contained in the object
     *
     * @return BigDecimal number contained in the object
     */
  public BigDecimal getValue() { return value; }

    /** getter method to obtain the exp contained in the object
     *
     * @return int number contained in the object
     */
    public int getexp() { return exp; }

    /**
     * Constructor method
     *
     * @param v TBigDecimal value to be contained in the object
     */
    public /*constructor*/ MyNumber(BigDecimal v) {
        value=v;
        exp=0;
	  }

    public /*constructor*/ MyNumber(BigDecimal v, int e) {
        value=v;
        exp=e;
    }

    /**
     * accept method to implement the visitor design pattern to traverse arithmetic expressions.
     * Each number will pass itself to the visitor object to get processed by the visitor.
     *
     * @param v	The visitor object
     */
  public void accept(Visitor v) {
      v.visit(this);
  }


    /** The depth of a number expression is always 0
     *
     * @return The depth of a number expression
     */
  public int countDepth() {
	  return 0;
  }

    /** The number of operations contained in a number expression is always 0
     *
     * @return The number of operations contained in a number expression
     */
  public int countOps() {
	  return 0;
  }

    /** The number of numbers contained in a number expression is always 1
     *
     * @return The number of numbers contained in  a number expression
     */
  public int countNbs() {
	  return 1;
  }

    /**
     * Convert a number into a String to allow it to be printed.
     *
     * @return	The String that is the result of the conversion.
     */
  @Override
  public String toString() {
      if (exp!=0) {
          return switch (notation) {
              case TRADITIONAL -> String.format(value.multiply(new BigDecimal(pow(10, exp))).toString());

              case SCIENTIFIC -> String.format(value.toString() + "x10^" + (exp));

              case E_NOTATION -> String.format(value.toString() + "E^" + (exp));
          };
      }
      else{
          return String.format(value.toString());
      }
  }


  /** Two MyNumber expressions are equal if the values they contain are equal
   *
   * @param o The object to compare to
   * @return  A boolean representing the result of the equality test
   */
  @Override
  public boolean equals(Object o) {
      // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
      if (o == null) return false;

      // If the object is compared to itself then return true
      if (o == this) {
          return true;
      }

      // If the object is of another type then return false
      if (!(o instanceof MyNumber)) {
            return false;
      }

      if(this.exp==0){
          if(((MyNumber)o).exp==0){
              return this.value.equals(((MyNumber)o).value);
          }
          else{
              return this.value.equals(((MyNumber)o).value.multiply(new BigDecimal(pow(10,((MyNumber)o).exp))));
          }
      }
      else{
          if(((MyNumber)o).exp==0){
              return this.value.multiply(new BigDecimal(pow(10,this.exp))).equals(((MyNumber)o).value);
          }
          else{
              return this.value.multiply(new BigDecimal(pow(10,this.exp))).equals(((MyNumber) o).value.multiply(new BigDecimal(pow(10, ((MyNumber) o).exp))));
          }
      }

      // Used == since the contained value is a primitive value
      // If it had been a Java object, .equals() would be needed
  }

    /** The method hashCode needs to be overridden it the equals method is overridden;
     * 	otherwise there may be problems when you use your object in hashed collections
     * 	such as HashMap, HashSet, LinkedHashSet.
     *
     * @return	The result of computing the hash.
     */
  @Override
  public int hashCode() {
		return value.hashCode();
  }

}
