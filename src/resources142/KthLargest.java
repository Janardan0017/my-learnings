package resources142;

public class KthLargest {
	
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 6, 2, 3};
		int k = 4;
		int res = getKthLargest(arr, k);
		System.out.println(res);
	}
	
	public static int getKthLargest(int[] nums, int k) {
		java.util.Arrays.sort(nums);
		
		return nums[nums.length - k];
	}
}