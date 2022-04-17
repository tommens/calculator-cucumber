package memory.service;

import common.UnexpectedExpressionException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static common.Configuration.EXPRESSION_SEPARATOR;
import static java.nio.file.Files.delete;
import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Path.of;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemoriesCareTakerTest implements MemoriesCareTaker {

    private final String PROVIDED_EXP_1 = "1+1";
    private final String PROVIDED_RES_1 = "2";
    private final String EXPECTED_EXPRESSION_1 = PROVIDED_EXP_1 +EXPRESSION_SEPARATOR+ PROVIDED_RES_1;

    private final String PROVIDED_EXP_2 = "2+2";
    private final String PROVIDED_RES_2 = "4";
    private final String EXPECTED_EXPRESSION_2 = PROVIDED_EXP_2 +EXPRESSION_SEPARATOR+ PROVIDED_RES_2;

    private final String EXPECTED_LN = "\n";
    private final String PATH_TO_SAVE = "src/test/resources/file_to_save.txt";

    @Test
    @Order(1)
    void keepComponent_happy_case_1() {
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 0);
        keepComponentValue(PROVIDED_EXP_1, PROVIDED_RES_1);
        assertEquals(stringResult.getMementoContent().toString(), EXPECTED_EXPRESSION_1 +EXPECTED_LN);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
        assertEquals(memoryMediator.getCircularListFromLastItem().getValue(), EXPECTED_EXPRESSION_1);
    }

    @Test
    @Order(2)
    void keepComponent_nullExp() {
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
        keepComponentValue(null, PROVIDED_RES_2);
        assertEquals(stringResult.getMementoContent().toString(), EXPECTED_EXPRESSION_1 +EXPECTED_LN);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
    }

    @Test
    @Order(3)
    void keepComponent_nullRes() {
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
        keepComponentValue(PROVIDED_EXP_2, null);
        assertEquals(stringResult.getMementoContent().toString(), EXPECTED_EXPRESSION_1 +EXPECTED_LN);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
    }

    @Test
    @Order(4)
    void keepComponent_happy_case_2() {
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 1);
        keepComponentValue(PROVIDED_EXP_2, PROVIDED_RES_2);
        assertEquals(stringResult.getMementoContent().toString(), EXPECTED_EXPRESSION_1+EXPECTED_LN+EXPECTED_EXPRESSION_2+EXPECTED_LN);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 2);
        assertEquals(memoryMediator.getCircularListFromLastItem().getValue(), EXPECTED_EXPRESSION_2);
    }

    @Test
    @Order(5)
    void loadCircularList_null() throws UnexpectedExpressionException, IOException {
        loadCircularList(null);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().size(), 2);
        assertEquals(memoryMediator.getCircularListFromLastItem().getValue(), EXPECTED_EXPRESSION_2);
    }

    @Test
    @Order(6)
    void loadMemory_happy_case() {
        String res = loadMemory();
        assertEquals(res, EXPECTED_EXPRESSION_1+EXPECTED_LN+EXPECTED_EXPRESSION_2+EXPECTED_LN);
    }

    @Test
    @Order(7)
    void save_content() {
        File file_to_save = new File(PATH_TO_SAVE);
        try {
            saveToFile(file_to_save);
            BufferedReader read = newBufferedReader(of(PATH_TO_SAVE));
            assertEquals(read.readLine(), EXPECTED_EXPRESSION_1);
            assertEquals(read.readLine(), EXPECTED_EXPRESSION_2);
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException");
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    @Order(8)
    void retrieve_content() throws UnexpectedExpressionException, IOException {
        memoryMediator.cleanCircularList();
        memoryMediator.getMementoOriginator().cleanMemento();
        File saved_file = new File(PATH_TO_SAVE);
        memoryMediator.retrieveCircularList(saved_file);
        assertEquals(memoryMediator.getMementoOriginator().getMementos().get(0).toString(), EXPECTED_EXPRESSION_1);
        assertTrue(memoryMediator.getNavigationListService().containsValue(EXPECTED_EXPRESSION_1));
        delete(of(PATH_TO_SAVE));
    }

}