package leetcode;

public class Problem695 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxArea(grid));
    }

    public static int maxArea(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = area(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int area(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length) {
            return 0;
        } else {
            return 1 + area(grid, i, j - 1) + area(grid, i - 1, j) + area(grid, i, j + 1) + area(grid, i + 1, j);
        }
    }
}
