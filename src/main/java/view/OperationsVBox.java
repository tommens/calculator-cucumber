package view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.stream.Stream;

/**
 * This class is used to create the part of the calculator containing the basics operations (+, -, *, /, %, =) and some other useful buttons (rational number and . for real numbers). Singleton Design Pattern.
 */
public class OperationsVBox extends CalculatorPart {

    private static OperationsVBox instance;

    private OperationsVBox() {

        addHBox(getFirstHBox());
        addHBox(new ButtonsHBox(Stream.of("+", "-", "%", "e", "gcd").map(GenericButton::new).toList(), "operator-button"));
        addHBox(new ButtonsHBox(Stream.of("*", "/", "^","E", "lcm").map(GenericButton::new).toList(), "operator-button"));
        addHBox(getBottomHBox());
    }

    /**
     * This method is used to get the instance of the OperationsVBox.
     *
     * @return The instance of the OperationsVBox.
     */
    public static OperationsVBox getInstance() {
        instance = instance == null ? new OperationsVBox() : instance;
        return instance;
    }

    private HBox getFirstHBox() {
        // Button to create a rational number
        Button fracButton = new Button("X/Y");
        fracButton.setOnAction(actionEvent -> ExpressionTextField.getInstance().updateText("_"));
        fracButton.setTooltip(new Tooltip("Use this button to create a rational number. Enter the nominator, press this button and enter the denominator."));

        HBox hBox = new ButtonsHBox(
                List.of(new GenericButton("("), new GenericButton(")"), new GenericButton(".") , new GenericButton("π"),fracButton),
                "operator-button");
        hBox.prefHeightProperty().bind(heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        return hBox;
    }

    /**
     * This method is used to create a HBox containing the last bottom buttons of this calculator part.
     *
     * @return The HBox containing the buttons.
     */
    private HBox getBottomHBox() {
        // clear button
        Button clearButton = new Button("CLEAR");
        clearButton.setOnAction(actionEvent -> {
            ExpressionTextField.getInstance().setText("");
            ResultLabel.getInstance().setText("");
        });

        // back button
        Button backButton = new Button("<-");
        backButton.setOnAction(actionEvent -> ExpressionTextField.getInstance().shortenText(1));



        // Button for converting measurements
        Button conversionButton = new Button("Unit converter");
        conversionButton.setOnAction(actionEvent -> ConversionWindow.displayConversionWindow());
        
        // Button for time calculations
        Button timeButton = new Button("Time");
        timeButton.setOnAction(actionEvent -> TimeWindow.displayTimeWindow());
        
        HBox hBox = new ButtonsHBox(List.of(backButton, clearButton,conversionButton,timeButton));
        hBox.prefHeightProperty().bind(heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        return hBox;
    }
}
