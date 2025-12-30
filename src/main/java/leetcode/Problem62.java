package leetcode;

public class Problem62 {

    static int result;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(uniquePathsRecursion(51, 9));
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        System.out.println(uniquePathsMemoization(51, 9));
        System.out.println(System.currentTimeMillis()-start);
    }

    // recursive solution
    public static int uniquePathsRecursion(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        } else if (m < 1 || n < 1) {
            return 0;
        } else {
            return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n - 1);
        }
    }

    // memoization solution
    public static int uniquePathsMemoization(int m, int n) {
        return traverseForMemoization(m - 1, n - 1, new int[m][n]);
    }

    private static int traverseForMemoization(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 && n == 0) {
            return 1;
        } else if (memo[m][n] > 0) {
            return memo[m][n];
        } else {
            memo[m][n] = traverseForMemoization(m - 1, n, memo) + traverseForMemoization(m, n - 1, memo);
            return memo[m][n];
        }
    }
}
