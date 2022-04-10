package memories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle the memento (DTO file)
 * keepStatusUpdated keep the memory ready to be saved
 * when save is called all the history is provided
 */
public class ResultOriginator {

    List<ScreenDisplayDTO> mementos = new ArrayList<>();

    public void keepStatusUpdated(ScreenDisplayDTO result) { mementos.add(result); }

    public void save(File fileToMemorize) throws FileNotFoundException {
        if (fileToMemorize != null) {
            PrintWriter writer = new PrintWriter(fileToMemorize);
            for (ScreenDisplayDTO s : mementos)
                writer.println(s.toString());

            writer.close();
        }
    }

    public void cleanMementos() {
        mementos.clear();
    }

}
