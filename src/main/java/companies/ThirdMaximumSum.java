package companies;

import java.util.Arrays;
import java.util.Scanner;

public class ThirdMaximumSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while (!str.equalsIgnoreCase("exit")) {
            String[] strArr = str.trim().split(" ");
            int[] ar = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
            System.out.println(thirdMaxSum(ar));
            str = scan.nextLine();
        }
    }

    static int thirdMaxSum(int[] ar) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int n : ar) {
            if (n > first) {
                if (first > second) {
                    if (second > third) {
                        third = second;
                    }
                    second = first;
                }
                first = n;
            } else if (n > second) {
                if (second > third) {
                    third = second;
                }
                second = n;
            } else if (n > third) {
                third = n;
            }
        }
        System.out.println(first + " " + second + " " + third);
        return second + third;
    }
}
