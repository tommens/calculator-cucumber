package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * This class is a template for the different parts of the calculator.
 */
public abstract class CalculatorPart extends VBox {

    //The maximum number of added buttons in width and height
    int maxWidthNbButtons=0, maxHeightNbButtons=0;

    /**
     * This method is used to get the maximum number of buttons in width, used in this part of the calculator.
     * @return The maximum number of buttons in width.
     */
    public int getMaxWidthNbButtons() {
        return maxWidthNbButtons;
    }

    /**
     * This method is used to get the maximum number of buttons in height, used in this part of the calculator.
     * @return The maximum number of buttons in height.
     */
    public int getMaxHeightNbButtons() {
        return maxHeightNbButtons;
    }

    /**
     * This method is used to set the maximum number of buttons in width, used in this part of the calculator.
     * @param size The maximum number of buttons in width.
     */
    void setMaxWidthNbButtons(int size) {
        maxWidthNbButtons = Math.max(maxWidthNbButtons, size);
    }

    /**
     * This method is used to set the maximum number of buttons in height, used in this part of the calculator.
     */
    void setMaxHeightNbButtons() {
        maxHeightNbButtons += 1;
    }

    /**
     * This method is used to create a HBox containing the buttons of the calculator.
     * @param elements The list of the buttons' text.
     * @return The HBox containing the buttons.
     */
    HBox getGeneralHBox(ArrayList<String> elements, String styleClass) {
        setMaxHeightNbButtons();
        setMaxWidthNbButtons(elements.size());
        HBox hbox = new HBox();
        elements.forEach((element) -> {

            Button button = new Button(element);
            button.getStyleClass().add(styleClass);
            button.setOnAction(actionEvent -> ExpressionLabel.getInstance().updateText(button.getText()));

            //bind the size of the button to the size of the hbox
            button.prefWidthProperty().bind(hbox.widthProperty().multiply(1. / elements.size()));
            button.prefHeightProperty().bind(hbox.heightProperty());


            hbox.getChildren().add(button);

            //bind the size of the hbox to the size of the CalculatorPart VBox
            hbox.prefHeightProperty().bind(heightProperty());
            hbox.prefWidthProperty().bind(widthProperty());

        });

        return hbox;
    }

    /**
     * This method is used to set the font size of the buttons, when the window is resized.
     * @param fontSize The new font size.
     */
    public void setFontSize(double fontSize) {
        getChildren().forEach(node -> node.setStyle("-fx-font-size: " + fontSize + "px;"));
    }

}
