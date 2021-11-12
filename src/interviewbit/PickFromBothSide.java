package interviewbit;

import java.util.ArrayList;

public class PickFromBothSide {

    public static void main(String[] args) {
        int[] ar = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : ar) {
            list.add(i);
        }
        System.out.println(solve(list, 48));
        ;

    }

    public static int solve(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = A.size() - 1;
        int sum = 0;
        while (i < B) {
            sum += A.get(i);
            i++;
        }
        int res = Integer.MIN_VALUE;
        i--;
        while (i > 0) {
            sum += (A.get(j) - A.get(i));
            res = Math.max(res, sum);
            i--;
            j--;
        }
//        sum += A.get(j);
//        res = Math.max(res, sum);

//        while(B-- > 0) {
//            if(A.get(i) > A.get(j)) {
//                System.out.println("compare "+A.get(i) +" > "+A.get(j));
//                sum += A.get(i);
//                i++;
//            } else {
//                System.out.println("compare "+A.get(i) +" <= "+A.get(j));
//                sum += A.get(j);
//                j--;
//            }
//        }
        System.out.println(i + " " + A.get(i));
        System.out.println(j + " " + A.get(j));
        return res;
    }
}
