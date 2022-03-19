package GUI.component;

import javafx.scene.layout.AnchorPane;

/**
 * Define the visibility of a specific component
 */
public interface ModeVisibilityStrategy {

    String PREFIX = "mode";
    String SUFFIX = "Box";

    /**
     *
     * @param components the component Tree
     * @param index the index of the component to (de)activate
     * @param activationModeEnum the action defined by Enum
     */
    default void modeActivation(AnchorPane components, int index, ActivationModeEnum activationModeEnum) throws UnexpectedStateException {
        try {
            components.lookup("#" + PREFIX + index + SUFFIX).setVisible(activationModeEnum.getStatus());
        } catch (Exception e) {
            throw new UnexpectedStateException("Invalid component Tree during initialization");
        }
    }

}
