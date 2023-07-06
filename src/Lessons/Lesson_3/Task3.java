package Lessons.Lesson_3;

import java.util.ArrayList;
import java.util.List;

//📌Создать список типа ArrayList<String>.
//📌Поместить в него как строки, так и целые числа.
//📌Пройти по списку, найти и удалить целые числа.
public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        List<String> list = new ArrayList<>();
        list.add("df");
        list.add("45");
        list.add("cv");
        list.add("4");
        list.add("5");

        System.out.println(list);
        findNumbers(list);
        System.out.println(list);

    }

    private void findNumbers(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("[-+]?\\d+")) {
                list.remove(i--);
            }
        }
    }
}
