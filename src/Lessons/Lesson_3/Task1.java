package Lessons.Lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.sort;

//📌Заполнить список десятью случайными числами.
//📌Отсортировать список методом sort() и вывести его на экран.
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        list.size();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
}
