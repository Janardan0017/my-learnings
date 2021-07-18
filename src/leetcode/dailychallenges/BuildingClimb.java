package leetcode.dailychallenges;

/**
 * Created by emp350 on 26/04/21
 */
public class BuildingClimb {

    public static void main(String[] args) {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int i = furthestBuilding(heights, 5, 1);
        System.out.println(i);
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        return moveNext(heights, 0, 1, bricks, ladders);
    }

    public static int moveNext(int[] heights, int i, int j, int bricks, int ladders) {
        int h = heights[j] - heights[i];
        if (h > 0) {
            if (bricks >= h) {
                moveNext(heights, i + 1, j + 1, bricks - h, ladders);
            }
            if (ladders > 0) {
                moveNext(heights, i + 1, j + 1, bricks, ladders - 1);
            }
        } else {
            moveNext(heights, i + 1, j + 1, bricks, ladders);
        }
        return j;
    }
}
