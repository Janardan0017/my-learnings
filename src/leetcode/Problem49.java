package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            List<String> list = map.get(sortedStr);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sortedStr, list);
        }
        List<List<String>> result = new ArrayList<>();
        map.forEach((key, value) -> {
            result.add(value);
        });
        return result;
    }
}