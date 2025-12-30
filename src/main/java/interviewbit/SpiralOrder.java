package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        list.add(new ArrayList<>(Arrays.asList(12, 13, 14, 5)));
        list.add(new ArrayList<>(Arrays.asList(11, 16, 15, 6)));
        list.add(new ArrayList<>(Arrays.asList(10, 9, 8, 7)));
        System.out.println(spiralOrder(list));
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int T = 0;
        int B = A.size() - 1;
        int L = 0;
        int R = A.get(0).size() - 1;
        int dir = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (T <= B && L <= R) {
            if (dir == 0) { // left to right
                for (int i = L; i <= R; i++) {
                    list.add(A.get(T).get(i));
                }
                T++;
                dir = 1;
            } else if (dir == 1) {  // top to bottom
                for (int i = T; i <= B; i++) {
                    list.add(A.get(i).get(R));
                }
                R--;
                dir = 2;
            } else if (dir == 2) { // right to left
                for (int i = R; i >= L; i--) {
                    list.add(A.get(B).get(i));
                }
                B--;
                dir = 3;
            } else {    // bottom to top
                for (int i = B; i >= T; i--) {
                    list.add(A.get(i).get(L));
                }
                L++;
                dir = 0;
            }
        }
        return list;
    }
}
