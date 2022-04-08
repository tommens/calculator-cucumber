package calculator;

import java.util.List;

final public class Times extends Operation
{

    public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction{
  	    super(elist);
  	    symbol = "x";
  	    neutral = 1;
    }


    @Override
    public boolean op(boolean a, boolean b){
        return false;
    }

    @Override
    public boolean op(boolean op){
        return false;

    @Override
    public Number op(Number l, Number r){
        return l.multiply(r);
    }
}
