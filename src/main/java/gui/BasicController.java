package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import common.UnexpectedExpressionException;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import memory.CircularLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static common.Configuration.*;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends Controller {

    private FileChooser fileChooser = new FileChooser();
    private Calculator calculator = new Calculator();

    public BasicController() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(FILE_TYPE_DESCRIPTION, FILE_TYPE)
        );
    }

    public void submitButton() {
        Expression expr = Parser.parse(this.inputField.getText());
        String resp = calculator.eval(expr).toString();
        this.outputField.setText(resp);
        keepComponentValue(inputField.getText(), resp);
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

    public void historyLeftButton() {
        CircularLinkedList item = getCircularList();
        left();
        screenUpdate(item);
    }

    public void historyRightButton() {
        CircularLinkedList item = getCircularList();
        right();
        screenUpdate(item);
    }

    private void screenUpdate(CircularLinkedList item) {
        if (item == null)  return;
        outputField.setText(item.getDTO().getResult());
        inputField.setText(item.getDTO().getExpression());
    }

    public void saveHistory() throws FileNotFoundException {
        saveToFile(fileChooser.showSaveDialog(stage));
    }

    public void loadHistory() throws IOException, UnexpectedExpressionException {
        fileChooser.setInitialDirectory(new File(System.getProperty(DEFAULT_DIRECTORY)));
        loadCircularList(fileChooser.showOpenDialog(null));
    }

    public void printHistory(ActionEvent actionEvent) {
        // TODO:  implementation
    }
}