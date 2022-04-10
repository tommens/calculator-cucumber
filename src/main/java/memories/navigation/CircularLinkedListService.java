package memories.navigation;

import memories.ScreenDisplayDTO;

/**
 * A circular list service
 * accessed by CircularListFacade implementation, eventually (package scope)
 * provide some high level functionalities over circular linked node's list
 */
class CircularLinkedListService {

    private static CircularLinkedList head;
    private static CircularLinkedList current;
    private static CircularLinkedList tail;
    private static int length;

    /**
     * Access point to the linked nodes list
     * @return CircularLinkedList
     */
    CircularLinkedList getCurrent() {
        return current;
    }

    void navigateLeft() {
        if (current != null) current = current.getPrevious();
    }

    void navigateRight() {
        if (current != null) current = current.getNext();
    }

    void addNode(ScreenDisplayDTO value) {
        if (value == null) return;
        CircularLinkedList newNode;

        if (head == null) {
            newNode = new CircularLinkedList(value, 1);
            head = newNode;
        } else {
            newNode = new CircularLinkedList(value, tail.getIndex()+1);
            head.setPrevious(newNode);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }

        tail = newNode;
        tail.setNext(head);
        current = tail;
        length += 1;
    }

    boolean containsValue(String value) {
        if (head == null) return false;
        else return search(value, head);
    }

    void clean() {
        length = 0;
        head = null;
        tail = null;
        current = null;
    }

    int getLength() {
        return length;
    }

    CircularLinkedList getTail() {
        return tail;
    }

    CircularLinkedList getHead() {
        return head;
    }

    private boolean search(String value, CircularLinkedList nodeCursor) {
        do {
            if (nodeCursor.getValue().equals(value))
                return true;

            nodeCursor = nodeCursor.getNext();
        } while (nodeCursor != head);

        return false;
    }

}
