package view;

import calculator.ArithmeticType;
import javafx.scene.control.Button;

import java.util.List;
import java.util.stream.Stream;

public class ArithmeticSelectorButton extends Button {

    private static final List<ArithmeticType> VALUES = Stream.of(ArithmeticType.values())
            .toList();
    private static ArithmeticSelectorButton instance;
    private int index;

    private ArithmeticSelectorButton() {
        super(VALUES.get(0).toString());
        index = 0;
        setOnAction(actionEvent -> swapArithmetic());
        MainApplication.getCalculator().setType(VALUES.get(index));
    }

    public static ArithmeticSelectorButton getInstance() {
        if (instance == null) {
            instance = new ArithmeticSelectorButton();
        }
        return instance;
    }

    private void swapArithmetic() {
        index = (index + 1) % VALUES.size();
        setText(VALUES.get(index).toString());
        MainApplication.getCalculator().setType(VALUES.get(index));
    }
}
