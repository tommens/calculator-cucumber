package calculator;

import visitor.Visitor;

/**
 * MyNumber is an abstract class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
public abstract class MyNumber implements Expression
{

    /**
     * abstract method to obtain the integer value contain in the object
     * @return The integer number contain in the object
     */
    public abstract Integer getInteger();

    /**
     * abstract method to obtain the rational number contain in the object
     * @return The rational number contain in the object
     */
    public abstract MyRationalNumber getRational();

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


    /** The method hashCode needs to be overridden it the equals method is overridden;
     * 	otherwise there may be problems when you use your object in hashed collections
     * 	such as HashMap, HashSet, LinkedHashSet.
     *
     * @return	The result of computing the hash.
     */
  @Override
  public int hashCode() {
		return getInteger();
  }

}
