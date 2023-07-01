package Lessons.Lesson_2;
// 📌 Дано четное число N (>0) и символы c1 и c2.
// 📌 Написать метод, который вернет строку длины N, которая
// состоит из чередующихся символов c1 и c2, начиная с c1.
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        int n = 8;
        char c1 = 'A';
        char c2 = 'B';
        System.out.println(alternatingChars(n, c1, c2));
    }

    private String alternatingChars(int n, char c1, char c2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            builder.append(c1);
            builder.append(c2);
        }
        if (n % 2 != 0)
            builder.append(c1);
        return builder.toString();
    }
}

