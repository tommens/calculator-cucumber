package view;

import calculator.ArithmeticType;
import calculator.Calculator;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to assemble the different parts of the calculator. This is the calculator's view itself. Singleton Design Pattern.
 */
public class CalculatorView extends VBox {
    private static CalculatorView instance;
    private final List<CalculatorPart> calculatorParts;
    private ArithmeticType arithmeticType;
    private double totalHeightRequired = 2., totalWidthRequired = 0.;

    private CalculatorView() {

        HBox buttonsHbox = new HBox();
        buttonsHbox.getChildren().addAll(LeftVBox.getInstance(), OperationsVBox.getInstance());

        calculatorParts = new ArrayList<>();
        addCalculatorPart(LeftVBox.getInstance());
        addCalculatorPart(OperationsVBox.getInstance());

        getChildren().addAll(buildMenuBar(), ExpressionTextField.getInstance(), ResultLabel.getInstance(), buttonsHbox);

        bindHeightAndWidth();
    }

    /**
     * This method returns the unique instance of the CalculatorView.
     *
     * @return The unique instance of the CalculatorView.
     */
    public static CalculatorView getInstance() {
        instance = instance == null ? new CalculatorView() : instance;
        return instance;
    }

    private void addCalculatorPart(CalculatorPart calculatorPart) {
        calculatorParts.add(calculatorPart);
        setTotalHeightRequired(calculatorPart.getChildren().size());
        setTotalWidthRequired(calculatorPart.getMaxWidthNbButtons());
    }

    /**
     * This method is used to set the font size of the calculator.
     *
     * @param fontSize The font size to set.
     */
    public void setFontSize(double fontSize) {
        ExpressionTextField.getInstance().setStyle("-fx-font-size: " + fontSize / 8 + "px;");
        ResultLabel.getInstance().setStyle("-fx-font-size: " + fontSize / 8 + "px;");
        LeftVBox.getInstance().setFontSize(fontSize / 20);
        OperationsVBox.getInstance().setFontSize(fontSize / 20);
    }

    /**
     * This method is used to set the total height required by the calculator.
     *
     * @param totalHeightRequired The total height required by a part of the calculator.
     */
    public void setTotalHeightRequired(double totalHeightRequired) {
        this.totalHeightRequired = Math.max(totalHeightRequired + 2, this.totalHeightRequired);
    }

    /**
     * This method is used to set the total width required by the calculator.
     *
     * @param totalWidthRequired The total width required by a part of the calculator.
     */
    public void setTotalWidthRequired(double totalWidthRequired) {
        this.totalWidthRequired += totalWidthRequired;
    }

    /**
     * This method is used to bind the height and width of the calculator's parts.
     */
    public void bindHeightAndWidth() {
        calculatorParts.forEach(calculatorPart -> {
            calculatorPart.prefWidthProperty().bind(widthProperty().multiply(calculatorPart.getMaxWidthNbButtons() / totalWidthRequired));
            System.out.println(calculatorPart.getMaxWidthNbButtons());
            calculatorPart.prefHeightProperty().bind(heightProperty().multiply(calculatorPart.getChildren().size() / totalHeightRequired));
            System.out.println(calculatorPart.getChildren().size());
        });
        System.out.println("Total height required: " + totalHeightRequired);
        System.out.println("Total width required: " + totalWidthRequired);
        ExpressionTextField.getInstance().prefHeightProperty().bind(heightProperty().multiply(1 / totalHeightRequired));
        ResultLabel.getInstance().prefHeightProperty().bind(heightProperty().multiply(1 / totalHeightRequired));
    }

    private MenuBar buildMenuBar(){
        MenuBar menuBar = new MenuBar();
        Menu settingsMenu = new Menu("Settings");
        MenuItem item = new MenuItem("Real numbers settings");
        item.setOnAction(e->{new SettingsMenu(MainApplication.getCalculator());});
        settingsMenu.getItems().add(item);
        menuBar.getMenus().add(settingsMenu);
        return menuBar;
    }
}
