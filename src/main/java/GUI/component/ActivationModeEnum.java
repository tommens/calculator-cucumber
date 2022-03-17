package GUI.component;

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
