package leetcode;

import java.util.Arrays;

public class Problem1465 {

    public static void main(String[] args) {
        System.out.println(maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long horizontalMaxDiff = getMaxCuts(horizontalCuts, h);
        long verticalMaxDiff = getMaxCuts(verticalCuts, w);
        long result = (horizontalMaxDiff * verticalMaxDiff) % 1000000007;
        return (int) result;
    }

    public static long getMaxCuts(int[] arr, int n) {
        Arrays.sort(arr);
        long maxDiff = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-arr[i-1] > maxDiff) {
                maxDiff = arr[i] - arr[i-1];
            }
        }
        if(n - arr[arr.length-1] > maxDiff) {
            maxDiff = n - arr[arr.length-1];
        }
        return maxDiff;
    }
}
