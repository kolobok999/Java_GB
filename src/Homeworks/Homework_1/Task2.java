package Homeworks.Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

//2) Вывести все простые числа от 1 до 1000
public class Task2 {
    private Integer[] primesToN;
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        int n = 1000;
        generatePrimesNumbers(n);
        for (int items : primesToN) {
            System.out.println(items);
        }
    }

    private void generatePrimesNumbers(int n) {
        boolean[] temp = new boolean[n];
        Arrays.fill(temp, true);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int p = 2; p < temp.length; p++) {
            if (temp[p]) {
                for (int j = p * 2; j < n; j += p) {
                    temp[j] = false;
                }
                primes.add(p);
            }
        }
        primesToN = primes.toArray(new Integer[0]);
    }
}
