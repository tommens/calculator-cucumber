package view;

import javafx.scene.control.Label;

public class ExpressionLabel extends Label {

    private static ExpressionLabel instance;

    private ExpressionLabel(){
        getStyleClass().add("expression-label");
    }

    public static ExpressionLabel getInstance(){
        if (instance == null)
            instance = new ExpressionLabel();
        return instance;
    }

    /**
     * This method is used to modify the display of the calculator.
     * @param toAdd The string to add to the display.
     */
    public void updateText(String toAdd){
        setText(getText() + toAdd);
    }

    public void shortenText(int nbCharToRemove) {
        if(getText().length() > 0)
            setText(getText().substring(0, getText().length() - nbCharToRemove));
    }
}

