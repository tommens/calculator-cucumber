package calculator;

import java.util.List;

public class Modulo extends Operation{
    public Modulo(List<Expression> elist) throws IllegalConstruction {
        super(elist);
    }

    protected Modulo(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "%";
    }

    @Override
    public int op(int l, int r) {
        return l % r;
    }
}
