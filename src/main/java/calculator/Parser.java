package calculator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CalculatorExpressionLexer;
import parser.CalculatorExpressionParser;
import visitor.SyntaxTreeVisitor;


public class Parser {

    /**
     * Parses the string and return a syntax tree for the expression
     * @param expression the expression to parse
     */
    public static Expression parse(String expression) {
        // Source: https://github.com/antlr/antlr4/blob/4.6/doc/listeners.md
        CharStream input = new ANTLRInputStream(expression);
        CalculatorExpressionLexer lexer = new CalculatorExpressionLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorExpressionParser parser = new CalculatorExpressionParser(tokens);
        CalculatorExpressionParser.ExpressionContext tree = parser.expression();

        // Map tree to Expression
        SyntaxTreeVisitor treeVisitor = new SyntaxTreeVisitor();
        return treeVisitor.visit(tree);
    }
}
