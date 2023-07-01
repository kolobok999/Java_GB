package Lessons.Lesson_2;

import java.io.*;

//    📌Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
//       который запишет эту строку в простой текстовый файл, обработайте исключения.
public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.go();
    }

    private void go() {
        int n = 100;
        String text = "TEST";
        writeToFile(getData(text, n));
    }

    private void writeToFile(String str) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/Lessons/Lesson_2/output.txt"))){
            br.write(str);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
    private String getData(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
