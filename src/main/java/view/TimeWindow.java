package view;

import calculator.MyTime;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
        dp1.getEditor().setDisable(true); //removing text field to avoid errors in date writing
        Label optionalText1Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText1 = new TextField();
        optionalText1.setPromptText("HH(:MM:(SS)) (AM/PM)");
        Label optionalTimezone1Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone1ComboBox = new ComboBox<>();
        timezone1ComboBox.getItems().addAll("+00:00","+01:00","+02:00","+03:00","+04:00","+05:00","+06:00","+07:00",
                "+08:00","+09:00","+10:00","+11:00","+12:00","-01:00","-02:00","-03:00","-04:00","-05:00","-06:00","-07:00",
                "-08:00","-09:00","-10:00","-11:00","-12:00");

        Label textLabel2 = new Label("\nEnter a second date");
        DatePicker dp2 = new DatePicker();
        dp2.getEditor().setDisable(true); //removing text field to avoid errors in date writing
        Label optionalText2Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText2 = new TextField();
        optionalText2.setPromptText("HH(:MM:(SS)) (AM/PM)");
        Label optionalTimezone2Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone2ComboBox = new ComboBox<>();
        timezone2ComboBox.getItems().addAll("+00:00","+01:00","+02:00","+03:00","+04:00","+05:00","+06:00","+07:00",
                "+08:00","+09:00","+10:00","+11:00","+12:00","-01:00","-02:00","-03:00","-04:00","-05:00","-06:00","-07:00",
                "-08:00","-09:00","-10:00","-11:00","-12:00");

        Button durationButton = new Button("Get duration");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(tabPane, textLabel1, dp1,optionalText1Label, optionalText1, optionalTimezone1Label,
                timezone1ComboBox,textLabel2,dp2,optionalText2Label,optionalText2,optionalTimezone2Label,
                timezone2ComboBox,durationButton);

        Scene scene = new Scene(root, 400, 650);
        timeConversionStage.setScene(scene);
        timeConversionStage.show();

        //Displaying the time duration in days, hours, minutes, and seconds
        HBox timeNumbersBox = new HBox(3);
        timeNumbersBox.setAlignment(Pos.CENTER);
        Label numbersLabel = new Label("00   00   00   00");
        HBox timeLabelsBox = new HBox(3);
        timeLabelsBox.setAlignment(Pos.CENTER);
        Label textLabel = new Label("    days           hours       minutes      seconds");
        numbersLabel.getStyleClass().add("time-number");
        timeNumbersBox.getChildren().add(numbersLabel);
        timeLabelsBox.getChildren().add(textLabel);
        root.getChildren().addAll(timeNumbersBox,timeLabelsBox);

        //Label to put text in case of errors
        Label errorLabel = new Label("");
        root.getChildren().add(errorLabel);
        errorLabel.getStyleClass().add("time-error");

        //Time computation
        durationButton.setOnAction(event -> {
            String currentDate1,currentDate2 = LocalDate.now().toString();
            String currentTime1, currentTime2 = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
            String timezone1,timezone2 = "+00:00";
            String timeFormat1, timeFormat2 = null;
            errorLabel.setText(""); //clearing potential previous errors
            //Checking if we have at least one date (if we have just 1, the other is set to the current date)
            if (dp2.getValue()==null && dp1.getValue()==null) {
                errorLabel.setText("Error : please provide the date to subtract");
            }
            else {
                if (dp1.getValue() == null && dp2.getValue() != null) {
                    currentDate2 = dp2.getValue().toString();
                } else if (dp1.getValue() != null && dp2.getValue() == null) {
                    currentDate1 = dp1.getValue().toString();
                } else {
                    currentDate1 = dp1.getValue().toString();
                    currentDate2 = dp2.getValue().toString();
                }

                //evaluating the optional fields

                MyTime time1 = new MyTime(optionalText1.getText());
                MyTime time2 = new MyTime(optionalText2.getText());

                /*
                String timeProvided1 = optionalText1.getText();
                String timeProvided2 = optionalText2.getText();
                if (timeProvided1.matches("\\d{2}(:\\d{2}(:\\d{2}))?")) {
                    if (timeProvided1.length() == 2) {
                        //We add :00 at the end of the String if no seconds were provided
                        currentTime1 = timeProvided1 + ":00:00";
                    } else if (timeProvided1.length() == 2) {
                        currentTime1 = timeProvided1 + ":00";
                    }
                    else {
                        currentTime1 = timeProvided1;
                    }
                }*/
            }
        });

        // Applying the CSS styles
        scene.getStylesheets().add("view/style.css");
    }
}
