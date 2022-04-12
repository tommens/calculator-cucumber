package memory.service;

import common.UnexpectedExpressionException;
import memory.memento.ResultOriginator;
import memory.memento.ScreenMementoDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Handle de Mementos.
 * Interface to the Memory mediator
 */
public interface MemoriesCareTaker {

    ResultOriginator stringResult = new ResultOriginator();
    MemoryMediator memoryMediator = new MemoryMediator();

    default void keepComponentValue(String expr, String res) {
        ScreenMementoDTO txt = new ScreenMementoDTO(expr, res);
        stringResult.keepStatusUpdated(txt);
        memoryMediator.addItem(txt);
    }

    default void loadCircularList(File memorized) throws IOException, UnexpectedExpressionException {
        memoryMediator.cleanCircularList();
        memoryMediator.retrieveCircularList(memorized);
    }

    default void saveToFile(File fileToMemorize) throws FileNotFoundException {
        memoryMediator.saveHistory(fileToMemorize);
    }

    default CircularLinkedListService history() {
        return memoryMediator.getNavigationListService();
    }

}
