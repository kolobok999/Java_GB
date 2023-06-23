package Homeworks.Homework_1;
//1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        int n = 10;
        System.out.printf("%d-й элемент треугольных чисел равен: %d\n", n, triangularNumber(n));
        System.out.printf("Факториал числа %d равен: %d\n", n, fact(n));
    }

    private int triangularNumber(int n) {
        return n * (n + 1) / 2;
    }

    private int fact(int n) {
        if (n == 1 || n == 0) return 1;
        return fact(n - 1) * n;
    }


}
