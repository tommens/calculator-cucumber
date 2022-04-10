package memories;

public class ScreenDisplayDTO {

    private final static String SEPARATOR = " = ";
    private final String expression;
    private final String result;

    public ScreenDisplayDTO(String exp, String res) {
        expression = exp;
        result = res;
    }

    public static ScreenDisplayDTO marshaller(String res) {
        String[] tab = res.split(SEPARATOR);
        if (tab[0] != null && tab[1] != null)
            return new ScreenDisplayDTO(tab[0], tab[1]);
        return null;
    }

    @Override
    public String toString() {
        return expression+SEPARATOR+result;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

}
