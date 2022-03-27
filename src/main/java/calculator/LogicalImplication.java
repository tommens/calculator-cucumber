package calculator;

import java.util.List;

public class LogicalImplication  extends Operation{

    public /*constructor*/ LogicalImplication(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public LogicalImplication(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "==>";
    }

    @Override
    public int op(int l, int r) {
        return 0;
    }

    @Override
    public boolean op(boolean a, boolean b) {
        return !a || b;
    }

    @Override
    public boolean op(boolean a) {
        return false;
    }
}
