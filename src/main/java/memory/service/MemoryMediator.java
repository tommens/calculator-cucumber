package memory.service;

import common.UnexpectedExpressionException;
import memory.CircularLinkedList;
import memory.memento.ResultOriginator;
import memory.memento.ScreenMementoDTO;

import java.io.*;

import static memory.memento.ScreenMementoDTO.marshaller;

/**
 * Provide from static context a circular list with following functionalities :
 * - retrieveCircularList read a file to handle it's CircularLinkedList content
 * - saveCircularList save the CircularLinkedList content to a file
 * - emptyCircularList make a clean
 * - getCircularListFromLastItem give the last saved value
 */
public abstract class MemoryMediator {

    private static CircularLinkedListService circularList;
    private static final ResultOriginator mementoOriginator;

    private MemoryMediator(){}

    static {
        circularList = getServiceInstance();
        mementoOriginator = new ResultOriginator();
    }

    static CircularLinkedList getCurrent() {
        if (circularList != null && circularList.getCurrent() != null)
            return circularList.getCurrent();
        return null;
    }

    static void navigateLeft() {
        circularList.navigateLeft();
    }

    static void navigateRight() {
        circularList.navigateRight();
    }

    static void addItem(ScreenMementoDTO val) {
        circularList.addNode(val);
        mementoOriginator.keepStatusUpdated(val);
    }

    static void cleanCircularList() {
        circularList.clean();
    }

    static CircularLinkedList getCircularListFromLastItem() {
        if (circularList != null)
            return circularList.getTail();
        else
            return null;
    }

    static void retrieveCircularList(File memorized) throws IOException, UnexpectedExpressionException {
        cleanCircularList();
        String memorizedLine;

        if(memorized != null){

            BufferedReader reader = new BufferedReader(new FileReader(memorized));
            while ((memorizedLine = reader.readLine()) != null)
                addItem(marshaller(memorizedLine));
        }
    }

    static void saveHistory(File fileToMemorize) throws FileNotFoundException {
        mementoOriginator.save(fileToMemorize);
    }

    static CircularLinkedListService getServiceInstance() {
        if (circularList == null) circularList = new CircularLinkedListService();
        return circularList;
    }

}
