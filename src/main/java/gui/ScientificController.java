package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.event.Event;
import javafx.scene.control.Button;

import java.math.MathContext;

public class ScientificController extends Controller {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    protected MathContext mc = MathContext.DECIMAL128;

    @Override
    public void submitButton() {
        String input = inputField.getText();
        input = input.replace("є", BigDecimalMath.e(mc).toString());
        input = input.replace("π", BigDecimalMath.pi(mc).toString());
        input = input.replace("√", "sqrt");
        input = input.replace("∛", "cbrt");
        input = input.replace("%", "/100");
        Expression expr = parser.parse(input);
        this.outputField.setText(calculator.eval(expr).toReal().toString());
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
