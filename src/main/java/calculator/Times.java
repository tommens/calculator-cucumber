package calculator;

import java.util.List;

final public class Times extends Operation
{

  public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
  	this(elist, null);
  }

  public Times(List<Expression> elist, Notation n) throws IllegalConstruction {
  	super(elist,n);
  	symbol = "*";
  	neutral = 1;
  }
  
  public int op(int l, int r)
    { return (l*r); }

    @Override
    public boolean op(boolean a, boolean b) {
        return false;
    }

    @Override
    public boolean op(boolean op) {
        return false;
    }
}
