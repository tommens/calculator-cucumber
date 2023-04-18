package parser;

import calculator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class implement the method to visit tokens
 */
public class ExpressionVisitor extends ExprBaseVisitor<Expression>{

    @Override
    public Expression visitInput(ExprParser.InputContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Expression visitAddition(ExprParser.AdditionContext ctx) {
        List<Expression> list = new ArrayList<>();
        Expression leftExpression = visit(ctx.getChild(0));
        Expression rightExpression = visit(ctx.getChild(2));
        Collections.addAll(list,leftExpression,rightExpression);
        try {
            return new Plus(list);
        }catch (IllegalConstruction exception){
            System.out.println("cannot create operations without parameters");
            return null;
        }
    }

    @Override
    public Expression visitSubtraction(ExprParser.SubtractionContext ctx) {
        List<Expression> list = new ArrayList<>();
        Expression leftExpression = visit(ctx.getChild(0));
        Expression rightExpression = visit(ctx.getChild(2));
        Collections.addAll(list,leftExpression,rightExpression);
        try {
            return new Minus(list);
        }catch (IllegalConstruction exception){
            System.out.println("cannot create operations without parameters");
            return null;
        }
    }

    @Override
    public Expression visitMultiplication(ExprParser.MultiplicationContext ctx) {
        List<Expression> list = new ArrayList<>();
        Expression leftExpression = visit(ctx.getChild(0));
        Expression rightExpression = visit(ctx.getChild(2));
        Collections.addAll(list,leftExpression,rightExpression);
        try {
            return new Times(list);
        }catch (IllegalConstruction exception){
            System.out.println("cannot create operations without parameters");
            return null;
        }
    }

    @Override
    public Expression visitDivision(ExprParser.DivisionContext ctx) {
        List<Expression> list = new ArrayList<>();
        Expression leftExpression = visit(ctx.getChild(0));
        Expression rightExpression = visit(ctx.getChild(2));
        Collections.addAll(list,leftExpression,rightExpression);
        try {
            return new Divides(list);
        }catch (IllegalConstruction exception){
            System.out.println("cannot create operations without parameters");
            return null;
        }
    }

    @Override
    public Expression visitInteger(ExprParser.IntegerContext ctx) {
        return new MyInteger(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Expression visitReal(ExprParser.RealContext ctx) {
        return new MyRealNumber(ctx.getText());
    }

    @Override
    public Expression visitFraction(ExprParser.FractionContext ctx) {
        return null;
    }
}
