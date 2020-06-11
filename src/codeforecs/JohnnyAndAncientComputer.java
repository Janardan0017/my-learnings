package codeforecs;

import java.math.BigInteger;
import java.util.Scanner;

public class JohnnyAndAncientComputer {

	public static int solve(BigInteger a, BigInteger b){
		BigInteger x = BigInteger.ZERO;
		if(a.equals(b)){
			return 0;
		}else if(a.compareTo(b) > 0 && a.mod(b).equals(BigInteger.ZERO)){
			x = a.divide(b);
		}else if(b.mod(a).equals(BigInteger.ZERO)){
			x = b.divide(a);
		}

		if(x.equals(BigInteger.ZERO)){
			return -1;
		}
		int c = 0;
		while(!x.equals(BigInteger.ONE)){
			if(x.mod(BigInteger.valueOf(8)).equals(BigInteger.ZERO)){
				x = x.divide(BigInteger.valueOf(8));
			}else if(x.mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO)){
				x = x.divide(BigInteger.valueOf(4));
			}else if(x.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
				x = x.divide(BigInteger.valueOf(2));
			}else {
				return -1;
			}
			c++;
		}
		return c;
	}

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		while(t-- > 0){
			String[] input = in.nextLine().trim().split(" ");
			BigInteger a = new BigInteger(input[0]);
			BigInteger b = new BigInteger(input[1]);
			System.out.println(solve(a, b));
		}
	}
}