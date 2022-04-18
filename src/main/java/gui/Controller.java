package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class Controller {
    private Scene sceneBasic;
    private Scene sceneConverter;
    private Scene sceneScientific;
    private Scene sceneFunctions;

    private boolean submitted = false;

    @FXML
    public VBox mainScreen;
    public MenuBar bar;
    public TextField inputField;
    public TextField outputField;

    public void setSceneBasic(Scene sceneBasic) {
        this.sceneBasic = sceneBasic;
    }

    public void setSceneConverter(Scene sceneConverter) {
        this.sceneConverter = sceneConverter;
    }

    public void setSceneScientific(Scene sceneScientific) {
        this.sceneScientific = sceneScientific;
    }

    public void setSceneFunctions(Scene sceneFunctions) {
        this.sceneFunctions = sceneFunctions;
    }

    public void cancelButton() {
        setSubmitted(false);
        inputField.setText("");
        outputField.setText("");
    }

    public void eraseButton() {
        clearAfterSubmitted();
        String current = inputField.getText();
        if (!current.isEmpty()) {
            inputField.setText(current.substring(0, current.length()-1));
        }
    }

    public void clickValueButton(Event e) {
        clearAfterSubmitted();
        String val = ((Button) e.getSource()).getText();
        inputField.setText(inputField.getText() + val);
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void clearAfterSubmitted() {
        if (isSubmitted()) {
            setSubmitted(false);
            inputField.setText("");
            outputField.setText("");
        }
    }

    @FXML
    public void showSceneBasic() {
        inputField.setText("");
        outputField.setText("");
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneBasic);
    }

    @FXML
    public void showSceneConverter() {
        inputField.setText("");
        outputField.setText("");
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneConverter);
    }

    @FXML
    public void showSceneScientific() {
        inputField.setText("");
        outputField.setText("");
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneScientific);
    }

    @FXML
    public void showSceneFunctions() {
        inputField.setText("");
        outputField.setText("");
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneFunctions);
    }

    public void showAlertMessage(String message) {
        inputField.setText(inputField.getText() + " !! " + message);
    }

    public abstract void submitButton();
}
