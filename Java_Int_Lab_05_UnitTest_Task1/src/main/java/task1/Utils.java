package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public String concatenateWords(String stringOne, String stringTwo) {
        String regexp = "[\\w]*"; // глобальный поиск из az, AZ, 0-9, включая символ _ (подчеркивание).
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcherStringOne = pattern.matcher(stringOne);
        Matcher matcherStringTwo = pattern.matcher(stringTwo);
        if (matcherStringOne.matches() && matcherStringTwo.matches())
            return stringOne.concat(stringTwo);
        throw new NonLatinException();
    }

    public Long computeFactorial(int number) {
        long result = 1;
        for (int i = 0; i <= number; i++) {
            result *= i;
        } if (number < 0){
            throw new IllegalArgumentException(); // не может быть отрицтельным
        } else if (number == 0) {
            return 1L;
        }
        return result;
    }
}
