package memories;

public class ResultMemento {

    private final String result;

    public ResultMemento(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}
