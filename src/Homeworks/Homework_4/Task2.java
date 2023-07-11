package Homeworks.Homework_4;

import java.util.Collections;
import java.util.LinkedList;

//Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        String[] elem = {"Hello", "ladies", "and", "gentlemen"};
        Collections.addAll(list, elem);
        MyQueue queue = new MyQueue(list);

        System.out.println(queue);
        System.out.println(queue.first());

        queue.enqueue("!");
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
