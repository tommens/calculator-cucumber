package calculator;

import visitor.Visitor;


public abstract class Number implements Expression
{

    protected  /*constructor*/ Number() {
    }

    /**
     * Converts the number to a Real number
     */
    public abstract Real toReal();

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

    public Number add(Number val){
        if(val instanceof Rational rat){
            return add(rat);
        }else if(val instanceof Real r){
            return add(r);
        }
        return null;
    }
    protected abstract Number add(Rational rat);
    protected abstract Number add(Real r);

    public Number subtract(Number val) {
        return add(val.negate());
    };

    public Number multiply(Number val){
        if(val instanceof Rational rat){
            return multiply(rat);
        }else if(val instanceof Real r){
            return multiply(r);
        }
        return null;
    }
    protected abstract Number multiply(Rational rat);
    protected abstract Number multiply(Real r);

    public Number divide(Number val){
        if(val instanceof Rational rat){
            return divide(rat);
        }else if(val instanceof Real r){
            return divide(r);
        }
        return null;
    }
    protected abstract Number divide(Rational rat);
    protected abstract Number divide(Real r);

}
