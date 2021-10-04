package task1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class UtilsTest {

    private Utils utils = new Utils();

    @Test
    void concatenateWord() {
        assertEquals("JonSina", utils.concatenateWords("Jon", "Sina"));
    }

    @Test
    void concatenateNonLatinWords() {
        Executable closureContainingCodeToTest = () -> utils.concatenateWords("Старк", "Ария");
        assertThrows(NonLatinException.class, closureContainingCodeToTest);
    }

    @Test
    void concatenateEmptyWords() {
        assertEquals("", utils.concatenateWords("", ""));
    }

    @Test
    void concatenateNullWords() {
        Executable closureContainingCodeToTest = () -> utils.concatenateWords(null, null);
        assertThrows(NullPointerException.class, closureContainingCodeToTest);
    }

    @Test
    @Disabled
    void testFactorialWithTimeout() {
        int result = (int) (Math.random() * 100000000L);
        assertTimeout(Duration.ofMillis(30), ()->
                utils.computeFactorial(result));
    }

    @Test
    void computeFactorialOfZero() {
        assertEquals(Long.valueOf(1), utils.computeFactorial(0));
    }

    @Test
    void computeFactorialOfNegativeNumber() {
        Executable executable = () -> utils.computeFactorial(-1);
        assertThrows(IllegalArgumentException.class, executable);
    }
}
