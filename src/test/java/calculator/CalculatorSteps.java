package calculator;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculatorSteps {

//	static final Logger log = getLogger(lookup().lookupClass());

	private ArrayList<Expression> params;
	private Operation op;
	private Calculator c;

	@Before
    public void resetMemoryBeforeEachScenario() {
		params = null;
		op = null;
	}

	@Given("I initialise a calculator")
	public void givenIInitialiseACalculator() {
		c = new Calculator();
	}

	@Given("an operation {string}")
	public void givenAnOperation(String s) {
		// Write code here that turns the phrase above into concrete actions
		params = new ArrayList<>(); // create an empty set of parameters to be filled in
		try {
			switch (s) {
				case "+"	->	op = new Plus(params);
				case "-"	->	op = new Minus(params);
				case "*"	->	op = new Times(params);
				case "/"	->	op = new Divides(params);
				case "GCD"	->	op = new GreatestCommonDivisor(params);
				case "LCM"	->	op = new LeastCommonMultiple(params);
				case "%"	->	op = new Modulo(params);
				case "^"	->	op = new Power(params);
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
		numbers.get(0).forEach(n -> params.add(new MyInteger(Integer.parseInt(n))));
	    params.forEach(n -> System.out.println("value ="+ n));
		op = null;
	}

	// The string in the Given annotation shows how to use regular expressions...
	// In this example, the notation d+ is used to represent numbers, i.e. nonempty sequences of digits
	@Given("^the sum of two numbers (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheSum(int n1, int n2) {
		try {
			params = new ArrayList<>();
		    params.add(new MyInteger(n1));
		    params.add(new MyInteger(n2));
		    op = new Plus(params);}
		catch(IllegalConstruction e) { fail(); }
	}

	@Then("^its (.*) notation is (.*)$")
	public void thenItsNotationIs(String notation, String s) {
		if (notation.equals("PREFIX")||notation.equals("POSTFIX")||notation.equals("INFIX")) {
			op.notation = Notation.valueOf(notation);
			assertEquals(s, op.printOperation());
		}
		else fail(notation + " is not a correct notation! ");
	}

	@When("I provide a first real number {string}")
	public void whenIProvideARealNumber(String s) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(new MyRealNumber(s));
		op.addMoreParams(params);
	}

	@When("I provide a second real number {string}")
	public void whenIProvideASecondRealNumber(String s) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(new MyRealNumber(s));
		op.addMoreParams(params);
	}

	@When("^I provide a (.*) number (\\d+)$")
	public void whenIProvideANumber(String s, int val) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(new MyInteger(val));
		op.addMoreParams(params);
	}

	@When("^I provide a (.*) rational number (\\d+)_/(\\d+)$")
	public void whenIProvideARationalNumber(String s, int numerator, int denominator) {
		//add extra parameter to the operation
		params = new ArrayList<>();
		params.add(MyRationalNumber.create(numerator,denominator));
		op.addMoreParams(params);
	}
	@Then("^the (.*) is (\\d+)$")
	public void thenTheOperationIs(String s, int val) {
		try {
			switch (s) {
				case "sum"			->	op = new Plus(params);
				case "product"		->	op = new Times(params);
				case "quotient"		->	op = new Divides(params);
				case "difference"	->	op = new Minus(params);
				default -> fail();
			}
			assertEquals(val, c.eval(op));
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	@Then("the operation evaluates to {int}")
	public void thenTheOperationEvaluatesTo(int val) {
		assertEquals(val, c.eval(op));
	}

	@Then("the result of the operation is {string}")
	public void thenTheResultOfOperation(String val) {
		assertEquals(new BigDecimal(val), c.evalReal(op));
	}
  
	@ParameterType(".*")
	public MyRationalNumber rationalNumber(String s) {
		String[] parts = s.split("/");
		return MyRationalNumber.create(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
	}
	@Then("the operation evaluates to rational {string}")
	public void thenTheOperationEvaluatesTo(String val) {
		String[] parts = val.split("_/");
		assertEquals(MyRationalNumber.create(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])), c.evalRational(op));
	}

}
