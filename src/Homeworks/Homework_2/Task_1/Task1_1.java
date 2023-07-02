package Homeworks.Homework_2.Task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//1) Дана строка sql-запроса "select * from students where ".
//   Сформируйте часть WHERE этого запроса, используя StringBuilder.
//   Данные для фильтрации приведены ниже в виде json-строки.
//   Если значение null, то параметр не должен попадать в запрос.
//   Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class Task1_1 {
    public static void main(String[] args) {
        Task1_1 task11 = new Task1_1();
        task11.go();
    }

    private void go() {
        String fileName = "src/Homeworks/Homework_2/Task_1/Students.json";
        String req = "select * from students where";
        List<Student> myStudents= getStudents(fileName);
        for (Student myStudent : myStudents) {
            System.out.println(myStudent.toString());
            System.out.println(getRequest(req, myStudent));
            System.out.println();
        }
    }

    private String getRequest(String req, Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(req.toUpperCase());
        if (student.age.equals("null") &&
                student.city.equals("null") &&
                student.country.equals("null") &&
                student.name.equals("null"))
            return sb.substring(0, sb.length() - 6);

        if (!student.name.equals("null"))
            sb.append(" name='").append(student.name).append("'");

        if (!student.country.equals("null") &&
                !student.name.equals("null"))
            sb.append(" AND");
        if (!student.country.equals("null"))
            sb.append(" country='").append(student.country).append("'");

        if (!student.city.equals("null") &&
                (!student.country.equals("null") ||
                        !student.name.equals("null")))
            sb.append(" AND");
        if (!student.city.equals("null"))
            sb.append(" city='").append(student.city).append("'");

        if (!student.age.equals("null") &&
                (!student.city.equals("null") ||
                        !student.country.equals("null") ||
                        !student.name.equals("null")))
            sb.append(" AND");

        if (!student.age.equals("null"))
            sb.append(" age='").append(student.age).append("'");
        return sb.toString();
    }

    private List<Student> getStudents(String fileName) {
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        List<Student> myStudents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                Student student = new Student();
                student.name = parse(line,0);
                student.country = parse(line, 1);
                student.city = parse(line, 2);
                student.age = parse(line, 3);
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
        String name;
        String country;
        String city;
        String age;

        public Student(){}

        public Student(String name, String country, String city, String age) {
            this.name = name;
            this.country = country;
            this.city = city;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student {" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

