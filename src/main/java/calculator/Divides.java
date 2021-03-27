package calculator;

import java.math.BigInteger;
import java.util.List;

final public class Divides extends Operation
{

  public /*constructor*/ Divides(List<Expression> elist) throws IllegalConstruction {
	  super(elist);
	  symbol = "/";
	  neutral = BigInteger.ONE;
  }

  public Divides(List<Expression> elist, Notation n) throws IllegalConstruction {
	super(elist,n);
	symbol = "/";
	neutral = BigInteger.ONE;
    }
  
  public BigInteger op(BigInteger l, BigInteger r)
    {
    	if (r.equals(BigInteger.ZERO)){
    		throw new DivisionByZero();
		}
    	return (l.divide(r));
    }
}
