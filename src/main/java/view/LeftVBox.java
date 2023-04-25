package view;


import calculator.Calculator;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is used to create the VBox containing the numbers (0 to 9) of the calculator. Singleton Design Pattern.
 */
public class LeftVBox extends CalculatorPart {
    private static LeftVBox instance;

    private LeftVBox(){

        getChildren().addAll(
                getGeneralHBox(new ArrayList<>(Arrays.asList("7","8","9")), "numeric-button"),
                getGeneralHBox(new ArrayList<>(Arrays.asList("4","5","6")), "numeric-button"),
                getGeneralHBox(new ArrayList<>(Arrays.asList("1","2","3")), "numeric-button"),
                getBottomHBox());

                //getSevenToNineHBox(), getFourToSixHBox(), getOneToThreeHBox(), getZeroHBox());
    }

    private HBox getBottomHBox() {

        setMaxHeightNbButtons();
        setMaxWidthNbButtons(3);

        // Button to evaluate the expression
        Button resultButton = new Button("=");
        resultButton.setOnAction(actionEvent -> {
            Calculator calculator= new Calculator();
            int x = calculator.eval(calculator.read(ExpressionLabel.getInstance().getText()));
            ResultLabel.getInstance().setText(String.valueOf(x));
        });

        // 0 button
        Button zeroButton = new Button("0");
        zeroButton.getStyleClass().add("numeric-button");
        zeroButton.setOnAction(actionEvent -> {
            ExpressionLabel.getInstance().updateText("0");
        });

        HBox hBox = new ButtonsHBox(List.of(ArithmeticSelectorButton.getInstance(), zeroButton, resultButton));
        hBox.prefHeightProperty().bind(heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        return hBox;
    }


    /**
     * This method is used to get the instance of the IntNumbersVBox.
     * @return
     */
    public static LeftVBox getInstance(){
        instance = instance == null ? new LeftVBox() : instance;
        return instance;
    }



}
