package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Problem54 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{3},{2}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3},{6, 5, 4}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 6, 5, 4}}));
        System.out.println(spiralOrder(new int[][]{{1, 2}, {6, 3}, {5, 4}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3},{6, 5, 4}}));
    }
        

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int topBoundry = 0;
        int rightBoundry = matrix[0].length - 1;
        int leftBoundry = 0;
        int bottomBoundry = matrix.length - 1;
        boolean leftToRight = true;
        boolean topToBottom = false;
        boolean rightToLeft = false;
        boolean bottomToTop = false;
        int totalElements = matrix[0].length * matrix.length;
        while (totalElements > 0) {
            if (leftToRight) {
                if (j < rightBoundry) {
                    list.add(matrix[i][j]);
                    j++;
                } else {
                    list.add(matrix[i][j]);
                    i++;
                    leftToRight = false;
                    topToBottom = true;
                    topBoundry++;
                }
            } else if (topToBottom) {
                if (i < bottomBoundry) {
                    list.add(matrix[i][j]);
                    i++;
                } else {
                    list.add(matrix[i][j]);
                    j--;
                    topToBottom = false;
                    rightToLeft = true;
                    rightBoundry--;
                }
            } else if (rightToLeft) {
                if (j > leftBoundry) {
                    list.add(matrix[i][j]);
                    j--;
                } else {
                    list.add(matrix[i][j]);
                    i--;
                    rightToLeft = false;
                    bottomToTop = true;
                    bottomBoundry--;
                }
            } else if (bottomToTop) {
                if (i > topBoundry) {
                    list.add(matrix[i][j]);
                    i--;
                } else {
                    list.add(matrix[i][j]);
                    j++;
                    bottomToTop = false;
                    leftToRight = true;
                    leftBoundry++;
                }
            }
            totalElements--;
        }
        return list;
    }
}
