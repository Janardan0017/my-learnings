package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsInInfiniteGrid {

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(0, 1, 1));
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(0, 1, 2));
        System.out.println(coverPoints(x, y));
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int steps = 0;
        for (int i = 1; i < A.size(); i++) {
            steps += minSteps(A.get(i - 1), B.get(i - 1), A.get(i), B.get(i));
        }
        return steps;
    }

    static int minSteps(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(y2 - y1), Math.abs(x2 - x1));
    }
}
