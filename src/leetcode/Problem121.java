package leetcode;

import java.util.Collections;
import java.util.TreeMap;

public class Problem121 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(arr);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int n : prices) {
            if (treeMap.containsKey(n)) {
                treeMap.put(n, treeMap.get(n) + 1);
            } else {
                treeMap.put(n, 1);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (treeMap.get(prices[i]) > 1) {
                treeMap.put(prices[i], treeMap.get(prices[i]) - 1);
            } else {
                treeMap.remove(prices[i]);
            }
            maxProfit = Math.max(maxProfit, treeMap.firstKey() - prices[i]);
        }
        return maxProfit;
    }
}
