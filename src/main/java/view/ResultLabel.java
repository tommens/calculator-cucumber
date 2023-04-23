package view;

import javafx.scene.control.Label;

public class ResultLabel extends Label {

    private static ResultLabel instance;
    private ResultLabel(){
        getStyleClass().add("result-label");
    }

    public static ResultLabel getInstance(){
        if (instance == null)
            instance = new ResultLabel();
        return instance;
    }

}