package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to assemble the different parts of the calculator. This is the calculator's view itself. Singleton Design Pattern.
 */
public class CalculatorView extends VBox {
    private static CalculatorView instance;

    private List<CalculatorPart> calculatorParts;

    private double totalHeightRequired=1., totalWidthRequired=0.;

    private CalculatorView(){
        calculatorParts = new ArrayList<>();
        HBox buttonsHbox = new HBox();
        buttonsHbox.getChildren().addAll(getIntNumbersVBox(), getOperationsVBox());



        getChildren().addAll(ExpressionLabel.getInstance(), ResultLabel.getInstance(), buttonsHbox);

        bindHeightAndWidth();
    }

    /**
     * This method returns the unique instance of the CalculatorView.
     * @return The unique instance of the CalculatorView.
     */
    public static CalculatorView getInstance(){
        instance = instance == null ? new CalculatorView() : instance;
        return instance;
    }

    /**
     * This method get a Unique instance of the IntNumbersVBox part and update the total height and width required by the calculator.
     * @return The unique instance of the IntNumbersVBox.
     */
    public LeftVBox getIntNumbersVBox(){
        LeftVBox leftVBox = LeftVBox.getInstance();

        //System.out.println(intNumbersVBox.getMaxWidthNbButtons()/totalWidthRequired);
        calculatorParts.add(leftVBox);
        setTotalHeightRequired(leftVBox.getMaxHeightNbButtons());
        setTotalWidthRequired(leftVBox.getMaxWidthNbButtons());
        return leftVBox;
    }

    /**
     * This method get a Unique instance of the OperationsVBox part and update the total height and width required by the calculator.
     * @return The unique instance of the OperationsVBox.
     */
    private OperationsVBox getOperationsVBox() {
        OperationsVBox operationsVBox = OperationsVBox.getInstance();

        calculatorParts.add(operationsVBox);
        setTotalHeightRequired(operationsVBox.getMaxHeightNbButtons());
        setTotalWidthRequired(operationsVBox.getMaxWidthNbButtons());
        return operationsVBox;
    }



    /**
     * This method is used to set the font size of the calculator.
     * @param fontSize The font size to set.
     */
    public void setFontSize(double fontSize){
        ExpressionLabel.getInstance().setStyle("-fx-font-size: "+fontSize/8+"px;");
        ResultLabel.getInstance().setStyle("-fx-font-size: "+fontSize/8+"px;");
        getIntNumbersVBox().setFontSize(fontSize/20);
        getOperationsVBox().setFontSize(fontSize/20);

    }

    /**
     * This method is used to set the total height required by the calculator.
     * @param totalHeightRequired The total height required by a part of the calculator.
     */
    public void setTotalHeightRequired(double totalHeightRequired) {
        this.totalHeightRequired = Math.max(totalHeightRequired+1, this.totalHeightRequired);
    }

    /**
     * This method is used to set the total width required by the calculator.
     * @param totalWidthRequired The total width required by a part of the calculator.
     */
    public void setTotalWidthRequired(double totalWidthRequired) {
        this.totalWidthRequired += totalWidthRequired;
    }

    /**
     * This method is used to bind the height and width of the calculator's parts.
     */
    public void bindHeightAndWidth(){
        calculatorParts.forEach(calculatorPart -> {
            calculatorPart.prefWidthProperty().bind(widthProperty().multiply(calculatorPart.getMaxWidthNbButtons()/totalWidthRequired));
            calculatorPart.prefHeightProperty().bind(heightProperty().multiply(calculatorPart.getMaxHeightNbButtons()/totalHeightRequired));
        });
        ExpressionLabel.getInstance().prefWidthProperty().bind(widthProperty());
        ExpressionLabel.getInstance().prefHeightProperty().bind(heightProperty().multiply(1/totalHeightRequired));

        ResultLabel.getInstance().prefHeightProperty().bind(heightProperty().multiply(1/totalHeightRequired));
        ResultLabel.getInstance().prefWidthProperty().bind(widthProperty());

    }

}
