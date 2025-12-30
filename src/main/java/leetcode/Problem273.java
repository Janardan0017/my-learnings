package leetcode;

import java.util.HashMap;

public class Problem273 {

    static HashMap<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eveven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }

    public static void main(String[] args) {
//        for (int i = 100; i < 200; i++) {
//            System.out.println("\"" + numberToWords(i) + "\"");
//        }
        System.out.println("\"" + numberToWords(100) + "\"");
        System.out.println("\"" + numberToWords(1000) + "\"");
        System.out.println("\"" + numberToWords(900) + "\"");
        System.out.println("\"" + numberToWords(1000000) + "\"");
        System.out.println("\"" + numberToWords(100000) + "\"");
        System.out.println("\"" + numberToWords(80000000) + "\"");
        System.out.println("\"" + numberToWords(100200300) + "\"");
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 21) {
            return map.get(num);
        } else if (num < 100) {
            int unit = num % 10;
            int deci = (num / 10) * 10;
            if (unit == 0) {
                return map.get(deci);
            } else {
                return map.get(deci) + " " + map.get(unit);
            }
        } else if (num < 1000) {
            return map.get(num / 100) + (num % 100 == 0 ? " Hundred" : " Hundred " + numberToWords(num % 100));
        } else if (num < 1000000) {
            return numberToWords(num / 1000) + (num % 1000 == 0 ? " Thousand" : " Thousand " + numberToWords(num % 1000));
        } else if (num < 1000000000) {
            return numberToWords(num / 1000000) + (num % 1000000 == 0 ? " Million" : " Million " + numberToWords(num % 1000000));
        } else {
            return map.get(num / 1000000000) + (num % 1000000000 == 0 ? " Billion" : " Billion " + numberToWords(num % 1000000000));
        }
    }
}
