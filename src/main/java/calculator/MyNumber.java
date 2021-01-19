package calculator;

public class MyNumber implements Expression
{
  private int value;

  public /*constructor*/ MyNumber(int v) {
	  value=v;
	  }

  public Integer compute() {
	  return value;
	  }
  
  public Integer countDepth() {
	  return 0;
  }
  
  public Integer countOps() {
	  return 0;
  }

  public Integer countNbs() {
	  return 1;
  }

  @Override
  public String toString() {
	  return Integer.toString(value);
  }

  //Two MyNumber expressions are equal if the values they contain are equal
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
      return this.value == ((MyNumber)o).value;
      // I used == above since the contained value is a primitive value
      // If it had been a Java object, .equals() would be needed
  }

  // The method hashCode() needs to be overridden if the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
  @Override
  public int hashCode() {
		return value;
  }

}
