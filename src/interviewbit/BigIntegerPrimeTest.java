package interviewbit;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerPrimeTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        BigInteger bi = new BigInteger(s);
        System.out.println(bi.isProbablePrime(1));
    }
}
