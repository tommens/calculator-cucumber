package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import memories.MemoriesCareTaker;

public abstract class Controller implements MemoriesCareTaker {
    private Scene sceneBasic;
    private Scene sceneConverter;
    protected Stage stage;

    private boolean submitted;

    @FXML
    public VBox mainScreen;
    public MenuBar bar;
    public TextField inputField;
    public TextField outputField;

    public void setSceneBasic(Scene sceneBasic) {
        this.sceneBasic = sceneBasic;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSceneConverter(Scene sceneConverter) {
        this.sceneConverter = sceneConverter;
    }

    public void cancelButton() {
        setSubmitted(false);
        inputField.setText("");
        outputField.setText("");
    }

    public void eraseButton() {
        String current = inputField.getText();
        if (!current.isEmpty()) {
            inputField.setText(current.substring(0, current.length()-1));
        }
    }

    public void clickValueButton(Event e) {
        if (isSubmitted()) {
            setSubmitted(false);
            inputField.setText("");
            outputField.setText("");
        }
        String val = ((Button) e.getSource()).getText();
        inputField.setText(inputField.getText() + val);
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

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public abstract void submitButton();
}
