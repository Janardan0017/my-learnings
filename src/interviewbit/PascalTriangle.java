package interviewbit;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        nthPascalRow(1);
        nthPascalRow(2);
        nthPascalRow(3);
        nthPascalRow(4);
        nthPascalRow(5);
        nthPascalRow(6);
        nthPascalRow(7);
    }

    public static ArrayList<Integer> nthPascalRow(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(nCr(n - 1, i));
        }
        System.out.println(list);
        return list;
    }

    public static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
}
