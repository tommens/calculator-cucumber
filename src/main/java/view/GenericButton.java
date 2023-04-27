package view;

import javafx.scene.control.Button;

public class GenericButton extends Button {
    public GenericButton(String text) {
        super(text);
        setOnAction(actionEvent -> ExpressionTextField.getInstance().updateText(getText()));
    }
}
