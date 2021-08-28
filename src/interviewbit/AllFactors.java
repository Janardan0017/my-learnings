package interviewbit;

import java.util.ArrayList;

//Given a number N, find all factors of N.
public class AllFactors {

    public static void main(String[] args) {
        System.out.println(allFactors(1));
        System.out.println(allFactors(2));
        System.out.println(allFactors(3));
        System.out.println(allFactors(4));
        System.out.println(allFactors(5));
    }

    public static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i < A; i++) {
            if (A % i == 0)
                list.add(i);
        }

        for (int i = (int) Math.sqrt(A); i >= 1; i--) {
            if (A % i == 0)
                list.add(A / i);
        }
        return list;
    }
}
