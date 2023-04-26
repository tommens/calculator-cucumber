package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TimeWindow {
    public static void displayTimeWindow(){

        Stage timeConversionStage = new Stage();
        timeConversionStage.setTitle("Time computation");

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Duration between dates");
        VBox tab1Content = new VBox(new Label("Gives the duration between two dates."));
        tab1.setContent(tab1Content);
        Tab tab2 = new Tab("Adding seconds to date", new Label("Input : a date and a number of seconds."));

        tabPane.getTabs().addAll(tab1, tab2);
        Label textLabel1 = new Label("Enter a first date");
        DatePicker dp1 = new DatePicker();
        Label optionalText1Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText1 = new TextField();
        optionalText1.setPromptText("HH:(MM):(SS) (AM/PM)");
        Label optionalTimezone1Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone1ComboBox = new ComboBox<>();
        timezone1ComboBox.getItems().addAll("+00","+01","+02","+03","+04","+05","+06","+07","+08","+09","+10","+11",
                "+12","-01","-02","-03","-04","-05","-06","-07","-08","-09","-10","-11","-12");

        Label textLabel2 = new Label("\nEnter a second date");
        DatePicker dp2 = new DatePicker();
        Label optionalText2Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText2 = new TextField();
        optionalText2.setPromptText("HH:(MM):(SS) (AM/PM)");
        Label optionalTimezone2Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone2ComboBox = new ComboBox<>();
        timezone2ComboBox.getItems().addAll("+00","+01","+02","+03","+04","+05","+06","+07","+08","+09","+10","+11",
                "+12","-01","-02","-03","-04","-05","-06","-07","-08","-09","-10","-11","-12");

        Label answer = new Label("");
        Button durationButton = new Button("Get duration");
        durationButton.setOnAction(event -> {

                });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(tabPane, textLabel1, dp1,optionalText1Label, optionalText1, optionalTimezone1Label,
                timezone1ComboBox,textLabel2,dp2,optionalText2Label,optionalText2,optionalTimezone2Label,
                timezone2ComboBox,answer);

        Scene scene = new Scene(root, 400, 650);
        timeConversionStage.setScene(scene);
        timeConversionStage.show();
    }
}
