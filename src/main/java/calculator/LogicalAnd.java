package calculator;

import java.util.List;

public class LogicalAnd extends Operation{

    public /*constructor*/ LogicalAnd(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public LogicalAnd(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "AND";
        //neutral = 1;
    }
    @Override
    public int op(int l, int r) {
        return 0;
    }

    @Override
    public boolean op(boolean a, boolean b) {
        return a && b;
    }

    @Override
    public boolean op(boolean a) {
        return false;
    }
}
