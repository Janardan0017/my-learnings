package leetcode;

import java.util.*;

public class Problem890 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("aab", "abc", "abd", "cdd", "mkk");
        String pattern = "xyy";
        solve(words, pattern);
    }

    public static List<String> solve(List<String> words, String pattern) {
        List<String> result = new ArrayList<>();
        char[] patternChars = pattern.toCharArray();
        for(String word: words) {
            Map<Character, Character> charMap = new HashMap<>();
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char ch = wordChars[i];
                if (!charMap.containsKey(ch)) {
                    charMap.put(ch, patternChars[i]);
                }
                wordChars[i] = charMap.get(ch);
            }
            System.out.println(String.valueOf(wordChars));

        }
        return result;
    }
}
