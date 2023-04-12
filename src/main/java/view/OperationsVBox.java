package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

public class OperationsVBox extends CalculatorPart {

    private static OperationsVBox instance;

    private OperationsVBox(){
        getChildren().addAll(getGeneralHBox(new ArrayList<>(Arrays.asList("+", "-"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("*", "/"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("%", "."))),
                getLastHBox());
    }

    private Node getLastHBox() {
        int nbButtons = 2;
        setMaxHeightNbButtons();
        setMaxWidthNbButtons(nbButtons);
        HBox hbox = new HBox();
        Button fracButton = new Button("X/Y");
        fracButton.setOnAction(actionEvent -> modifyDisplay(fracButton, "_"));
        fracButton.setVisible(true);
        fracButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        fracButton.prefHeightProperty().bind(hbox.heightProperty());

        Button resultButton = new Button("=");
        resultButton.setVisible(true);
        resultButton.setOnAction(actionEvent -> {
            System.out.println("Evaluating");
            /* call the evaluation function */
        });
        resultButton.prefWidthProperty().bind(hbox.widthProperty().multiply(1./nbButtons));
        resultButton.prefHeightProperty().bind(hbox.heightProperty());

        hbox.getChildren().addAll(fracButton, resultButton);
        hbox.prefHeightProperty().bind(heightProperty());
        hbox.prefWidthProperty().bind(widthProperty());
        return hbox;
    }

    public static OperationsVBox getInstance(){
        instance = instance == null ? new OperationsVBox() : instance;
        return instance;
    }


}
