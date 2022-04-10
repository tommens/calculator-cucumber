package memories.navigation;

import memories.ScreenDisplayDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static memories.navigation.CircularListMediator.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
class CircularListFacadeTest {

    private final CircularLinkedListService ACTUAL_EMBEDDED_VALUE_TO_TEST = getServiceInstance();

    private static final String EXPECTED_FIRST_SAVED_VALUE = "1+1 = 2";
    private static final String EXPECTED_SECOND_SAVED_VALUE = "2+2 = 4";
    private static final String EXPECTED_LAST_SAVED_VALUE = "4+4 = 8";
    private static final String EXPECTED_NOT_EXISTING_VALUE = "1+1 = 3";

    @BeforeEach
    void setUp() {
        // retrieveCircularList();
        cleanCircularList();
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenDisplayDTO("1+1", "2"));
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenDisplayDTO("2+2", "4"));
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenDisplayDTO("4+4", "8"));
    }

    @Test
    void retrieve_saved_datas_true() {
        assertTrue(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_FIRST_SAVED_VALUE));
        assertTrue(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_SECOND_SAVED_VALUE));
    }

    @Test
    void retrieve_saved_datas_false() {
        assertFalse(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_NOT_EXISTING_VALUE));
    }

    @Test
    void navigate_in_tha_list() {
        // retrieve circularList from Facade
        CircularLinkedList item = getCircularListFromLastItem();
        if (item == null) fail();

        // navigate like someone doing undo / redo
        assertEquals(item.getValue(), EXPECTED_LAST_SAVED_VALUE);
        assertEquals(item.getPrevious().getValue(), EXPECTED_SECOND_SAVED_VALUE);
        assertEquals(item.getPrevious().getPrevious().getValue(), EXPECTED_FIRST_SAVED_VALUE);
        assertEquals(item.getPrevious().getNext().getPrevious().getValue(), EXPECTED_SECOND_SAVED_VALUE);

        // check circularity of the list from right to left
        assertEquals(item.getValue(), item.getPrevious().getPrevious().getPrevious().getValue());

        // check circularity of the list from left to right
        assertEquals(item.getValue(), item.getNext().getNext().getNext().getValue());
    }

    @Test
    void create_new_empty_list() {
        cleanCircularList();
        assertFalse(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_FIRST_SAVED_VALUE));
    }

}