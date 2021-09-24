import java.util.Arrays;

public class TI {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3};
        System.out.println(Arrays.toString(addValueToArray(ar, 1)));
    }

    public static int[] addValueToArray(int[] ar, int n) {
        for (int i = ar.length - 1; i >= 0; i--) {
            int x = ar[i] + n;
            ar[i] = x % 10;
            n = x / 10;
        }

        if (n > 0) {
            int[] ar2 = new int[ar.length + 1];
            ar2[0] = n;
            for (int i = 0; i < ar.length; i++) {
                ar2[i + 1] = ar[i];
            }
            return ar2;
        }
        return ar;
    }
}
