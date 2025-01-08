package algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for(int i=-1; i< 12; i++) {
            System.out.println(i + ": "+getPosition(arr, i));
        }
    }

    public static int getPosition(int[] arr, int x) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        while(leftIndex < arr.length && rightIndex >= 0) {
            if(arr[middle] == x) {
                break;
            } else if(arr[middle] > x) {
                rightIndex = middle - 1;
            } else {
                leftIndex = middle + 1;
            }
            middle = leftIndex + (rightIndex - leftIndex) / 2;
        }
        return middle >= 0 && middle < arr.length && arr[middle] == x ? middle : -1;
    }
}

// 1 2 3 4 5 6 7 8 9
// binary search algorithm to find x in arr
// 1. leftIndex = 0 and rightIndex = arr.size-1
// 2. middle = leftIndex + (rightIndex-leftIndex)/2;
// 3. do while leftIndex >= 0 && rightIndex < arr.size
// 4. if arr[middle] = x then return middle
//    else if arr[middle] < x then leftIndex = middle+1
//    else if arr[middle] > x then rightIndex = middle-1