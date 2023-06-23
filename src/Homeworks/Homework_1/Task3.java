package Homeworks.Homework_1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        System.out.println("Вас приветствует калькулятор!\n" +
                "Я могу выполнить 4 простейшие операции, это сложение, вычитание, умножение, деление.\n" +
                "Для начала определимся с цифрами. Введите первое число:");
        int a = getA();
        System.out.println("Какую операцию выполним? (доступны \"+ - * /\"");
        char sign = getSign(); //вводим операцию
        System.out.println("И теперь введите второе число:");
        int b = getB(sign);
        System.out.printf("Решаем пример: %d %c %d = %.2f", a, sign, b, computing(a, b, sign));
    }

    private int getA() {
        return new Scanner(System.in).nextInt();
    }

    private int getB(char sign) {
        int b = new Scanner(System.in).nextInt();
        if (sign == '/') {
            if (b == 0) {
                System.out.println("На ноль делить нельзя! Введите другое число.");
                b = getB(sign);
            }
        }
        return b;
    }

    private char getSign() {
        char sign = new Scanner(System.in).next().charAt(0);
        switch (sign) {
            case '+':
            case '-':
            case '/':
            case '*':
                return sign;
            default:
                System.out.println("Введите пожалуйста один из допустимых символов: \"+ - * /\"");
                sign = getSign();
        }
        return sign;
    }

    private double computing(int a, int b, char sign) {
        switch (sign) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return (double) a / b;
            default:
                System.out.println("\nчто-то пошло не так");
                return 0;
        }
    }
}
