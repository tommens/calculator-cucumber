package GUI;

/**
 * Enum version of a state pattern that handle the chosen Mode
 */
public class ModesContext {

    private ModeEnum currentState;

    public void updateCurrentState(ModeEnum newState){
        this.currentState = newState;
    }

    public String getMode(int wValue) {
        return switch (currentState) {
            case M1 -> "1";
            case M2 -> "2";
            case M3 -> "3";
            case M4 -> "4";
            default -> "5";
        };
    }

    public boolean isInitialState() {
        return ModeEnum.M1.equals(currentState);
    }
}

