package parser;

import calculator.*;

import java.math.MathContext;
import java.util.ArrayList;


/**
 * This class implement the method to visit tokens
 */
public class ExpressionVisitor extends ExprBaseVisitor<Expression>{

    private ArrayList<ArrayList<Expression>> temp = new ArrayList<>();
    private Notation tempNot;

    private MathContext mathContext;

    public ExpressionVisitor(MathContext mc){
        mathContext = mc;
    }

    @Override
    public Expression visitInput(ExprParser.InputContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Expression visitPrefixOperation(ExprParser.PrefixOperationContext ctx) {
        temp.add(new ArrayList<Expression>());
        visit(ctx.getChild(1));
        tempNot = Notation.PREFIX;
        Expression op = visit(ctx.getChild(0));
        tempNot = null;
        temp.remove(temp.size()-1);
        return op;
    }

    @Override
    public Expression visitInfixOperation(ExprParser.InfixOperationContext ctx) {
        temp.add(new ArrayList<Expression>());
        Expression e1 = visit(ctx.getChild(0));
        addValueInfixOp(e1);
        Expression e2 = visit(ctx.getChild(2));
        addValueInfixOp(e2);
        tempNot = Notation.INFIX;
        Expression op = visit(ctx.getChild(1));
        tempNot = null;
        temp.remove(temp.size()-1);
        return op;
    }

    private void addValueInfixOp(Expression exp){
        if (exp != null){
            temp.get(temp.size()-1).add(exp);
        }
    }

    @Override
    public Expression visitPostfixOperation(ExprParser.PostfixOperationContext ctx) {
        temp.add(new ArrayList<Expression>());
        visit(ctx.getChild(0));
        tempNot = Notation.POSTFIX;
        Expression op = visit(ctx.getChild(1));
        tempNot = null;
        temp.remove(temp.size()-1);
        return op;
    }

    @Override
    public Expression visitValues(ExprParser.ValuesContext ctx) {
        for (int i=0; i< ctx.getChildCount();i++){
            Expression e = visit(ctx.getChild(i));
            if (e != null){
                temp.get(temp.size()-1).add(e);
            }
        }
        return null;
    }


    @Override
    public Expression visitPlus(ExprParser.PlusContext ctx){
        try {
            Plus op = new Plus(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitMinus(ExprParser.MinusContext ctx) {
        try {
            Minus op = new Minus(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitTimes(ExprParser.TimesContext ctx) {
        try {
            Times op = new Times(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitDivides(ExprParser.DividesContext ctx) {
        try {
            Divides op = new Divides(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitModulo(ExprParser.ModuloContext ctx) {
        try {
            Modulo op = new Modulo(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitPower(ExprParser.PowerContext ctx) {
        try {
            Power op = new Power(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitGCD(ExprParser.GCDContext ctx) {
        try {
            GreatestCommonDivisor op = new GreatestCommonDivisor(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitLCM(ExprParser.LCMContext ctx) {
        try {
            LeastCommonMultiple op = new LeastCommonMultiple(temp.get(temp.size()-1),tempNot);
            setMathContext(op);
            return op;
        }catch (IllegalConstruction exception){
            return  null;
        }
    }

    @Override
    public Expression visitInteger(ExprParser.IntegerContext ctx) {
        return new MyInteger(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Expression visitReal(ExprParser.RealContext ctx) {
        if (mathContext != null){
            return new MyRealNumber(ctx.getText(),mathContext);
        }
        return new MyRealNumber(ctx.getText());
    }

    @Override
    public Expression visitFraction(ExprParser.FractionContext ctx) {
        String value = ctx.getText();
        String[] fracVal = value.split("_");
        return MyRationalNumber.create(Long.parseLong(fracVal[0]), Long.parseLong(fracVal[1]));
    }

    private void setMathContext(Operation op){
        if (mathContext != null){
            op.setMathContext(mathContext);
        }
    }
}
