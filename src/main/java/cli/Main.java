package cli;

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
                    else
                        System.out.println("Unknown: " + s);

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
