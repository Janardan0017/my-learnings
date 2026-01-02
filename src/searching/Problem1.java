package searching;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3};
        int[] ar2 = {1, 2, 2};
        int[] ar3 = {1, 2, 2, 3, 4};
        System.out.println(checkDuplicateBruteForce(ar1));
        System.out.println(checkDuplicateBruteForce(ar2));
        System.out.println(checkDuplicateBruteForce(ar3));
        int[] ar = new int[100000];
        for (int i = 1; i < ar.length; i++) {
            ar[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(checkDuplicates(ar));
        System.out.println("Total time: " + (System.currentTimeMillis() - start));
    }

    public static boolean checkDuplicateBruteForce(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDuplicateSorting(int[] ar) {
        Arrays.sort(ar);
        for (int i = 1; i < ar.length; i++) {
            if (ar[i - 1] == ar[i]) {
                return true;
            }
        }
        return false;
    }

    // This only works if array elements are in range of 0 to n-1
    public static boolean checkDuplicates(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < 0) {
                if (ar[Math.abs(ar[i])] < 0)
                    return false;
            }
            ar[ar[i]] = -ar[ar[i]];
        }
        return false;
    }
}
