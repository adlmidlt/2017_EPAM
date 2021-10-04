import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorService {

    private StringBuilder print = new StringBuilder();
    private StringBuilder outResult = new StringBuilder();

    public double printCalculator(String exp) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                print.append(exp.charAt(i));

            } else if (stack.isEmpty()) {
                print.append(" ");
                stack.addFirst(exp.charAt(i));

            } else if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                if (stack.peekFirst() == '*' || stack.peekFirst() == '/') {
                    print.append(" ");
                    print.append(stack.pollFirst());
                }
                stack.addLast(exp.charAt(i));
                print.append(" ");

            } else if (exp.charAt(i) == '*' || exp.charAt(i) == '/') {
                if (stack.peekFirst() == '*' || stack.peekFirst() == '/') {
                    print.append(" ");
                    print.append(stack.pollFirst());
                }
                stack.addFirst(exp.charAt(i));
                print.append(" ");
            } else {
                stack.addFirst(exp.charAt(i));
            }
        }
        print.append(" ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            print.append(stack.pollFirst());
        }
        return calculateResult();
    }

    private double calculateResult() {
        double result;
        Deque<Double> res = new ArrayDeque<>();

        for (int i = 0; i < print.length(); i++) {
            if (Character.isDigit(print.charAt(i))) {
                outResult.append(print.charAt(i));
            } else if (print.charAt(i) == ' ' && Character.isDigit(print.charAt(i - 1))) {
                res.addFirst(Double.parseDouble(outResult.toString()));
                outResult.delete(0, outResult.length());

            } else if (print.charAt(i) == '+') {
                res.addLast(res.pollLast() + res.pollLast());

            } else if (print.charAt(i) == '*') {
                res.addFirst(res.pollFirst() * res.pollFirst());

            } else if (print.charAt(i) == '/') {
                result = res.pollFirst();
                res.addFirst(res.pollFirst() / result);

            } else if (print.charAt(i) == '-') {
                res.addLast(res.pollLast() - res.pollLast());
            }
        }
        return res.pollFirst();
    }
}
