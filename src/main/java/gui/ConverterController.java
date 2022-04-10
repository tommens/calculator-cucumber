package gui;

/**
 * This controller handle the main graphical interface's actions.
 * Read the converter panel which contains functionalities
 * Switch mode
 */
public class ConverterController extends Controller {

    public void submitButton() {
        // Todo evaluate expression and return good result or error
        this.outputField.setText(this.inputField.getText());
        this.setSubmitted(true);
    }
}