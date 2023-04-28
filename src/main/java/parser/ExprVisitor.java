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
	 * Visit a parse tree produced by {@link ExprParser#postfixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperation(ExprParser.PostfixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatoroperatoroperatoroperatoroperatoree2e2e2tt2t2t2numnumnumnumnum}.
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
	 * Visit a parse tree produced by the {@code Modulo}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(ExprParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ExprParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GCD}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGCD(ExprParser.GCDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LCM}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLCM(ExprParser.LCMContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#infixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOperation(ExprParser.InfixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StartValueInfix}
	 * labeled alternative in {@link ExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartValueInfix(ExprParser.StartValueInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InfixPlus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixPlus(ExprParser.InfixPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InfixMinus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixMinus(ExprParser.InfixMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Void}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid(ExprParser.VoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SecondValueInfix}
	 * labeled alternative in {@link ExprParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondValueInfix(ExprParser.SecondValueInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InfixTimes}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixTimes(ExprParser.InfixTimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InfixDivides}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixDivides(ExprParser.InfixDividesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Void2}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid2(ExprParser.Void2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(ExprParser.FContext ctx);
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
	/**
	 * Visit a parse tree produced by the {@code Pi}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPi(ExprParser.PiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Euler}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEuler(ExprParser.EulerContext ctx);
}