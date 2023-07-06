import java.io.File;
import java.io.IOException;

//В консоли запросить имя пользователя. В зависимости от
//        текущего времени, вывести приветствие вида
//        📌 "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        📌 "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        📌 "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        📌 "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.go();
    }

    void go(){
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.txt");
        File f3 = new File(pathFile);
        System.out.println(f3.getAbsoluteFile());
    }
}