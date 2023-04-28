package calculator;

import visitor.Counter;
import visitor.Displayer;
import visitor.TimeVisitor;
import visitor.Visitor;

/**
 * Expression is an abstract class that represents arithmetic expressions.
 * It has two concrete subclasses Operation and MyNumber.
 *
 * @see Operation
 * @see MyNumber
 */
public interface Expression {

   /**
    * accept is a method needed to implement the visitor design pattern
    *
    * @param v The visitor object being passed as a parameter
    */
   void accept(Visitor v) throws ArithmeticException;

    default String printOperation() {
        String result = accept(Displayer.createDisplayer());
        Displayer.deleteDisplayer();
        return result;
    }

    default String printOperation(Notation notation) {
        String result = accept(Displayer.createDisplayer(notation));
        Displayer.deleteDisplayer();
        return result;
    }

    default String accept(Displayer displayer) {
        try {
            return displayer.visit((Operation) this);
        } catch (ClassCastException e) {
            return "";
        }
    }

    default void accept(Counter counter) {
        counter.visit(this);
    }

    void accept(TimeVisitor v);
}




