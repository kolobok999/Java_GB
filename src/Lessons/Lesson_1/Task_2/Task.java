package Lessons.Lesson_1.Task_2;
//Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
//        максимальное количество подряд идущих 1.
public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    void go(){
        int [] arr = new int[] {1,1,0,1,1,1};
        int streak = getMaxStreak(arr);
        System.out.println(streak);
    }
    int getMaxStreak(int[] array) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                if (maxCount < count) {
                    maxCount = count;
                    count = 0;
                }
            }
        }
        if (maxCount < count)
            maxCount = count;
        return  maxCount;
    }
}
