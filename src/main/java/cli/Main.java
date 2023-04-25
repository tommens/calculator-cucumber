package cli;

import calculator.Memory;
import calculator.Notation;
import calculator.Variable;

import java.util.List;
import java.util.Scanner;


public class Main
{
    /**While loop to continue*/
    private static boolean isRunning = true;
    /**List of input*/
    private static List<String> listInput;
    /**Notation actual*/
    private static Notation notation = Notation.INFIX;
    /**is Verbose mode (print list of expression)*/
    private static boolean verbose = false;

    private static Memory memory = new Memory();
    private static Memory log = new Memory();


    /**
     * Print the help
     */
    public static void printHelp()
    {
        System.out.println("=== HELP START===");
        System.out.println("$> Quit program : '.quit'");
        System.out.println("$> Verbose mode : '.verbose <true|false>' ");
        printMenu();
        System.out.println("=== HELP END===\n");
    }


    /**
     * Print the menu
     */
    public static void printMenu()
    {
        System.out.println("$> Please enter an expression to evaluate or '.quit' to exit ");
        System.out.println("$> To change the notation, use the command '.mode <mode>' where <mode> is normal, complex, XX "); //TODO : complete here
        System.out.println("$> To change the notation, use the command '.notation <notation>' where <notation> is infix, prefix, postfix ");
        System.out.println("$> To display the memory, use the command '.memory' ");
        System.out.println("$> To display the log, use the command '.log' or 'log <number>' where number is the last lines of data in the memory ");
        System.out.println("$> To store a variable in the memory, use the command '.store <variable name> <expression>' ");
        System.out.println("$> To remove a variable in the memory, use the command '.remove <variable name>' ");
        System.out.println("$> To change the name of a variable, use the command '.rename <type> <variable name> <new variable name>' where type is memory or log ");
        System.out.println("$> To clear the memory, use the command '.clear' where type is memory or log ");
        System.out.println("$> To display the maximum size of the memory, use the command '.size'");
        System.out.println("$> To set custom maximum size of the memory, use the command '.set_size <number>' where number is the maximum size of the memory ");
    }


    /**
     * Get the input of the user or wait the command
     */
    public static void get_input()
    {
        System.out.print("$>>> ");
        Scanner scanner = new Scanner(System.in);
        String inputUser = scanner.nextLine();
        InputUser inputUser_instance = new InputUser(notation);
        listInput = InputUser.cleanInput(inputUser);
        if (listInput.size() != 0)
        {
            if (listInput.get(0).equals(".quit"))
                isRunning = false;
            else if (listInput.get(0).equals(".mode") && listInput.size() == 2)
                System.out.println("$> Mode changed to " + listInput.get(1));
            else if (listInput.get(0).equals(".notation") && listInput.size() == 2)
            {
                notation = InputUser.getNotation(listInput.get(1));
                System.out.println("$> Notation : " + notation.toString());
            }
            else if (listInput.get(0).equals(".verbose") && listInput.size() == 2)
                verbose = InputUser.isABoolean(listInput.get(1));
            else if (listInput.get(0).equals(".help"))
                printHelp();
            else if (listInput.get(0).equals(".log")) {
                if (listInput.size() == 1) {
                    System.out.println("$> Displaying all log");
                    log.display();
                } else {
                    System.out.println("$> Displaying last " + listInput.get(1) + " data");
                    log.displayLastData(Integer.parseInt(listInput.get(1)));
                }
            }
            else if (listInput.get(0).equals(".memory")) {
                if (listInput.size() == 1) {
                    System.out.println("$> Displaying all memory");
                    memory.display();
                } else {
                    System.out.println("$> Displaying last " + listInput.get(1) + " data");
                    memory.displayLastData(Integer.parseInt(listInput.get(1)));
                }
            }
            else if (listInput.get(0).equals(".remove")) {
                if (listInput.size() != 2) {
                    System.out.println("$> please enter valid syntax");
                }
                try {
                    memory.remove(listInput.get(1));
                    System.out.println("$> Removing variable: "+ listInput.get(1));
                } catch (IllegalArgumentException e) {
                    System.out.println("$> " + e.getMessage());
                }
            }
            else if (listInput.get(0).equals(".clear"))
            {
                if (listInput.size() != 2) {
                    System.out.println("$> please enter valid syntax");
                }
                if (listInput.get(1).equals("memory")) {
                    System.out.println("$> Clearing all variables in memory");
                    memory.clear();
                } else if (listInput.get(1).equals("log")) {
                    System.out.println("$> Clearing all variables in log");
                    log.clear();
                } else {
                    System.out.println("$> please enter valid syntax");
                }
            } else if (listInput.get(0).equals(".rename"))
                try {
                    if (listInput.size() != 4) {
                        System.out.println("$> please enter valid syntax");
                    }
                    if (listInput.get(1).equals("memory")) {
                        Variable variable = memory.get(listInput.get(2));
                        variable.setName(listInput.get(3));
                        System.out.println("$> Renaming variable: " + listInput.get(2) + " to " + listInput.get(3));
                    } else if (listInput.get(1).equals("log")) {
                        Variable variable = log.get(listInput.get(2));
                        variable.setName(listInput.get(3));
                        System.out.println("$> Renaming variable: " + listInput.get(2) + " to " + listInput.get(3));
                    } else {
                        System.out.println("$> please enter valid syntax");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("$> " + e.getMessage());
                }
            else if (listInput.get(0).equals(".set_size")) {
                if (listInput.size() != 2) {
                    System.out.println("$> please enter valid syntax");
                }
                try {
                    memory.setMaxSize(Integer.parseInt(listInput.get(1)));
                    System.out.println("$> Setting new size of memory: " + listInput.get(1));
                } catch (IllegalArgumentException e) {
                    System.out.println("$> " + e.getMessage());
                }
            }
            else if (listInput.get(0).equals(".size")) {
                if (memory.getMaxSize() == -1)
                    System.out.println("$> displaying maximum size of memory: unlimited");
                else
                    System.out.println("$> displaying maximum size of memory: " + memory.getMaxSize());

            } else {
                if (listInput.get(0).equals(".store")) {
                    System.out.println("$> Adding new variable: "+ listInput.get(1));
                    inputUser_instance.setMemory(memory);
                    inputUser_instance.setName(listInput.get(1));
                    listInput = listInput.subList(2, listInput.size());
                    inputUser_instance.setLog(log);
                    inputUser_instance.setUserInput(listInput);
                    System.out.println("$> " + inputUser_instance.compute(verbose));
                    inputUser_instance.setMemory(null);
                    inputUser_instance.setName(null);
                } else {
                    inputUser_instance.setLog(log);
                    inputUser_instance.setUserInput(listInput);
                    System.out.println("$> " + inputUser_instance.compute(verbose));
                }
            }
        }
        else
            System.out.println("$> Please enter a valid expression !");
    }

    /**
     * Main
     * @param args is empty
     */
    public static void main(String[] args)
    {
        System.out.print("$> Calculator Cucumber\n This is a calculator that can be used to perform basic arithmetic operations.\n");
        printMenu();
        memory.loadMemory();
        log.loadLog();
        while(isRunning)
        {
            get_input();
        }
        memory.saveMemory();
        log.saveLog();
        System.out.println("$> Bye bye !");
    }
}