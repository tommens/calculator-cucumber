package GUI.component;

import javafx.scene.layout.AnchorPane;

public interface ModeVisibilityStrategy {

    /*TODO: (@tests)
     * --------------
     * - check component null
     * - check is not in component tree
     */

    String PREFIX = "mode";
    String SUFFIX = "Box";

    default void modeActivation(AnchorPane components, int index, ActivationModeEnum activationModeEnum) {
        components.lookup("#" + PREFIX + index + SUFFIX).setVisible(activationModeEnum.getStatus());
    }

}
