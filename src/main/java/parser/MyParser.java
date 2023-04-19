package parser;

import calculator.Expression;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


/**
 * This class represent a parser that convert a string representing
 * an expression to an Expression object
 */
public class MyParser {

    /**
     * convert a string representing an expression to an Expression object
     * @param inputString a string representing an expression
     * @return An Expression object
     */
    public static Expression parse(String inputString){
        CharStream input = CharStreams.fromString(inputString);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.input();
        ExpressionVisitor visitor = new ExpressionVisitor();
        return visitor.visit(tree);
    }
}
