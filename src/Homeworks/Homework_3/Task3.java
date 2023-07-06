package Homeworks.Homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        List<Integer> array = new ArrayList<>();
        int n = 10;
        fillArListRand(array, n);
        System.out.println(array);
        System.out.printf("Минимальное значение: %d\n", findMinList(array));
        System.out.printf("Максимальное значение: %d\n", findMaxList(array));
        System.out.printf("Среднее значение: %.2f", findAverageList(array));
    }

    private double findAverageList(List<Integer> list) {
        double avr = 0;
        for (int el : list) {
            avr += el;
        }
        return avr / list.size();
    }

    private int findMaxList(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int el : list) {
            if (el > max)
                max = el;
        }
        return max;
    }

    private void fillArListRand(List<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
    }

    private int findMinList(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int el : list) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }
}
