package codeforecs;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArraysAndSwaps {

    public static void solve(int[] A, int[] B, int n, int k) {
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        while (i < k && A[i] < B[n - i - 1]) {
            int x = A[i];
            A[i] = B[n - 1 - i];
            B[n - 1 - i] = x;
            i++;
        }
        int sum = 0;
        for (int m = 0; m < n; m++) {
            sum += A[m];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String nk = in.nextLine();
            String inputArrayA = in.nextLine();
            String inputArrayB = in.nextLine();
            String[] nkArr = nk.split(" ");
            int n = Integer.parseInt(nkArr[0]);
            int k = Integer.parseInt(nkArr[1]);
            int[] A = new int[n];
            int[] B = new int[n];
            String[] arrayA = inputArrayA.split(" ");
            String[] arrayB = inputArrayB.split(" ");
            java.util.Arrays.setAll(A, i -> Integer.parseInt(arrayA[i]));
            java.util.Arrays.setAll(B, i -> Integer.parseInt(arrayB[i]));
            solve(A, B, n, k);
        }
    }
}