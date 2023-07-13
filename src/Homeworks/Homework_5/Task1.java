package Homeworks.Homework_5;

import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.go();
    }

    private void go() {
        Map<Integer, Map<String, List<Integer>>> phoneBook = new HashMap<>();
        addPersonToPhonebook(phoneBook, createPerson("Кирилл", Arrays.asList(123456,123457,123458)));
        System.out.println(phoneBook);
        addPersonToPhonebook(phoneBook, createPerson("Илья", Arrays.asList(1234,123434,12358)));
        System.out.println(phoneBook);
        addPersonToPhonebook(phoneBook, createPerson("Илья", Arrays.asList(222222222,333333333)));
        System.out.println(phoneBook);
    }

    public void addPersonToPhonebook(Map<Integer, Map<String, List<Integer>>> phoneBook, Person person) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put(person.name, person.phones);
        phoneBook.put(phoneBook.size() + 1, map);
    }

    public Person createPerson(String name, List<Integer> phones){
        return new Person(name, phones);
    }

    public static class Person {
        String name;
        List<Integer> phones;

        public Person(String name, List<Integer> phones) {
            this.name = name;
            this.phones = phones;
        }
    }

}
