package calculator;

import visitor.Visitor;

public class Variable implements Expression {

    @Override
    public void accept(Visitor v) {

    }

    @Override
    public Integer countDepth() {
        return null;
    }

    @Override
    public Integer countOps() {
        return null;
    }

    @Override
    public Integer countNbs() {
        return null;
    }
}
