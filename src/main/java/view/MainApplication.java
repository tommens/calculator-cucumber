package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 * This class is the main application of the calculator GUI
 */
public class MainApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        Platform.setImplicitExit(false);
        System.setProperty("file.encoding", "UTF-8" );
        this.primaryStage = primaryStage;

        initialize();

    }

    /**
     * Initialize the calculator view
     */
    public static void initialize(){
        primaryStage.setOnCloseRequest(event -> {
            if (!event.getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {
                event.consume();
            }
            Platform.setImplicitExit(true);
            Platform.exit();
            System.exit(0);

        });

        // Make the window a little bit transparent
        primaryStage.setOpacity(0.95);

        // Create the calculator view
        CalculatorView calculatorView = CalculatorView.getInstance();

        // Create the scene
        Scene scene = new Scene(calculatorView);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("view/style.css");

        primaryStage.setTitle("Calculator --- WALCARIUS -- MARCHELLI -- TULIPPE-HECQ -- VAN DRIESSCHE");

        // Bind the calculatorView to the scene
        calculatorView.prefHeightProperty().bind(scene.heightProperty());
        calculatorView.prefWidthProperty().bind(scene.widthProperty());


        //make font size of calculatorView elements resize while resizing the window
        calculatorView.prefHeightProperty().addListener((observable, oldValue, newValue) -> calculatorView.setFontSize(newValue.doubleValue()));


        // Set the minimum size of the window
        primaryStage.setMinWidth(600);

        // Keep the ratio of the window
        primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));
        primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}