package calculator;

import java.util.List;

public class LogicalEquivalence extends Operation{

    public /*constructor*/ LogicalEquivalence(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public LogicalEquivalence(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "<==>";
    }

    @Override
    public int op(int l, int r) {
        return 0;
    }

    @Override
    public boolean op(boolean a, boolean b) {
        return (!a || b) && (!b || a);
    }

    @Override
    public boolean op(boolean a) {
        return false;
    }
}
