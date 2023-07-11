package Homeworks.Homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task3 {
    Logger logger = Logger.getLogger(Task3.class.getName());
    Deque<Integer> stack = new ArrayDeque<>();
    int a;
    int b;
    char sign;
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        try {
            String path = "src/Homeworks/Homework_1/";
            setLogger(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);
            stack.push(1);
            while (stack.peek() != null) {
                if (stack.peek() == 1) {
                    System.out.println("Вас приветствует калькулятор!\n" +
                            "Я могу выполнить 4 простейшие операции, это сложение, вычитание, умножение, деление.\n" +
                            "Для начала определимся с цифрами. Введите первое число:");
                    a = getA(reader);
                }
                if (stack.peek() == 2) {
                    System.out.println("Какую операцию выполним? (доступны \"+ - * /\"");
                    sign = getSign(reader); //вводим операцию
                }
                if (stack.peek() == 3) {
                    System.out.println("И теперь введите второе число:");
                    b = getB(scanner, sign);
                }
                if (stack.peek() == 4) {
                    System.out.printf("Решаем пример: %d %c %d = %.2f", a, sign, b, computing(a, b, sign));
                    stack.clear();
                    scanner.close();
                    reader.close();
                }
            }
        }catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    private int getA(BufferedReader reader) {
        String s;
        int a = 0;
        try {
            s = reader.readLine();
            if (isNumber(s)) {
                stack.push(2);
                a = Integer.parseInt(s);
            }
            else {
                logger.info("Это не число");
                a = getA(reader);
            }
        }catch (IOException ex) {
            logger.info(ex.getMessage());
        }
        return a;
    }

    private int getB(Scanner scanner, char sign) {
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("back")) {
            stack.pop();
            return 0;
        }
        int b;
        if (isNumber(s)) {
            b = Integer.parseInt(s);
        } else {
            logger.info("Вы ввели не число! Введите число.");
            b = getB(scanner, sign);
        }
        if (sign == '/') {
            if (b == 0) {
                logger.info("На ноль делить нельзя! Введите другое число.");
                b = getB(scanner, sign);
            }
        }
        stack.push(4);
        return b;
    }

    private char getSign(BufferedReader reader) {
        char sign = ' ';
        try {
            String s = reader.readLine();
            if (s.equalsIgnoreCase("back")) {
                stack.pop();
                return ' ';
            }
            sign = s.charAt(0);
            switch (sign) {
                case '+':
                case '-':
                case '/':
                case '*':
                    stack.push(3);
                    return sign;
                default:
                    logger.info("Введите пожалуйста один из допустимых символов: \"+ - * /\"");
                    sign = getSign(reader);
            }
        } catch (IOException ex) {
            logger.info(ex.getMessage());
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

    private boolean isNumber(String s) {
        return s.matches("[-+]?\\d+");
    }
}
