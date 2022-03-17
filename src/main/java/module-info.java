module gui.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens GUI to javafx.fxml;
    exports GUI;
    exports GUI.component;
    opens GUI.component to javafx.fxml;
}