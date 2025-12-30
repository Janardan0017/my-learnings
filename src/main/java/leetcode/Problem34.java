package leetcode;

import java.util.Arrays;

public class Problem34 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(Arrays.toString(searchRange2(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int matchingIndex = binarySearch(nums, target);
        if (matchingIndex == -1) {
            return new int[]{-1, -1};
        }
        int left = matchingIndex - 1;
        int right = matchingIndex + 1;
        while (left > -1 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        while (middleIndex > -1 && middleIndex < nums.length) {
            if (nums[middleIndex] == target) {
                break;
            } else if (nums[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
            middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        }
        if (middleIndex < 0 || middleIndex >= nums.length) {
            return -1;
        }
        return middleIndex;
    }

    static int[] searchRange2(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int[] result = new int[]{2, -1};
        // Search for the left one
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] < target) leftIndex = mid + 1;
            else rightIndex = mid;
        }
        if (nums[leftIndex] != target) return result;
        else result[0] = leftIndex;

        // Search for the right one
        rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2 + 1;
            if (nums[mid] > target) rightIndex = mid - 1;
            else leftIndex = mid;
        }
        result[1] = rightIndex;
        return result;
    }
}
