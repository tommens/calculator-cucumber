package visitor;

import calculator.*;
import calculator.operation.Divides;
import calculator.operation.Minus;
import calculator.operation.Plus;
import calculator.operation.Times;
import calculator.operation.buildinfunctions.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
import parser.CalculatorExpressionParser;
import parser.CalculatorExpressionVisitor;

import java.util.List;

public class SyntaxTreeVisitor implements CalculatorExpressionVisitor<Expression> {

    Calculator calculator;

    public SyntaxTreeVisitor(Calculator calc) {
        calculator = calc;
    }

    private Expression term(ParserRuleContext ctx) {
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

    private Expression factor(ParserRuleContext ctx) {
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

    private Expression function(ParserRuleContext ctx) {
        Expression argument = ctx.getChild(2).accept(this);
        String functionName = ctx.getChild(0).getText();
        try {
            return switch (functionName) {
                case "acos"      -> new Acos(argument);
                case "asin"      -> new Asin(argument);
                case "asinh"     -> new Asinh(argument);
                case "atan"      -> new Atan(argument);
                case "atanh"     -> new Atanh(argument);
                case "cos"       -> new Cos(argument);
                case "cosh"      -> new Cosh(argument);
                case "identity"  -> new Identity(argument);
                case "ln"        -> new Ln(argument);
                case "log"       -> new Log(argument);
                case "sin"       -> new Sin(argument);
                case "sinh"      -> new Sinh(argument);
                case "sqrt"      -> new Sqrt(argument);
                case "tan"       -> new Tan(argument);
                case "tanh"      -> new Tanh(argument);
                default -> {
                    // There is no built-in function
                    if (!calculator.hasFunction(functionName)) {
                        throw new RuntimeException("No function called " + functionName + " exists.");
                    }
                    Function fn = calculator.getFunction(functionName);
                    fn.accept(new VariableAssignerVisitor(argument)); // Set the value ?

                    yield fn;
                }

            };
        } catch (IllegalConstruction e) {
            throw new RuntimeException("Could not instantiate function called " + functionName);
        }
    }

    @Override
    public Expression visitExpression(CalculatorExpressionParser.ExpressionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Expression visitFunction_call(CalculatorExpressionParser.Function_callContext ctx) {
        return function(ctx);
    }

    @Override
    public Expression visitTerm(CalculatorExpressionParser.TermContext ctx) {
        return term(ctx);
    }

    @Override
    public Expression visitFactor(CalculatorExpressionParser.FactorContext ctx) {
        return factor(ctx);
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
                    case CalculatorExpressionParser.DECIMAL -> throw new RuntimeException("Missing implementation for decimal numbers"); // TODO Rational or real
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
                    case CalculatorExpressionParser.DECIMAL -> throw new RuntimeException("Missing implementation for decimal numbers"); // TODO Rational or real
                    case CalculatorExpressionParser.IMAGINARY -> throw new RuntimeException("Missing implementation for imaginary numbers");
                    default -> throw new InvalidSyntax("Invalid number");
                };
            }
            default -> throw new InvalidSyntax("Unknown number of children.");
        };

    }

    @Override
    public Expression visitFunction_defintion(CalculatorExpressionParser.Function_defintionContext ctx) {
        String functionName = ctx.getChild(0).getText();
        Expression subExpr = ctx.getChild(2).accept(this);
        Function f = new Function(functionName, subExpr);
        calculator.addFunction(f);
        return f;
    }

    @Override
    public Expression visitFunction_function_call(CalculatorExpressionParser.Function_function_callContext ctx) {
        return function(ctx);
    }

    @Override
    public Expression visitFunction_parenthesed_expression(CalculatorExpressionParser.Function_parenthesed_expressionContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Expression visitFunction_term(CalculatorExpressionParser.Function_termContext ctx) {
        return term(ctx);
    }

    @Override
    public Expression visitFunction_factor(CalculatorExpressionParser.Function_factorContext ctx) {
        return factor(ctx);
    }

    @Override
    public Expression visitFunction_value(CalculatorExpressionParser.Function_valueContext ctx) {
        // Always one child, whether it is a number or an expression
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitVariable(CalculatorExpressionParser.VariableContext ctx) {
        return new Variable(ctx.getChild(0).getText());
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
