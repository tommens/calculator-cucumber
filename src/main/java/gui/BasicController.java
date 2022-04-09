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
        addOperation("+");
    }

    public void minusButton() {
        addOperation("-");
    }

    public void timesButton() {
        addOperation("×");
    }

    public void dividesButton() {
        addOperation("/");
    }

    private void addOperation(String operation) {
        if (isSubmitted()) {
            setSubmitted(false);
            inputField.setText("");
        }
        inputField.setText(inputField.getText() + operation);
    }

    public void historyLeftButton(ActionEvent actionEvent) {
        //TODO: implementation

    }

    public void historyRightButton(ActionEvent actionEvent) {
        //TODO: implementation

    }
}