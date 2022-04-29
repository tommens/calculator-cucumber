package gui.navigation;

/**
 * Enum version of a state pattern that handle the chosen Mode
 */
public class ModesContext {

    private ModeEnum currentState;

    public void updateCurrentState(ModeEnum newState){
        this.currentState = newState;
    }

    public String getMode() {
        return currentState.title();
    }

}
