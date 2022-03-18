package GUI.component;

import javafx.scene.layout.AnchorPane;

public interface ModeVisibilityStrategy {

    String PREFIX = "mode";
    String SUFFIX = "Box";

    default void modeActivation(AnchorPane components, int index, ActivationModeEnum activationModeEnum) {
        components.lookup("#" + PREFIX + index + SUFFIX).setVisible(activationModeEnum.getStatus());
    }

}
