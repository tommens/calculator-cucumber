package visitor;

import calculator.Converter;
import calculator.MyNumber;
import calculator.Operation;

/* Visitor design pattern
 */
public abstract class Visitor {

    public abstract void visit(MyNumber n);
    public abstract void visit(Converter n);
    public abstract void visit(Operation o);
}
