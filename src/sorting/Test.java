package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n = in.nextInt();
        int[] ar = new int[n];
        Arrays.setAll(ar, p -> (int) (Math.random() * n));
        System.out.println(Arrays.toString(ar));
        ar = bubbleSort(ar);
        System.out.println(Arrays.toString(ar));

    }

    // swap adjacent elements if ar[i] > ar[i+1]
    static int[] bubbleSort(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (ar[j - 1] > ar[j]) {
                    int x = ar[j];
                    ar[j] = ar[j - 1];
                    ar[j - 1] = x;
                }
            }
        }
        return ar;
    }
}