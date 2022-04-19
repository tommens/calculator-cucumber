package memory.memento;

import common.UnexpectedExpressionException;

import java.io.Serial;
import java.io.Serializable;
import static common.Configuration.*;

/**
 * Memento DTO (data transfer object) class with marshalling capabilities
 */
public class ScreenMementoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;
    private final String expression;
    private final String result;

    public ScreenMementoDTO(String exp, String res) {
        expression = exp;
        result = res;
    }

    public static ScreenMementoDTO marshaller(String res) throws UnexpectedExpressionException {
        String[] tab = res.split(EXPRESSION_SEPARATOR);
        ScreenMementoDTO dto;

        try {
            dto = new ScreenMementoDTO(tab[0], tab[1]);
        } catch (IndexOutOfBoundsException e) {
            throw new UnexpectedExpressionException(ERROR_MSG_RESULT_STRUCTURE);
        }

        return dto;
    }

    @Override
    public String toString() {
        return expression+ EXPRESSION_SEPARATOR +result;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

}
