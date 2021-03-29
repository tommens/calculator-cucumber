package calculator;

import java.math.BigInteger;
import java.util.List;

final public class ModularInverse extends Operation {

    public /*constructor*/ ModularInverse(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "mod";
        modulo=new BigInteger(Integer.MAX_VALUE+"");
    }

    public ModularInverse(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "mod";
        modulo=new BigInteger(Integer.MAX_VALUE+"");
    }

    public /*constructor*/ ModularInverse(List<Expression> elist, MyNumber modulo) throws IllegalConstruction {
        super(elist);
        symbol = "mod";
        this.modulo=modulo.getValue();
    }

    public ModularInverse(List<Expression> elist, MyNumber modulo, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "mod";
        this.modulo=modulo.getValue();
    }

    public BigInteger op(BigInteger l, BigInteger r) throws ArithmeticException{
        return (l.modInverse(r));
    }
}
