package Lessons.Lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//    Реализовать консольное приложение, которое:
//        1.Принимает от пользователя строку вида text~num
//        2.Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//        3.Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
public class Task1 {
    public static void main(String[] args) throws IOException {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new LinkedList<>();
        while (true) {
            System.out.println("Введите строку вида text~num: ");
            String msg = reader.readLine();
            if (msg.equalsIgnoreCase("")) break;
            splitUserText(msg, list);
        }
        reader.close();
        System.out.println(list);
    }

    private void splitUserText(String line, List<String> list) {
        String[] msg = line.split("~");
        if (!msg[1].matches("[-+]?\\d+")) {
            System.out.println("num - не число");
            return;
        }

        int num = Integer.parseInt(msg[1]);
        String text = msg[0];
        if (text.equalsIgnoreCase("print")) {
            System.out.println(list.remove(Integer.parseInt(msg[1])));
            return;
        }

        if (num > list.size()) {
            System.out.println("В листе нет столько элементов и он будет добавлен в конец");
            list.add(text);
        } else {
            list.add(num, text);
        }
    }
}
