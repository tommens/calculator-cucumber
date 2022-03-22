// Generated from /home/thomas/Documents/Projects/calculator-cucumber/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorExpressionParser}.
 */
public interface CalculatorExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CalculatorExpressionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CalculatorExpressionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalculatorExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalculatorExpressionParser.NumberContext ctx);
}