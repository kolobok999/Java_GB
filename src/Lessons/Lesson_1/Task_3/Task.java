package Lessons.Lesson_1.Task_3;
//📌 Дан массив nums = [3,2,2,3] и число val = 3.
//        📌 Если в массиве есть числа, равные заданному, нужно перенести
//        эти элементы в конец массива.
//        📌 Таким образом, первые несколько (или все) элементов массива
//        должны быть отличны от заданного, а остальные - равны ему.
public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    private void go() {
        int [] array = new int[] {3,2,2,5, 3, 4, 3};
        int val = 3;
        int lastItem = array.length - 1;
        for (int i = lastItem; i >= 0; i--) {
            if (array[i] == val) {
                swap(array, i, lastItem--);
            }
        }

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private void swap(int [] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
