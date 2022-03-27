package memories;

import java.util.ArrayList;
import java.util.List;

import static common.Configuration.OPERATION_MEMORY_SIZE;

/**
 * Handle de Mementos.
 * HistoryLeft contains the mementos they are saved when a calculation is done.
 * HistoryRight receive the mementos when user navigate (undo / redo)
 * As the two histories are Stacks they are both open like books.
 * NB : Only historyLeft is growing during each save.
 *
 */
public interface MemoriesCareTaker {

    ResultOriginator stringResult = new ResultOriginator();
    List<ResultMemento> history = new ArrayList<>();

    default void keepComponentValue(String text) {
        stringResult.keepStatusUpdated(text);
        if (history.size() >= OPERATION_MEMORY_SIZE) {
            history.remove(0);
            keepComponentValue(text);
        }
        history.add(stringResult.save());
    }

}
