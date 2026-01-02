package algorithm;

import java.util.Arrays;

public class ArrayPermutation {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        permutationWithoutExtraSpace(arr, 0);
    }

    static void permutationWithoutExtraSpace(int[] arr, int k) {
        if(k == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=k; i<arr.length; i++) {
            swap(arr, i, k);
            permutationWithoutExtraSpace(arr, k+1);
            swap(arr, k, i);
        }
    }

    public static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}