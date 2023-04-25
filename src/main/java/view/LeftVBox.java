package view;



import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to create the VBox containing the numbers (0 to 9) of the calculator. Singleton Design Pattern.
 */
public class LeftVBox extends CalculatorPart {
    private static LeftVBox instance;

    private LeftVBox(){

        getChildren().addAll(
                getGeneralHBox(new ArrayList<>(Arrays.asList("7","8","9"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("4","5","6"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("1","2","3"))),
                getGeneralHBox(new ArrayList<>(Arrays.asList("0"))));

                //getSevenToNineHBox(), getFourToSixHBox(), getOneToThreeHBox(), getZeroHBox());
    }


    /**
     * This method is used to get the instance of the IntNumbersVBox.
     * @return
     */
    public static LeftVBox getInstance(){
        instance = instance == null ? new LeftVBox() : instance;
        return instance;
    }



}
