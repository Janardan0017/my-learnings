package leetcode.dailychallenges;

import java.util.Arrays;

/**
 * Created by emp350 on 29/04/21
 */
public class FirstAndLastPosition {

    public static void main(String[] args) {
//        int[] ar = {5, 7, 7, 8, 8, 10};
        int[] ar = {5, 7, 7, 8, 8, 10};
//        System.out.println(Arrays.toString(searchRange(ar, 5)));
        System.out.println(binarySearch(ar, 8));
        System.out.println(binarySearch(ar, 5));
        System.out.println(binarySearch(ar, 10));
        System.out.println(binarySearch(ar, 1));
    }

    public static int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i <= 0) {
            return new int[]{-1, -1};
        }
        int j = i - 1;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        while (j >= 0 && nums[j] == target) {
            j--;
        }
        return new int[]{j + 1, i - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        int x = (i + j) / 2;
        while (i >= 0 && j <= nums.length) {
            if (nums[x] == target)
                return x;
            if (nums[x] < target) {
                j = x - 1;
            } else {
                i = x + 1;
            }
        }
        return -1;
    }
}
