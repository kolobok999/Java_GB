package Lessons.Lesson_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//    📌Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
//        что на 0-й позиции каждого внутреннего списка содержится название жанра,
//        а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры.
public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.go();
    }

    private void go() {
        List<ArrayList<String>> catalog = new ArrayList<>();
        ArrayList<String> books = new ArrayList<>();
        String[] books1 = {"Проза", "Война и мир", "Двенадцать стульев"};
        String[] books2 = {"Поэзия", "Бородино", "Береза"};
        String[] books3 = {"Детектив", "Шерлок холмс", "Преступление"};
        fillCatalog(catalog, books1);
        fillCatalog(catalog, books2);
        fillCatalog(catalog, books3);
        System.out.println(catalog);
    }

    private void fillCatalog(List<ArrayList<String>> cat, String[] bk) {
        ArrayList<String> books = new ArrayList<>();
        Collections.addAll(books, bk);
        cat.add(books);
    }
}
