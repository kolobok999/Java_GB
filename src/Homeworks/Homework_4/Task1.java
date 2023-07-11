package Homeworks.Homework_4;

//Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        String[] elem = {"Hello", "ladies", "and", "gentlemen"};
        Collections.addAll(list, elem);

        System.out.println(list);
        list = reverseList(list);
        System.out.println(list);

    }
    private static List<String> reverseList(List<String> list) {
        List<String> newList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
