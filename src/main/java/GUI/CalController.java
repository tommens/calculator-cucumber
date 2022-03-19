package GUI;

import GUI.component.ModeEnum;
import GUI.component.ModeVisibilityStrategy;
import GUI.component.UnexpectedStateException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import static GUI.component.ActivationModeEnum.ACTIVATE;
import static GUI.component.ActivationModeEnum.DEACTIVATE;
import static GUI.component.ModeEnum.mode;
import static javafx.scene.control.Alert.AlertType.*;
import static javafx.scene.control.ButtonType.CLOSE;

/**
 * This controller handle the main graphical interface's actions.
 * Read the calculator panel which contains functionalities
 * Switch mode
 */
public class CalController implements ModeVisibilityStrategy {

    @FXML
    AnchorPane componentTreeRoot;

    @FXML
    Button processResult;

    @FXML
    TextArea textResult;

    @FXML
    ChoiceBox<String> modes;

    @FXML
    public void initialize() {
        initModes();
    }

    public void addDecimal() {
        Platform.runLater(() -> {
            Alert dialog = new Alert(INFORMATION, "Not yes implemented", CLOSE);
            dialog.show();
        });
    }

    public void clearScreen() {
        textResult.setText("");
    }

    public void addNumber(ActionEvent actionEvent) {
        textResult.setText(getControlValue(actionEvent));
    }

    public void addOperation(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        textResult.setText(textResult.getText()+b.getText().charAt(0));
    }

    @FXML
    protected void onProcessResult() {
        if (!textResult.getText().equals(""))
            textResult.setText(processing());
    }

    private String processing() {
        return "calculator v0.3.0";
    }

    private String getControlValue(ActionEvent actionEvent) {
        StringBuilder txtValue = new StringBuilder(textResult.getText());
        Button b = (Button) actionEvent.getSource();
        txtValue.append(b.getText());
        return txtValue.toString();
    }

    private void initModes() {
        for (ModeEnum mode : ModeEnum.values())
            modes.getItems().add(mode.title());

        modes.setValue(ModeEnum.BASIC.title());
        modes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                modeActivation(componentTreeRoot, mode(oldValue).index(), DEACTIVATE);
                modeActivation(componentTreeRoot, mode(newValue).index(), ACTIVATE);

            } catch (UnexpectedStateException e) {
                e.printStackTrace();
                Platform.runLater(() -> {
                    Alert dialog = new Alert(ERROR, e.getMessage(), CLOSE);
                    dialog.show();
                });
            }

        });
    }

}