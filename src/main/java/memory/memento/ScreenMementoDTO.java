package memory.memento;

import java.io.Serializable;

import static common.Configuration.EXPRESSION_SEPARATOR;

/**
 * Memento DTO (data transfer object) class with marshalling capabilities
 */
public class ScreenMementoDTO implements Serializable {

    private final String expression;
    private final String result;

    public ScreenMementoDTO(String exp, String res) {
        expression = exp;
        result = res;
    }

    public static ScreenMementoDTO marshaller(String res) {
        String[] tab = res.split(EXPRESSION_SEPARATOR);
        if (tab[0] != null && tab[1] != null)
            return new ScreenMementoDTO(tab[0], tab[1]);
        return null;
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
