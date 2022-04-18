package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

import java.util.List;

import static converter.Unit.getUnitCategories;

/**
 * Controller for the functions view.
 */
public class FunctionsController extends Controller {
    @FXML
    public Pane pane;

    private Calculator calculator;
    private Parser parser;
    private double xCenter = 0;
    private double yCenter = 0;
    private double step = 0.1;
    private double pixelSize = 0.05;
    private final List<String> acceptedFunctions = List.of("abs", "acos", "acosh", "asin", "asinh", "atan", "atanh", "cbrt", "cos", "cosh", "exp", "ln", "log", "sin", "sinh", "sqrt", "tan", "tanh");

    public void initialize() {
        calculator = new Calculator();
        parser = new Parser(calculator);
    }

    public void submitButton() {
        String function = inputField.getText();
        if (function.isEmpty()) {
            showAlertMessage("Please enter a function");
        } else if (!function.contains("x")) {
            showAlertMessage("Please enter a function with x");
        } else if (!acceptedFunctions.contains(function.split("\\(")[0])) {
            showAlertMessage("Please enter a valid function");
        } else {
            drawCanvas();
        }
    }

    public void zoomin(ActionEvent actionEvent) {

    }

    public void up(ActionEvent actionEvent) {

    }

    public void left(ActionEvent actionEvent) {

    }

    public void down(ActionEvent actionEvent) {

    }

    public void right(ActionEvent actionEvent) {

    }

    public void zoomout(ActionEvent actionEvent) {

    }

    public void cancel(ActionEvent actionEvent) {

    }

    private void drawCanvas() {
        pane.getChildren().clear();
        Path path = new Path();
        String function = inputField.getText();

        int xCenterPixel = (int) (pane.getWidth() / 2);
        int yCenterPixel = (int) (pane.getHeight() / 2);

        Line axisX = new Line(0, yCenterPixel, pane.getWidth(), yCenterPixel);
        Line axisY = new Line(xCenterPixel, 0, xCenterPixel, pane.getHeight());

        pane.getChildren().addAll(axisX, axisY);

        boolean isFirstPoint = true;

        for(int x = 0 ; x < (int) (pane.getWidth()) ; x++) {
            double xValue = pixelToDouble(x, xCenter) - (xCenterPixel*pixelSize);

            try {
                Expression expression = parser.parse(function.replace("x", Double.toString(xValue)));
                double yValue = calculator.eval(expression).toReal().getValue().doubleValue();
                int y = yCenterPixel + doubleToPixel(yValue + yCenter);
                if (isFirstPoint) {
                    path.getElements().add(new MoveTo(x, y));
                    isFirstPoint = false;
                } else {
                    path.getElements().add(new LineTo(x, y));
                }
            } catch (Exception ignored) {

            }
        }
        pane.getChildren().add(path);
    }

    private double pixelToDouble(int pixel, double center) {
        return center + (pixel * pixelSize);
    }

    private int doubleToPixel(double value) {
        return -(int) (value / pixelSize);
    }
}