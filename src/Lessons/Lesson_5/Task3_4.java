package Lessons.Lesson_5;

import java.util.*;

//Написать метод, который переведет число из римского формата записи в арабский.
// Например, MMXXII = 2022
public class Task3_4 {
    public static void main(String[] args) {
        Task3_4 task34 = new Task3_4();
        task34.go();
    }

    private void go() {
        String data = "MMXIX";
//        String data = "MMXXII";
        System.out.printf("%s = %d\n", data, romanToArabic(data));
        System.out.println(intToRoman(2019));
    }

    private int romanToArabic(String roman) {
        int arabic = 0;
        Map<Character, Integer> dict = romanMap();
        char[] ch = roman.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            if (!dict.containsKey(ch[i])) return -1;
            if (dict.get(ch[i]) >= dict.get(ch[i + 1])) {
                arabic += dict.get(ch[i]);
            } else {
                arabic -= dict.get(ch[i]);
            }
        }
        arabic += dict.get(ch[ch.length - 1]);

        return arabic;
    }

    private Map<Character, Integer> romanMap() {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        return dict;
    }
    public String intToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }
    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

}
