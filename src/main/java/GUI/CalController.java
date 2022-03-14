package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import static GUI.ModeEnum.mode;

public class CalController {

    @FXML
    Label valueTmpDynamicItem;

    @FXML
    HBox menuBasic;

    @FXML
    Label tmpText;

    @FXML
    ChoiceBox<String> modes;

    @FXML
    protected void onProcessResult() {
        tmpText.setText(" Calculator 0.1.0 ");
    }

    @FXML
    public void initialize() {
        valueTmpDynamicItem.setText("Fx 1");
        initModes();
    }

    private void initModes() {
        for (ModeEnum mode : ModeEnum.values())
            modes.getItems().add(mode.title());

        modes.setValue(ModeEnum.M1.title());
        modes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int newIndex = mode(newValue).index();
            String lab = "Fx "+(newIndex+1);
            valueTmpDynamicItem.setText(lab);
        });
    }

}