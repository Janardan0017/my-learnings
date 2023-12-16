package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem1337 {

    public static void main(String[] args) {

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=1; i<mat.length; i++) {
            priorityQueue.add(i);
        }
        return new int[0];
    }

    public static int getWeaker(int i, int[] row1, int j, int[] row2) {
        for (int m = 0; m < row1.length; m++) {
            if (row1[m] == 0 && row2[m] == 1) {
                return i;
            } else if (row1[m] == 1 && row2[m] == 0) {
                return j;
            }
        }
        return i;
    }

}
