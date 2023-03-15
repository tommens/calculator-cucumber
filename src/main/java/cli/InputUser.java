package cli;

import calculator.*;

import java.util.ArrayList;
import java.util.List;


public class InputUser
{

    //--------------------STATIC--------------------//
    protected static String listOperators = "+-*/";
    protected static String listNumbers = "0123456789";

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

    public static boolean isNumber(String input)
    {
        return listNumbers.contains(input);
    }

    public static boolean isOperator(String input)
    {
        return listOperators.contains(input);
    }

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

    public static boolean isABoolean(String input)
    {
        return input.equalsIgnoreCase("true");
    }

    //--------------------INSTANCE--------------------//

    private List<Expression> list_of_expression = new ArrayList<>();
    private Notation notation;
    private List<String> user_input_list;

    public InputUser(Notation notation) //TODO : add mode
    {
        this.notation = notation;
    }

    public void setNotation(Notation notation)
    {
        this.notation = notation;
    }

    public void setUserInput(List<String> inputUser)
    {
        this.user_input_list = inputUser;
    }

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