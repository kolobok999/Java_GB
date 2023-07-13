package Homeworks.Homework_5;

import java.util.*;

//Пусть дан список сотрудников: Иван Иванов, Пётр Петров и др.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        String[] list = {"Иван Иванов", "Петр Петров", "Иван Чайкин", "Сергей Смирнов", "Петр Труханов", "Иван Дорн"};
        List<String> employees = new ArrayList<>();
        Collections.addAll(employees, list);
        System.out.println(employees);
        Map<String, Integer> names = repeatCount(employees);
        System.out.println(names);
        names = sortByValues(names);
        System.out.println(names);
    }
    private Map<String, Integer> repeatCount(List<String> list) {
        Map<String, Integer> nameCount = new HashMap<>();
        for (String person : list) {
            String name = person.split(" ")[0];
            if (nameCount.containsKey(name)) {
                nameCount.put(name, nameCount.get(name) + 1);
            } else {
                nameCount.put(name, 1);
            }
        }
        return nameCount;
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
            return (int) map.get(s1) - (int) map.get(s2);
        }
    }
}
