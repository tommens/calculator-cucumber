package view;

import converter.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Objects;

public class ConversionWindow {
    public static void displayConversionWindow(){

        Stage unitConversionStage = new Stage();
        unitConversionStage.setTitle("Unit converter");
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        //We create a ComboBox to select the measurement type
        ComboBox<String> measurementComboBox = new ComboBox<>();
        measurementComboBox.getItems().addAll("Area", "Currency", "Energy", "Length",
                "Power", "Pressure", "Time");
        //measurementComboBox.setValue("Area"); // We set a default value
        root.getChildren().add(new Label("Measurement :"));
        root.getChildren().add(measurementComboBox);

        //Same to select the "from" unit and the "to" unit
        ComboBox<String> fromComboBox = new ComboBox<>();
        ComboBox<String> toComboBox = new ComboBox<>();
        root.getChildren().add(new Label("Convert from :"));
        //fromComboBox.getItems().setAll("m2","mm2","cm2","dm2","dam2","hm2","km2"); //default values
        root.getChildren().add(fromComboBox);
        root.getChildren().add(new Label("To :"));
        //toComboBox.getItems().setAll("m2","mm2","cm2","dm2","dam2","hm2","km2"); //same
        root.getChildren().add(toComboBox);

        //Entering required value to convert
        TextField valueTextField = new TextField();
        valueTextField.setPromptText("Enter value to convert");
        root.getChildren().add(new Label("Value :"));
        root.getChildren().add(valueTextField);
        double val = 0;
        
        //Zone where the conversion result is printed
        Label conversionResultLabel = new Label();
        root.getChildren().add(new Label(""));
        root.getChildren().add(conversionResultLabel);

        //Conversion button
        Button convertButton = new Button("Convert");
        var ref = new Object() {
            double finalVal = val;
        };
        convertButton.setOnAction(event -> {
            String fromUnit, toUnit;
            fromUnit = fromComboBox.getValue();
            toUnit = toComboBox.getValue();
            // Getting the name of the class from the measurement String
            String measurementName = measurementComboBox.getValue();
            if (fromUnit==null || toUnit==null || Objects.equals(measurementName, "")){
                conversionResultLabel.setText("Please select a measurement, an initial unit, " +
                        "a final unit and a value");
            }
            else {
                BigDecimal conversionResult = null;
                //Catching exception if the entered value is incorrect
                if (!Objects.equals(valueTextField.getText(), "")) {
                    try {
                        ref.finalVal = Double.parseDouble(valueTextField.getText());
                    } catch (NumberFormatException e) {
                        valueTextField.setText("Please enter a valid number (use . as comma)");
                        conversionResultLabel.setText("");
                    }
                }
                switch (measurementName) {
                    case "Area" -> conversionResult = Area.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Currency" -> conversionResult = Currency.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Energy" -> conversionResult = Energy.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Length" -> conversionResult = Length.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Power" -> conversionResult = Power.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Pressure" -> conversionResult = Pressure.printConversion(ref.finalVal, fromUnit, toUnit);
                    case "Time" -> conversionResult = Time.printConversion(ref.finalVal, fromUnit, toUnit);
                }
                if (conversionResult != null) {
                    conversionResultLabel.setText("Result : " + conversionResult + toUnit);
                }
            }
        });
        root.getChildren().add(convertButton);

        // Update the "From" and "To" ComboBoxes when the measurement type is changed
        measurementComboBox.setOnAction(event -> {
            fromComboBox.setValue(null);
            toComboBox.setValue(null);
            String measurement = measurementComboBox.getValue();
            switch (measurement) {
                case "Area" -> {
                    fromComboBox.getItems().setAll("m2", "mm2", "cm2", "dm2", "dam2", "hm2", "km2");
                    toComboBox.getItems().setAll("m2", "mm2", "cm2", "dm2", "dam2", "hm2", "km2");
                }
                case "Currency" -> {
                    fromComboBox.getItems().setAll("€", "$", "¥", "£", "CNY", "CHF");
                    toComboBox.getItems().setAll("€", "$", "¥", "£", "CNY", "CHF");
                }
                case "Energy" -> {
                    fromComboBox.getItems().setAll("J", "cal", "eV", "kWh", "PET");
                    toComboBox.getItems().setAll("J", "cal", "eV", "kWh", "PET");
                }
                case "Length" -> {
                    fromComboBox.getItems().setAll("m", "mm", "cm", "dm", "dam", "hm", "km", "in", "mi", "yd", "NM", "ft");
                    toComboBox.getItems().setAll("m", "mm", "cm", "dm", "dam", "hm", "km", "in", "mi", "yd", "NM", "ft");
                }
                case "Power" -> {
                    fromComboBox.getItems().setAll("W", "kW", "MW", "GW", "TW", "PW");
                    toComboBox.getItems().setAll("W", "kW", "MW", "GW", "TW", "PW");
                }
                case "Pressure" -> {
                    fromComboBox.getItems().setAll("Pa", "hPa", "kPa", "dbar", "bar", "atm");
                    toComboBox.getItems().setAll("Pa", "hPa", "kPa", "dbar", "bar", "atm");
                }
                case "Time" -> {
                    fromComboBox.getItems().setAll("s", "ms", "mn", "h", "d", "wk", "yr");
                    toComboBox.getItems().setAll("s", "ms", "mn", "h", "d", "wk", "yr");
                }
            }
        });

        // Show the unit converter window
        Scene scene = new Scene(root, 400, 350);
        unitConversionStage.setScene(scene);
        unitConversionStage.show();
    }
}
