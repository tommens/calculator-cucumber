package gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends Controller {

    public void submitButton() {
        // Todo evaluate expression and return good result or error
        this.outputField.setText(this.inputField.getText());
        this.setSubmitted(true);
    }

    public void plusButton() {
        addOperation("+");
    }

    public void minusButton() {
        addOperation("-");
    }

    public void timesButton() {
        addOperation("x");
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

    public void historyButton(ActionEvent actionEvent) {
        //Todo add code to call history

    }
}