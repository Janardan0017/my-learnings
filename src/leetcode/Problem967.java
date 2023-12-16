package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem967 {

    public static void main(String[] args) {
        Problem967 obj = new Problem967();
        int[] ints = obj.numsSameConsecDiff(3, 7);
        System.out.println(Arrays.toString(ints));
    }

    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        for (int i = 1; i < n; i++) {
            Set<Integer> newNums = new HashSet<>();
            for (Integer num : numbers) {
                int lastDigit = num % 10;
                int plusDigit = lastDigit + k;
                int minusDigit = lastDigit - k;
                if (plusDigit >= 0 && plusDigit < 10) {
                    newNums.add(num * 10 + plusDigit);
                }
                if (minusDigit >= 0 && minusDigit < 10) {
                    newNums.add(num * 10 + minusDigit);
                }
            }
            numbers = newNums;
        }
        int[] nums = new int[numbers.size()];
        int i = 0;
        for (int x : numbers) {
            nums[i] = x;
            i++;
        }
        return nums;
    }
}
