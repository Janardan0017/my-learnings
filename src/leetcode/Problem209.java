package leetcode;

public class Problem209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minWindow = nums.length;
        while(end < nums.length) {
            if(sum < target) {  // if sum is less than target then add the next element
                sum += nums[end];
                end++;
            } else { // if sum is greater or equal to target                
                minWindow = Math.min(minWindow, end - start);
                sum -= nums[start];
                start += 1;
            }
        }
        while(sum - nums[start] >= target) {
            sum -= nums[start];
            start += 1;
        }
        if(start == 0 && end == nums.length && sum < target) {
            return 0;
        }
        return Math.min(minWindow, end - start);
    }
}