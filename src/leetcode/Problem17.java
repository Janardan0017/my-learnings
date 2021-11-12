package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emp350 on 3/04/20
 */
public class Problem17 {

    public static final Map<Character, String> digitCharMap = new HashMap<>();

    {
        digitCharMap.put('2', "abc");
        digitCharMap.put('3', "def");
        digitCharMap.put('4', "ghi");
        digitCharMap.put('5', "jkl");
        digitCharMap.put('6', "mno");
        digitCharMap.put('7', "pqrs");
        digitCharMap.put('8', "tuv");
        digitCharMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (char c : chars) {
            String s = digitCharMap.get(c);
            char[] digitChars = s.toCharArray();
            List<String> temp = new ArrayList<>();
            for (String str : result) {
                for (char chr : digitChars) {
                    temp.add(str + chr);
                }
                result = temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
