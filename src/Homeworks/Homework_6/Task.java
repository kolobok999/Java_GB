package Homeworks.Homework_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//        отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//        Например: "Введите цифру, соответствующую необходимому критерию":
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет
//        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.go();
    }

    public void go() {
        HashSet<Notebook> notebooks = new HashSet<>();
        notebooks.add(createNotebook("HP", "Chromebook 14a-na0226nr",
                "Silver", 64, "Celeron", 4, "Chrome OS"));

        notebooks.add(createNotebook("Acer", "SFX14-42G-R607",
                "Gray", 512, "Ryzen 7", 16, "Windows 11 Home"));

        notebooks.add(createNotebook("MSI", "Stealth GS77 -17",
                "Black", 16384, "Core i9", 64, "Windows 11 Pro"));

        notebooks.add(createNotebook("Dell", "XPS 9720 Laptop",
                "Silver", 16384, "Core i9", 64, "Windows 11 Pro"));

        notebooks.add(createNotebook("ASUS", "ProArt StudioBook Pro X",
                "Gray", 4096, "Intel Xeon", 64, "Windows 10 Pro"));

        System.out.println(notebooks);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Введите цифру, соответствующую необходимому критерию\":\n" +
                        "        1 - ОЗУ\n" +
                        "        2 - Объем ЖД\n" +
                        "        3 - Операционная система\n" +
                        "        4 - Цвет\n" +
                        "Для выхода введите \"end\"");
                String f = reader.readLine();
                if (f.equalsIgnoreCase("end")) break;
                filters(Integer.parseInt(f), reader, notebooks);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Notebook createNotebook(String brand, String modelName, String color, int hardDiskSize, String cpuModel, int ramMemory, String operatingSystem) {
        return new Notebook(brand, modelName, color, hardDiskSize, cpuModel, ramMemory, operatingSystem);
    }

    public void filters(int n, BufferedReader reader, HashSet<Notebook> notebooks) throws IOException {
        int min;
        int max;
        String s;
        switch (n) {
            case 1:
                System.out.println("Введите диапазон ОЗУ");
                min = Integer.parseInt(reader.readLine());
                max = Integer.parseInt(reader.readLine());
                for (Notebook nb : notebooks) {
                    if (nb.getRamMemory() >= min && nb.getRamMemory() <= max) {
                        System.out.println(nb);
                    }
                }
                break;
            case 2:
                System.out.println("Введите диапазон объема ЖД");
                min = Integer.parseInt(reader.readLine());
                max = Integer.parseInt(reader.readLine());
                for (Notebook nb : notebooks) {
                    if (nb.getHardDiskSize() >= min && nb.getHardDiskSize() <= max) {
                        System.out.println(nb);
                    }
                }
                break;
            case 3:
                System.out.println("Введите ОС");
                s = reader.readLine();
                for (Notebook nb : notebooks) {
                    if (nb.getOperatingSystem().contains(s.substring(0, 1).toUpperCase() + s.substring(1))) {
                        System.out.println(nb);
                    }
                }
                break;
            case 4:
                System.out.println("Введите цвет:");
                s = reader.readLine();
                for (Notebook nb : notebooks) {
                    if (nb.getColor().contains(s.substring(0, 1).toUpperCase() + s.substring(1))) {
                        System.out.println(nb);
                    }
                }
                break;
            case 5:
            case 6:
            case 7:
            default:
                System.out.println("Нет такого критерия поиска");
        }
    }


}
