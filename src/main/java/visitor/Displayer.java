package visitor;

import calculator.Notation;
import calculator.Operation;

import java.util.stream.Stream;

public class Displayer implements NotationVisitor {

    private Notation notation;

    public Displayer(Notation notation) {
        this.notation = notation;
    }

    public Displayer(){

    }

    @Override

    public String visit(Operation operation) {
        notation = notation == null ? operation.notation : notation;

        Stream<String> s = operation.args.stream().map(Object::toString);
        return switch (notation) {
            case INFIX -> "( " +
                    s.reduce((s1, s2) -> s1 + " " + operation.getSymbol() + " " + s2).get() +
                    " )";
            case PREFIX -> operation.getSymbol() + " " +
                    "(" +
                    s.reduce((s1, s2) -> s1 + ", " + s2).get() +
                    ")";
            case POSTFIX -> "(" +
                    s.reduce((s1, s2) -> s1 + ", " + s2).get() +
                    ")" +
                    " " + operation.getSymbol();

        };
    }

}
