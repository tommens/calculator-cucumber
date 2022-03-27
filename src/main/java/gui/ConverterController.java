package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import calculator.Rational;
import converter.Unit;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller handle the main graphical interface's actions.
 * Read the converter panel which contains functionalities
 * Switch mode
 */
public class ConverterController extends Controller {

    @FXML
    ComboBox<String> typeConv;
    @FXML
    ComboBox<String> fromUnit;
    @FXML
    ComboBox<String> toUnit;

    Calculator calculator;

    public void initialize() {
        List<String> types = getAllTypes();
        if (types != null) {
            typeConv.getItems().addAll(types);
            typeConv.setValue(types.get(0));
            updateUnits();
        }
        calculator = new Calculator();
    }

    public void submitButton() {
        Expression input = Parser.parse(this.inputField.getText());
        String from = getConverterFromName(fromUnit.getValue());
        String to = getConverterFromName(toUnit.getValue());
        Expression expr = Parser.parse(input + "/" + from + "×" + to);
        this.outputField.setText(calculator.eval(expr).toString());
        this.setSubmitted(true);
    }

    public List<String> getAllTypes() {
        List<String> result = new ArrayList<>();
        for (Unit unit : Unit.values()) {
            if (!result.contains(unit.getType())) {
                result.add(unit.getType());
            }
        }
        return result;
    }

    public List<String> getAllUnitsFromType(String type) {
        List<String> result = new ArrayList<>();
        for (Unit unit : Unit.values()) {
            if (unit.getType().equals(type)) {
                if (!result.contains(unit.getName())) {
                    result.add(unit.getName());
                }
            }
        }
        return result;
    }

    public String getConverterFromName(String name) {
        for (Unit unit : Unit.values()) {
            if (unit.getName().equals(name)) {
                return unit.getConverter();
            }
        }
        return null;
    }

    public void changeType(Event event) {
        updateUnits();
    }

    public void updateUnits() {
        fromUnit.getItems().clear();
        toUnit.getItems().clear();
        List<String> names = getAllUnitsFromType(typeConv.getValue());
        if (names != null) {
            fromUnit.getItems().addAll(names);
            fromUnit.setValue(names.get(0));
            toUnit.getItems().addAll(names);
            toUnit.setValue(names.get(1));
        }
    }
}