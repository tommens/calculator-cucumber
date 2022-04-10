package memories.navigation;

import static java.lang.Integer.valueOf;
import static memories.navigation.CircularListMediator.*;
import static org.junit.jupiter.api.Assertions.*;

import memories.ScreenDisplayDTO;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CircularLinkedListTest {

    private final CircularLinkedListService CL_SERVICE = getServiceInstance();
    private final ScreenDisplayDTO ONE_FIRST_VALUE = new ScreenDisplayDTO("1","1");
    private final ScreenDisplayDTO SECOND_VALUE = new ScreenDisplayDTO("2","2");
    private final ScreenDisplayDTO THIRD_VALUE = new ScreenDisplayDTO("3","3");

    @Test
    @Order(1)
    void setUp() {
        cleanCircularList();
    }

    @Test
    @Order(2)
    public void add_first_node() {
        assertEquals(CL_SERVICE.getLength(), 0);
        addItem(ONE_FIRST_VALUE);
        assertEquals(CL_SERVICE.getLength(), 1);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), head.getNext().getValue(), tail.getValue());
        assertEquals(head.getIndex(), valueOf(ONE_FIRST_VALUE.getResult()));

    }

    @Test
    @Order(3)
    public void add_second_node() {
        assertEquals(CL_SERVICE.getLength(), 1);
        addItem(SECOND_VALUE);
        assertEquals(CL_SERVICE.getLength(), 2);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), tail.getNext().getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), head.getNext().getValue(), SECOND_VALUE.toString());
        assertEquals(tail.getIndex(), valueOf(SECOND_VALUE.getResult()));

    }

    @Test
    @Order(4)
    public void add_third_node() {
        assertEquals(CL_SERVICE.getLength(), 2);
        addItem(THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), 3);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), THIRD_VALUE.toString());
        assertEquals(tail.getIndex(), valueOf(THIRD_VALUE.getResult()));
        assertEquals(tail.getPrevious().getValue(), SECOND_VALUE.toString());
        assertEquals(head.getNext().getValue(), SECOND_VALUE.toString());

    }

    @Test
    @Order(5)
    public void add_last_node() {
        ScreenDisplayDTO LAST_VALUE = new ScreenDisplayDTO("4","4");
        assertEquals(CL_SERVICE.getLength(), 3);
        addItem(LAST_VALUE);
        assertEquals(CL_SERVICE.getLength(), 4);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), LAST_VALUE.toString());
        assertEquals(tail.getPrevious().getValue(), THIRD_VALUE.toString());
        assertEquals(head.getNext().getValue(), SECOND_VALUE.toString());

    }

}