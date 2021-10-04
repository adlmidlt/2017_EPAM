import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalculateServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    void calculateAddition() {
        assertEquals(4.0, calculatorService.printCalculator("2 + 2"));
    }

    @Test
    void calculateSub() {
        assertEquals(10.0, calculatorService.printCalculator("15 - 5"));
    }

    @Test
    void calculateSpace() {
        assertEquals(5.0, calculatorService.printCalculator("2+     3"));
    }

    @Test
    void calculateMult() {
        assertEquals(6.0, calculatorService.printCalculator("3 * 2"));
    }

    @Test
    void calculateDiv() {
        assertEquals(3.0, calculatorService.printCalculator("6 / 2"));
    }

    @Test
    void priorityCalculateToken() {
        assertEquals(12.0, calculatorService.printCalculator("3 + 3 * 3"));
    }

    @Test
    @Disabled
    void calculateDivOfZero() {
        assertEquals(0.0, calculatorService.printCalculator("3 / 0"));
    }

    @Test
    void calculateNegativOfNumber() {
        assertEquals(-1, calculatorService.printCalculator("3 - 4"));
    }

    @Test
    void calculateSubZero() {
        assertThat(calculatorService.printCalculator("1-1"), is(equalTo(0.0)));
    }
}
