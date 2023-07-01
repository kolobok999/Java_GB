package Lessons.Lesson_2;
//📌 Напишите метод, который принимает на вход строку (String) и
//        определяет является ли строка палиндромом (возвращает
//        boolean значение).
public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.go();
    }

    private void go() {
        String str = "шалаш";
        System.out.println(isPalindrome(str));
    }

    private boolean isPalindrome(String str) {
        int size = str.length() - 1;
        for (int i = 0; i <= size / 2; i++) {
            if (str.charAt(i) != str.charAt(size - i)) return false;
        }
        return true;
    }
}
