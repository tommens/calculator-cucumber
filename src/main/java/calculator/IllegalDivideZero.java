package calculator;

/**
 * Problem :
 * ---------
 * Better exception handling: The current code is not checking for
 * division by zero exceptions
 */
public class IllegalDivideZero extends Exception
{
    public IllegalDivideZero()
    {
        super("Division by zero is not allowed");
    }
}
