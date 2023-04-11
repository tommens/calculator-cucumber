package calculator;

import visitor.Visitor;


import java.util.Arrays;
import java.util.List;

import java.math.BigDecimal;
import java.math.MathContext;

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
  private final BigDecimal value;
  private final int exp;

  private final int decimal_number = 15;



  private final BigDecimal imaginary;

  private final int imaginaryExp;



  public NumberNotation notation = NumberNotation.CARTESIAN;

    /** getter method to obtain the value contained in the object
     *
     * @return BigDecimal number of the real part contained in the objectµ
     */
  public BigDecimal getValue() { return value; }

    /** getter method to obtain the exp contained in the object
     *
     * @return int number contained in the object
     */
    public int getexp() { return exp; }

    /** getter method to obtain the value contained in the object
     *
     * @return The integer number of the imaginary part contained in the object
     */
  public BigDecimal getImaginary() { return imaginary; }

    public int getImaginaryExp() { return imaginaryExp; }

    /**
     * Constructor method
     *
     * @param v TBigDecimal value to be contained in the object
     */

    public /*constructor*/ MyNumber(BigDecimal v) {
        value=v.round(new MathContext(decimal_number));
        exp=0;

        BigDecimal tmp = new BigDecimal(0);
        imaginary = tmp.round(new MathContext(decimal_number));
        imaginaryExp = 0;
	  }
    public /*constructor*/ MyNumber(BigDecimal v, int e) {
        value=v.round(new MathContext(decimal_number));
        exp=e;

        BigDecimal tmp = new BigDecimal(0);
        imaginary = tmp.round(new MathContext(decimal_number));
        imaginaryExp = 0;
    }

    public /*constructor*/ MyNumber(BigDecimal v, BigDecimal i) {
        value=v.round(new MathContext(decimal_number));
        exp=0;

        imaginary = i.round(new MathContext(decimal_number));
        imaginaryExp = 0;
    }

    public /*constructor*/ MyNumber(BigDecimal v, int e, BigDecimal i, int ie) {
        value=v.round(new MathContext(decimal_number));
        exp=e;

        imaginary = i.round(new MathContext(decimal_number));
        imaginaryExp = ie;
    }

    public /*constructor*/ MyNumber(String number) {
        String[] parts = number.split("(?=[-+i])|(?<=[-+i])");
        value = new BigDecimal(Double.parseDouble(parts[0]));
        if(parts[1].equals("-"))
            imaginary = new BigDecimal(Double.parseDouble(parts[2])*-1);
        else
            imaginary = new BigDecimal(Double.parseDouble(parts[2]));
        exp = 0;
        imaginaryExp = 0;
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
        return !(imaginary.signum() == 0);
    }
    @Override
    public String toString() {
        return toString(notation);
    }

    public final String toString(NumberNotation n) {

        Double real = value.multiply(BigDecimal.valueOf(pow(10, exp)).round(new MathContext(decimal_number))).doubleValue();
        Double imag = imaginary.multiply(BigDecimal.valueOf(pow(10, imaginaryExp)).round(new MathContext(decimal_number))).doubleValue();

        Double r;

        Double O;
        try {
            MyNumber tmp1 = new Divides(null).op(new MyNumber(imaginary,imaginaryExp),new MyNumber(value,exp));
            O = Math.atan(tmp1.getValue().multiply(BigDecimal.valueOf(pow(10, tmp1.getexp())).round(new MathContext(decimal_number))).doubleValue());

            MyNumber tmp2 = new Modulus(null).op(this);
            r = tmp2.getValue().multiply(BigDecimal.valueOf(pow(10, tmp2.getexp())).round(new MathContext(decimal_number))).doubleValue();
        }
        catch(IllegalConstruction e) {
            return String.format("%,.2f+%,.2fi", real, imag);
        }

        return switch (n) {
            case CARTESIAN ->
                String.format("%,.2f+%,.2fi", real, imag);

            case POLAR ->
                    String.format("%,.2f*(cosine(%,.2f) + i*sine(%,.2f))", r, O, O);

            case EXPONENTIAL ->
                    String.format("%,.2fe^(%,.2f*i)", r, O);

              case SCIENTIFIC -> String.format(value.toString() + "x10^" + (exp)+" + "+ imaginary.toString() + "x10^" + (imaginaryExp)+"i");

              case E_NOTATION -> String.format(value.toString() + "E^" + (exp)+" + "+ imaginary.toString() + "E^" + (imaginaryExp)+"i");
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

      Boolean real = false;

      Boolean imag = false;

      if(this.exp==0){
          if(((MyNumber)o).exp==0){
              real = (this.value.compareTo(((MyNumber)o).value)==0);
          }
          else{
              real = (this.value.compareTo(((MyNumber)o).value.multiply(BigDecimal.valueOf(pow(10, ((MyNumber) o).exp))))==0);
          }
      }
      else{
          if(((MyNumber)o).exp==0){
              real = (this.value.multiply(BigDecimal.valueOf(pow(10, this.exp))).compareTo(((MyNumber)o).value)==0);
          }
          else{
              real = (this.value.multiply(BigDecimal.valueOf(pow(10, this.exp))).compareTo(((MyNumber) o).value.multiply(BigDecimal.valueOf(pow(10, ((MyNumber) o).exp))))==0);
          }
      }

      if(this.imaginaryExp==0){
          if(((MyNumber)o).imaginaryExp==0){
              imag = (this.imaginary.compareTo(((MyNumber)o).imaginary)==0);
          }
          else{
              imag = (this.imaginary.compareTo(((MyNumber)o).imaginary.multiply(BigDecimal.valueOf(pow(10, ((MyNumber) o).imaginaryExp))))==0);
          }
      }
      else{
          if(((MyNumber)o).imaginaryExp==0){
              imag = (this.imaginary.multiply(BigDecimal.valueOf(pow(10, this.imaginaryExp))).compareTo(((MyNumber)o).imaginary)==0);
          }
          else{
              imag = (this.imaginary.multiply(BigDecimal.valueOf(pow(10, this.imaginaryExp))).compareTo(((MyNumber) o).imaginary.multiply(BigDecimal.valueOf(pow(10, ((MyNumber) o).imaginaryExp))))==0);
          }
      }

      return imag && real;
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
