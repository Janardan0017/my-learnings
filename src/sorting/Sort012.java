package sorting;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] ar = {2, 1, 0, 2, 1, 0, 2, 1, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(Arrays.toString(sortArray(ar)));
    }

    public static int[] sortArray(int[] ar) {
        int start = 0;
        int end = ar.length - 1;
        int i = 0;
        while (i < end) {
            if (ar[i] == 0) {
                ar[i] = ar[start];
                ar[start] = 0;
                start++;
            } else if (ar[i] == 2) {
                ar[i] = ar[end];
                ar[end] = 2;
                end--;
            }
            i++;
        }
        return ar;
    }
}
