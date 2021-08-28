package interviewbit;

import java.util.ArrayList;

public class MaxMin {

    public static void main(String[] args) {
//        int[] ar = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        int[] ar = {-2, 1, -4, 5, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: ar) {
            list.add(i);
        }
        System.out.println(solve(list));
    }

    public static int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i: A) {
            if(i > max) {
                max = i;
            } else if(i < min) {
                min = i;
            }
        }
        return max + min;
    }
}
