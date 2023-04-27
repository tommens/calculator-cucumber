package view;

import javafx.scene.control.TextField;

public class ExpressionTextField extends TextField {

    private static ExpressionTextField instance;

    private ExpressionTextField() {
        setPrefWidth(Integer.MAX_VALUE);
        getStyleClass().add("expression-label");
    }

    public static ExpressionTextField getInstance() {
        if (instance == null)
            instance = new ExpressionTextField();
        return instance;
    }

    /**
     * This method is used to modify the display of the calculator.
     *
     * @param toAdd The string to add to the display.
     */
    public void updateText(String toAdd) {
        setText(getText() + toAdd);
    }

    public void shortenText(int nbCharToRemove) {
        if (getText().length() > 0)
            setText(getText().substring(0, getText().length() - nbCharToRemove));
    }
}

