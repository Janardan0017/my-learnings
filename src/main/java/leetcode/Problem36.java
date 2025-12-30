package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem36 {

    public boolean isValidSudoku(char[][] board) {
        // validate each row
        for(char[] row: board) {
            Set<Character> set = new HashSet<>();
            for(char c: row) {
                if(c != '.' && set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        // validate each column
        for(int col=0; col<board[0].length; col++) {
            Set<Character> set = new HashSet<>();
            for(int row=0; row<board.length; row++) {
                if(board[row][col] != '.' && set.contains(board[row][col])) {
                    return false;
                } else {
                    set.add(board[row][col]);
                }
            }
        }
        // validate each box
        int row = 3;
        int col = 3;
        while(row < 9 && col < 9) {
            for(int i=0; i<row; i++) {
                Set<Character> set = new HashSet<>();
                for(int j=0; j<col; j++) {

                }
            }
        }
        return true;
    }
}
