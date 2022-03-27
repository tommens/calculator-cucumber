package calculator;

import java.util.List;

public class LogicalNot extends Operation{

    public /*constructor*/ LogicalNot(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public LogicalNot(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "NOT";

    }
    @Override
    public int op(int l, int r) {
        return 0;
    }

    @Override
    public boolean op(boolean a, boolean b) {
        return false;
    }

    @Override
    public boolean op(boolean a) {
        return !a;
    }
}
