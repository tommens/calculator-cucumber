package view;

import calculator.Calculator;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to create the part of the calculator containing the basics operations (+, -, *, /, %, =) and some other useful buttons (rational number and . for real numbers). Singleton Design Pattern.
 */
public class OperationsVBox extends CalculatorPart {

    private static OperationsVBox instance;

    private OperationsVBox(){
        getChildren().addAll(getGeneralHBox(new ArrayList<>(Arrays.asList("(", ")"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("+", "-"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("*", "/"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("%", "."))),
                getLastHBox());
    }

    /**
     * This method is used to create a HBox containing the last bottom buttons of this calculator part.
     * @return The HBox containing the buttons.
     */
    private Node getLastHBox() {
        int nbButtons = 4;

        setMaxHeightNbButtons();
        setMaxWidthNbButtons(nbButtons);

        HBox hbox = new HBox();

        // Button to create a rational number
        Button fracButton = new Button("X/Y");
        fracButton.setOnAction(actionEvent -> ExpressionLabel.getInstance().updateText("_"));
        fracButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        fracButton.prefHeightProperty().bind(hbox.heightProperty());
        fracButton.setTooltip(new Tooltip("Use this button to create a rational number. Enter the nominator, press this button and enter the denominator."));

        // Button to evaluate the expression
        Button resultButton = new Button("=");
        resultButton.setOnAction(actionEvent -> {
            Calculator calculator= new Calculator();
            int x = calculator.eval(calculator.read(ExpressionLabel.getInstance().getText()));
            ResultLabel.getInstance().setText(String.valueOf(x));
        });
        resultButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        resultButton.prefHeightProperty().bind(hbox.heightProperty());

        Button clearButton = new Button("CLEAR");
        clearButton.setOnAction(actionEvent -> {
            ExpressionLabel.getInstance().setText("");
            ResultLabel.getInstance().setText("");
        });
        clearButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        clearButton.prefHeightProperty().bind(hbox.heightProperty());

        // Button for converting measurements
        Button conversionButton = new Button("Unit converter");
        conversionButton.setOnAction(actionEvent -> ConversionWindow.displayConversionWindow());
        conversionButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        conversionButton.prefHeightProperty().bind(hbox.heightProperty());

        hbox.getChildren().addAll(fracButton, resultButton, clearButton,conversionButton);
        hbox.prefHeightProperty().bind(heightProperty());
        hbox.prefWidthProperty().bind(widthProperty());
        return hbox;
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
