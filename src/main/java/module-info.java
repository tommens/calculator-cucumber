module gui.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires org.antlr.antlr4.runtime;

    opens gui to javafx.fxml;
    exports gui;
}