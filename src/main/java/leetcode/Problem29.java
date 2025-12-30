package leetcode;

public class Problem29 {

    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }

    public static int divide(int dividend, int divisor) {
        int isPositive = 1;
        long y = dividend;
        long x = divisor;
        if (y < 0) {
            isPositive *= -1;
            y *= -1;
        }
        if (x < 0) {
            isPositive *= -1;
            x *= -1;
        }
        if (x == 1) {
            long result = y * isPositive;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) result;
        }
        if (dividend == divisor) {
            return isPositive;
        }
        int count = 0;
        while (y > x) {
            y -= x;
            count++;
        }
        return count * isPositive;
    }
}
