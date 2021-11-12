package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-8, 6, 3, 4, -5, 9));
        System.out.println(maxset(list));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int i = 0;
        int max = 0;
        int l = 0;
        int r = -1;
        int sum = 0;
        while (i < A.size()) {
            if (A.get(i) >= 0) {
                sum += A.get(i);
            } else {
                if (sum > max) {
                    max = sum;
                    l = r + 1;
                    r = i;
                }
                sum = 0;
            }
            i++;
        }
        if (sum > max) {
            l = r + 1;
            r = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (l < r) {
            list.add(A.get(l));
            l++;
        }
        return list;
    }
}
