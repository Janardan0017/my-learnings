package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 5, 4};
//        int[] numbers = {5, 4, 3, 2, 1};
//        int[] numbers = {2, 4, 6, 1, 3, 5};
        int[] numbers = {2, 1, 9, 8};
        System.out.println(Arrays.toString(mergeSort(numbers, 0, numbers.length - 1)));
    }

    public static int[] mergeSort(int[] ar, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            mergeSort(ar, leftIndex, middleIndex);
            mergeSort(ar, middleIndex + 1, rightIndex);
            merge(ar, leftIndex, middleIndex, rightIndex);
        }
        return ar;
    }

    public static void merge(int[] numbers, int leftIndex, int middleIndex, int rightIndex) {
        int leftPointer = leftIndex;
        int middlePointer = middleIndex + 1;
        int[] tempArr = new int[rightIndex - leftIndex + 1];
        int tempArrIndex = 0;
        while (leftPointer <= middleIndex && middlePointer <= rightIndex) {
            if (numbers[leftPointer] < numbers[middlePointer]) {
                tempArr[tempArrIndex] = numbers[leftPointer];
                leftPointer++;
            } else {
                tempArr[tempArrIndex] = numbers[middlePointer];
                middlePointer++;
            }
            tempArrIndex++;
        }

        while (leftPointer <= middleIndex) {
            tempArr[tempArrIndex] = numbers[leftPointer];
            leftPointer++;
            tempArrIndex++;
        }

        while (middlePointer <= rightIndex) {
            tempArr[tempArrIndex] = numbers[middlePointer];
            middlePointer++;
            tempArrIndex++;
        }
        tempArrIndex = leftIndex;
        for (int t : tempArr) {
            numbers[tempArrIndex] = t;
            tempArrIndex++;
        }
    }
}
