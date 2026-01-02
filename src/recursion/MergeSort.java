package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 1, 9, 4, 8, 7, 5};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int low, int high) {
        if(low == high) return;
        int mid = low + (high-low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new LinkedList<>();
        int i = low;
        int j = mid+1;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }
        while(i <= mid) {
            temp.add(arr[i++]);
        }
        while(j <= high) {
            temp.add(arr[j++]);
        }
        i = low;
        for(int x: temp) {
            arr[i++] = x;
        }
    }
}