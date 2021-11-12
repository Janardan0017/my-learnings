package hackerrank;

import java.util.Arrays;
import java.util.TreeSet;

public class FindAllSubset {

    public static void main(String[] args) {
        String s = "abcdefghi";
        String[] res = findSubset(s);
        Arrays.sort(res);
        for (String x : res) {
            System.out.println(x);
        }
    }

    public static String[] findSubset(String s) {
        TreeSet<String> treeSet = new TreeSet<>();
        char[] ar = s.toCharArray();
        for (int i = 1; i < Math.pow(2, ar.length); i++) {
            int j = ar.length - 1;
            int x = i;
            StringBuilder sb = new StringBuilder();
            while (x > 0) {
                if (x % 2 != 0) {
                    sb.insert(0, ar[j]);
                }
                j--;
                x /= 2;
            }
            treeSet.add(sb.toString());
        }
        return treeSet.toArray(new String[0]);
    }
}
