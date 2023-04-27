package converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCurrency {
    @Test
    public void testToEuros() {
        Currency currency = new Currency("$");
        double result = currency.toEuros(5);
        double expected = 4.58;
        assertEquals(expected, result,0.01);
    }

    @Test
    public void testFromEuros() {
        Currency currency = new Currency("CNY");
        double result = currency.fromEuros(10);
        double expected = 75.15;
        assertEquals(expected, result,0.01);
    }

    @Test
    public void testPrintCurrencyConversion() {
        double methodResult = Currency.printConversion(10, "€", "£").doubleValue();
        double expectedResult = BigDecimal.valueOf(8.784454607).doubleValue();
        assertEquals(expectedResult,methodResult);
    }
}
