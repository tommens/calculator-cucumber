package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import common.UnexpectedExpressionException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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


    private final FileChooser fileChooser = new FileChooser();
    private final Calculator calculator = new Calculator();

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

    public void historyLeft() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateLeft();
        screenUpdate(item);
    }

    public void historyRight() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateRight();
        screenUpdate(item);
    }

    public void historyLast() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateLast();
        screenUpdate(item);
    }

    public void historyFirst() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateFirst();
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

    public void configHistory() {
        long currentValue = history().getMemorySize();
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle(CONFIGURATION_TITLE);
        Slider slider = new Slider(MIN_MEM_SIZE, MAX_MEM_SIZE, currentValue);
        Label label = new Label(MEMORY_SIZE_DIALOG_TEXT);
        Label res = new Label(Long.toString(currentValue));
        ButtonType buttonOk = new ButtonType(MEMORY_SIZE_DIALOG_BUTTON);
        HBox content = new HBox(slider, label, res);

        slider.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
                long val = Math.round(newValue.doubleValue());
                res.setText(String.valueOf(val));
                history().setMemorySize(val);
            });

        dialog.setGraphic(content);
        dialog.getDialogPane().getButtonTypes().add(buttonOk);
        dialog.show();

    }

    public void printHistory(ActionEvent actionEvent) {
        // TODO:  implementation
    }

}