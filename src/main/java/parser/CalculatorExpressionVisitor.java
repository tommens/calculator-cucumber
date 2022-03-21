// Generated from /home/thomas/Documents/Projects/calculator-cucumber/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CalculatorExpressionParser.ValueContext ctx);
}