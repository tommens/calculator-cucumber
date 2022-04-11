package visitor;

import calculator.Number;
import calculator.Operation;
import calculator.Variable;
import calculator.operation.buildinfunctions.RealFunction;

/* Visitor design pattern
 */
public abstract class Visitor {

    public abstract void visit(Number n);
    public abstract void visit(Variable v);
    public abstract void visit(Operation o);
    public abstract void visit(RealFunction f);
}
