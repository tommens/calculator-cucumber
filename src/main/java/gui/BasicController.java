package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;

import static gui.common.Configuration.FILE_TYPE;
import static gui.common.Configuration.FILE_TYPE_DESCRIPTION;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends ControllerWithMemory {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    public CheckBox isRational;
    private final FileChooser fileChooser = new FileChooser();

    public BasicController() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(FILE_TYPE_DESCRIPTION, FILE_TYPE)
        );
    }

    public void submitButton() {
        if (inputField == null) return;
        String input = inputField.getText().replace("%", "/100");
        Expression expr = parser.parse(input);
        String result;
        try {
            if (isRational.isSelected())
                result = calculator.eval(expr).toString();
            else
                result = calculator.eval(expr).toReal().toString();

            this.outputField.setText(result);
            keepComponentValue(inputField.getText(), result);

        } catch (Exception e) {
            this.showAlertMessage(e.getMessage());
        }
        this.setSubmitted(true);
    }

    public void plusButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "+");
    }

    public void minusButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "-");
    }

    public void timesButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "×");
    }

    public void dividesButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "/");
    }



}