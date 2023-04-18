// Generated from parser/Expr.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(ExprParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(ExprParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(ExprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(ExprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(ExprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(ExprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(ExprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(ExprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(ExprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(ExprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ExprParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ExprParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void enterReal(ExprParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void exitReal(ExprParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fraction}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void enterFraction(ExprParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fraction}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void exitFraction(ExprParser.FractionContext ctx);
}