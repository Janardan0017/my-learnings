package leetcode;

public class Problem240 {

    int rowSize;
    int colSize;

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        Problem240 problem240 = new Problem240();
        System.out.println(problem240.searchMatrix(matrix, 8));
//        System.out.println(problem240.searchMatrix(matrix, 19));
//        System.out.println(problem240.searchMatrix(matrix, 23));
//        System.out.println(problem240.searchMatrix(matrix, 18));
//        System.out.println(problem240.searchMatrix(matrix, 123));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        rowSize = matrix.length;
        colSize = matrix[0].length;
        return checkIfPresent(matrix, target, 0, 0);
    }

    public boolean checkIfPresent(int[][] matrix, int target, int rowIndex, int colIndex) {
        if (rowIndex >= rowSize && colIndex >= colSize) {
            return false;
        }
        if (rowIndex < rowSize && colIndex < colSize) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            } else if (matrix[rowIndex][colIndex] < target) {
                return checkIfPresent(matrix, target, rowIndex + 1, colIndex + 1);
            } else {
                return checkIfPresent(matrix, target, rowIndex, colIndex - 1) ||
                        checkIfPresent(matrix, target, rowIndex - 1, colIndex);
            }
        } else if (rowIndex < rowSize) {
            if (matrix[rowIndex][colIndex - 1] > target) {
                return checkIfPresent(matrix, target, rowIndex, colIndex - 1);
            } else {
                return false;
            }
        } else {
            if (matrix[rowIndex][colIndex] > target) {
                return checkIfPresent(matrix, target, rowIndex - 1, colIndex);
            } else {
                return false;
            }
        }
    }

    public boolean leftCheck(int[][] matrix, int target, int rowIndex, int colIndex) {
        while (colIndex >= 0 && matrix[rowIndex][colIndex] > target) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }
            colIndex--;
        }
        return false;
    }

    public boolean topCheck(int[][] matrix, int target, int rowIndex, int colIndex) {
        while (rowIndex >= 0 && matrix[rowIndex][colIndex] > target) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }
            rowIndex--;
        }
        if(rowIndex < 0) {
            return checkIfPresent(matrix, target, 0, colIndex+1);
        }
        return false;
    }
}
