package GUI;

import GUI.component.ActivationModeEnum;
import GUI.component.ModeEnum;
import GUI.component.ModeVisibilityStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import static GUI.component.ActivationModeEnum.*;
import static GUI.component.ModeEnum.mode;

public class CalController implements ModeVisibilityStrategy {

    @FXML
    AnchorPane componentTreeRoot;



    @FXML
    Button processResult;

    @FXML
    TextArea textResult;

    @FXML
    ChoiceBox<String> modes;

    private void initModes() {
        for (ModeEnum mode : ModeEnum.values())
            modes.getItems().add(mode.title());

        modes.setValue(ModeEnum.BASIC.title());
        modes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            modeActivation(componentTreeRoot, mode(oldValue).index(), DEACTIVATE);
            modeActivation(componentTreeRoot, mode(newValue).index(), ACTIVATE);
        });
    }

    @FXML
    public void initialize() {
        initModes();
    }

    public void addDecimal() {}

    public void clearScreen() {
        textResult.setText("");
    }

    public void addSomething(ActionEvent actionEvent) {
        textResult.setText(getButtonValue(actionEvent));
    }

    private String getButtonValue(ActionEvent actionEvent) {
        StringBuilder txtValue = new StringBuilder(textResult.getText());
        Button b = (Button) actionEvent.getSource();
        txtValue.append(b.getText());
        return txtValue.toString();
    }

    @FXML
    protected void onProcessResult() {
        textResult.setText("calculator v0.2.0");
    }

}