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
    private Label display;

    private List<CalculatorPart> calculatorParts;

    private double totalHeightRequired=1., totalWidthRequired=0.;

    private CalculatorView(){
        calculatorParts = new ArrayList<>();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(getIntNumbersVBox(), getOperationsVBox());



        vbox.getChildren().addAll(getDisplay(),hbox);

        bindHeightAndWidth();
        getChildren().add(vbox);
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
    public IntNumbersVBox getIntNumbersVBox(){
        IntNumbersVBox intNumbersVBox = IntNumbersVBox.getInstance();

        System.out.println(intNumbersVBox.getMaxWidthNbButtons()/totalWidthRequired);
        calculatorParts.add(intNumbersVBox);
        setTotalHeightRequired(intNumbersVBox.getMaxHeightNbButtons());
        setTotalWidthRequired(intNumbersVBox.getMaxWidthNbButtons());
        return intNumbersVBox;
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
     * This method get a Unique instance of the Display (Label) part.
     * @return The unique instance of the Display.
     */
    public Label getDisplay(){
        if(display==null) {
            display = new Label("");
            display.setVisible(true);
            display.prefWidthProperty().bind(widthProperty());
        }
        return display;
    }

    /**
     * This method is used to modify the display of the calculator.
     * @param stringToAdd The string to add to the display.
     */
    public void setDisplay(String stringToAdd){
        getDisplay().setText(getDisplay().getText()+stringToAdd);
    }

    /**
     * This method is used to clear the display of the calculator.
     */
    public void clearDisplay(){
        getDisplay().setText("");
    }

    /**
     * This method is used to set the font size of the calculator.
     * @param fontSize The font size to set.
     */
    public void setFontSize(double fontSize){
        getDisplay().setStyle("-fx-font-size: "+fontSize/8+"px;");
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
        getDisplay().setVisible(true);
        getDisplay().prefHeightProperty().bind(heightProperty().multiply(1/totalHeightRequired));
    }

}
