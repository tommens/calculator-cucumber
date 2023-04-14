package calculator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.CalculatorView;


/**
 * Cette classe est la classe qui lance l'application JAVAFX.
 */
public class MainApplication extends Application {
    private static Stage primaryStage;
    private static CalculatorView intNumbersVBox;
    @Override
    public void start(Stage primaryStage){
        Platform.setImplicitExit(false);
        System.setProperty("file.encoding", "UTF-8" );
        this.primaryStage = primaryStage;

        intNumbersVBox = CalculatorView.getInstance();
        initialize();

    }

    public static void initialize(){
        primaryStage.setOnCloseRequest(event -> {
            if (!event.getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {
                event.consume();
            }
            Platform.setImplicitExit(true);
            Platform.exit();
            System.exit(0);

        });

        primaryStage.setOpacity(0.95);

        //Menu principal

        CalculatorView panel = CalculatorView.getInstance();
        Scene scene = new Scene(panel);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("view/style.css");

        primaryStage.setTitle("Calculator --- WALCARIUS -- MARCHELLI -- TULIPPE-HECQ -- VAN DRIESSCHE");
        panel.prefHeightProperty().bind(scene.heightProperty());
        panel.prefWidthProperty().bind(scene.widthProperty());


        //make font size of panel elements resize while resizing the window
        panel.prefHeightProperty().addListener((observable, oldValue, newValue) -> panel.setFontSize(newValue.doubleValue()));



        primaryStage.setMinWidth(600);
        primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));
        primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}