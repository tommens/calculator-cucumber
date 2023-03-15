package cli;

import calculator.Notation;

import java.util.List;
import java.util.Scanner;


public class Main
{
    protected static boolean isRunning = true;
    protected static List<String> listInput;


    public static void printHelp()
    {
        System.out.print("=== HELP START===\n");
        System.out.print("$> Quit program : .quit\n");
        System.out.print("=== HELP END===\n");
    }


    public static void printMenu()
    {
        System.out.println("Please enter an expression to evaluate or .quit to exit ");
        System.out.println("To change the notation, use the command .mode <mode> where <mode> is normal, complex, XX "); //TODO : complete here
    }



    public static void get_input()
    {
        System.out.print("$>>> ");
        Scanner scanner = new Scanner(System.in);
        String inputUser = scanner.nextLine();
        InputUser inputUser_instance = new InputUser(Notation.INFIX);
        listInput = InputUser.cleanInput(inputUser);
        if (listInput.size() != 0)
        {
            if (listInput.get(0).equals(".quit"))
                isRunning = false;
            else if (listInput.get(0).equals(".mode") && listInput.size() == 2)
                System.out.println("$> Mode changed to " + listInput.get(1));
            else if (listInput.get(0).equals(".help"))
                printHelp();
            else
            {
                inputUser_instance.setUserInput(listInput);
                inputUser_instance.compute();
            }
        }
        else
            System.out.println("$> Please enter a valid expression !");
    }

    public static void main(String[] args)
    {
        System.out.print("Calculator Cucumber\n This is a calculator that can be used to perform basic arithmetic operations.\n");
        printMenu();
        while(isRunning)
        {
            get_input();
        }
        System.out.println("$> Bye bye !");
    }
}