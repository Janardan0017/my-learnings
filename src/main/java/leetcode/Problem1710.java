package leetcode;

import java.util.Arrays;

public class Problem1710 {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {5, 10}, {2, 2}, {3, 1}, {3, 3}};
//        int result = maximumUnits(arr, 10);
//        System.out.println(result);
        Arrays.sort(arr, (a,b) -> b[1]-a[1]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        sort(boxTypes);
        int units = 0;
        int i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            if(boxTypes[i][0] <= truckSize) {
                units += boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
            } else {
                units += truckSize * boxTypes[i][1];
                break;
            }
            i++;
        }
        return units;
    }

    static void sort(int[][] arr) {
        boolean swap = true;
        int i;
        while (swap) {
            swap = false;
            for (i = 1; i < arr.length; i++) {
                if (arr[i][1] > arr[i - 1][1]) {
                    int[] temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swap = true;
                }
            }
        }
    }
}
