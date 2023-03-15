package cli;

import calculator.Calculator;
import calculator.Divides;
import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Minus;
import calculator.MyNumber;
import calculator.Notation;
import calculator.Operation;
import calculator.Plus;
import calculator.Times;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to process the input of user
 */
public class InputUser
{

    //--------------------STATIC--------------------//
    /**List of operator*/
    protected static String listOperators = "+-*/";
    /**List of number*/
    protected static String listNumbers = "0123456789";


    /**
     * Method to clean the input of user (remove space)
     * @param input : string input of user
     * @return list of string without space
     */
    public static List<String> cleanInput(String input)
    {
        List<String> listInput = new ArrayList<>();
        for (String cut_list : input.split(" "))
        {
            if (!cut_list.equals("") && !cut_list.equals(" "))
            {
                listInput.add(cut_list);
            }
        }
        return listInput;
    }


    /**
     * @return boolean : is a number between 0 and 9
     */
    public static boolean isNumber(String input)
    {
        return listNumbers.contains(input);
    }


    /**
     * @return boolean : is an operator
     */
    public static boolean isOperator(String input)
    {
        return listOperators.contains(input);
    }


    /**
     * @param input : string input of user
     * @return notation : prefix, postfix or infix
     *                       default : infix
     */
    public static Notation getNotation(String input)
    {
        Notation notation;
        switch (input.toLowerCase())
        {
            case "prefix"		->	notation = Notation.PREFIX;
            case "postfix"		->	notation = Notation.POSTFIX;
            default				->	notation = Notation.INFIX;
        }
        return notation;
    }


    /**
     * @param inputUser : string input of user (operator)
     * @param params : list of expression (parameters)
     * @param notation : notation of the operation
     * @return expression of the operation
     */
    public static Expression getOperator(String inputUser, List<Expression> params, Notation notation)
    {
        Operation e = null;
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (inputUser){
                case "+"	->	e = new Plus(params, notation);
                case "-"	->	e = new Minus(params, notation);
                case "*"	->	e = new Times(params, notation);
                case "/"	->	e = new Divides(params, notation);
                default		->	System.out.println("Error"); //TODO : handle exception
            }
        } catch (IllegalConstruction ignored){}//TODO : handle exception
        return e;
    }


    /**
     * @return boolean : is a boolean (true or false)
     */
    public static boolean isABoolean(String input)
    {
        return input.equalsIgnoreCase("true");
    }


    //--------------------INSTANCE--------------------//
    /**List of expression*/
    private final List<Expression> list_of_expression = new ArrayList<>();
    /**Notation actual*/
    private Notation notation;
    /**List of string input of user without space*/
    private List<String> user_input_list;


    /**
     * Constructor
     * @param notation : notation of the operation
     */
    public InputUser(Notation notation) //TODO : add mode
    {
        this.notation = notation;
    }


    /**
     * Set the notation
     * @param notation : notation of the operation
     */
    public void setNotation(Notation notation)
    {
        this.notation = notation;
    }


    /**
     * Set the input of user
     * @param inputUser : list of string input of user without space
     */
    public void setUserInput(List<String> inputUser)
    {
        this.user_input_list = inputUser;
    }


    /**
     * Compute the input of user
     * @param isVerbose : boolean to display the expression
     */
    public void compute(boolean isVerbose)
    {
        String operator = null;
        for (String s : user_input_list)
        {
            if (isNumber(s))
                list_of_expression.add(new MyNumber(Integer.parseInt(s)));
            else if (isOperator(s))
                operator = s;
        }
        if (operator != null)
        {
            Expression e = getOperator(operator, list_of_expression, this.notation);
            if (isVerbose)
                System.out.println("$> " + e.toString());
            System.out.println("$> " + new Calculator().eval(e));
        }
    }
}