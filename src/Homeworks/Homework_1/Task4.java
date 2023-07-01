package Homeworks.Homework_1;
//4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.go();
    }

    private void go() {
        String equation = "2? + ?5 = 69";
        String [] str = equation.split(" ");

        if (str[0].charAt(0) == '?') {

        }
    }

    private String prefix(String[] str) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        if (i == 6) i = 0;
        if (i == 6 && j == str[i].length()) return result.toString();

        while (true) {
            if (str[i].charAt(j) == '?') {
                str[i] = str[i].replace('?', '0');
                i += 2;
            }
        }
    }
}
//254 + 58 = 312
//25? + 5? = 312