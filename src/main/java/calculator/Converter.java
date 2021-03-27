package calculator;

import visitor.Visitor;

import java.math.BigInteger;

public class Converter implements Expression{

    MyNumber value;
    String representation;
    int radix;

    public Converter(MyNumber value, int radix) {
        this.value=value;
        representation=value.getRepresentation();
        this.radix=radix;
    }

    public BigInteger getValue(){
        return value.getValue();
    }

    public MyNumber getNumber(){
        return value;
    }

    public int getRadix() {
        return radix;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
