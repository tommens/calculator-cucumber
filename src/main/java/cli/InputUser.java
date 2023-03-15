package cli;

import java.util.ArrayList;
import java.util.List;

public class InputUser
{
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
}


/*
if (inputUser.equals(".quit"))
        {
            isRunning = false;
        }
        else
        {
            System.out.println("You entered: " + inputUser);
            Operation operation = null;
            for (String s : inputUser.split(""))
            {
                if (!s.equals(" "))
                {
                    if (listNumbers.contains(s))
                        System.out.println("Number: " + s);
                    else if (listOperators.contains(s))
                    {
                        System.out.println("Operator: " + s);
                       try {
                           List<Expression> params = Arrays.asList(new MyNumber(4),new MyNumber(4));
                           operation = new Plus(params);
                       }catch (IllegalConstruction e){
                           e.printStackTrace();
                       }
                    }
                }
            }
            if (operation != null)
                printNotaion(inputUser, operation);
        }


            public static Expression getOperator(String inputUser, List<Expression> params)
    {
        Expression e = null;
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (inputUser){
                case "+"	->	e = new Plus(params);
                case "-"	->	e = new Minus(params);
                case "*"	->	e = new Times(params);
                case "/"	->	e = new Divides(params);
                default		->	System.out.println("Error"); //TODO : handle exception
            }
        } catch (IllegalConstruction exception) {
            //TODO : handle exception
        }
        return e;
    }

    private static void printNotaion(String input, Operation op)
    {
        if (input.equals(op.toString(Notation.INFIX)))
            System.out.println("Infix notation");
        else if (input.equals(op.toString(Notation.PREFIX)))
            System.out.println("Prefix notation");
        else if (input.equals(op.toString(Notation.POSTFIX)))
            System.out.println("Postfix notation");
    }
* */