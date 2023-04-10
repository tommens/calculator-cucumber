package calculator;

import java.util.List;

public class Power extends Operation{
    public Power(List<Expression> elist) throws IllegalConstruction {
        super(elist);
    }

    protected Power(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        symbol = "**";
    }

    public static int power(int a, int b){
        int res =1;
        for (int i = 0; i< b; i++) {
            res *= a;
        }
        return res;
    }
    @Override
    public int op(int l, int r) {
        return power(l,r);
    }
}
