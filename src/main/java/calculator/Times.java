package calculator;

import java.util.List;

final public class Times extends Operation
{

  public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
  	super(elist);
  	symbol = "×";
  	neutral = 1;
  }

    @Override
    public Number op(Number l, Number r) {
        return l.multiply(r);
    }
}
