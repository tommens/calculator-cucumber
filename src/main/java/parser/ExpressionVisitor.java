package parser;

import calculator.*;

import java.math.MathContext;
import java.util.ArrayList;


/**
 * This class implement the method to visit tokens
 */
public class ExpressionVisitor extends ExprBaseVisitor<Expression>{

    /** Stack in which we store values as we visit the derivation tree*/
    private Stack stack = new Stack();

    /** The notation of the current operation visited */
    private Notation tempNot;

    /** MathContext is use for real numbers */
    private MathContext mathContext;


    /**
     * Constructor
     * @param mc The mathContext that is use for operations on real numbers
     */
    public ExpressionVisitor(MathContext mc){
        mathContext = mc;
    }

    /**
     * Visit the root of the derivation tree
     * @param ctx the parse tree
     * @return The Expression object corresponding to the input given
     */
    @Override
    public Expression visitInput(ExprParser.InputContext ctx) {
        return visit(ctx.getChild(0));
    }

    /**
     * Visit an expression
     * @param ctx the parse tree
     * @return An Expression object
     */
    @Override
    public Expression visitExpr(ExprParser.ExprContext ctx) {
        return visit(ctx.getChild(0));
    }

    /**
     * Visit a prefix operation (Grammar : Operation values)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the prefix operation visited
     */
    @Override
    public Expression visitPrefixOperation(ExprParser.PrefixOperationContext ctx) {
        stack.addNewArray();
        visit(ctx.getChild(1));
        tempNot = Notation.PREFIX;
        Expression op = visit(ctx.getChild(0));
        tempNot = null;
        return op;
    }

    /**
     * Visit a postfix operation (Grammar : Values Operation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the postfix operation visited
     */
    @Override
    public Expression visitPostfixOperation(ExprParser.PostfixOperationContext ctx) {
        stack.addNewArray();
        visit(ctx.getChild(0));
        tempNot = Notation.POSTFIX;
        Expression op = visit(ctx.getChild(1));
        tempNot = null;
        return op;
    }

    /**
     * Visit a set of values
     * @param ctx the parse tree
     * @return null
     */
    @Override
    public Expression visitValues(ExprParser.ValuesContext ctx) {
        for (int i=0; i< ctx.getChildCount();i++){
            Expression e = visit(ctx.getChild(i));
            if (e != null){
                stack.insertInLastArray(e);
            }
        }
        return null;
    }


    /**
     * Visit a Plus (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Plus operation visited
     */
    @Override
    public Expression visitPlus(ExprParser.PlusContext ctx){
        try {
            Plus op = new Plus(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a Minus operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Minus operation visited
     */
    @Override
    public Expression visitMinus(ExprParser.MinusContext ctx) {
        try {
            Minus op = new Minus(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a Times operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Times operation visited
     */
    @Override
    public Expression visitTimes(ExprParser.TimesContext ctx) {
        try {
            Times op = new Times(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a Divides operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Divides operation visited
     */
    @Override
    public Expression visitDivides(ExprParser.DividesContext ctx) {
        try {
            Divides op = new Divides(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a modulo operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Modulo operation visited
     */
    @Override
    public Expression visitModulo(ExprParser.ModuloContext ctx) {
        try {
            Modulo op = new Modulo(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a Power operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Power operation visited
     */
    @Override
    public Expression visitPower(ExprParser.PowerContext ctx) {
        try {
            Power op = new Power(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a GCB operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the GCD operation visited
     */
    @Override
    public Expression visitGCD(ExprParser.GCDContext ctx) {
        try {
            GreatestCommonDivisor op = new GreatestCommonDivisor(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit a LCM operation (for prefix and postfix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the LCM operation visited
     */
    @Override
    public Expression visitLCM(ExprParser.LCMContext ctx) {
        try {
            LeastCommonMultiple op = new LeastCommonMultiple(stack.popArray(),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    /**
     * Visit an Integer
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Integer number visited
     */
    @Override
    public Expression visitInteger(ExprParser.IntegerContext ctx) {
        return new MyInteger(Integer.parseInt(ctx.getText()));
    }

    /**
     * Visit a Real number
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Real number visited
     */
    @Override
    public Expression visitReal(ExprParser.RealContext ctx) {
        if (mathContext != null){
            return new MyRealNumber(ctx.getText(),mathContext);
        }
        return new MyRealNumber(ctx.getText());
    }

    /**
     * Visit a Rational number
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Rational number visited
     */
    @Override
    public Expression visitFraction(ExprParser.FractionContext ctx) {
        String value = ctx.getText();
        String[] fracVal = value.split("_");
        return MyRationalNumber.create(Long.parseLong(fracVal[0]), Long.parseLong(fracVal[1]));
    }

    /**
     * Set the mathContext to an operation
     * @param op The operation in which we want to set the mathContext
     */
    private void setMathContext(Operation op){
        if (mathContext != null){
            op.setMathContext(mathContext);
        }
    }


    /**
     * Visit an Infix operation
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Infix operation visited
     */
    @Override
    public Expression visitInfixOperation(ExprParser.InfixOperationContext ctx) {
        stack.addNewArray();
        Expression e = visit(ctx.getChild(0));
        stack.popArray();
        return e;
    }

    /**
     * Visit the grammar "e : t e2"
     * @param ctx the parse tree
     * @return An Expression object
     */
    @Override
    public Expression visitStartValueInfix(ExprParser.StartValueInfixContext ctx) {
        stack.addNewArray();
        Expression e = visit(ctx.getChild(0));
        Expression e2 = visit(ctx.getChild(1));
        stack.popArray();
        if (e2 == null){
            stack.insertInLastArray(e);
            return e;
        }
        stack.insertInLastArray(e2);
        return e2;
    }

    /**
     * Visit a Plus operation (for infix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Plus operation visited
     */
    @Override
    public Expression visitInfixPlus(ExprParser.InfixPlusContext ctx) {
        visit(ctx.getChild(1));
        try{
            Plus op = new Plus(stack.popArray(),Notation.INFIX);
            setMathContext(op);
            stack.addNewArray();
            stack.insertInLastArray(op);
            Expression e = visit(ctx.getChild(2));
            if (e == null){
                return op;
            }
            return e;
        }catch (IllegalConstruction exception){
            return null;
        }
    }

    /**
     * Visit a Minus operation (for infix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Plus operation visited
     */
    @Override
    public Expression visitInfixMinus(ExprParser.InfixMinusContext ctx) {
        visit(ctx.getChild(1));
        try{
            Minus op = new Minus(stack.popArray(),Notation.INFIX);
            setMathContext(op);
            stack.addNewArray();
            stack.insertInLastArray(op);
            Expression e = visit(ctx.getChild(2));
            if (e == null){
                return op;
            }
            return e;
        }catch (IllegalConstruction exception){
            return null;
        }
    }

    /**
     * Visit the grammar "t : f t2 "
     * @param ctx the parse tree
     * @return An Expression object
     */
    @Override
    public Expression visitSecondValueInfix(ExprParser.SecondValueInfixContext ctx) {
        stack.addNewArray();
        Expression e = visit(ctx.getChild(0));
        Expression e2 = visit(ctx.getChild(1));
        stack.popArray();
        if (e2 == null){
            stack.insertInLastArray(e);
            return e;
        }
        stack.insertInLastArray(e2);
        return e2;
    }

    /**
     * Visit a Times operation (for infix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Plus operation visited
     */
    @Override
    public Expression visitInfixTimes(ExprParser.InfixTimesContext ctx) {
        visit(ctx.getChild(1));
        try{
            Times op = new Times(stack.popArray(),Notation.INFIX);
            setMathContext(op);
            stack.addNewArray();
            stack.insertInLastArray(op);
            Expression e = visit(ctx.getChild(2));
            if (e == null){
                return op;
            }
            return e;
        }catch (IllegalConstruction exception){
            return null;
        }
    }

    /**
     * Visit a Divides operation (for infix notation)
     * @param ctx the parse tree
     * @return The Expression object corresponding to the Divides operation visited
     */
    @Override
    public Expression visitInfixDivides(ExprParser.InfixDividesContext ctx) {
        visit(ctx.getChild(1));
        try{
            Divides op = new Divides(stack.popArray(),Notation.INFIX);
            setMathContext(op);
            stack.addNewArray();
            stack.insertInLastArray(op);
            Expression e = visit(ctx.getChild(2));
            if (e == null){
                return op;
            }
            return e;
        }catch (IllegalConstruction exception){
            return null;
        }
    }

    /**
     * Visit a number or an expression between brackets
     * @param ctx the parse tree
     * @return An Expression object
     */
    @Override
    public Expression visitF(ExprParser.FContext ctx) {
        Expression e = visit(ctx.getChild(0));
        if ( e == null){
            // we don't visit a num
            // we visit ( expr )
            e = visit(ctx.getChild(1));
        }
        stack.insertInLastArray(e);
        return e;
    }

    /**
     * Visit the number Pi
     * @param ctx the parse tree
     * @return An Expression object containing pi
     */
    @Override
    public Expression visitPi(ExprParser.PiContext ctx) {
        return new MyRealNumber(Math.PI);
    }

    /**
     * Visit the Euler number
     * @param ctx the parse tree
     * @return An Expression object containing the euler number
     */
    @Override
    public Expression visitEuler(ExprParser.EulerContext ctx) {
        return new MyRealNumber(Math.E);
    }
}
