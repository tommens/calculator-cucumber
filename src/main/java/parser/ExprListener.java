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
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#prefixOperation}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOperation(ExprParser.PrefixOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prefixOperation}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOperation(ExprParser.PrefixOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#infixOperation}.
	 * @param ctx the parse tree
	 */
	void enterInfixOperation(ExprParser.InfixOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#infixOperation}.
	 * @param ctx the parse tree
	 */
	void exitInfixOperation(ExprParser.InfixOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#postfixOperation}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOperation(ExprParser.PostfixOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#postfixOperation}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOperation(ExprParser.PostfixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatoroperatoroperatoroperatoroperatornumnumnum}.
	 * @param ctx the parse tree
	 */
	void enterValues(ExprParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatoroperatoroperatoroperatoroperatornumnumnum}.
	 * @param ctx the parse tree
	 */
	void exitValues(ExprParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterPlus(ExprParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitPlus(ExprParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterMinus(ExprParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitMinus(ExprParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Times}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterTimes(ExprParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Times}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitTimes(ExprParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divides}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterDivides(ExprParser.DividesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divides}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitDivides(ExprParser.DividesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Modulo}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterModulo(ExprParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Modulo}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitModulo(ExprParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterPower(ExprParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitPower(ExprParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GCD}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterGCD(ExprParser.GCDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GCD}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitGCD(ExprParser.GCDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LCM}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterLCM(ExprParser.LCMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LCM}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitLCM(ExprParser.LCMContext ctx);
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