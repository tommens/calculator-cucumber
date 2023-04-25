package view;

import calculator.ArithmeticType;
import javafx.scene.control.Button;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArithmeticSelectorButton extends Button {

    private static ArithmeticSelectorButton instance;

    private static final List<String> VALUES = Stream.of(ArithmeticType.values())
            .map(Enum::name)
            .toList();

    private int index;

    private ArithmeticSelectorButton(){
        super(VALUES.get(0));
        index = 0;
        setOnAction(actionEvent -> swapArithmetic());
    }

    private void swapArithmetic() {
        index = (index + 1) % VALUES.size();
        setText(VALUES.get(index));
    }

    public static ArithmeticSelectorButton getInstance() {
        if(instance == null){
            instance = new ArithmeticSelectorButton();
        }
        return instance;
    }
}
