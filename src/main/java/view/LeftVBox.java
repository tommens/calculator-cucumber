package view;


import calculator.Calculator;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.stream.Stream;

/**
 * This class is used to create the VBox containing the numbers (0 to 9) of the calculator. Singleton Design Pattern.
 */
public class LeftVBox extends CalculatorPart {
    private static LeftVBox instance;

    private LeftVBox() {
        addHBox(new ButtonsHBox(Stream.of("7", "8", "9").map(GenericButton::new).toList(), "numeric-button"));
        addHBox(new ButtonsHBox(Stream.of("4", "5", "6").map(GenericButton::new).toList(), "numeric-button"));
        addHBox(new ButtonsHBox(Stream.of("1", "2", "3").map(GenericButton::new).toList(), "numeric-button"));
        addHBox(getBottomHBox());
    }

    /**
     * This method is used to get the instance of the IntNumbersVBox.
     *
     * @return
     */
    public static LeftVBox getInstance() {
        instance = instance == null ? new LeftVBox() : instance;
        return instance;
    }

    private HBox getBottomHBox() {
        // Button to evaluate the expression
        Button resultButton = new Button("=");
        resultButton.setOnAction(actionEvent -> {
            String x = MainApplication.getCalculator().evalExpression(ExpressionTextField.getInstance().getText());
            ResultLabel.getInstance().setText(String.valueOf(x));
        });

        // 0 button
        Button zeroButton = new Button("0");
        zeroButton.getStyleClass().add("numeric-button");
        zeroButton.setOnAction(actionEvent -> {
            ExpressionTextField.getInstance().updateText("0");
        });

        HBox hBox = new ButtonsHBox(List.of(ArithmeticSelectorButton.getInstance(), zeroButton, resultButton));
        hBox.prefHeightProperty().bind(heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        return hBox;
    }
}
