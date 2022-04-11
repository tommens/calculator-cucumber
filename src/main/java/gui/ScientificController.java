package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.event.Event;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public class ScientificController extends Controller {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);

    @Override
    public void submitButton() {
        String input = inputField.getText();
        input = input.replace("є", BigDecimal.valueOf(Math.E).toString());
        input = input.replace("π", BigDecimal.valueOf(Math.PI).toString());
        Expression expr = parser.parse(input);
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

    public void clickFctButton(Event event) {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + ((Button)event.getSource()).getText() + "(");
    }

    public void clickFactButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "!");
    }

    public void clickAbsButton() {
        clearAfterSubmitted();
        inputField.setText("|" + inputField.getText() + "|");
    }

    public void clickInverseButton() {
        clearAfterSubmitted();
        String input = inputField.getText();
        if (input.length() > 0) {
            if (input.contains("/")) {
                inputField.setText(input.substring(input.indexOf("/") + 1) + "/" + input.substring(0, input.indexOf("/")));
            } else {
                inputField.setText("1/" + input);
            }
        }
    }

    public void clickSquareButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "^2");
    }

    public void clickCubicButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "^3");
    }
}
