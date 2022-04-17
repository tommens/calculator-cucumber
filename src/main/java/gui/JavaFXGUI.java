package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static common.Configuration.*;

/**
 * The GUI application Launcher
 */
public class JavaFXGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Define bounds for screen
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.setMaxWidth(MAX_WIDTH);
        stage.setMaxHeight(MAX_HEIGHT);

        // Charge scene for basic calculator
        FXMLLoader loaderBasic = new FXMLLoader(getClass().getResource("/gui/layouts/basic.fxml"));
        Parent parentBasic = loaderBasic.load();
        Scene sceneBasic = new Scene(parentBasic);

        // Charge scene for converter
        FXMLLoader loaderConverter = new FXMLLoader(getClass().getResource("/gui/layouts/converter.fxml"));
        Parent parentConverter = loaderConverter.load();
        Scene sceneConverter = new Scene(parentConverter);

        // Add controller to basic loader
        BasicController basicController = loaderBasic.getController();
        basicController.setSceneBasic(sceneBasic);
        basicController.setSceneConverter(sceneConverter);
        basicController.setStage(stage);

        // Add controller to converter loader
        ConverterController converterController = loaderConverter.getController();
        converterController.setSceneBasic(sceneBasic);
        converterController.setSceneConverter(sceneConverter);

        stage.setScene(sceneBasic);
        stage.setTitle(TITLE_MAIN);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}