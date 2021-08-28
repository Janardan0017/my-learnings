package madeeasy.searching;

public class Problem17 {

    public static void main(String[] args) {
        int[] ar = new int[10000000];
        for (int i = 0; i < 10000000-1; i++) {
            if(i != 99)
                ar[i] = i + 1;
        }
        System.out.println(missingNumber(ar));
    }

    static int missingNumber(int[] ar) {
        int i, x = 0, y = 0, n = ar.length;
        for (i = 0; i < n; i++) {
            x ^= ar[i];
        }
        for (i = 1; i <= n + 1; i++) {
            y ^= i;
        }
        return x ^ y;
    }
}
