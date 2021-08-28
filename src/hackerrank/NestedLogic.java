package hackerrank;

import java.time.YearMonth;
import java.util.Scanner;

public class NestedLogic {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String dmy1 = "1 6 2015";
        String dmy2 = "6 6 2015";
        System.out.println(getFine(dmy1, dmy2));;

    }

    public static int getFine(String dmy1_in, String dmy2_in) {
        String[] dmy1 = dmy1_in.trim().split(" ");
        String[] dmy2 = dmy2_in.trim().split(" ");
        int d1 = Integer.parseInt(dmy1[0]);
        int m1 = Integer.parseInt(dmy1[1]);
        int y1 = Integer.parseInt(dmy1[2]);

        int d2 = Integer.parseInt(dmy2[0]);
        int m2 = Integer.parseInt(dmy2[1]);
        int y2 = Integer.parseInt(dmy2[2]);

        if (d1 < d2) {
            YearMonth yearMonth = YearMonth.of(y1, m1);
            d1 += yearMonth.lengthOfMonth();
            m1--;
        }

        if (m1 < m2) {
            m1 += 12;
            y1--;
        }
        int d1d2 = d1 - d2;
        int m1m2 = m1 - m2;
        int y1y2 = y1 - y2;

        int fine = 0;
        if(y1y2 < 0)
            return 0;
        if (y1y2 > 0) {
            fine = 10000;
        } else if (m1m2 > 0) {
            fine = 500 * m1m2;
        } else if (d1d2 > 0) {
            fine = 15 * d1d2;
        }
        return fine;
    }
}
