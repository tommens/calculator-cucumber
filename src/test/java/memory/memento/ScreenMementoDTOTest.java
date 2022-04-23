package memory.memento;

import gui.common.UnexpectedExpressionException;
import org.junit.jupiter.api.Test;
import static gui.common.Configuration.ERROR_MSG_RESULT_STRUCTURE;
import static gui.common.Configuration.EXPRESSION_SEPARATOR;
import static memory.memento.ScreenMementoDTO.marshaller;
import static org.junit.jupiter.api.Assertions.*;

class ScreenMementoDTOTest {

    @Test
    void marshaller_happy_case() {
        ScreenMementoDTO dto = new ScreenMementoDTO("0", "0");
        try {
            dto = marshaller("1 + 1" + EXPRESSION_SEPARATOR + "2");
        } catch (UnexpectedExpressionException e) {
            fail();
        }

        assertEquals(dto.getExpression(), "1 + 1");
        assertEquals(dto.getResult(), "2");
    }

    @Test
    void marshaller_throws_exception() {
        UnexpectedExpressionException thrown = assertThrows(UnexpectedExpressionException.class, () -> {
            marshaller("123");
        });

        assertEquals(ERROR_MSG_RESULT_STRUCTURE, thrown.getMessage());
    }

}
