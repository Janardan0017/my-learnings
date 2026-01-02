package madeeasy.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {

    int[] A;

    void solve(int n) {
        if (n < 1) {
            System.out.println(Arrays.toString(A));
        } else {
            A[n - 1] = 0;
            solve(n - 1);
            A[n - 1] = 1;
            solve(n - 1);
        }
    }

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        obj.A = new int[n];
        obj.solve(n);
    }
}