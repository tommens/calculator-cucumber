package GUI.component;

import javafx.scene.layout.AnchorPane;

public interface ModeVisibilityStrategy {

    String PREFIX = "mode";
    String SUFFIX = "Box";

    default void deactivateMode(AnchorPane components, int index) {
        components.lookup("#" + PREFIX + index + SUFFIX).setVisible(false);
    }

    default void activateMode(AnchorPane components, int index) {
        components.lookup("#" + PREFIX + index + SUFFIX).setVisible(true);
    }

}
