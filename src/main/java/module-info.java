module gui.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens GUI to javafx.fxml;
    exports GUI;
}