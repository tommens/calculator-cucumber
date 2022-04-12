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

    private final CircularLinkedListService navigationListService;
    private final ResultOriginator mementoOriginator;

    MemoryMediator(){
        navigationListService = new CircularLinkedListService();
        mementoOriginator = new ResultOriginator();
    }

    public CircularLinkedListService getNavigationListService() {
        return navigationListService;
    }

    void addItem(ScreenMementoDTO val) {
        navigationListService.addNode(val);
        mementoOriginator.keepStatusUpdated(val);
    }

    void cleanCircularList() {
        navigationListService.clean();
    }

    CircularLinkedList getCircularListFromLastItem() {
        if (navigationListService != null)
            return navigationListService.getTail();
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

}
