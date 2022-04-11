package memory.memento;

import common.UnexpectedExpressionException;
import org.junit.jupiter.api.Test;

import static common.Configuration.ERROR_MSG_RESULT_STRUCTURE;
import static common.Configuration.EXPRESSION_SEPARATOR;
import static memory.memento.ScreenMementoDTO.marshaller;
import static org.junit.jupiter.api.Assertions.*;

class ScreenMementoDTOTest {

    @Test
    void marshaller_happy() {
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
    void marshaller_not_happy() {
        UnexpectedExpressionException thrown = assertThrows(UnexpectedExpressionException.class, () -> {
            marshaller("123");
        });

        assertEquals(ERROR_MSG_RESULT_STRUCTURE, thrown.getMessage());
    }

}
