package Lessons.Lesson_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет.
// Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
// 1.повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
// (Например, add - egg изоморфны)
// 2.буква может не меняться, а остаться такой же.
// (Например, note - code)
// Пример 1:
// Input: s = "foo", t = "bar"
// Output: false
// Пример 2:
// Input: s = "paper", t = "title"
// Output: true
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
        System.out.println(isIsomorph(s, t));

    }
    private boolean isIsomorph(String str1, String str2) {
        if (str1.equals(str2)) return true;
        if (str1.length() != str2.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
                map1.putIfAbsent(str1.charAt(i), str2.charAt(i));
        }
        for (int i = 0; i < str1.length(); i++) {
            map2.putIfAbsent(str2.charAt(i), str1.charAt(i));
        }
        return map1.size() == map2.size();
    }
}
