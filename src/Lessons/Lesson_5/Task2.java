package Lessons.Lesson_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Написать программу, определяющую правильность расстановки скобок в выражении.
// Пример 1: a+(d*3) - истина
// Пример 2: [a+(1*3) - ложь
// Пример 3: [6+(3*3)] - истина
// Пример 4: {a}[+]{(d*3)} - истина
// Пример 5: <{a}+{(d*3)}> - истина
// Пример 6: {a+]}{(d*3)} - ложь
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.go();
    }

    private void go() {
        String[] str = {"a+(d*3)", "[a+(1*3)", "[6+(3*3)]", "{a}[+]{(d*3)}", "<{a}+{(d*3)}>", "{a+]}{(d*3)}"};
        for (String el : str) {
            System.out.printf("%s : %b\n", el, checkBrackets(el));
        }

    }

    private boolean checkBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracer = new HashMap<>();
        bracer.put(')', '(');
        bracer.put(']', '[');
        bracer.put('}', '{');
        bracer.put('>', '<');
        for (char ch : str.toCharArray()) {
            if (bracer.containsValue(ch)) stack.push(ch);
            else if (bracer.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracer.get(ch)) return false;
            }
        }
        return stack.isEmpty();
    }
}
