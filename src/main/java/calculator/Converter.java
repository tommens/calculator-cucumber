package calculator;

import visitor.Visitor;

import java.math.BigInteger;

public class Converter implements Expression{

    BigInteger value;

    public Converter(BigInteger value) {
        this.value=value;
    }

    public BigInteger getValue(){
        return value;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
