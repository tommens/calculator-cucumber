package view;

import calculator.Calculator;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.math.MathContext;
import java.math.RoundingMode;

public class SettingsMenu {

    private Stage window;
    private GridPane layout;

    private Calculator calculator;

    private ComboBox<String> precisionBox;
    private Spinner<Integer> precision;
    private Label precisionLabel;
    private ComboBox<RoundingMode> roundingBox;


    public SettingsMenu(Calculator c){
        calculator = c;

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Settings");
        window.setMinHeight(200);
        window.setMinWidth(100);
        window.setResizable(false);

        layout = new GridPane();
        layout.setMinWidth(50);
        layout.setMinHeight(200);
        layout.setVgap(10);
        layout.setHgap(5);
        layout.setPadding(new Insets(5,5,5,5));
        buildPrecisionChoice(layout);
        buildRoundingChoice(layout);
        buildBottomButton(layout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }

    private void buildPrecisionChoice(GridPane layout){
        layout.add(new Label("Precision of reals numbers"),0,0);
        precisionBox = new ComboBox<>();
        precisionBox.getItems().addAll("Unlimited","Custom");
        precisionBox.getSelectionModel().select(convertPrecisionToString());
        updatePrecisionView();
        precisionBox.setOnAction(e->updatePrecisionView());
        layout.add(precisionBox,1,0);
    }

    private void updatePrecisionView(){
        if (precisionBox.getSelectionModel().getSelectedItem().equals("Custom")){
            precisionLabel = new Label("Enter the precision");
            layout.add(precisionLabel,0,1);
            precision = new Spinner<>(0,128,calculator.getMathContext().getPrecision());
            layout.add(precision,1,1);
        }else{
            layout.getChildren().remove(precisionLabel);
            layout.getChildren().remove(precision);
        }
    }

    private String convertPrecisionToString(){
        int p = calculator.getMathContext().getPrecision();
        if (p == MathContext.UNLIMITED.getPrecision()){
            return "Unlimited";
        }
        return "Custom";
    }

    private void buildRoundingChoice(GridPane layout){
        layout.add(new Label("Rounding method"),0,2);
        roundingBox = new ComboBox<>();
        roundingBox.getItems().addAll(RoundingMode.UP,RoundingMode.DOWN,
                RoundingMode.CEILING,RoundingMode.FLOOR,
                RoundingMode.HALF_UP, RoundingMode.HALF_DOWN,
                RoundingMode.HALF_EVEN, RoundingMode.UNNECESSARY
        );
        roundingBox.getSelectionModel().select(calculator.getMathContext().getRoundingMode());
        layout.add(roundingBox,1,2);
    }

    private void buildBottomButton(GridPane layout){
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e->{
            savePrecision();
            calculator.setRoundingMode(roundingBox.getValue());
            window.close();
        });
        layout.add(saveButton,0,3);
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> window.close());
        layout.add(quitButton,1,3);

    }

    private void savePrecision(){
        if (precisionBox.getSelectionModel().getSelectedItem().equals("Unlimited")){
            calculator.setPrecision(0);
        }else{
            calculator.setPrecision(precision.getValue());
        }
    }

}
