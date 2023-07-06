package Homeworks.Homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Пусть дан произвольный список целых чисел, удалить из него четные числа
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        List<Integer> array = new ArrayList<>();
        int n = 50;
        fillArListRand(array, n);
        System.out.println(array);
        delEvenNumbers(array);
        System.out.println(array);
    }

    private void fillArListRand(List<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
    }

    private void delEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i--);
            }
        }
    }
}
