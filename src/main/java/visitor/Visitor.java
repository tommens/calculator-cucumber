package visitor;

import calculator.MyBoolean;
import calculator.MyNumber;
import calculator.Operation;

/* Visitor design pattern
 */
public abstract class Visitor {

    public abstract void visit(MyNumber n);
    public abstract void visit(Operation o);
    public abstract void visit(MyBoolean b);

}
