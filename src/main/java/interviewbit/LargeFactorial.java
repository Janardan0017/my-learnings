package interviewbit;

import java.math.BigInteger;

public class LargeFactorial {

    public static void main(String[] args) {
        System.out.println(solve2(0));
        System.out.println(solve2(1));
        System.out.println(solve2(2));
        System.out.println(solve2(5));
        System.out.println(solve2(10));
    }

    public static String solve(int n) {
        if (n <= 1) {
            return "1";
        }
        BigInteger factorial = BigInteger.valueOf(n);
        n--;
        while (n > 1) {
            factorial = BigInteger.valueOf(n).multiply(factorial);
            n--;
        }
        return factorial.toString();
    }

    public static String solve2(int n) {
        if (n <= 1) {
            return "1";
        }
        String fact = "1";
        while (n > 1) {
            fact = multiply(fact, n);
            n--;
        }
        return fact;
    }

    public static String multiply(String str, int n) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int temp = Integer.parseInt(String.valueOf(str.charAt(i))) * n + remainder;
            sb.insert(0, temp % 10);
            remainder = temp / 10;
        }
        if (remainder > 0) {
            sb.insert(0, remainder);
        }
        return sb.toString();
    }
}
