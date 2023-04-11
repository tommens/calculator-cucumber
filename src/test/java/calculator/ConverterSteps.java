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
    private String measurement;
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
        measurement=m;
        firstUnit=unit1;
        switch (measurement) {
            case "Area" -> {
                Area measure = new Area(unit1);
            }
            case "Currency" -> {
                Currency measure = new Currency(unit1);
            }
            case "Energy" -> {
                Energy measure = new Energy(unit1);
            }
            case "Length" -> {
                Length measure = new Length(unit1);
            }
            case "Power" -> {
                Power measure = new Power(unit1);
            }
            case "Pressure" -> {
                Pressure measure = new Pressure(unit1);
            }
            case "Time" -> {
                Time measure = new Time(unit1);
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
        assertEquals(result,measure);
    }
}
