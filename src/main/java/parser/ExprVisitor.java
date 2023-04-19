// Generated from parser/Expr.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(ExprParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#prefixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperation(ExprParser.PrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#infixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOperation(ExprParser.InfixOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#postfixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperation(ExprParser.PostfixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatornumnumnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(ExprParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(ExprParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(ExprParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Times}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes(ExprParser.TimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divides}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivides(ExprParser.DividesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(ExprParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(ExprParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fraction}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(ExprParser.FractionContext ctx);
}