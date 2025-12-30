package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem629 {

    public static void main(String[] args) {
//        int count = kInversePairs(100, 1);
//        System.out.println(count);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        System.out.println(list1.equals(list2));

    }

    public static int kInversePairs(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j) {
                    System.out.println("(" + i + "," + j + ")");
                    count++;
                }
            }
        }
        return count;
    }
}
