package interviewbit;

import java.util.ArrayList;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(sieve(10));
    }

    public static ArrayList<Integer> sieve(int a) {
        double sqrt = Math.sqrt(a);
        boolean[] temp = new boolean[a + 1];
        for (int i = 2; i <= sqrt; i++) {
            if (!temp[i]) {
                int j = 2;
                while (j * i <= a) {
                    temp[j * i] = true;
                    j++;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= a; i++) {
            if (!temp[i])
                result.add(i);
        }
        return result;
    }
}
