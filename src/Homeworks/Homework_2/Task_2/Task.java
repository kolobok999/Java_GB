package Homeworks.Homework_2.Task_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task {
    static Logger logger = Logger.getLogger(Task.class.getName());
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    private void go() {
        String path = "src/Homeworks/Homework_2/Task_2/";
        setLogger(path);
        int[] array = new int[]{12, 54, 84, 63, 27, 58, 15, 1};

        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
        bubbleSort(array);

        for (int a : array)
            System.out.print(a + " ");
    }

    private void setLogger(String path) {
        try {
            FileHandler fh = new FileHandler(path + "log.txt");
            logger.addHandler(fh);
//            XMLFormatter xml = new XMLFormatter();
//            fh.setFormatter(xml);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    private void bubbleSort(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
           for (int j = 0; j < arr.length - 1 - i; j++) {
               if (arr[j] > arr[j + 1]) {
                   swap(arr, j, j + 1);
               }
               logger.info(Arrays.toString(arr));
           }
        }
    }

    private void swap(int []arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
