
import java.util.HashMap;
import java.util.Map;

public class Problem128 {

    public static void main(String[] args) {
        // System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, 1);
        }

        int max = 0;
        for(int n: nums) {
            Integer current = map.get(n);
            if(current == null) {
                continue;
            }
            Integer left = map.get(n-1);
            Integer right = map.get(n+1);
            if(left != null) {
                map.put(n-1, left + current);
                max = Math.max(max, left + current);
            }
            if(right != null) {
                map.put(n+1, right + current);
                max = Math.max(max, right + current);
            }
            map.remove(n);
        }
        return max;
    }
}