package memories.navigation;

import memories.ResultOriginator;
import memories.ScreenDisplayDTO;

import java.io.*;

import static memories.ScreenDisplayDTO.marshaller;

/**
 * Provide from static context a circular list with following functionalities :
 * - retrieveCircularList read a file to handle it's CircularLinkedList content
 * - saveCircularList save the CircularLinkedList content to a file
 * - emptyCircularList make a clean
 * - getCircularListFromLastItem give the last saved value
 */
public abstract class CircularListFacade {

    private static CircularLinkedListService circularList;
    private static final ResultOriginator mementoOriginator;

    private CircularListFacade(){}

    static {
        circularList = getServiceInstance();
        mementoOriginator = new ResultOriginator();
    }

    public static CircularLinkedList getCurrent() {
        if (circularList != null && circularList.getCurrent() != null)
            return circularList.getCurrent();
        return null;
    }

    public static void navigateLeft() {
        circularList.navigateLeft();
    }

    public static void navigateRight() {
        circularList.navigateRight();
    }

    public static void addItem(ScreenDisplayDTO val) {
        circularList.addNode(val);
        mementoOriginator.keepStatusUpdated(val);
    }

    public static void cleanCircularList() {
        circularList.clean();
    }

    public static CircularLinkedList getCircularListFromLastItem() {
        if (circularList != null)
            return circularList.getTail();
        else
            return null;
    }

    public static void retrieveCircularList(File memorized) throws IOException {
        cleanCircularList();
        String memorizedLine;

        if(memorized != null){

            BufferedReader reader = new BufferedReader(new FileReader(memorized));
            while ((memorizedLine = reader.readLine()) != null)
                addItem(marshaller(memorizedLine));
        }
    }

    public static void saveHistory(File fileToMemorize) throws FileNotFoundException {
        mementoOriginator.save(fileToMemorize);
    }

    static CircularLinkedListService getServiceInstance() {
        if (circularList == null) circularList = new CircularLinkedListService();
        return circularList;
    }

}
