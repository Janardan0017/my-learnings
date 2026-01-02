package recursionandbacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {

    int[] A;

    public void solve(int n, int k) {
        if (n < 2) {
            System.out.println(Arrays.toString(A));
        } else {
            for (int j = 1; j <= k; j++) {
                A[n - 1] = j;
                solve(n - 1, k);
            }
        }
    }

    public static void main(String[] args) {
        Problem4 obj = new Problem4();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        obj.A = new int[n];
        obj.solve(n, k);
    }
}