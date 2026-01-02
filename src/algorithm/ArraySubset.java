package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ArraySubset {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        subset(arr, new ArrayList<>(), 0);
    }

    public static void subset(int[] arr, List<Integer> sub, int idx) {
        if (idx == arr.length) {
            System.out.println(sub);
            return;
        }
        sub.add(arr[idx]);
        subset(arr, sub, idx + 1);
        sub.removeLast();
        subset(arr, sub, idx + 1);
    }
}
