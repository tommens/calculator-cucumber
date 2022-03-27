package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.event.ActionEvent;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends Controller {

    private Calculator calculator = new Calculator();

    public void submitButton() {
        Expression expr = Parser.parse(this.inputField.getText());
        this.outputField.setText(calculator.eval(expr).toString());
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