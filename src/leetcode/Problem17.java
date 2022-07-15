package leetcode;

import java.util.*;

/**
 * Created by emp350 on 3/04/20
 */
public class Problem17 {

    public static final Map<Character, String> digitCharMap = new HashMap<>();


    static {
        digitCharMap.put('2', "abc");
        digitCharMap.put('3', "def");
        digitCharMap.put('4', "ghi");
        digitCharMap.put('5', "jkl");
        digitCharMap.put('6', "mno");
        digitCharMap.put('7', "pqrs");
        digitCharMap.put('8', "tuv");
        digitCharMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23456789"));
    }

    public static List<String> letterCombinations(String digits) {
        StringBuilder input = new StringBuilder();
        for(char digit: digits.toCharArray()) {
            input.append(digitCharMap.get(digit));
        }

        List<int[]> combinations = new ArrayList<>();
        combination(digits.length(), input.length(), new int[input.length()], combinations);

        List<String> result = new ArrayList<>();
        for(int[] arr: combinations) {
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == 1) {
                    temp.append(input.charAt(i));
                }
            }
            result.add(temp.toString());
        }
        return result;
    }

    public static void combination(int digitsLength, int n, int[] arr, List<int[]> list) {
        if (n < 1) {
            if(Arrays.stream(arr).sum() == digitsLength) {
                list.add(arr.clone());
            }
        } else {
            arr[n - 1] = 0;
            combination(digitsLength,n - 1, arr, list);
            arr[n - 1] = 1;
            combination(digitsLength,n - 1, arr, list);
        }
    }

}
