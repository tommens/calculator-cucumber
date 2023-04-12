package calculator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.CalculatorView;
import view.IntNumbersVBox;

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

        //Menu principal

        CalculatorView panel = CalculatorView.getInstance();
        Scene scene = new Scene(panel);
        primaryStage.setTitle("Calculator --- WALCARIUS -- MARCHELLI -- TULIPPE-HECQ -- VAN DRIESSCHE");
        panel.prefHeightProperty().bind(scene.heightProperty());
        panel.prefWidthProperty().bind(scene.widthProperty());



        primaryStage.setMinWidth(1280);
        primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));
        primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(0.56));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}