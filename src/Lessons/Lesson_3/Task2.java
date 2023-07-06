package Lessons.Lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.sort;

//📌Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//📌Вывести название каждой планеты и количество его повторений в списке.
//📌Пройти по списку и удалить повторяющиеся элементы.
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        String[] solarSystem = {"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"};
        List<String> solar = new ArrayList<>();
        Random random = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            solar.add(solarSystem[random.nextInt(solarSystem.length)]);
        }
        System.out.println(solar);
        sort(solar);
        int count = 1;
        String planet = solar.get(0);
        for (int i = 1; i < solar.size(); i++) {
            if (solar.get(i).equals(planet)) {
                count++;
                solar.remove(i--);
            } else {
                System.out.print(planet + " - " + count + ", ");
                planet = solar.get(i);
                count = 1;
            }
        }
        System.out.print(planet + " - " + count);
        System.out.println();
        System.out.println(solar);
    }
}
