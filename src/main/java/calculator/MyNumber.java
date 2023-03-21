package calculator;

import visitor.Visitor;

import java.util.Arrays;
import java.util.List;

/**
 * MyNumber is a concrete class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
public class MyNumber implements Expression
{
  private final int value;


  private final int imaginary;

    /** getter method to obtain the value contained in the object
     *
     * @return The integer number contained in the object
     */

  public NumberNotation notation = NumberNotation.CARTESIAN;

  public Integer getValue() { return value; }

  public Integer getImaginary() { return imaginary; }

    /**
     * Constructor method
     *
     * @param v The integer value to be contained in the object
     */
  public /*constructor*/ MyNumber(int v) {
      value=v;
      imaginary=0;
  }

    public /*constructor*/ MyNumber(int v, int i) {
        value=v;
        imaginary=i;
    }

    public /*constructor*/ MyNumber(String number) {
        String[] parts = number.split("(?=[-+i])|(?<=[-+i])");
        value = Integer.parseInt(parts[0]);
        if(parts[1].equals("-"))
            imaginary = Integer.parseInt(parts[2]) * -1;
        else
            imaginary = Integer.parseInt(parts[2]);

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

    public boolean isComplex(){
        return imaginary!=0;
    }
  @Override
  public String toString() {
      if(!this.isComplex())
          return Integer.toString(value);
      else if(value == 0)
          return Integer.toString(imaginary)+"i";
      return toString(notation);
  }

    public final String toString(NumberNotation n) {

        List<Expression> params = Arrays.asList(this, this);
        int r = 0;
        int v = Math.abs(value);
        int i = Math.abs(imaginary);
        int sign = (imaginary / i) * (value / v);
        try {
            Modulus mod = new Modulus(params);
            r = mod.op(this).getValue();
        }catch(IllegalConstruction e) {
            String.format("%d%+di", value, imaginary); }

        return switch (n) {
            case CARTESIAN ->
                    String.format("%d%+di", value, imaginary);

            case POLAR ->
                    String.format("%d (cos(arc-tan(%d/%d)) + i*sin(arc-tan(%d/%d)))", r, i*sign, v, i*sign, v);

            case EXPONENTIAL ->
                    String.format("%de^(i*arc-tan(%d/%d))", r, i*sign, v);
        };
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
      return this.value == ((MyNumber)o).value && this.imaginary == ((MyNumber)o).imaginary;
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
		return value;
  }

}
