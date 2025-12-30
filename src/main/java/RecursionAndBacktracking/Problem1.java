package madeeasy.RecursionAndBacktracking;

import java.util.Scanner;

public class Problem1 {

    static int count = 0;

    static void solve(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            count++;
            System.out.println(count+": "+fromPeg + " -> " + toPeg);
            return;
        }
        solve(n - 1, fromPeg, auxPeg, toPeg);
        count++;
        System.out.println(count+": "+fromPeg + " -> " + toPeg);
        solve(n - 1, auxPeg, toPeg, fromPeg);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n, 'C', 'A', 'B');
    }
}