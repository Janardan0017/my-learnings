package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created for interview-preperation on 3/12/20
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(longestNonRepeatingSubstring("abcd"));
        System.out.println(longestNonRepeatingSubstring("abccd"));
        System.out.println(longestNonRepeatingSubstring("aaa"));
        System.out.println(longestNonRepeatingSubstring("ababa"));
        System.out.println(longestNonRepeatingSubstring("abcdefc"));
    }

    public static String longestNonRepeatingSubstring(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int[] ar = new int[123];
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                if (ar[chars[j]] != 0)
                    break;
                sb.append(chars[j]);
                ar[chars[j]]++;
            }
            if (sb.length() > result.length())
                result = sb;
        }
        return result.toString();
    }
}
