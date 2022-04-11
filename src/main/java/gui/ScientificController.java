package gui;

public class ScientificController extends Controller {

    @Override
    public void submitButton() {

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
