package Lessons.Lesson_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//📌1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
//📌2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
public class Task0 {
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        task0.go();
    }

    private void go() {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int n = 100_000;
        System.out.println("arrayList: " + getListAddTime(arrList, n));
        System.out.println("linkedList: " + getListAddTime(linkedList, n));


    }

    private long getListAddTime(List<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(i / 2, i);
        }
        return System.currentTimeMillis() - start;
    }

}
