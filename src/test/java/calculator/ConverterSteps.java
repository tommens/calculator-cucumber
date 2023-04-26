package calculator;

import converter.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterSteps {
    private String measurement;
    private double value;

    @Before
    public void resetMemoryBeforeEachScenario() {
        measurement = null;
    }

    @Given("a measurement {string} and a first unit {string}")
    public void givenAMeasurementAndAValue(String m, String s) {
        measurement=m;
    }

    @When("I provide a value {double}")
    public void IProvideAValue(double d) {
        value=d;
    }

    @When("a second unit {string}")
    public void ASecondUnit(String s) {
    }

    //I had to create this additional method because Cucumber tests were returning false if I had something like
    //0.01 instead of 0.010000
    private void assertBigDecimalEquals(double expected, double actual) {
        BigDecimal expectedDecimal = BigDecimal.valueOf(expected).setScale(6, RoundingMode.HALF_UP);
        BigDecimal actualDecimal = BigDecimal.valueOf(actual).setScale(6, RoundingMode.HALF_UP);
        assertEquals(expectedDecimal, actualDecimal);
    }
    @Then("the conversion from {string} to {string} evaluates to {double}")
    public void theConversionEvaluatesTo(String u1, String u2, double result) {
        switch (measurement) {
            case "Area" :
                assertBigDecimalEquals(result, Area.printConversion(value,u1,u2).doubleValue());
                break;
            case "Currency" :
                assertBigDecimalEquals(result, Currency.printConversion(value,u1,u2).doubleValue());
                break;
            case "Energy" :
                assertBigDecimalEquals(result, Energy.printConversion(value,u1,u2).doubleValue());
                break;
            case "Length" :
                assertBigDecimalEquals(result, Length.printConversion(value,u1,u2).doubleValue());
                break;
            case "Power" :
                assertBigDecimalEquals(result, converter.Power.printConversion(value,u1,u2).doubleValue());
                break;
            case "Pressure" :
                assertBigDecimalEquals(result, Pressure.printConversion(value,u1,u2).doubleValue());
                break;
            case "Time" :
                assertBigDecimalEquals(result, Time.printConversion(value,u1,u2).doubleValue());
                break;
        }
    }
}
