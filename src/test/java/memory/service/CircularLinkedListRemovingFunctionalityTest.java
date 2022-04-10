package memory.service;

import memory.CircularLinkedList;
import memory.memento.ScreenMementoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static common.Configuration.OPERATION_MEMORY_SIZE;
import static java.lang.String.valueOf;
import static memory.service.MemoryMediator.getServiceInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class CircularLinkedListRemovingFunctionalityTest {

    private final CircularLinkedListService CL_SERVICE = getServiceInstance();

    @BeforeEach
    void setUp() {
        CL_SERVICE.clean();
    }

    @Test
    void removeElement() {

        int OPERATION_MEMORY_SIZE = 3; //CONFIGURATION
        ScreenMementoDTO ONE_FIRST_VALUE = new ScreenMementoDTO("1","1");
        ScreenMementoDTO SECOND_VALUE = new ScreenMementoDTO("2","2");
        ScreenMementoDTO THIRD_VALUE = new ScreenMementoDTO("3","3");
        ScreenMementoDTO LAST_VALUE = new ScreenMementoDTO("4","4");

        CL_SERVICE.addNode(ONE_FIRST_VALUE);
        CL_SERVICE.addNode(SECOND_VALUE);
        CL_SERVICE.addNode(THIRD_VALUE);

        CircularLinkedList current = CL_SERVICE.getCurrent();
        assertEquals(current.getDTO(), THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), OPERATION_MEMORY_SIZE);

        CL_SERVICE.removeFormerNode();
        assertEquals(current.getDTO(), THIRD_VALUE);
        CL_SERVICE.addNode(LAST_VALUE);

        assertEquals(current.getDTO(), THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), OPERATION_MEMORY_SIZE);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head, tail.getNext());
        assertEquals(tail, head.getPrevious());

        assertEquals(head.getDTO(), SECOND_VALUE);
        assertEquals(tail.getDTO(), LAST_VALUE);

    }

    @Test
    void addExtraElement() {
        int extraElementIndex = OPERATION_MEMORY_SIZE+1;
        ScreenMementoDTO EXPECTED_HEAD_TO_BE_DELETED = new ScreenMementoDTO(valueOf(0),valueOf(0));
        ScreenMementoDTO EXPECTED_HEAD_AFTER_EXTRA_ADD = new ScreenMementoDTO(valueOf(1),valueOf(1));
        ScreenMementoDTO EXPECTED_TAIL_AFTER_EXTRA_ADD = new ScreenMementoDTO(valueOf(extraElementIndex), valueOf(extraElementIndex));

        for (int i=0; i < OPERATION_MEMORY_SIZE; i++)
            CL_SERVICE.addNode(new ScreenMementoDTO(valueOf(i), valueOf(i)));

        assertEquals(CL_SERVICE.getLength(), OPERATION_MEMORY_SIZE);
        assertTrue(CL_SERVICE.containsValue(EXPECTED_HEAD_TO_BE_DELETED.toString()));

        CL_SERVICE.addNode(EXPECTED_TAIL_AFTER_EXTRA_ADD);

        assertFalse(CL_SERVICE.containsValue(EXPECTED_HEAD_TO_BE_DELETED.toString()));

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getDTO().toString(), EXPECTED_HEAD_AFTER_EXTRA_ADD.toString());
        assertEquals(tail.getDTO(), EXPECTED_TAIL_AFTER_EXTRA_ADD);

    }

}
