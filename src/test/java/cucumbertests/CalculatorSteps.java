package cucumbertests;

import calculator.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.Assert.assertThrows;


public class CalculatorSteps {

	private ArrayList<Expression> params;
	private Operation op;
	private Calculator c;
	private Memory m;

	@Before
    public void resetMemoryBeforeEachScenario() {
		params = null;
		op = null;
	}

	@Given("I initialise a calculator")
	public void givenIInitialiseACalculator() {
		c = new Calculator();
	}

	@Given("an integer operation {string}")
	public void givenAnIntegerOperation(String s) {
		// Write code here that turns the phrase above into concrete actions
		params = new ArrayList<>(); // create an empty set of parameters to be filled in
		try {
			switch (s) {
				case "+"	->	op = new Plus(params);
				case "-"	->	op = new Minus(params);
				case "*"	->	op = new Times(params);
				case "/"	->	op = new Divides(params);
				default		->	fail();
			}
		} catch (IllegalConstruction e) {
			fail();
		}
	}


	// The following example shows how to use a DataTable provided as input.
	// The example looks slightly complex, since DataTables can take as input
	//  tables in two dimensions, i.e. rows and lines. This is why the input
	//  is a list of lists.
	@Given("the following list of integer numbers")
	public void givenTheFollowingListOfNumbers(List<List<String>> numbers) {
		params = new ArrayList<>();
		// Since we only use one line of input, we use get(0) to take the first line of the list,
		// which is a list of strings, that we will manually convert to integers:
		numbers.get(0).forEach(n -> params.add(new MyNumber(new BigDecimal(n))));
	    params.forEach(n -> System.out.println("value ="+ n));
		op = null;
	}

	// The string in the Given annotation shows how to use regular expressions...
	// In this example, the notation d+ is used to represent numbers, i.e. nonempty sequences of digits
	@Given("^the sum of two number (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheSum(MyNumber n1,MyNumber n2) {
		try {
			params = new ArrayList<>();
		    params.add(n1);
		    params.add(n2);
		    op = new Plus(params);}
		catch(IllegalConstruction e) { fail(); }
	}


	@Given("^the difference of two MyNumbers (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheDifference(MyNumber n1,MyNumber n2) {
		try {
			params = new ArrayList<>();
			params.add(n1);
			params.add(n2);
			op = new Minus(params);}
		catch(IllegalConstruction e) { fail(); }
	}

	@Given("^the product of two MyNumbers (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheProduct(MyNumber n1,MyNumber n2) {
		try {
			params = new ArrayList<>();
			params.add(n1);
			params.add(n2);
			op = new Times(params);}
		catch(IllegalConstruction e) { fail(); }
	}

	@Given("^the quotient of two MyNumbers (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheQuotient(MyNumber n1,MyNumber n2) {
		try {
			params = new ArrayList<>();
			params.add(n1);
			params.add(n2);
			op = new Divides(params);}
		catch(IllegalConstruction e) { fail(); }
	}

	@Given("a memory in the calculator of size {int}")
	public void aMemoryInTheCalculator(int size) {
		m = new Memory(size);
	}

	@Then("^its (.*) notation is (.*)$")
	public void thenItsNotationIs(String notation, String s) {
		if (notation.equals("PREFIX")||notation.equals("POSTFIX")||notation.equals("INFIX")) {
			op.notation = Notation.valueOf(notation);
			assertEquals(s, op.toString());
		}
		else fail(notation + " is not a correct notation! ");
	}

	@When("^I provide a (.*) number (\\d+)$")
	public void whenIProvideANumber(String s, BigDecimal val) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(new MyNumber(val));
		op.addMoreParams(params);
	}

	@When("^I provide a (.*) variable (.*) containing the value (\\d+)$")
	public void whenIProvideAVariable(String s, String name, BigDecimal val) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(new Variable(name, new MyNumber(val)));
		op.addMoreParams(params);
	}

	@When("^I create a variable (.*) containing above data and I store it in memory$")
	public void iCreateAVariableXContainingAboveData(String name) {
		m.add(name, c.eval(op), op);
	}

	@When("^I remove the variable (.*) from memory$")
	public void iRemoveTheVariableXFromMemory(String name) {
		m.remove(name);
	}


	@Then("^the (.*) is (\\d+)$")
	public void thenTheOperationIs(String s, BigDecimal val) {
		try {
			switch (s) {
				case "sum"			->	op = new Plus(params);
				case "product"		->	op = new Times(params);
				case "quotient"		->	op = new Divides(params);
				case "difference"	->	op = new Minus(params);
				default -> fail();
			}
			assertEquals(new MyNumber(val), c.eval(op));
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	@Then("the operation evaluates to {double}")
	public void thenTheOperationEvaluatesTo(double val) {
		assertEquals(new MyNumber(new BigDecimal(val)), c.eval(op)); //val => expected
	}


	@When("I provide a first number with parameters {double} and {int}")
	public void iProvideAFirstNumberWithParametersAnd(double arg0, int arg1) {
		params = new ArrayList<>();
		params.add(new MyNumber(new BigDecimal(arg0),arg1));
		op.addMoreParams(params);
	}

	@When("I provide a second number with parameters {double} and {int}")
	public void iProvideASecondNumberWithParametersAnd(double arg0, int arg1) {
		params = new ArrayList<>();
		params.add(new MyNumber(new BigDecimal(arg0),arg1));
		op.addMoreParams(params);
	}

	@Then("the operation evaluates to the number with parameters {string} and {int}")
	public void theOperationEvaluatesToTheNumberWithParametersAnd(String arg0, int arg1) {
		assertEquals(new MyNumber(new BigDecimal(arg0),arg1), c.eval(op));
	}
	@Then("^the calculator memory contains a variable (.*) with value (\\d+)$")
	public void theCalculatorContainsAVariableXWithValue(String name, int val) {
		assertEquals(m.getMemory().get(0).getName(), name);
	}
  
  @Then("^the calculator memory does not contain a variable (.*)$")
	public void theCalculatorMemoryDoesNotContainAVariableX(String name) {
		assertEquals(m.getMemory().size(), 0);
		assertThrows(RuntimeException.class, () -> m.get(name));
  }



	@Given("two number with parameters {string} and {int} and {string} and {int}")
	public void twoNumberWithParametersArgAndArgAndArgAndArg(String arg0, int arg1, String arg2, int arg3) {

		assertEquals(new MyNumber(new BigDecimal(arg0),arg1), new MyNumber(new BigDecimal(arg2),arg3));

	}

	@Given("one number with parameters {string} and {int}")
	public void oneNumberWithParametersArgAndArg(String arg0, int arg1) {
		MyNumber number = new MyNumber(new BigDecimal(arg0),arg1);
		MyNumber a= new MyNumber(new BigDecimal(0));
		assertEquals(number,number);
		assertNotEquals(number,null);
		assertNotEquals(number,a);

	
	}
}
