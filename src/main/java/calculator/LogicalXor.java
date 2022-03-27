package calculator;

import java.util.List;

public class LogicalXor extends Operation {

    public /*constructor*/ LogicalXor(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public LogicalXor(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist,n);
        symbol = "XOR";
    }

    @Override
    public int op(int l, int r) {
        return 0;
    }

    @Override
    public boolean op(boolean a, boolean b) {
        return a ^ b;
    }

    @Override
    public boolean op(boolean a) {
        return false;
    }
}
