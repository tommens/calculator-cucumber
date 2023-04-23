package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestPrecision {

    private final String value1 = "3.14159";
    private final String value2 = "2.71828";
    private Divides op;

    private List<Expression> params;
    private final int precision = 3;

    private final MathContext mathContext = new MathContext(precision);

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
        params = new ArrayList<>(Arrays.asList(new MyRealNumber(value1),new MyRealNumber(value2)));
        try {
            op = new Divides(params);
            op.setMathContext(mathContext);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    void testPrecisionOperation(){
        BigDecimal result = calculator.evalReal(op);
        assertEquals(precision,result.precision());
    }

}
