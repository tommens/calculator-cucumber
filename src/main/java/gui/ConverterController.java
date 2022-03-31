package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import converter.Unit;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import java.util.List;
import static converter.Unit.*;

/**
 * This controller handle the main graphical interface's actions.
 * Read the converter panel which contains functionalities
 * Switch mode
 */
public class ConverterController extends Controller {

    /**
     * Scrollable list of units types
     */
    @FXML
    ComboBox<String> typeConv;

    /**
     * Scrollable list of units from
     */
    @FXML
    ComboBox<String> fromUnit;

    /**
     * Scrollable list of units to
     */
    @FXML
    ComboBox<String> toUnit;

    /**
     * The calculator object
     */
    Calculator calculator;

    /**
     * Initialize the controller
     */
    public void initialize() {
        List<String> categories = getUnitCategories();
        typeConv.getItems().addAll(categories);
        typeConv.setValue(categories.get(0));
        updateUnits();
        calculator = new Calculator();
    }

    /**
     * Convert the value from the first unit to the second unit
     */
    public void submitButton() {
        Expression input = Parser.parse(this.inputField.getText());
        Unit from = getUnitByName(fromUnit.getValue());
        Unit to = getUnitByName(toUnit.getValue());
        if (from == null || to == null) {
            throw new IllegalArgumentException("Unit not found");
        }
        Expression expr = Parser.parse(
                "(" + input + "-" + from.getUnitConstant() +")" + "/" + from.getUnitRatio()
                        + "×" + to.getUnitRatio() + "+" + to.getUnitConstant());
        this.outputField.setText(calculator.eval(expr).toString());
        this.setSubmitted(true);
    }

    /**
     * Update the units list if change of category
     */
    public void changeType() {
        updateUnits();
    }

    /**
     * Update the units list
     */
    public void updateUnits() {
        fromUnit.getItems().clear();
        toUnit.getItems().clear();
        List<Unit> units = getUnitsByCategory(typeConv.getValue());
        List<String> unitNames = units.stream().map(Unit::getUnitName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        fromUnit.getItems().addAll(unitNames);
        fromUnit.setValue(unitNames.get(0));
        toUnit.getItems().addAll(unitNames);
        toUnit.setValue(unitNames.get(1));
    }
}