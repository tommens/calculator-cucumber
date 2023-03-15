package junit5tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import calculator.Notation;
import cli.InputUser;
import org.junit.jupiter.api.Test;

public class TestInputUser
{
    @Test
    void testCleanInput()
    {
        String input = "  1 + 2  ";
        for (String ss : InputUser.cleanInput(input))
            assertNotEquals(ss, " ");
    }

    @Test
    void testIsNumber()
    {
        String input = "0 1 2 3 4 5 6 7 8 9";
        for (String ss : InputUser.cleanInput(input))
            assertTrue(InputUser.isNumber(ss));
        String input2 = "a";
        assertFalse(InputUser.isNumber(input2));
    }

    @Test
    void testGetNotation()
    {
        String input = "POSTFIX";
        assertEquals(InputUser.getNotation(input), Notation.POSTFIX);
        String input2 = "INFIX";
        assertEquals(InputUser.getNotation(input2), Notation.INFIX);
        String input3 = "PREFIX";
        assertEquals(InputUser.getNotation(input3), Notation.PREFIX);
    }

    @Test
    void testGetOperator()
    {
        String input = "+ - * /";
        for (String ss : InputUser.cleanInput(input))
            assertTrue(InputUser.isOperator(ss));
        String input2 = "a";
        assertFalse(InputUser.isOperator(input2));
    }

    //TODO: testGetOperator

    @Test
    void testInstance()
    {
        InputUser inputUser = new InputUser(Notation.PREFIX);
        assertTrue(inputUser instanceof InputUser);
    }

    @Test
    void testCompute()
    {
        InputUser user = new InputUser(Notation.INFIX);
        user.setUserInput(InputUser.cleanInput("1 + 2"));
        assertEquals(user.compute(false), 3);

        user = new InputUser(Notation.INFIX);
        user.setUserInput(InputUser.cleanInput("1"));
        assertEquals(user.compute(false), 0);

        user = new InputUser(Notation.INFIX);
        user.setUserInput(InputUser.cleanInput("1 +"));
        assertEquals(user.compute(false), 1);

        user = new InputUser(Notation.INFIX);
        user.setUserInput(InputUser.cleanInput("1 + 2 + 3"));
        assertEquals(user.compute(false), 6);
    }
}
