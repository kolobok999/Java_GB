package Lessons.Lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Реализовать консольное приложение, которое:
//        1.Принимает от пользователя и “запоминает” строки.
//        2.Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//        3.Если введено revert, удаляет предыдущую введенную строку из памяти.
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        Stack<String> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String text = reader.readLine();
                if (text.equals("")) break;
                if (text.equalsIgnoreCase("print")) {
                    int size = stack.size();
                    for (int i = size - 1; i >= 0; i--) {
                        System.out.print(stack.get(i) + " ");
                    }
                    System.out.println();
                    continue;
                }
                if (text.equalsIgnoreCase("revert")) {
                    System.out.println("Удалена запись: " + stack.pop());
                    continue;
                }
                stack.add(text);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
