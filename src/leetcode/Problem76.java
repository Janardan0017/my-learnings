
import java.util.*;

class Problem76 {

    public static void main(String[] args) {
        System.out.println(minWindow("babb", "baba"));
        System.out.println(minWindow("bbaac", "aba"));
        System.out.println(minWindow("ab", "a"));
        System.out.println(minWindow("aa", "aa"));
        System.out.println(minWindow("abcabdebac", "cda"));
        System.out.println(minWindow("BBBBA", "AB"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("A", "ABC"));
        System.out.println(minWindow("bba", "ab"));
        System.out.println(minWindow("ASDFG", "ASDFG"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        char[] sArr = s.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        while (i < s.length() && !sameMap(sMap, tMap)) {
            if (tMap.containsKey(sArr[i])) {
                sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0) + 1);
            }
            i++;
        }

        if (!sameMap(sMap, tMap)) {
            return "";
        }

        // shrink the starting point as much as possible
        int end = i;
        int start = shrink(sMap, tMap, sArr, 0);
        int[] minWindow = {start, end};
        char startChar = sArr[start];
        while (end < sArr.length) {
            char endChar = sArr[end];
            Integer charCount = sMap.get(endChar);
            if (charCount != null) {
                sMap.put(endChar, charCount + 1);
                if (endChar == startChar) {
                    start = shrink(sMap, tMap, sArr, start);
                    startChar = sArr[start];
                    if (end - start + 1 < minWindow[1] - minWindow[0]) {
                        minWindow[0] = start;
                        minWindow[1] = end + 1;
                    }
                }
            }
            end++;
        }
        return s.substring(minWindow[0], minWindow[1]);
    }

    public static boolean sameMap(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static int shrink(Map<Character, Integer> sMap, Map<Character, Integer> tMap, char[] sArr, int start) {
        Integer temp = sMap.get(sArr[start]);
        while (temp == null || temp > tMap.get(sArr[start])) {
            if (temp != null) {
                sMap.put(sArr[start], temp - 1);
            }
            start++;
            temp = sMap.get(sArr[start]);
        }
        return start;
    }

}
