package calculator;

import converter.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterSteps {
    private Measurement measurement;

    @Before
    public void resetMemoryBeforeEachScenario() {
        measurement = null;
    }

    @Given("a measurement {string} and a first unit {string}")
    public void givenAMeasurementAndAValue(String m, String unit1) {
        switch (m) {
            case "Area" -> measurement = new Area(unit1);
            case "Currency" -> measurement = new Currency(unit1);
            case "Energy" -> measurement = new Energy(unit1);
            case "Length" -> measurement = new Length(unit1);
            case "Power" -> measurement = new converter.Power(unit1);
            case "Pressure" -> measurement = new Pressure(unit1);
            case "Time" -> measurement = new Time(unit1);
        }
    }

    @When("I provide a value {double}")
    public void IProvideAValue() {
    }

    @When("a second unit {string}")
    public void ASecondUnit() {
    }

    @Then("the conversion from {string} to {string} evaluates to {double}")
    public void theConversionEvaluatesTo(String unit1, String unit2, double result) {
        assertEquals(BigDecimal.valueOf(result), Measurement.printConversion(result,unit1,unit2));
    }
}
