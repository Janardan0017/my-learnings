package resources142;

public class KthSmallest {

    public static int getkthSmallestIfAllNumsAreDifferent(int[] nums, int k) {
        if (k > nums.length) {
            System.out.println("Invalid input");
            return -1;
        }
        java.util.Arrays.sort(nums);
        return nums[k - 1];
    }

    public static void main(String[] args) {

        int[] nums = {8, 4, 3, 5, 6, 2, 1, 9, 0, 7};
        int kthSmallest = getkthSmallestIfAllNumsAreDifferent(nums, 5);
        System.out.println(kthSmallest);
    }
}