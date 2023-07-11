package Lessons.Lesson_4;
//  Реализовать стэк с помощью массива
//  Нужно реализовать методы: size(), empty(), push(), peek(), pop().
public class Task4 {
    private int[] array;
    private int top;

    public Task4(int size) {
        array = new int[size];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int number) {
        array[++top] = number;
    }

    public int peek() {
        if (!isEmpty()) {
            return array[top];
        }
        throw new RuntimeException("Стек пустой!");
    }

    public int pop() {
        if (!isEmpty()) {
            return array[top--];
        }
        throw new RuntimeException("Стек пустой!");
    }

    public static void main(String[] args) {
        Task4 st = new Task4(10);
        st.push(1);
        st.push(5);
        st.push(7);
        st.push(8);
        st.push(34);
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }
}
