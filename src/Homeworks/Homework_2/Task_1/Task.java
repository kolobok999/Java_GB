package Homeworks.Homework_2.Task_1;
//1) Дана строка sql-запроса "select * from students where ".
//   Сформируйте часть WHERE этого запроса, используя StringBuilder.
//   Данные для фильтрации приведены ниже в виде json-строки.
//   Если значение null, то параметр не должен попадать в запрос.
//   Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    private void go() {
        String req = "select * from students where";
        String[] filter = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
//        String[] filter = {"name:null", "country:null", "city:null", "age:null"};
        System.out.println(getRequest(req, filter));
    }

    private String getRequest(String req, String[] filter) {
        StringBuilder sb = new StringBuilder();
        sb.append(req.toUpperCase());
        for (String item : filter) {
            String[] str = item.split(":");
            if (!str[1].equals("null")) {
                sb.append(" ").append(str[0]).append(" = '").append(str[1]).append("'  AND ");
            }
        }
        return sb.substring(0, sb.length()-6);
    }
}
