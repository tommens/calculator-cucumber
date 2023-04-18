package junit5tests;

//Import Junit5 libraries for unit testing:
import org.junit.jupiter.api.*;

import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;

import calculator.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;


class TestNumberNotation {

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotation(MyNumber num, String s, NumberNotation n) {
        assertEquals(s, num.toString(n));
        num.notation = n;
        assertEquals(s, num.toString());
    }

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotations(MyNumber num, double O, double r) {
        DecimalFormat format = new DecimalFormat("0.#");

        Double real = num.getValue().multiply(BigDecimal.valueOf(pow(10, num.getexp())).round(new MathContext(15))).doubleValue();
        Double imag = num.getImaginary().multiply(BigDecimal.valueOf(pow(10, num.getImaginaryExp())).round(new MathContext(15))).doubleValue();

        //cartesian notation:
        String s = String.format("%s+%si", format.format(real),format.format(imag));
        testNotation(num, s, NumberNotation.CARTESIAN);
        //polar notation:
        s = String.format("%s*(cosine(%s) + i*sine(%s))",format.format(r), O, O);
        testNotation(num, s, NumberNotation.POLAR);
        //exponential notation:
        s = String.format("%s*e^(%s*i)",format.format(r), O);
        testNotation(num, s, NumberNotation.EXPONENTIAL);

        s = String.format("%sx10^%s + i*%sx10^%s", num.getValue(),num.getexp(),num.getImaginary(),num.getImaginaryExp());
        testNotation(num, s, NumberNotation.SCIENTIFIC);

        s = String.format("%sE^%s + i*%sE^%s", num.getValue(),num.getexp(),num.getImaginary(),num.getImaginaryExp());
        testNotation(num, s, NumberNotation.E_NOTATION);
    }


    /* This is an auxilary method to avoid code duplication.
     */
    void testRealNotations(MyNumber num) {
        DecimalFormat format = new DecimalFormat("0.#");

        Double real = num.getValue().multiply(BigDecimal.valueOf(pow(10, num.getexp())).round(new MathContext(15))).doubleValue();

        //cartesian notation:
        String s = String.format("%s", format.format(real));
        testNotation(num, s, NumberNotation.CARTESIAN);
        //polar notation:
        s = String.format("%s", num.getValue());
        testNotation(num, s, NumberNotation.POLAR);
        //exponential notation:
        s = String.format("%s", num.getValue());
        testNotation(num, s, NumberNotation.EXPONENTIAL);

        s = String.format("%sx10^%s", num.getValue(),num.getexp());
        testNotation(num, s, NumberNotation.SCIENTIFIC);

        s = String.format("%sE^%s", num.getValue(),num.getexp());
        testNotation(num, s, NumberNotation.E_NOTATION);
    }


    /* This is an auxilary method to avoid code duplication.
     */
    void testImaginaryNotations(MyNumber num) {
        DecimalFormat format = new DecimalFormat("0.#");

        Double imag = num.getImaginary().multiply(BigDecimal.valueOf(pow(10, num.getImaginaryExp())).round(new MathContext(15))).doubleValue();

        double O = Math.PI/2;

        //cartesian notation:
        String s = String.format("%si", format.format(imag));
        testNotation(num, s, NumberNotation.CARTESIAN);
        //polar notation:
        s = String.format("%s*(cosine(%s) + i*sine(%s))", num.getImaginary(), O, O);
        testNotation(num, s, NumberNotation.POLAR);
        //exponential notation:
        s = String.format("%s*e^(%s*i)", num.getImaginary(), O);
        testNotation(num, s, NumberNotation.EXPONENTIAL);

        s = String.format("i*%sx10^%s", num.getImaginary(),num.getImaginaryExp());
        testNotation(num, s, NumberNotation.SCIENTIFIC);

        s = String.format("i*%sE^%s", num.getImaginary(),num.getImaginaryExp());
        testNotation(num, s, NumberNotation.E_NOTATION);
    }

    @Test
    void testOutput() {
        int value1 = 8;
        int value2 = 6;
        MyNumber num = new MyNumber(new BigDecimal(value1),new BigDecimal(value2));

        Double r = Math.sqrt((double)(value1*value1)+(double)(value2*value2));

        Double O = Math.atan((double)value2/value1);

        testNotations(num,O,r);

        MyNumber num2 = new MyNumber(new BigDecimal(value1));
        testRealNotations(num2);

        MyNumber num3 = new MyNumber(new BigDecimal(0),new BigDecimal(value1));
        testImaginaryNotations(num3);
    }

}
