package view;

import calculator.MyRealNumber;
import calculator.MyTime;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TimeWindow {
    public static void displayTimeWindow(){
        // ------------------------------------------ FIRST TAB ----------------------------------------------
        Stage timeConversionStage = new Stage();
        timeConversionStage.setTitle("Time computation");

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Duration between dates");
        VBox tab1Content = new VBox(new Label("Gives the duration between two dates."));


        //First date label and datepicker
        Label textLabel1 = new Label("Enter a first date");
        DatePicker dp1 = new DatePicker();
        dp1.getEditor().setDisable(true); //removing text field to avoid errors in date writing

        //Time label and textfield
        Label optionalText1Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText1 = new TextField();
        optionalText1.setPromptText("HH(:MM:(SS)) (AM/PM)");

        //Timezone label and combobox
        Label optionalTimezone1Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone1ComboBox = new ComboBox<>();
        timezone1ComboBox.getItems().addAll("+00:00","+01:00","+02:00","+03:00","+04:00","+05:00","+06:00","+07:00",
                "+08:00","+09:00","+10:00","+11:00","+12:00","-01:00","-02:00","-03:00","-04:00","-05:00","-06:00","-07:00",
                "-08:00","-09:00","-10:00","-11:00","-12:00");

        //Second date label and datepicker
        Label textLabel2 = new Label("\nEnter a second date");
        DatePicker dp2 = new DatePicker();
        dp2.getEditor().setDisable(true); //removing text field to avoid errors in date writing

        //Time label and textfield
        Label optionalText2Label = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText2 = new TextField();
        optionalText2.setPromptText("HH(:MM:(SS)) (AM/PM)");

        //Timezone label and combobox
        Label optionalTimezone2Label = new Label("Optional : select a timezone");
        ComboBox<String> timezone2ComboBox = new ComboBox<>();
        timezone2ComboBox.getItems().addAll("+00:00","+01:00","+02:00","+03:00","+04:00","+05:00","+06:00","+07:00",
                "+08:00","+09:00","+10:00","+11:00","+12:00","-01:00","-02:00","-03:00","-04:00","-05:00","-06:00","-07:00",
                "-08:00","-09:00","-10:00","-11:00","-12:00");

        //Duration button
        Button durationButton = new Button("Get duration");

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

        //Label to put additional time informations
        Label additionalLabel = new Label("");

        //Label to put text in case of errors
        Label errorLabel = new Label("");
        errorLabel.getStyleClass().add("time-error");

        //Adding everything
        VBox root1 = new VBox(10);
        root1.setPadding(new Insets(10));
        root1.getChildren().addAll(textLabel1, dp1, optionalText1Label, optionalText1, optionalTimezone1Label,
                timezone1ComboBox, textLabel2, dp2, optionalText2Label, optionalText2, optionalTimezone2Label,
                timezone2ComboBox, durationButton, timeNumbersBox, timeLabelsBox, additionalLabel,errorLabel);
        tab1Content.getChildren().add(root1);
        tab1.setContent(tab1Content);

        //Time computation
        durationButton.setOnAction(event -> {
            String time1String="",time2String="";//we will pass these strings as arguments for MyTime constructor
            String currentDate1= LocalDate.now().toString(),currentDate2 = LocalDate.now().toString();
            String currentTime1 = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
            String currentTime2 = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
            String timezone1= "+00:00",timezone2 = "+00:00";
            String timeFormat1= null, timeFormat2 = null;
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
                time1String += " " + currentDate1;
                time2String += " " + currentDate2;

                //evaluating the optional fields
                String[] inputParts1 = optionalText1.getText().split(" ");
                for (String part : inputParts1) {
                    if (part.matches("\\d{2}(:\\d{2}(:\\d{2}))?") && !part.startsWith("+") && !part.startsWith("-")) {
                        if (part.length() == 2) {
                            //We add :00:00 at the end of the String if no seconds nor minutes were provided
                            currentTime1 = part + ":00:00";
                        } else if (part.length() == 5) {
                            //We add :00 at the end of the String if no seconds were provided
                            currentTime1 = part + ":00";
                        } else {
                            currentTime1 = part;
                        }
                    }//Changing the time format depending on what was provided
                    else if (part.matches("(?i)am|pm")) {
                        timeFormat1 = part.toUpperCase();
                    }
                }
                String[] inputParts2 = optionalText2.getText().split(" ");
                for (String part : inputParts2) {
                    if (part.matches("\\d{2}(:\\d{2}(:\\d{2}))?") && !part.startsWith("+") && !part.startsWith("-")) {
                        if (part.length() == 2) {
                            //We add :00:00 at the end of the String if no seconds nor minutes were provided
                            currentTime2 = part + ":00:00";
                        } else if (part.length() == 5) {
                            //We add :00 at the end of the String if no seconds were provided
                            currentTime2 = part + ":00";
                        } else {
                            currentTime2 = part;
                        }
                    }//Changing the time format depending on what was provided
                    else if (part.matches("(?i)am|pm")) {
                        timeFormat2 = part.toUpperCase();
                    }
                }

                time1String += " " + currentTime1 + " " + timeFormat1;
                time2String += " " + currentTime2 + " " + timeFormat2;

                if (timezone1ComboBox.getValue() != null) {
                    timezone1 = timezone1ComboBox.getValue();
                }
                if (timezone2ComboBox.getValue() != null) {
                    timezone2 = timezone2ComboBox.getValue();
                }

                time1String += " " + timezone1;
                time2String += " " + timezone2;

                //Putting all together
                MyTime myTime1 = null, myTime2 = null;
                try {
                    myTime1 = new MyTime(time1String);
                } catch (DateTimeParseException e) {
                    errorLabel.setText("Please enter a valid first time");
                }
                try {
                    myTime2 = new MyTime(time2String);
                } catch (DateTimeParseException e) {
                    errorLabel.setText("Please enter a valid second time");
                }
                if (myTime1 != null && myTime2 != null) {
                    long[] durations = myTime1.subtractGUI(myTime2);
                    numbersLabel.setText(durations[0] + "   " + durations[1] + "   " + durations[2] + "   " + durations[3]);
                    additionalLabel.setText("Or " + durations[4] + " hours / " + durations[5] + " minutes / " + durations[6]
                            + " seconds");
                }
            }
        });
        // --------------------------------------- END OF FIRST TAB ----------------------------------------------
        // ------------------------------------------- SECOND TAB ------------------------------------------------
        //Unfortunately, you can't add a same object to two different tabs, so I had to duplicate a lot of code
        //First date label and datepicker
        Label textLabel1Copy = new Label("Enter a first date");
        DatePicker dp1Copy = new DatePicker();
        dp1Copy.getEditor().setDisable(true); //removing text field to avoid errors in date writing

        //Time label and textfield
        Label optionalText1LabelCopy = new Label("Optional : enter a time, accepted formats are HH:(MM):(SS) (AM/PM))");
        TextField optionalText1Copy = new TextField();
        optionalText1Copy.setPromptText("HH(:MM:(SS)) (AM/PM)");

        //Timezone label and combobox
        Label optionalTimezone1LabelCopy = new Label("Optional : select a timezone");
        ComboBox<String> timezone1ComboBoxCopy = new ComboBox<>();
        timezone1ComboBoxCopy.getItems().addAll("+00:00","+01:00","+02:00","+03:00","+04:00","+05:00","+06:00","+07:00",
                "+08:00","+09:00","+10:00","+11:00","+12:00","-01:00","-02:00","-03:00","-04:00","-05:00","-06:00","-07:00",
                "-08:00","-09:00","-10:00","-11:00","-12:00");

        //textfield for the number to add
        Label numberFieldLabel = new Label("\nThen, enter a value and select its type (put a - to subtract a value) :");
        TextField numberField = new TextField();
        //ComboBox to hold the value type
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("seconds", "minutes", "hours","days");
        typeComboBox.setValue("seconds"); //setting default value
        HBox numberBox = new HBox(10);
        numberBox.getChildren().addAll(numberField, typeComboBox);

        //Evaluation button
        Button evaluationButton = new Button("Evaluate");

        //Label to put the result
        Label resultLabel = new Label("");

        //Label to put text in case of errors
        Label errorLabelCopy = new Label("");
        errorLabel.getStyleClass().add("time-error");
        errorLabelCopy.getStyleClass().add("time-error");

        Tab tab2 = new Tab("Adding seconds to date");
        VBox tab2Content = new VBox(new Label("Input : a date and a number of seconds."));
        VBox root2 = new VBox(10);
        root2.setPadding(new Insets(10));
        root2.getChildren().addAll(textLabel1Copy, dp1Copy, optionalText1LabelCopy, optionalText1Copy,
                optionalTimezone1LabelCopy, timezone1ComboBoxCopy,numberFieldLabel,numberBox,evaluationButton,
                resultLabel,errorLabelCopy);
        tab2Content.getChildren().addAll(root2);
        tab2.setContent(tab2Content);

        //Time computation
        evaluationButton.setOnAction(event -> {
            resultLabel.setText(""); //Clearing potential previous result
            MyRealNumber value = null;
            try {
                value = new MyRealNumber(numberField.getText());
            } catch (NumberFormatException | NullPointerException e) {
                errorLabelCopy.setText("Please provide a valid number");
            }
            String time1String="";//we will pass these strings as arguments for MyTime constructor
            String currentDate1= LocalDate.now().toString();
            String currentTime1 = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
            String timezone1= "+00:00";
            String timeFormat1= null;
            errorLabelCopy.setText(""); //clearing potential previous errors

            if (dp1Copy.getValue() != null) {
                currentDate1 = dp1Copy.getValue().toString();
            }
            time1String += " " + currentDate1;
            //evaluating the optional fieds
            String[] inputParts1 = optionalText1Copy.getText().split(" ");
            for (String part : inputParts1) {
                if (part.matches("\\d{2}(:\\d{2}(:\\d{2}))?") && !part.startsWith("+") && !part.startsWith("-")) {
                    if (part.length() == 2) {
                        //We add :00:00 at the end of the String if no seconds nor minutes were provided
                        currentTime1 = part + ":00:00";
                    } else if (part.length() == 5) {
                        //We add :00 at the end of the String if no seconds were provided
                        currentTime1 = part + ":00";
                    } else {
                        currentTime1 = part;
                    }
                }//Changing the time format depending on what was provided
                else if (part.matches("(?i)am|pm")) {
                    timeFormat1 = part.toUpperCase();
                }
            }
            time1String += " " + currentTime1 + " " + timeFormat1;

            if (timezone1ComboBoxCopy.getValue() != null) {
                timezone1 = timezone1ComboBoxCopy.getValue();
            }
            time1String += " " + timezone1;

            //Putting all together
            MyTime myTime1 = null;
            try {
                myTime1 = new MyTime(time1String);
            } catch (DateTimeParseException e) {
                errorLabel.setText("Please enter a valid first time");
            }
            if (myTime1 != null) {
                MyTime result;
                try {
                    result = switch (typeComboBox.getValue()) {
                        default -> myTime1.add(value);
                        case "minutes" ->
                                myTime1.add(new MyRealNumber(value.getRealNumber().multiply(new BigDecimal("60.0")).toString()));
                        case "hours" ->
                                myTime1.add(new MyRealNumber(value.getRealNumber().multiply(new BigDecimal("3600.0")).toString()));
                        case "days" ->
                                myTime1.add(new MyRealNumber(value.getRealNumber().multiply(new BigDecimal("86400.0")).toString()));
                    };
                    System.out.println(result.getDate());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    resultLabel.setText(result.getDate().format(formatter));
                } catch (NullPointerException e) {
                    errorLabelCopy.setText("Please provide a valid number");
                }
            }
        });





        tabPane.getTabs().addAll(tab1, tab2);
        Scene scene = new Scene(tabPane, 400, 650);
        timeConversionStage.setScene(scene);
        timeConversionStage.show();

        // Applying the CSS styles
        scene.getStylesheets().add("view/style.css");
    }
}
