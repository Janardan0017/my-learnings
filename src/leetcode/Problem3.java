package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created for interview-preperation on 3/12/20
 */
public class Problem3 {

    public static void main(String[] args) {
        // System.out.println(longestNonRepeatingSubstring("abcd"));
        // System.out.println(longestNonRepeatingSubstring("abccd"));
        // System.out.println(longestNonRepeatingSubstring("aaa"));
        // System.out.println(longestNonRepeatingSubstring("ababa"));
        // System.out.println(longestNonRepeatingSubstring("abcdefc"));
        System.out.println(lengthOfLongestSubstring_map("aabaab!bb"));
    }

    public static boolean containsAll(Map<String, Integer> source, Map<String, Integer> target) {
        for(Map.Entry<String, Integer> entry: source.entrySet()) {
            if(entry.getValue() != target.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

     public static int lengthOfLongestSubstring_map(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;
        for(char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                result = Math.max(end - start, result);
                start = map.get(c) + 1;
            }
            map.put(c, end);
            end += 1;
        }
        return Math.max(result, end - start);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                result = Math.max(set.size(), result);
                while (s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start += 1;
                }
                set.remove(s.charAt(start));
                start += 1;
            }
            set.add(s.charAt(end));
            end += 1;
        }
        return Math.max(result, set.size());
    }

    public static String longestNonRepeatingSubstring(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int[] ar = new int[123];
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                if (ar[chars[j]] != 0) {
                    break;
                }
                sb.append(chars[j]);
                ar[chars[j]]++;
            }
            if (sb.length() > result.length()) {
                result = sb;
            }
        }
        return result.toString();
    }
}
