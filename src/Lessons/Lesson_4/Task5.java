package Lessons.Lesson_4;

import java.util.List;
import java.util.Stack;

//      Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
//      http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181
//      Вычислить запись если это возможно.
public class Task5 {
    private List<String> standart_operators =
            List.of( "(", ")", "+", "-", "*", "/", "^" );
    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.go();
    }

    private void go() {
        String expression = "2 + 2 * 2";
        System.out.println(PolishNotation(expression));

    }

    private String PolishNotation(String expr) {
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i))) {
                sb.append(String.valueOf(expr.charAt(i))).append(" ");
            }
        }
        return sb.toString();
    }
    private byte GetPriority(String s) {
        switch (s) {
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 4;
        }
    }

    private boolean isNumber(String s) {
        return s.matches("[-+]?\\d+");
    }
}
