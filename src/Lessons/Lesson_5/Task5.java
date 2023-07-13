package Lessons.Lesson_5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Взять набор строк, например, "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись".
// Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.
public class Task5 {
    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.go();
    }

    private void go() {
        Map<Integer, String> map = new HashMap<>();
        String[] str = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись".split(" ");

        for (int i = 0; i < str.length; i++) {
            map.put(i, str[i]);
        }

        System.out.println(map);
        map = sortByValues(map);
        System.out.println(map);
    }

    public static <K, V> Map<K, V> sortByValues(Map<K, V> map) {
        Comparator<K> comparator = new CustomComparator<>(map);

        Map<K, V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);

        return sortedMap;
    }

    static class CustomComparator<K, V> implements Comparator<K> {
        private final Map<K, V> map;

        public CustomComparator(Map<K, V> map) {
            this.map = new TreeMap<>(map);
        }

        @Override
        public int compare(K s1, K s2) {
            return map.get(s1).toString().length() - map.get(s2).toString().length();
        }
    }
}
