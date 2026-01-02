package leetcode;

import java.util.*;

public class Problem30 {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int start = 0;
        int end = words.length * wordLength;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        while (end <= s.length()) {
            if (isContanated(s, start, end, wordLength, wordsMap)) {
                result.add(start);
            }
            start++;
            end++;
        }
        return result;
    }

    public static boolean isContanated(String s, int start, int end, int wordLength,
            Map<String, Integer> wordsMap) {
        Map<String, Integer> testMap = new HashMap<>(wordsMap);
        for (int i = start; i < end; i += wordLength) {
            String str = s.substring(i, i+wordLength);
            Integer count = testMap.get(str);
            if(count == null || count == 0) {
                return false;
            }
            testMap.put(str, count-1);
        }
        return true;
    }
}
