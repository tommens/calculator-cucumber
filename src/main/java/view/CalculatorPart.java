package view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class is a template for the different parts of the calculator.
 */
public abstract class CalculatorPart extends VBox {

    //The maximum number of added buttons in width
    int maxWidthNbButtons = 0;

    /**
     * This method is used to get the maximum number of buttons in width, used in this part of the calculator.
     *
     * @return The maximum number of buttons in width.
     */
    public int getMaxWidthNbButtons() {
        return maxWidthNbButtons;
    }

    public void addHBox(HBox hbox) {
        getChildren().add(hbox);
        maxWidthNbButtons = Math.max(maxWidthNbButtons, hbox.getChildren().size());
        hbox.prefHeightProperty().bind(heightProperty());
        hbox.prefWidthProperty().bind(widthProperty());
    }

    /**
     * This method is used to set the font size of the buttons, when the window is resized.
     *
     * @param fontSize The new font size.
     */
    public void setFontSize(double fontSize) {
        getChildren().forEach(node -> node.setStyle("-fx-font-size: " + fontSize + "px;"));
    }
}
