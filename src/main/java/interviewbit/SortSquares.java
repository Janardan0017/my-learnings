package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class SortSquares {

    public static void main(String[] args) {
        int[] ar = {-6, 4, -1, 5, 8};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : ar) {
            list.add(i);
        }
        System.out.println(solve(list));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Integer[] list = new Integer[A.size()];
        int i = 0;
        int j = A.size() - 1;
        int k = j;
        while (i <= j) {
            if (Math.abs(A.get(i)) > Math.abs(A.get(j))) {
                list[k] = A.get(i) * A.get(i);
                i++;
            } else {
                list[k] = A.get(j) * A.get(j);
                j--;
            }
            k--;
        }
        return new ArrayList<>(Arrays.asList(list));
    }
}
