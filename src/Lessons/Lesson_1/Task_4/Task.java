package Lessons.Lesson_1.Task_4;
// 📌 Напишите метод, который находит самую длинную строку общего
// префикса среди массива строк.
// 📌 Если общего префикса нет, вернуть пустую строку "".

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    private void go() {
        String[] str = {"flower", "flow", "flowerght"};
        String res = prefix(str);
        System.out.println(res);
    }

    private String prefix(String[] str) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        while (true) {
            char ch = str[0].charAt(j);
            if (i == str.length - 1) {
                i = 0;
                j++;
                result.append(ch);
                continue;
            }
            if (j == str[i].length() || j == str[i + 1].length()) {
                return result.toString();
            }
            if (str[i + 1].charAt(j) != ch) {
                return result.toString();
            } else {
                i++;
            }

        }
    }
}
