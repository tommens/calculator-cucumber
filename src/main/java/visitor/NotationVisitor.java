package visitor;

import calculator.Expression;
import calculator.Notation;
import calculator.Operation;

public interface NotationVisitor {
    String visit(Operation operation);




}
