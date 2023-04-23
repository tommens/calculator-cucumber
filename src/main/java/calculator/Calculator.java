package calculator;

import visitor.Evaluator;
import visitor.RealNumberEvaluator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import visitor.RationalNumberEvaluator;

/**
 * This class represents the core logic of a Calculator.
 * It can be used to print and evaluate artihmetic expressions.
 *
 * @author tommens
 */
public class Calculator {

    /*
     For the moment the calculator only contains a print method and an eval method
     It would be useful to complete this with a read method, so that we would be able
     to implement a full REPL cycle (Read-Eval-Print loop) such as in Scheme, Python, R and other languages.
     To do so would require to implement a method with the following signature, converting an input string
     into an arithmetic expression:
     public Expression read(String s)
    */

    private int precision;
    private MathContext mathContext = MathContext.UNLIMITED;

    private RoundingMode roundingMode = RoundingMode.HALF_UP;


    /**
     * Convert an input string into an arithmetic expression
     * @param s a string representing an arithmetic expression
     * @return the result of the conversion
     */
    public Expression read(String s){
        // use a parser to read s
        // for operation use the method setMathContext(mathContext)
        return null;
    }

    /**
     * Prints an arithmetic expression provided as input parameter.
     * @param e the arithmetic Expression to be printed
     * @see #printExpressionDetails(Expression) 
     */
    public void print(Expression e) {
        System.out.println("The result of evaluating expression " + e);
        System.out.println("is: " + eval(e) + ".");
        System.out.println();
    }

    /**
     * Prints verbose details of an arithmetic expression provided as input parameter.
     * @param e the arithmetic Expression to be printed
     * @see #print(Expression)
     */
    public void printExpressionDetails(Expression e) {
        print(e);
        System.out.print("It contains " + e.countDepth() + " levels of nested expressions, ");
        System.out.print(e.countOps() + " operations");
        System.out.println(" and " + e.countNbs() + " numbers.");
        System.out.println();
    }

    /**
     * Evaluates an arithmetic expression and returns its result
     * @param e the arithmetic Expression to be evaluated
     * @return The result of the evaluation
     */
    public int eval(Expression e) {
        // create a new visitor to evaluate expressions
        Evaluator v = new Evaluator();
        // and ask the expression to accept this visitor to start the evaluation process
        e.accept(v);
        // and return the result of the evaluation at the end of the process
        return v.getResult();
    }

    /**
     * Evaluates an arithmetic expression and returns its result
     * @param e the arithmetic Expression to be evaluated
     * @return The result of the evaluation
     */
    public BigDecimal evalReal(Expression e){
        // create a new visitor to evaluate expressions
        RealNumberEvaluator v = new RealNumberEvaluator();
        // and ask the expression to accept this visitor to start the evaluation process
        e.accept(v);
        // and return the result of the evaluation at the end of the process
        return v.getResult();
    }

    /**
     * Evaluates an arithmetic expression and returns its result as a rational number
     * @param e the arithmetic Expression to be evaluated
     * @return  The result of the evaluation as a rational number
     */
    public MyRationalNumber evalRational(Expression e){
        RationalNumberEvaluator v = new RationalNumberEvaluator();
        e.accept(v);
        return v.getResult();
    }

    /**
     * Prints an arithmetic expression provided as input parameter.
     * @param e the arithmetic Expression to be printed
     */
    public void printReal(Expression e){
        System.out.println("The result of evaluating expression " + e);
        System.out.println("is: " + evalReal(e) + ".");
        System.out.println();
    }

    /**
     * Set the precision of real number (the number of digits encoded)
     * @param p A positive integer representing the precision of the real numbers
     */
    public void setPrecision(int p){
        if (p > 0){
            precision = p;
            mathContext = new MathContext(precision,roundingMode);
        }
    }


    /**
     * Set the rounding mode of real numbers
     * @param rd the rounding mode to be considered
     */
    public void setRoundingMode(RoundingMode rd){
        roundingMode = rd;
        mathContext = new MathContext(precision,roundingMode);
    }


    /**
     * Prints an arithmetic expression provided as input parameter using rational numbers
     * @param e the arithmetic Expression to be printed
     */
    public void printRational(Expression e){
        System.out.println("The result of evaluating expression " + e);
        System.out.println("is: " + evalRational(e) + ".");
        System.out.println();
    }

    /*
     We could also have other methods, e.g. to verify whether an expression is syntactically correct
     public Boolean validate(Expression e)
     or to simplify some expression
     public Expression simplify(Expression e)
    */
}
