package calculator;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collections;

public class MyTimeSteps {

    private ArrayList<Expression> params;
    private Operation op;
    private Calculator c;
    private Expression e;
    private MyTime myTime;
    private int number;

    @Before
    public void resetMemoryBeforeEachScenario() {
        params = null;
        op = null;
    }
    @Given("A MyTime object with date {string}")
    public void GivenAMyTimeObjectWithDate(String date) {
        c = new Calculator();
        this.myTime = new MyTime(date);
        params = new ArrayList<>();
        long timeInSeconds = myTime.toSeconds();
        Collections.addAll(params,new MyNumber((int)timeInSeconds));
    }

    @When("I provide a number to subtract {int}")
    public void whenIProvideANumberToSubtract(int val) throws IllegalConstruction {
        // Subtract the number from MyTime object
        this.number = val;
        Collections.addAll(params,new MyNumber(val));
        e = new Minus(params, Notation.INFIX);
    }

    @When("I provide a number to add {int}")
    public void whenIProvideANumberToAdd(int val) throws IllegalConstruction {
        // Subtract the number from MyTime object
        this.number = val;
        Collections.addAll(params,new MyNumber(val));
        e = new Plus(params, Notation.INFIX);
    }
    @Then("the result is {string}")
    public void thenTheResultIs(String result) {
        assertEquals(result, MyTime.resultToDate(c.eval(e)));
    }
}
