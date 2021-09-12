package interviewbit;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubArray {

    public static void main(String[] args) {
        Integer[] ar = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<Integer> integers = Arrays.asList(ar);
        System.out.println(maxSubArray(integers));
    }

    public static int maxSubArray(final List<Integer> A) {
        int max = A.get(0);
        int sum = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int x = A.get(i);
            if (x > sum) {
                sum = x;
            } else if (x + sum >= sum) {
                sum += x;
            } else if (x + sum < sum && x+sum < max) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
