package visitor;

import calculator.MyTime;
import calculator.Operation;

public abstract class TimeVisitor {
    /**
     * The Visitor can traverse a number (a subtype of Expression)
     *
     * @param n The number being visited
     */
    public abstract void visit(MyTime n);

    /**
     * The Visitor can traverse an operation (a subtype of Expression)
     *
     * @param o The operation being visited
     */   public abstract void visit(Operation o);
}
