package leetcode;

public class Problem566 {

    public static void main(String[] args) {

    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c){
            return mat;
        }
        int[][] arr = new int[r][c];
        int i = 0;
        int j = 0;
        for(int[] row: mat) {
            for(int n: row) {
                arr[i][j] = n;
                if(j == c -1) {
                    j=0;
                    i++;
                } else {
                    j++;
                }
            }
        }
        return arr;
    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c){
            return mat;
        }
        int[][] arr = new int[r][c];
        int i = 0;
        int j = 0;
        int m = 0;
        int n = 0;
        while(m < r && n < c) {
            arr[m][n] = mat[i][j];
            if(j == mat[0].length-1) {
                j = 0;
                i++;
            } else {
                j++;
            }
            if(n == c-1) {
                n = 0;
                m++;
            } else {
                n++;
            }
        }
        return arr;
    }
}
