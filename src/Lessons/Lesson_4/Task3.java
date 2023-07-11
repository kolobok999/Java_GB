package Lessons.Lesson_4;

import java.util.*;

// 1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит на консоль содержимое стэка.
// 2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди.
public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        int n = 10;
        int[] array = new int[n];
        fillArray(array, n);
        System.out.println(Arrays.toString(array));
        printArrInStack(array);
        printArrInQueue(array);

    }

    private void fillArray(int[] arr, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    private void printArrInStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            stack.add(j);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void printArrInQueue(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int j : arr) {
            queue.add(j);
        }
        for (int el :
                queue) {
            System.out.print(el + " ");
        }
    }

}
