package GUI.component;

/**
 * This enum is used in component mode visibility strategy to decide the action apply to the component
 */
public enum ActivationModeEnum {

    DEACTIVATE(false),
    ACTIVATE(true);

    private final boolean status;

    ActivationModeEnum(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
