package hackerearth;

import java.util.Scanner;

public class CycliceShift {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        while (t-- > 0) {
            String[] nk = in.nextLine().trim().split(" ");
            String a = in.nextLine().trim();
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String b = a.charAt(n - 1) + a.substring(0, n - 1);
            long res = rotationCount(n, k, a, b);
            System.out.println(res);
        }
    }

    static long rotationCount(int n, int k, String a, String b) {
        if (a.equals(b))
            return k;
        String aCopy = a;
        String bCopy = b;
        //  find number of steps to go from a to b
        long step1 = 0;
        while (!aCopy.equals(b)) {
            aCopy = aCopy.substring(1, n) + aCopy.charAt(0);
//            System.out.println(aCopy+"--acopy");
            step1++;
        }
        long step2 = 0;
        // find number of steps to go from b to b
        do {
            bCopy = bCopy.substring(1, n) + bCopy.charAt(0);
//            System.out.println(bCopy+"--bcopy");
            step2++;
        } while (!bCopy.equals(b));
        System.out.println("Step1: " + step1 + " and step2: " + step2);
        return step1;
    }
}
