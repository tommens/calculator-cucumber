package calculator;

import converter.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConverterSteps {
    private Calculator c;
    private Measurement measurement;
    private String firstUnit;
    private String secondUnit;
    private double value;
    @Before
    public void resetMemoryBeforeEachScenario() {
        measurement = null;
    }

    @Given("I initialise a calculator")
    public void givenIInitialiseACalculator() {
        c = new Calculator();
    }

    @Given("a measurement {String} and a first unit {String}")
    public void givenAMeasurementAndAValue(String m, String unit1) {
        String measure=m;
        firstUnit=unit1;
        switch (measure) {
            case "Area" -> {
                measurement = new Area(unit1);
            }
            case "Currency" -> {
                measurement = new Currency(unit1);
            }
            case "Energy" -> {
                measurement = new Energy(unit1);
            }
            case "Length" -> {
                measurement = new Length(unit1);
            }
            case "Power" -> {
                measurement = new Power(unit1);
            }
            case "Pressure" -> {
                measurement = new Pressure(unit1);
            }
            case "Time" -> {
                measurement = new Time(unit1);
            }
        }
    }

    @When("I provide a value {double}")
    public void IProvideAValue(double val) {
        value=val;
    }

    @When("a second unit {String}")
    public void ASecondUnit(String unit2) {
        secondUnit=unit2;
    }

    @Then("the conversion from {String} to {String} evaluates to {double}")
    public void theConversionEvaluatesTo(String unit1, String unit2, double result) {
        assertEquals(result,measurement.printConversion(result,unit1,unit2));
    }
}
