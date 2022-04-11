package memory.service;

import common.UnexpectedExpressionException;
import memory.CircularLinkedList;
import memory.memento.ResultOriginator;
import memory.memento.ScreenMementoDTO;

import java.io.*;

import static memory.memento.ScreenMementoDTO.marshaller;

/**
 * Provide circular list following functionalities :
 * - Navigation (public scope)
 * - retrieveCircularList read a file to handle it's CircularLinkedList content
 * - saveCircularList save the CircularLinkedList content to a file
 * - add and clean
 */
public class MemoryMediator {

    private CircularLinkedListService circularList;
    private final ResultOriginator mementoOriginator;

    MemoryMediator(){
        circularList = getServiceInstance();
        mementoOriginator = new ResultOriginator();
    }

    public void navigateLeft() {
        circularList.navigateLeft();
    }

    public void navigateRight() {
        circularList.navigateRight();
    }

    public void navigateLast() {
        circularList.navigateLast();
    }

    public void navigateFirst() {
        circularList.navigateFirst();
    }

    public CircularLinkedList getCurrentPosition() { return circularList.getCurrent(); }

    void addItem(ScreenMementoDTO val) {
        circularList.addNode(val);
        mementoOriginator.keepStatusUpdated(val);
    }

    void cleanCircularList() {
        circularList.clean();
    }

    CircularLinkedList getCircularListFromLastItem() {
        if (circularList != null)
            return circularList.getTail();
        else
            return null;
    }

    void retrieveCircularList(File memorized) throws IOException, UnexpectedExpressionException {
        cleanCircularList();
        String memorizedLine;

        if(memorized != null){

            BufferedReader reader = new BufferedReader(new FileReader(memorized));
            while ((memorizedLine = reader.readLine()) != null)
                addItem(marshaller(memorizedLine));
        }
    }

    void saveHistory(File fileToMemorize) throws FileNotFoundException {
        mementoOriginator.save(fileToMemorize);
    }

    CircularLinkedListService getServiceInstance() {
        if (circularList == null) circularList = new CircularLinkedListService();
        return circularList;
    }

}
