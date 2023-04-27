package visitor;

import calculator.Expression;

public interface CounterVisitor {

    void visit(Expression expression);
}
