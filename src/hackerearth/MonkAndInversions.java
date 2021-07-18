package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class MonkAndInversions {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        while(T-- > 0) {
            String[] nk = s.nextLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int[][] arr = new int[n][n];
            int[] ar = Arrays.stream(s.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.println(Arrays.toString(ar));
        }
    }
}
