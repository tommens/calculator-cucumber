package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.event.Event;
import javafx.scene.control.Button;

import java.math.MathContext;

import static java.math.MathContext.DECIMAL128;

public class ScientificController extends ControllerWithMemory {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    protected MathContext mc = DECIMAL128;

    @Override
    public void submitButton() {
        String input = inputField.getText();
        input = input.replace("є", BigDecimalMath.e(mc).toString());
        input = input.replace("π", BigDecimalMath.pi(mc).toString());
        input = input.replace("√", "sqrt");
        input = input.replace("∛", "cbrt");
        input = input.replace("%", "/100");
        try {
            Expression expr = parser.parse(input);
            String result = calculator.eval(expr).toReal().toString();
            this.outputField.setText(result);
            keepComponentValue(inputField.getText(), result, getSelectedMode());
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

    public void clickFctButton(Event event) {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + ((Button)event.getSource()).getText() + "(");
    }

    public void clickAbsButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "abs(");
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
