package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class ButtonsHBox extends HBox {
    public ButtonsHBox(List<Button> buttonList) {
        super();
        buttonList.forEach((btn) -> {
            getChildren().add(btn);
            btn.prefWidthProperty().bind(widthProperty().multiply(1. / buttonList.size()));
            btn.prefHeightProperty().bind(heightProperty());
        });
    }
}
