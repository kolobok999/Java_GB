package Homeworks.Homework_2.Task_3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//3) Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder,
//        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    private void go() {
        String fileName = "src/Homeworks/Homework_2/Task_3/Students.json";
        List<Student> myStudents= getStudents(fileName);
        for (Student myStudent : myStudents) {
            System.out.println(myStudent.toString());
        }
    }

    private List<Student> getStudents(String fileName) {
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        List<Student> myStudents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                Student student = new Student();
                student.name = parse(line,0);
                student.grade = parse(line, 1);
                student.subject = parse(line, 2);
                myStudents.add(student);
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return myStudents;
    }

    private String parse(String line, int num) {

        return line.replace(" ", "")
                .split(",")[num]
                .split(":")[1]
                .split("\"")[1];
    }

    static class Student {
//        {"фамилия":"Иванов","оценка":"5","предмет":"Математика"}
        String name;
        String grade;
        String subject;

        public Student(){}

        public Student(String name, String grade, String subject, String age) {
            this.name = name;
            this.grade = grade;
            this.subject = subject;
        }
//Студент [фамилия] получил [оценка] по предмету [предмет]
        @Override
        public String toString() {
            return "Студент " + name +
                    " получил " + grade +
                    " по предмету " + subject + ".";
        }
    }

}


