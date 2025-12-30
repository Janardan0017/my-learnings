package algorithm;

import java.util.Scanner;

public class NQueen {

    public static void solveNQueen(int n, int[][] ar) {

    }

    public static boolean isValidPosition(int i, int j, int n, int[][] ar) {
        int x = i;
        int y = j;
        // check for column
        while (x > 0) {
            x--;
            if (ar[x][y] != 0) {
                return false;
            }
        }
        // left digonal check
        x = i;
        while (x > 0 && y > 0) {
            x--;
            y--;
            if (ar[x][y] != 0) {
                return false;
            }
        }
        x = i;
        y = j;
        // right digonal check
        while (x > 0 && y < n) {
            x--;
            y++;
            if (ar[x][y] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solveNQueen(n, new int[1][1]);
    }
}