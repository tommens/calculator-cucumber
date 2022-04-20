package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.scene.control.CheckBox;
import gui.common.UnexpectedExpressionException;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import memory.CircularLinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import static gui.common.Configuration.*;
import static javafx.print.Printer.getDefaultPrinter;
import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class BasicController extends Controller {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    public CheckBox isRational;
    private final FileChooser fileChooser = new FileChooser();

    public BasicController() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(FILE_TYPE_DESCRIPTION, FILE_TYPE)
        );
    }

    public void submitButton() {
        String input = inputField.getText().replace("%", "/100");
        Expression expr = parser.parse(input);
        try {
            if (isRational.isSelected()) {
                String result = calculator.eval(expr).toString();
                this.outputField.setText(result);
                keepComponentValue(inputField.getText(), result);
            } else {
                String result = calculator.eval(expr).toReal().toString();
                this.outputField.setText(result);
                keepComponentValue(inputField.getText(), result);
            }
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

    /**
     * Memory navigation button : going left
     */
    public void historyLeft() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateLeft();
        screenUpdate(item);
    }

    /**
     * Memory navigation button : going right
     */
    public void historyRight() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateRight();
        screenUpdate(item);
    }

    /**
     * Memory navigation button : going to the last processed expression
     */
    public void historyLast() {
        CircularLinkedList item = history().getCurrentPosition();
        history().navigateLast();
        screenUpdate(item);
    }

    /**
     * Memory navigation button : going to the oldest processed expression
     */
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

    /**
     * Open a dialog panel to save the memory status to a txt file
     */
    public void saveHistory() throws FileNotFoundException {
        saveToFile(fileChooser.showSaveDialog(stage));
    }

    /**
     * Open a dialog panel to load the memory status from a txt file
     */
    public void loadHistory() throws IOException, UnexpectedExpressionException {
        fileChooser.setInitialDirectory(new File(System.getProperty(DEFAULT_DIRECTORY)));
        loadCircularList(fileChooser.showOpenDialog(null));
    }

    /**
     * Open a dialog panel to configurate the memory size
     */
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

    /**
     * Open a dialog panel to select a printer and print the memory
     */
    public void printHistory() {

        Dialog<String> dialog = new Dialog<>();
        ButtonType buttonOk = new ButtonType(PRINTER_DIALOG_BUTTON, OK_DONE);
        ListView<Printer> printerListView = new ListView<>();
        TextArea somethingToPrint = new TextArea();
        Label jobStatus = new Label();
        ObservableSet<Printer> printers = Printer.getAllPrinters();
        AtomicReference<Printer> selectedPrinter = new AtomicReference<>(getDefaultPrinter());
        String printContent = loadMemory();

        dialog.setTitle(PRINT_TITLE);
        somethingToPrint.setEditable(true);
        somethingToPrint.setText(printContent);
        printers.forEach(p -> printerListView.getItems().add(p));
        printerListView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> selectedPrinter.set(newValue));

        HBox content = new HBox(printerListView, somethingToPrint);

        dialog.setGraphic(content);
        dialog.getDialogPane().getButtonTypes().add(buttonOk);
        dialog.setOnCloseRequest(event -> {
            if (selectedPrinter.get() == null) return;
            PrinterJob job = PrinterJob.createPrinterJob(selectedPrinter.get());
            System.out.println(PRINTER_WITH_THIS + selectedPrinter);
            jobStatus.textProperty().unbind();
            jobStatus.setText(PRINTER_INITIATE_TASK);
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
            boolean printed = job.printPage(somethingToPrint);

            if (printed)
                job.endJob();
            else {
                jobStatus.textProperty().unbind();
                jobStatus.setText(PRINTER_FAILED);
            }
        });

        dialog.show();

    }

}