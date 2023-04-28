package visitor;

import calculator.Notation;
import calculator.Operation;

import java.util.stream.Stream;

public class Displayer implements NotationVisitor {

    private Notation notation;

    private static Displayer instance = null;

    private boolean calledFromToString = false;

    private Displayer(Notation notation) {
        this.notation = notation;
    }

    private Displayer(){

    }

    private Displayer(boolean calledFromToString){
        this.calledFromToString = calledFromToString;
    }

    public static void deleteDisplayer() {
        instance = null;
    }



    @Override

    public String visit(Operation operation) {
        notation = calledFromToString ? operation.notation : (notation == null ? operation.notation : notation);

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

    public static Displayer createDisplayer(Notation notation){
        instance = new Displayer(notation);
        return instance;
    }

    public static Displayer createDisplayer(){
        instance = new Displayer();
        return instance;
    }

    public static Displayer createDisplayer(boolean calledFromToString){
        instance = new Displayer(calledFromToString);
        return instance;
    }

    public static Displayer getInstance(){
        return instance;
    }
}
