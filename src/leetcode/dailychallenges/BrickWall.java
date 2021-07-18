package leetcode.dailychallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by emp350 on 22/04/21
 */
public class BrickWall {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));

        System.out.println(leastBricks(wall));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        int[] indexes = new int[wall.size()];
        int[] sum = new int[wall.size()];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < wall.size(); i++) {
            int x = wall.get(i).get(0);
            sum[i] = x;
            if (x <= min1) {
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        int minCut = Integer.MAX_VALUE;
        while (min1 != min2) {
            int x = min1;
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            for (int i = 0; i < wall.size(); i++) {
                if (sum[i] < x) {
                    sum[i] = sum[i] + wall.get(i).get(indexes[i] + 1);
                    indexes[i]++;
                }
//                min1 = Integer.MAX_VALUE;
//                min2 = Integer.MAX_VALUE;
                if (sum[i] <= a) {
                    a = sum[i];
                } else if (sum[i] < b) {
                    b = sum[i];
                }
            }
            System.out.println(Arrays.toString(sum));
            System.out.println(min1);
            System.out.println(min2);
            int cut = 0;
            for (int i : sum) {
                if (i != min1)
                    cut++;
            }
            if (cut < minCut) {
                minCut = cut;
            }
            min1 = a;
            min2 = b;
        }
        return minCut;
    }
}
