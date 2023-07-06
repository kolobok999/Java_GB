package Homeworks.Homework_1;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task3 {
    static Logger logger = Logger.getLogger(Task3.class.getName());
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        String path = "src/Homeworks/Homework_1/";
        setLogger(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует калькулятор!\n" +
                "Я могу выполнить 4 простейшие операции, это сложение, вычитание, умножение, деление.\n" +
                "Для начала определимся с цифрами. Введите первое число:");
        int a = getA(scanner);
        System.out.println("Какую операцию выполним? (доступны \"+ - * /\"");
        char sign = getSign(scanner); //вводим операцию
        System.out.println("И теперь введите второе число:");
        int b = getB(scanner, sign);
        System.out.printf("Решаем пример: %d %c %d = %.2f", a, sign, b, computing(a, b, sign));
        scanner.close();
    }

    private int getA(Scanner scanner) {
        return scanner.nextInt();
    }

    private int getB(Scanner scanner, char sign) {
        int b = scanner.nextInt();
        if (sign == '/') {
            if (b == 0) {
                System.out.println("На ноль делить нельзя! Введите другое число.");
                b = getB(scanner, sign);
            }
        }
        return b;
    }

    private char getSign(Scanner scanner) {
        char sign = scanner.next().charAt(0);
        switch (sign) {
            case '+':
            case '-':
            case '/':
            case '*':
                return sign;
            default:
                System.out.println("Введите пожалуйста один из допустимых символов: \"+ - * /\"");
                sign = getSign(scanner);
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

    private void setLogger(String path) {
        try {
            FileHandler fh = new FileHandler(path + "log.txt");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
