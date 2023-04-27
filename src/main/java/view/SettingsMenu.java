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

/**
 * This class implement the settings window
 * The settings window allow to change the precision considered for real numbers
 * and change the rounding method
 */
public class SettingsMenu {

    private final Stage window;
    private final GridPane layout;

    /** Instance of the calculator */
    private final Calculator calculator;

    /** Combobox to choose between Unlimited and custom precision */
    private ComboBox<String> precisionBox;

    /** Spinner used to get the input of the user for the precision */
    private Spinner<Integer> precision;
    /** Label that is display when the user select custom precision */
    private Label precisionLabel;
    /** Combobox to choose the rounding method */
    private ComboBox<RoundingMode> roundingBox;


    /**
     * Constructor
     * @param c The instance of the calculator
     */
    public SettingsMenu(Calculator c){
        calculator = c;

        // create the window
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Settings");
        window.setMinHeight(200);
        window.setMinWidth(100);
        window.setResizable(false);

        // create the layout
        layout = new GridPane();
        layout.setMinWidth(50);
        layout.setMinHeight(200);
        layout.setVgap(10);
        layout.setHgap(5);
        layout.setPadding(new Insets(5,5,5,5));

        // build the component
        buildPrecisionChoice();
        buildRoundingChoice();
        buildBottomButton();

        // set the scene
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }


    /**
     * Build the first row containing the choice of the precision
     */
    private void buildPrecisionChoice(){
        layout.add(new Label("Precision of reals numbers"),0,0);
        precisionBox = new ComboBox<>();
        precisionBox.getItems().addAll("Unlimited","Custom");
        precisionBox.getSelectionModel().select(convertPrecisionToString());
        updatePrecisionView();
        precisionBox.setOnAction(e->updatePrecisionView());
        layout.add(precisionBox,1,0);
    }

    /**
     * Display or not the row to get a custom precision from the user
     */
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

    /**
     * Get the string corresponding to the current precision of the calculator
     * @return "Unlimited" if the precision is Unlimited, "Custom" otherwise
     */
    private String convertPrecisionToString(){
        int p = calculator.getMathContext().getPrecision();
        if (p == MathContext.UNLIMITED.getPrecision()){
            return "Unlimited";
        }
        return "Custom";
    }

    /**
     * Build the third row which contain the choice of the rounding method
     */
    private void buildRoundingChoice(){
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

    /**
     * Build the last row which contains the save and quit buttons
     */
    private void buildBottomButton(){
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

    /**
     * Save the precision
     */
    private void savePrecision(){
        if (precisionBox.getSelectionModel().getSelectedItem().equals("Unlimited")){
            calculator.setPrecision(MathContext.UNLIMITED.getPrecision());
        }else{
            calculator.setPrecision(precision.getValue());
        }
    }

}
