package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem1695 {

    public static void main(String[] args) {
        int[] ar = {1,2,3};
        int[] ar2 = {1,2,1,3,1,4,1,5,1,6};
        System.out.println(maximumUniqueSubarray(ar));
        System.out.println(maximumUniqueSubarray(ar2));

    }

    // get each sub array with unique elements
    // get the sum of each sub array
    // pick the sub array with maximum sum
    public static int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        for(int i=0; i<nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=i; j<nums.length; j++) {
                if(set.contains(nums[j])) {
                    int sum = set.stream().reduce(0, Integer::sum);
                    if(sum > maxSum) {
                        maxSum = sum;
                    }
                    break;
                } else {
                    set.add(nums[j]);
                }
            }
            int sum = set.stream().reduce(0, Integer::sum);
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}