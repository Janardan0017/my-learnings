package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] ar = {1, 2, 3, 5, 4};
//        int[] ar = {5, 4, 3, 2, 1};
//        int[] ar = {2, 4, 6, 1, 3, 5};
        int[] ar = {2, 1, 9, 8};
        System.out.println(Arrays.toString(mergeSort(ar, 0, ar.length - 1)));
    }

    public static int[] mergeSort(int[] ar, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(ar, l, m);
            mergeSort(ar, m + 1, r);
            merge(ar, l, m, r);
        }
        return ar;
    }

    public static void merge(int[] ar, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = 0;
        int[] temp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (ar[i] < ar[j]) {
                temp[k] = ar[i];
                i++;
            } else {
                temp[k] = ar[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            temp[k] = ar[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = ar[j];
            j++;
            k++;
        }
        k = l;
        for (int t : temp) {
            ar[k] = t;
            k++;
        }
    }
}
