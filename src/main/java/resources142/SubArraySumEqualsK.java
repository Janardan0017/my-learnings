package resources142;

public class SubArraySumEqualsK {

    public static void main(String[] args) {

        int[] ar = {1, 1, 1, 1, 1};
        int res = subarraySum(ar, 2);
        System.out.println(res);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}