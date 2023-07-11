package Homeworks.Homework_4;

import java.util.LinkedList;

//Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class MyQueue {

    private final LinkedList<String> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public MyQueue(LinkedList<String> list) {
        this.list = list;
    }

    public void enqueue(String el) {
        list.add(el);
    }

    public String dequeue() {
        return list.pollFirst();
    }

    public String first() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String el : list) {
            sb.append(el).append(" ");
        }
        return sb.toString();
    }
}
