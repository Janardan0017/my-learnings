package searching;

import java.util.Arrays;

public class Problem18 {

    public static void main(String[] args) {
        int[] arr0 = {1,2,3,1,2,3,3};
        int[] arr1 = {1,2,3,3,2,3,3};
        int[] arr2 = {1,1,1,1,1,1,1};
        System.out.println(getOddOccurredNumber(arr0));
        System.out.println(getOddOccurredNumber(arr1));
        System.out.println(getOddOccurredNumber(arr2));
    }

    static int getOddOccurredNumber(int[] arr) {
        return Arrays.stream(arr).reduce(0, (x, y) -> x ^ y);
//        int x = 0;
//        for(int n: arr) {
//            x = x ^ n;
//        }
//        return x;
    }
}
