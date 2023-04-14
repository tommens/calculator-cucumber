package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculatorView extends VBox {
    private static CalculatorView instance;
    private Label display;

    private double totalHeightRequired=5., totalWidthRequired=5.;

    private CalculatorView(){
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(getIntNumbersVBox(), getOperationsVBox());

        vbox.getChildren().addAll(getDisplay(),hbox);
        getChildren().add(vbox);
    }



    public double getTotalHeightRequired() {
        return totalHeightRequired;
    }

    public double getTotalWidthRequired() {
        return totalWidthRequired;
    }

    public static CalculatorView getInstance(){
        instance = instance == null ? new CalculatorView() : instance;
        return instance;
    }
    public IntNumbersVBox getIntNumbersVBox(){
        IntNumbersVBox intNumbersVBox = IntNumbersVBox.getInstance();
        intNumbersVBox.prefWidthProperty().bind(widthProperty().multiply(intNumbersVBox.getMaxWidthNbButtons()/totalWidthRequired));
        intNumbersVBox.prefHeightProperty().bind(heightProperty().multiply(intNumbersVBox.getMaxHeightNbButtons()/totalHeightRequired));
        System.out.println(intNumbersVBox.getMaxWidthNbButtons()/totalWidthRequired);
        return intNumbersVBox;
    }
    private OperationsVBox getOperationsVBox() {
        OperationsVBox operationsVBox = OperationsVBox.getInstance();
        operationsVBox.prefWidthProperty().bind(widthProperty().multiply(operationsVBox.getMaxWidthNbButtons()/totalWidthRequired));
        operationsVBox.prefHeightProperty().bind(heightProperty().multiply(operationsVBox.getMaxHeightNbButtons() / totalHeightRequired));
        return operationsVBox;
    }


    public Label getDisplay(){
        if(display==null) {
            display = new Label("");
            display.setVisible(true);
            display.prefHeightProperty().bind(heightProperty().multiply(1 / totalHeightRequired));
            display.prefWidthProperty().bind(widthProperty());
        }
        return display;
    }

    public void setDisplay(String stringToAdd){
        getDisplay().setText(getDisplay().getText()+stringToAdd);
    }

    public void clearDisplay(){
        getDisplay().setText("");
    }

    public void setFontSize(double fontSize){
        getDisplay().setStyle("-fx-font-size: "+fontSize/8+"px;");
        getIntNumbersVBox().setFontSize(fontSize/20);
        getOperationsVBox().setFontSize(fontSize/20);

    }

}
