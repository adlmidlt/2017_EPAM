package calc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculate {

    public static void main(String[] args) {

        String s = "3*3-2*3/1-4";
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));

            } else if (stack.isEmpty()) {
                sb.append(" ");
                stack.addFirst(s.charAt(i));

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (stack.peekFirst() == '*' || stack.peekFirst() == '/') {
                    sb.append(" ");
                    sb.append(stack.pollFirst());
                }
                stack.addLast(s.charAt(i));
                sb.append(" ");

            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (stack.peekFirst() == '*' || stack.peekFirst() == '/') {
                    sb.append(" ");
                    sb.append(stack.pollFirst());
                }
                stack.addFirst(s.charAt(i));
                sb.append(" ");
            } else {
                stack.addFirst(s.charAt(i));
            }
        }
        sb.append(" ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.pollFirst());
        }

        /* Вычисляем результат.*/
        float result;
        StringBuilder sb1 = new StringBuilder();
        Deque<Float> res = new ArrayDeque<>();
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sb1.append(sb.charAt(i));
            } else if (sb.charAt(i) == ' ' && Character.isDigit(sb.charAt(i - 1))) {
                res.addFirst(Float.parseFloat(sb1.toString()));
                sb1.delete(0, sb1.length());

            } else if (sb.charAt(i) == '+') {
                res.addLast(res.pollLast() + res.pollLast());

            } else if (sb.charAt(i) == '*') {
                res.addFirst(res.pollFirst() * res.pollFirst());

            } else if (sb.charAt(i) == '/') {
                result = res.pollFirst();
                res.addFirst(res.pollFirst() / result);

            } else if (sb.charAt(i) == '-') {
                res.addLast(res.pollLast() - res.pollLast());
            }
        }
        System.out.println("Результат = " + String.valueOf(res.pollFirst()));
    }
}
