package Lessons.Lesson_2;

import java.io.*;
import java.util.logging.*;
//📌Напишите метод, который вернет содержимое текущей папки в виде массива строк.
//📌Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
//📌Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.


//📌Напишите метод, который определит тип (расширение) файлов из текущей папки
//  и выведет в консоль результат вида
//    1 Расширение файла: txt
//    2 Расширение файла: pdf
//    3 Расширение файла:
//    4 Расширение файла: jpg

public class Task5 {
    static Logger logger = Logger.getLogger(Task5.class.getName());
    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.go();
    }

    private void go() {
        String pathProject = System.getProperty("user.dir");
        String path = pathProject + "/src/Lessons/Lesson_2/";
        setLogger(path);
        String file = path + "out.txt";
        writeListToFile(file, getPaths(path));
        getExtensions(file);
    }

    private void setLogger(String path) {
        try {
            FileHandler fh = new FileHandler(path + "log.xml");
            logger.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    private String[] getPaths(String path) {
        File file = new File(path);
        return file.list();
    }

    private void writeListToFile(String fileName, String[] data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
            for (String line : data) {
                br.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Error " + ex);
            logger.info(ex.getMessage());
        }
    }
    private void getExtensions(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int i = 1;
            while (line != null) {
                String ext = line.substring(line.lastIndexOf('.'));
                System.out.printf("%d Расширение файла: %s\n",i++, ext);
                line = br.readLine();
            }
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }

    }
}
