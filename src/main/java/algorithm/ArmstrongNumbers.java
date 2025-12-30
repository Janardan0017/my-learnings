package algorithm;

/**
 * An Armstrong number is a number where the sum of its digits raised to the
 * power of the number of digits equals the number itself. Eg: 1, 2, 3, 4, 5, 6,
 * 7, 8, 9, 153, 370, 371, 407, 1634, and 8208
 */
public class ArmstrongNumbers {

    public static void main(String[] args) {
        int count = 0;
        int x = 1;
        long start = System.currentTimeMillis();
        while (count < 50) {
            if (isArmstrongNumber(x)) {
                System.err.println(x);
                count++;
            }
            x++;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static boolean isArmstrongNumber(int n) {
        int temp = n;
        int digitCount = digitCount(temp);
        int sum = 0;
        while (temp > 0 && sum < n) {
            sum += Math.pow(temp % 10, digitCount);
            temp /= 10;
        }
        return sum == n;
    }

    public static int digitCount(int n) {
        if (n < 10) {
            return 1;
        }
        return digitCount(n/10) + 1;
    }
}
