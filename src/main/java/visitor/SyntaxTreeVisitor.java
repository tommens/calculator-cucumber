package visitor;

import calculator.*;
import org.antlr.v4.runtime.tree.*;
import parser.CalculatorExpressionParser;
import parser.CalculatorExpressionVisitor;

import java.math.BigDecimal;
import java.util.List;

public class SyntaxTreeVisitor implements CalculatorExpressionVisitor<Expression> {

    @Override
    public Expression visitExpression(CalculatorExpressionParser.ExpressionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Expression visitTerm(CalculatorExpressionParser.TermContext ctx) {
        return switch(ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression term = ctx.getChild(0).accept(this);
                Expression factor = ctx.getChild(2).accept(this);
                TerminalNodeImpl symbol = (TerminalNodeImpl) ctx.getChild(1);
                List<Expression> elist = List.of(term, factor);
                try {
                    yield switch (symbol.getSymbol().getType()) {
                        case CalculatorExpressionParser.PLUS -> new Plus(elist);
                        case CalculatorExpressionParser.MINUS -> new Minus(elist);
                        default -> throw new InvalidSyntax("The term uses an unknown symbol");
                    };
                } catch (IllegalConstruction e) {
                    throw new InvalidSyntax("Could not create the operator");
                }

            }
            default -> throw new InvalidSyntax("Term has an unknown amount of children.");
        };
    }

    @Override
    public Expression visitFactor(CalculatorExpressionParser.FactorContext ctx) {
        return switch(ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression factor = ctx.getChild(0).accept(this);
                Expression value = ctx.getChild(2).accept(this);
                TerminalNodeImpl symbol = (TerminalNodeImpl) ctx.getChild(1);
                List<Expression> elist = List.of(factor, value);
                try {
                    yield switch (symbol.getSymbol().getType()) {
                        case CalculatorExpressionParser.MULT -> new Times(elist);
                        case CalculatorExpressionParser.DIV -> new Divides(elist);
                        default -> throw new InvalidSyntax("The term uses an unknown symbol");
                    };
                } catch (IllegalConstruction e) {
                    throw new InvalidSyntax("Could not create the operator");
                }

            }
            default -> throw new InvalidSyntax("Term has an unknown amount of children.");
        };
    }

    @Override
    public Expression visitValue(CalculatorExpressionParser.ValueContext ctx) {
        // Always one child, whether it is a number or an expression
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitNumber(CalculatorExpressionParser.NumberContext ctx) {



        return switch (ctx.getChildCount()) {
            case 1 -> {
                // The number is the value of the child.
                assert ctx.getChild(0) instanceof TerminalNodeImpl;
                TerminalNodeImpl nb = (TerminalNodeImpl) ctx.getChild(0);
                yield switch (nb.getSymbol().getType()) {
                    case CalculatorExpressionParser.INT -> new Rational(Integer.parseInt(nb.getText()));
                    case CalculatorExpressionParser.DECIMAL -> new Real(nb.getText());
                    case CalculatorExpressionParser.IMAGINARY -> throw new RuntimeException("Missing implementation for imaginary numbers");
                    default -> throw new InvalidSyntax("Invalid number");
                };
            }
            case 2 -> {
                assert ((TerminalNodeImpl) ctx.getChild(0)).getSymbol().getType() == CalculatorExpressionParser.MINUS;
                assert ctx.getChild(1) instanceof TerminalNodeImpl;
                TerminalNodeImpl nb = (TerminalNodeImpl) ctx.getChild(1);
                yield switch (nb.getSymbol().getType()) {
                    case CalculatorExpressionParser.INT -> new Rational(Integer.parseInt(nb.getText())).negate();
                    case CalculatorExpressionParser.DECIMAL -> new Real(nb.getText());
                    case CalculatorExpressionParser.IMAGINARY -> throw new RuntimeException("Missing implementation for imaginary numbers");
                    default -> throw new InvalidSyntax("Invalid number");
                };
            }
            default -> throw new InvalidSyntax("Unknown number of children.");
        };


    }

    @Override
    public Expression visit(ParseTree parseTree) {
        return parseTree.getChild(0).accept(this); // The only child of an expression is a term.
    }

    @Override
    public Expression visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Expression visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Expression visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
