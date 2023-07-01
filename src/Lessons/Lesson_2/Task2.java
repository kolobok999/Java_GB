package Lessons.Lesson_2;
// 📌 Напишите метод, который сжимает строку.
// 📌 Пример.
//        вход: aaaabbbcdd
//        результат: a4b3c1d2
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        String str = "aaabbbcsdfasjdhfasunfvasdd";
        System.out.println(compressString(str));
    }

    private String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        int [] chars = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars[ch] += 1;
        }
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != 0) {
                sb.append(Character.toString(i));
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
