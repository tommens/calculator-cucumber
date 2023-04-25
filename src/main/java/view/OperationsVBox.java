package view;

import calculator.Calculator;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is used to create the part of the calculator containing the basics operations (+, -, *, /, %, =) and some other useful buttons (rational number and . for real numbers). Singleton Design Pattern.
 */
public class OperationsVBox extends CalculatorPart {

    private static OperationsVBox instance;

    private OperationsVBox(){
        getChildren().addAll(getGeneralHBox(new ArrayList<>(Arrays.asList("(", ")")), "operator-button"),
                getGeneralHBox(new ArrayList<>(Arrays.asList("+", "-")), "operator-button"),
                getGeneralHBox(new ArrayList<>(Arrays.asList("*", "/")),"operator-button"),
                getGeneralHBox(new ArrayList<>(Arrays.asList("%", ".")), "operator-button"),
                getLastHBox());
    }

    /**
     * This method is used to create a HBox containing the last bottom buttons of this calculator part.
     * @return The HBox containing the buttons.
     */
    private Node getLastHBox() {
        setMaxHeightNbButtons();
        setMaxWidthNbButtons(3);

        // Button to create a rational number
        Button fracButton = new Button("X/Y");
        fracButton.setOnAction(actionEvent -> ExpressionLabel.getInstance().updateText("_"));
        fracButton.setTooltip(new Tooltip("Use this button to create a rational number. Enter the nominator, press this button and enter the denominator."));

        // clear button
        Button clearButton = new Button("CLEAR");
        clearButton.setOnAction(actionEvent -> {
            ExpressionLabel.getInstance().setText("");
            ResultLabel.getInstance().setText("");
        });

        // back button
        Button backButton = new Button("<-");
        backButton.setOnAction(actionEvent -> {
            ExpressionLabel.getInstance().shortenText(1);
        });

        HBox hBox = new ButtonsHBox(List.of(fracButton, backButton, clearButton));
        hBox.prefHeightProperty().bind(heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        return hBox;
    }

    /**
     * This method is used to get the instance of the OperationsVBox.
     * @return The instance of the OperationsVBox.
     */
    public static OperationsVBox getInstance(){
        instance = instance == null ? new OperationsVBox() : instance;
        return instance;
    }


}
