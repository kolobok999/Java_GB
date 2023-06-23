package Lessons.Lesson_1.Task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        String name = reader.readLine();
        System.out.printf("Hello, %s!\n", name);
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

        if (hour > 23 && hour < 5) {
            System.out.printf("Доброй ночи, %s!\n", name);
        } else if (hour < 12) {
            System.out.printf("Доброй утро, %s!\n", name);
        } else if (hour < 18) {
            System.out.printf("Доброй вечер, %s!\n", name);
        }
    }
}
