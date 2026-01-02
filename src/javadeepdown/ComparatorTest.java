package javadeepdown;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int first = a[0] - b[0];
                return first == 0 ? a[1] - b[1] : first;
            }
        };
        
        Comparator<String> lengthComparator = (s1, s2) -> s1.length() > s2.length() ? 1 : -1;
        String[] strArr = {"jana", "ch", "z", "abc"};
        Arrays.sort(strArr, lengthComparator);
        System.out.println(Arrays.toString(strArr));

        // Comparator<int[]> twoDSort = (arr1, arr2) -> arr1[0] <= arr2[0] && arr1[1] <= arr2[1] ? -1 : 1;
        // int[][] arr = {{3, 7}, {2, 4}, {1, 3}, {3, 20}, {5, 15}, {3, 10}};xzxj/.q        
        // int[][] newArr = Arrays.copyOf(arr, arr.length + 1);
        // Arrays.sort(arr, twoDSort);
        // for (int[] a : newArr) {
        //     System.out.println(a[0] + ", " + a[1]);
        // }
        int[][] arrr = {{3, 7}, {2, 4}, {1, 3}, {3, 20}, {5, 15}, {3, 10}};
        Arrays.sort(arrr, comp);
        for (int[] a : arrr) {
            System.out.println(a[0] + ", " + a[1]);
        }
    }
}