package view;

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
        int nbButtons = 2;

        setMaxHeightNbButtons();
        setMaxWidthNbButtons(nbButtons);

        HBox hbox = new HBox();

        // Button to create a rational number
        Button fracButton = new Button("X/Y");
        fracButton.setOnAction(actionEvent -> modifyDisplay(fracButton, "_"));
        fracButton.setVisible(true);
        fracButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        fracButton.prefHeightProperty().bind(hbox.heightProperty());
        fracButton.setTooltip(new Tooltip("Use this button to create a rational number. Enter the nominator, press this button and enter the denominator."));

        // Button to evaluate the expression
        Button resultButton = new Button("=");
        resultButton.setVisible(true);
        resultButton.setOnAction(actionEvent -> {

        });
        resultButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        resultButton.prefHeightProperty().bind(hbox.heightProperty());

        hbox.getChildren().addAll(fracButton, resultButton);
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
