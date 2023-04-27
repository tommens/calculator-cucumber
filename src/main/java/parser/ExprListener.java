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
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatoroperatoroperatoroperatoroperatoree2e2e2tt2t2t2numnumnumnumnum}.
	 * @param ctx the parse tree
	 */
	void enterValues(ExprParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link ExprParser#operatoroperatoroperatoroperatoroperatoroperatoroperatoroperatoree2e2e2tt2t2t2numnumnumnumnum}.
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
	 * Enter a parse tree produced by the {@code StartValueInfix}
	 * labeled alternative in {@link ExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterStartValueInfix(ExprParser.StartValueInfixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StartValueInfix}
	 * labeled alternative in {@link ExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitStartValueInfix(ExprParser.StartValueInfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixPlus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void enterInfixPlus(ExprParser.InfixPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixPlus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void exitInfixPlus(ExprParser.InfixPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixMinus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void enterInfixMinus(ExprParser.InfixMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixMinus}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void exitInfixMinus(ExprParser.InfixMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Void}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void enterVoid(ExprParser.VoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Void}
	 * labeled alternative in {@link ExprParser#e2}.
	 * @param ctx the parse tree
	 */
	void exitVoid(ExprParser.VoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SecondValueInfix}
	 * labeled alternative in {@link ExprParser#t}.
	 * @param ctx the parse tree
	 */
	void enterSecondValueInfix(ExprParser.SecondValueInfixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SecondValueInfix}
	 * labeled alternative in {@link ExprParser#t}.
	 * @param ctx the parse tree
	 */
	void exitSecondValueInfix(ExprParser.SecondValueInfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixTimes}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void enterInfixTimes(ExprParser.InfixTimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixTimes}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void exitInfixTimes(ExprParser.InfixTimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixDivides}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void enterInfixDivides(ExprParser.InfixDividesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixDivides}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void exitInfixDivides(ExprParser.InfixDividesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Void2}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void enterVoid2(ExprParser.Void2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Void2}
	 * labeled alternative in {@link ExprParser#t2}.
	 * @param ctx the parse tree
	 */
	void exitVoid2(ExprParser.Void2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(ExprParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(ExprParser.FContext ctx);
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
	/**
	 * Enter a parse tree produced by the {@code Pi}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void enterPi(ExprParser.PiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pi}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void exitPi(ExprParser.PiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Euler}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void enterEuler(ExprParser.EulerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Euler}
	 * labeled alternative in {@link ExprParser#num}.
	 * @param ctx the parse tree
	 */
	void exitEuler(ExprParser.EulerContext ctx);
}