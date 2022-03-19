package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import static common.Configuration.*;

/**
 * The GUI application Launcher
 */
public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(MAIN_PAGE));
        Panel panel = new Panel();
        panel.getStyleClass().add(STYLE_CONFIGURATION);
        Scene scene = new Scene(fxmlLoader.load(), WINDOWS_WIDTH, WINDOWS_HEIGHT);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle(MAIN_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}