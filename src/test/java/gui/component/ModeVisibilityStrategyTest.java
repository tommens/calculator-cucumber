package gui.component;

//TODO: adapt tha tests with the update of the gui
//import javafx.scene.layout.AnchorPane;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static GUI.component.ActivationModeEnum.ACTIVATE;
//
//class ModeVisibilityStrategyTest implements ModeVisibilityStrategy {
//
//    private final int ARBITRARY_ID = 1;
//    private final ActivationModeEnum ARBITRARY_STATUS = ACTIVATE;
//    private final String EXPECTED_MSG = "Invalid component Tree during initialization";
//
//    @Test
//    void modeActivation_null_component() {
//
//        UnexpectedStateException thrown = Assertions.assertThrows(UnexpectedStateException.class, () -> {
//            modeActivation(null, ARBITRARY_ID, ARBITRARY_STATUS);
//        });
//
//        Assertions.assertEquals(EXPECTED_MSG, thrown.getMessage());
//    }
//
//    @Test
//    void modeActivation_id_not_found() {
//
//        UnexpectedStateException thrown = Assertions.assertThrows(UnexpectedStateException.class, () -> {
//            modeActivation(new AnchorPane(), ARBITRARY_ID, ARBITRARY_STATUS);
//        });
//
//        Assertions.assertEquals(EXPECTED_MSG, thrown.getMessage());
//    }
//
//}
