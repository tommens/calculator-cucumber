package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends Controller {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    public CheckBox isRational;

    public void submitButton() {
        String input = inputField.getText().replace("%", "/100");
        Expression expr = parser.parse(input);
        try {
            if (isRational.isSelected()) {
                this.outputField.setText(calculator.eval(expr).toString());
            } else {
                this.outputField.setText(calculator.eval(expr).toReal().toString());
            }
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

    public void historyButton(ActionEvent actionEvent) {
        //Todo add code to call history

    }
}