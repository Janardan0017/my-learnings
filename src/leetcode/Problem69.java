package leetcode;

public class Problem69 {

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        int x = (int) Math.sqrt(n);
        int y = mySqrt(n);
        System.out.println(x + " " + y);
    }

    public static int mySqrt(int x) {
        long temp = x/2;
        while(temp * temp > x) {
            temp /= 2;
        }
        long square = temp*temp;
        while(square < x) {
            temp++;
            square = temp * temp;
        }
        return square > x ? (int)(temp-1) : (int)temp;
    }
}