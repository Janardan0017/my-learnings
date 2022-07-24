package leetcode;

public class Problem70 {

    static int ways = 0;

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        if(n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void steps(int n) {
        if(n==0) {
            System.out.println("found");
            ways += 1;
            return;
        } else if(n < 0) {
            return;
        }
        steps(n-1);
        steps(n-2);
    }
}
