package cli;

import calculator.Divides;
import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Minus;
import calculator.Plus;
import calculator.Times;
import java.util.List;
import java.util.Scanner;


public class Main
{
    protected static boolean isRunning = true;

    protected static String listOperators = "+-*/";
    protected static String listNumbers = "0123456789";

    public static void helloWord()
    {
        System.out.print("Calculator Cucumber\n This is a calculator that can be used to perform basic arithmetic operations.\n");
    }

    public static void printMenu()
    {
        System.out.println("Please enter an expression to evaluate or .quit to exit ");
    }

    public static void getOperator(String inputUser, List<Expression> params)
    {
        Expression e;
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
    }

    public static void get_input()
    {
        System.out.print("$> ");
        Scanner scanner = new Scanner(System.in);
        String inputUser = scanner.nextLine();
        if (inputUser.equals(".quit"))
        {
            isRunning = false;
        }
        else
        {
            System.out.println("You entered: " + inputUser);
            for (String s : inputUser.split(""))
            {
                if (!s.equals(" "))
                {
                    if (listNumbers.contains(s))
                        System.out.println("Number: " + s);
                    else if (listOperators.contains(s))
                        System.out.println("Operator: " + s);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        helloWord();
        printMenu();
        while(isRunning)
        {
            get_input();
        }
    }
}
