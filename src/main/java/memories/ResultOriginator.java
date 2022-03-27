package memories;

public class ResultOriginator {

    String currentText;

    public void keepStatusUpdated(String result) { this.currentText = result; }
    public ResultMemento save() {
        return new ResultMemento(currentText);
    }

}
