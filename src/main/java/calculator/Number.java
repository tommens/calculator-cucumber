package calculator;

import visitor.Visitor;


public abstract class Number implements Expression
{

    protected  /*constructor*/ Number() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Integer countDepth() {
        return 0;
    }

    public Integer countOps() {
        return 0;
    }

    public Integer countNbs() {
        return 1;
    }

    public abstract Number negate();

    public abstract Number add(Number val);

    public abstract Number subtract(Number val);

    public abstract Number multiply(Number val);

    public abstract Number divide(Number val);

}
