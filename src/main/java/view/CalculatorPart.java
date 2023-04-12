package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class CalculatorPart extends VBox {

    int maxWidthNbButtons=0, maxHeightNbButtons=0;

    public int getMaxWidthNbButtons() {
        return maxWidthNbButtons;
    }

    public int getMaxHeightNbButtons() {
        return maxHeightNbButtons;
    }

    void setMaxWidthNbButtons(int size) {
        maxWidthNbButtons = Math.max(maxWidthNbButtons, size);
    }

    void setMaxHeightNbButtons() {
        maxHeightNbButtons += 1;
    }

    Node getGeneralHBox(ArrayList<String> elements) {
        setMaxHeightNbButtons();
        setMaxWidthNbButtons(elements.size());
        HBox hbox = new HBox();
        elements.stream().forEach((element) -> {
            Button button = new Button(element.toString());
            button.setOnAction(actionEvent -> { modifyDisplay(button, button.getText());


            });

            button.prefWidthProperty().bind(hbox.widthProperty().multiply(1. / elements.size()));
            button.prefHeightProperty().bind(hbox.heightProperty());


            hbox.getChildren().add(button);
            hbox.prefHeightProperty().bind(heightProperty());
            hbox.prefWidthProperty().bind(widthProperty());

        });

        return hbox;
    }

    void modifyDisplay(Button button, String text){
        try {
            Node calculatorView = button.getParent();
            while (!(calculatorView instanceof CalculatorView)) {
                calculatorView = calculatorView.getParent();
            }
            ((CalculatorView) calculatorView).setDisplay(text);
        } catch (Exception e) {

        }
    }

}
