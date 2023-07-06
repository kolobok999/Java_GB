package Homeworks.Homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Реализовать алгоритм сортировки слиянием
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        List<Integer> array = new ArrayList<>();
        int n = 10;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array.add(random.nextInt(100));
        }
        System.out.println(array);
        mergeSort(array);
        System.out.println(array);
    }

    private List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() == 1 || arr.size() == 0) return arr;
        List<Integer> left = mergeSort(arr.subList(0, arr.size() / 2));
        List<Integer> right = mergeSort(arr.subList(arr.size() / 2, arr.size()));
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < left.size() + right.size(); i++) {
            out.add(0);
        }
        int n = 0, m = 0, k = 0;
        while (n < left.size() && m < right.size()) {
            if (left.get(n) <= right.get(m)) { // Если левый элемент больше, то добавляем его в новый массив
                out.set(k, left.get(n));
                n++;
            } else {                           // Иначе добавляем правый
                out.set(k, right.get(m));
                m++;
            }
            k++;
        }
// Если одна из половинок закончилась, то оставшиеся элементы по порядку записываем в новый массив
        while (n < left.size()) {
            out.set(k, left.get(n));
            n++;
            k++;
        }
        while (m < right.size()) {
            out.set(k, right.get(m));
            m++;
            k++;
        }
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, out.get(i));
        }
        return arr;
    }
}
