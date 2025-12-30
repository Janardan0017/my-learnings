package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(8, 89));
        System.out.println(largestNumber(list2));
//        System.out.println(largestNumber(list2));
//        System.out.println(compare(3, 30));
//        System.out.println(compare(30, 3));
//        System.out.println(compare(8, 89));
//        System.out.println(compare(8, 9));
//        System.out.println(compare(18, 91));
//        System.out.println(compare(88, 97));
//        System.out.println(compare(9, 8));
    }

    public static String largestNumber(final List<Integer> A) {
        StringBuilder sb = new StringBuilder();
        int[] ints = A.stream().mapToInt(x -> x).toArray();
        mergeSort(ints, 0, ints.length - 1);
        for (int z : ints) {
            sb.append(z);
        }
        if (sb.charAt(0) == '0')
            return String.valueOf(0);
        return sb.toString();
    }

    public static boolean compare(int x, int y) {
        return Long.parseLong(x + "" + y) > Long.parseLong(y + "" + x);
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
            if (compare(ar[i], ar[j])) {
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
